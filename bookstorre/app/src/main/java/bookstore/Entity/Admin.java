package bookstore.Entity;

public class Admin extends User {
    private String role;
    public Admin(String userID, String username, String password, Boolean status, String role) {
        super(userID, username, password, status);
        this.role = "admin";
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "role='" + role + '\'' +
                '}';
    }
    public void updateAdmin(String username, String password, Boolean status) {
        super.setUsername(username);
        super.setPassword(password);
        super.setStatus(status);
    }
    public void login(String username, String password) {
        if (super.getUsername().equals(username) && super.getPassword().equals(password)) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }
    }
    public void logout() {
        System.out.println("Logout success");
    }

}
