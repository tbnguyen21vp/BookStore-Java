package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Publisher;
import store.utils.DatabaseUtils;

public class PublisherDAO {
    private static final String INSERT_PUBLISHER_SQL = "INSERT INTO publishers (publisherID, publisherName, status) VALUES (?, ?, ?)";
    private static final String SELECT_PUBLISHER_BY_ID = "SELECT * FROM publishers WHERE publisherID = ?";
    private static final String SELECT_ALL_PUBLISHERS = "SELECT * FROM publishers";
    private static final String UPDATE_PUBLISHER_SQL = "UPDATE publishers SET publisherName = ?, status = ? WHERE publisherID = ?";
    private static final String DELETE_PUBLISHER_SQL = "DELETE FROM publishers WHERE publisherID = ?";
    private static final String DISABLE_PUBLISHER_SQL = "UPDATE publishers SET status = ? WHERE publisherID = ?";
    private static final String ENABLE_PUBLISHER_SQL = "UPDATE publishers SET status = ? WHERE publisherID = ?";

    // add publisher
    public void addPublisher(Publisher publisher) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PUBLISHER_SQL)) {
            preparedStatement.setString(1, publisher.getPublisherID());
            preparedStatement.setString(2, publisher.getPublisherName());
            preparedStatement.setBoolean(3, publisher.getStatus());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // update publisher
    public boolean updatePublisher(Publisher publisher) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_PUBLISHER_SQL)) {
            statement.setString(1, publisher.getPublisherName());
            statement.setBoolean(2, publisher.getStatus());
            statement.setString(3, publisher.getPublisherID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // disable publisher
    public boolean disablePublisher(String publisherID) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(DISABLE_PUBLISHER_SQL)) {
            statement.setBoolean(1, false);
            statement.setString(2, publisherID);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // enable publisher

    public boolean enablePublisher(String publisherID) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(ENABLE_PUBLISHER_SQL)) {
            statement.setBoolean(1, true);
            statement.setString(2, publisherID);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // select publisher by id
    public Publisher selectPublisher(String publisherID) {
        Publisher publisher = null;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PUBLISHER_BY_ID)) {
            preparedStatement.setString(1, publisherID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String publisherName = rs.getString("publisherName");
                Boolean status = rs.getBoolean("status");
                publisher = new Publisher(publisherID, publisherName, status);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return publisher;
    }

    // select all publishers
    public List<Publisher> getAllPublishers() {
        List<Publisher> publishers = new ArrayList<>();
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PUBLISHERS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String publisherID = rs.getString("publisherID");
                String publisherName = rs.getString("publisherName");
                Boolean status = rs.getBoolean("status");
                Publisher publisher = new Publisher(publisherID, publisherName, status);
                publishers.add(publisher);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    // delete publisher
    public boolean deletePublisher(String publisherID) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PUBLISHER_SQL)) {
            preparedStatement.setString(1, publisherID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}
