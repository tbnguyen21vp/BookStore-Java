package bookstore.Entity;

public class Publisher {
    private String publisherID;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Boolean status;

    public Publisher(String publisherID, String name, String address, String email, String phone, Boolean status) {
        this.publisherID = publisherID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(String publisherID) {
        this.publisherID = publisherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Publisher{" +
                "publisherID='" + publisherID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }

    public void updatePublisher(String name, String address, String email, String phone, Boolean status) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

}
