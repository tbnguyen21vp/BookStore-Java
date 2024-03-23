package bookstorre.Model;

public class Publisher {
    String publisherID;
    String publisherName;
    String publisherDescription;
    Boolean status;

    public Publisher(String publisherID, String publisherName, String publisherDescription, Boolean status) {
        this.publisherID = publisherID;
        this.publisherName = publisherName;
        this.publisherDescription = publisherDescription;
        this.status = status;
    }

    // Getters

    public String getPublisherID() {
        return publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPublisherDescription() {
        return publisherDescription;
    }

    public Boolean getStatus() {
        return status;
    }

    // Setters

    public void setPublisherID(String publisherID) {
        this.publisherID = publisherID;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public void setPublisherDescription(String publisherDescription) {
        this.publisherDescription = publisherDescription;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherID='" + publisherID + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", publisherDescription='" + publisherDescription + '\'' +
                ", status=" + status +
                '}';
    }

}