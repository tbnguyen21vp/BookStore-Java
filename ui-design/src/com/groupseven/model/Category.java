
package com.groupseven.model;

/**
 *
 * @author TCCom
 */
public class Category {

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    private String categoryID;
    private String categoryName;
    private String categoryDescription;
    private Boolean status;

    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public Boolean getStatus() {
        return status;
    }
    
    public Category(String categoryID, String categoryName, String categoryDescription, boolean status) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.status = status;
    }
}
