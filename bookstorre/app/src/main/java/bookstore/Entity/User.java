package bookstore.Entity;

public class User {
    private String userID;
    private String username;
    private String password;
    private Boolean status;

    public User(String userID, String username, String password, Boolean status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override

    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
    // login();
    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }
    }

    // logout();
    public void logout() {
        System.out.println("Logout success");
    }


    // changePassword();
    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Change password success");
    }

    // update
    public void updateUser(String username, String password, Boolean status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }


}
