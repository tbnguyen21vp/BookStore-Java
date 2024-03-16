package bookstore.Entity;

public class Employee extends User {
    private String employeeID;

    public Employee(String userID, String username, String password, Boolean status, String employeeID) {
        super(userID, username, password, status);
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @Override

    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                '}';
    }

    public void updateEmployee(String username, String password, Boolean status) {
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


}
