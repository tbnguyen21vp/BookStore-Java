package bookstore.Entity;

public class Category {
    private String categoryID;
    private String name;
    private String description;
    private Boolean status;

    public Category(String categoryID, String name, String description, Boolean status) {
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    // getter and setter
    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Category{" +
                "categoryID='" + categoryID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    //upodate
    public void updateCategory(String name, String description, Boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    //disable
    public void disableCategory() {
        this.status = false;
    }

    //enable
    public void enableCategory() {
        this.status = true;
    }




}
