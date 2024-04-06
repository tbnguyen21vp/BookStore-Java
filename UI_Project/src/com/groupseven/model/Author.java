package com.groupseven.model;

/**
 *
 * @author TCCom
 */
public class Author {

    public Author(String authorID, String authorName, Boolean status) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.status = status;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    private String authorID;
    private String authorName;
    private Boolean status;
}
