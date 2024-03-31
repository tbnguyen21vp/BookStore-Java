package store.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import store.Model.Category;
import store.utils.DatabaseUtils;

public class CategoryDAO {
    private static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM categories WHERE categoryID = ?";
    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM categories";
    private static final String UPDATE_CATEGORY_SQL = "UPDATE categories SET name = ?, status = ? WHERE categoryID = ?";
    private static final String DELETE_CATEGORY_SQL = "DELETE FROM categories WHERE categoryID = ?";
    private static final String INSERT_CATEGORY_SQL = "INSERT INTO categories (categoryName) VALUES (?)";

    // add category
    public void addCategory(Category category) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // update category
    public boolean updateCategory(Category category) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL)) {
            statement.setString(1, category.getCategoryName());
            statement.setBoolean(2, category.getStatus());
            statement.setInt(3, category.getCategoryID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // disable category
    public boolean disableCategory(String categoryID) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL)) {
            statement.setBoolean(2, false);
            statement.setString(3, categoryID);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // enable category
    public boolean enableCategory(String categoryID) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL)) {
            statement.setBoolean(2, true);
            statement.setString(3, categoryID);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // get all categories
    public List<Category> getAllCategories() throws SQLException, ClassNotFoundException {
        List<Category> categories = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils(); // Create an instance of DatabaseUtils
        try (Connection connection = databaseUtils.connect(); // Call connect() on the instance
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int categoryID = rs.getInt("categoryID");
                String categoryName = rs.getString("name");
                boolean status = rs.getBoolean("status");
                Category category = new Category(categoryID, categoryName, status);
                categories.add(category);
            }
        }
        return categories;
    }

    // delete category
    public boolean deleteCategory(String categoryID) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY_SQL)) {
            preparedStatement.setString(1, categoryID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}
