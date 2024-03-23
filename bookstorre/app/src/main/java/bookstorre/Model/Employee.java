package bookstorre.Model;

public class Employee extends User{
    private String employeeRole;

    public Employee(String userID, String userName, String password, Boolean status, String employeeRole) {
        super(userID, userName, password, status);
        this.employeeRole = employeeRole;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }
    
}
