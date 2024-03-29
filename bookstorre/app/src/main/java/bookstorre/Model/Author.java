package bookstorre.Model;

public class Author {
    private String authorID;
    private String authorName;
    private Boolean status;

    // Getters
    public String getAuthorID() {
        return authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Boolean getStatus() {
        return status;
    }

    // Setters

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}
