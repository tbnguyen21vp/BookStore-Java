package bookstorre.Model;

public class Admin extends User {
    private String adminRole;

    // Include Firstname and Lastname in the constructor.
    public Admin(String userID, String userName, String password, Boolean status, String Firstname, String Lastname,
            String adminRole) {
        // Pass all the parameters to the superclass constructor.
        super(userID, userName, password, status, Firstname, Lastname);
        this.adminRole = adminRole;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }
}
