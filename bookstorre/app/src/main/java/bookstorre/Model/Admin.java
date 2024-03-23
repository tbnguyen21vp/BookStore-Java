package bookstorre.Model;

public class Admin extends User{
    private String adminRole;

    public Admin(String userID, String userName, String password, Boolean status, String adminRole) {
        super(userID, userName, password, status);
        this.adminRole = adminRole;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }


}
