package store.Model;

import java.sql.ResultSet;

public class Category {
    private String categoryID;
    private String categoryName;
    private Boolean status;

    public Category(String categoryID, String categoryName, Boolean status) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.status = status;
    }

    // Getters
    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Boolean getStatus() {
        return status;
    }

    // Setters

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Caretory{" +
                "categoryID='" + categoryID + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", status=" + status +
                '}';
    }

    public Category(ResultSet rs) {
        // TODO Auto-generated constructor stub
    }

}
