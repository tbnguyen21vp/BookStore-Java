package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Author;
import store.utils.DatabaseUtils;

public class AuthorDAO {
    private static final String INSERT_AUTHOR_SQL = "INSERT INTO authors (authorID, authorName, status) VALUES (?, ?, ?)";
    private static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM authors WHERE authorID = ?";
    private static final String SELECT_ALL_AUTHORS = "SELECT * FROM authors";
    private static final String UPDATE_AUTHOR_SQL = "UPDATE authors SET authorName = ?, status = ? WHERE authorID = ?";
    private static final String DELETE_AUTHOR_SQL = "DELETE FROM authors WHERE authorID = ?";

    // add author
    public void addAuthor(Author author) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR_SQL)) {
            preparedStatement.setString(1, author.getAuthorID());
            preparedStatement.setString(2, author.getAuthorName());
            preparedStatement.setBoolean(3, author.getStatus());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // update author
    public boolean updateAuthor(Author author) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_SQL)) {
            statement.setString(1, author.getAuthorName());
            statement.setBoolean(2, author.getStatus());
            statement.setString(3, author.getAuthorID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // disable author
    public boolean disableAuthor(String authorID) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_SQL)) {
            statement.setBoolean(2, false);
            statement.setString(3, authorID);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // enable author

    public boolean enableAuthor(String authorID) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_SQL)) {
            statement.setBoolean(2, true);
            statement.setString(3, authorID);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // delete author

    public Author selectAuthor(String authorID) throws SQLException {
        Author author = null;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID)) {
            preparedStatement.setString(1, authorID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String authorName = rs.getString("authorName");
                Boolean status = rs.getBoolean("status");
                author = new Author();
                author.setAuthorID(authorID);
                author.setAuthorName(authorName);
                author.setStatus(status);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return author;
    }

    // select all authors
    public List<Author> selectAllAuthors() throws SQLException {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHORS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String authorID = rs.getString("authorID");
                String authorName = rs.getString("authorName");
                Boolean status = rs.getBoolean("status");
                Author author = new Author();
                author.setAuthorID(authorID);
                author.setAuthorName(authorName);
                author.setStatus(status);
                authors.add(author);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return authors;
    }

    // delete author

    public boolean deleteAuthor(String authorID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(DELETE_AUTHOR_SQL)) {
            statement.setString(1, authorID);

            rowDeleted = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowDeleted = false;
        }
        return rowDeleted;
    }
}
