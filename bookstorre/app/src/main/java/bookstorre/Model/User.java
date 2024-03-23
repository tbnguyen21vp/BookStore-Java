package bookstorre.Model;

public class User {
    private String userID;
    private String userName;
    private String password;
    private Boolean status;


    public User(String userID, String userName, String password, Boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    // Getters
    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getStatus() {
        return status;
    }

    // Setters

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override

    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }


    
    
}
