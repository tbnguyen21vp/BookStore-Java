package bookstore.Entity;

public class Order {
    private String orderID;
    private String orderDate;
    private String customerID;
    private String employeeID;
    private Double totalCost;
    private Boolean status;

    public Order(String orderID, String orderDate, String customerID, String employeeID, Double totalCost, Boolean status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.totalCost = totalCost;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", customerID='" + customerID + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", totalCost=" + totalCost +
                ", status=" + status +
                '}';
    }

    public void updateOrder(String orderDate, String customerID, String employeeID, Double totalCost, Boolean status) {
        this.orderDate = orderDate;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.totalCost = totalCost;
        this.status = status;
    }

    //create order
    public void createOrder(String orderID, String orderDate, String customerID, String employeeID, Double totalCost, Boolean status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.totalCost = totalCost;
        this.status = status;
    }

    //delete order
    public void deleteOrder(String orderID, String orderDate, String customerID, String employeeID, Double totalCost, Boolean status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.totalCost = totalCost;
        this.status = status;
    }
    // caculate total cost
    public Double caculateTotalCost(Double price, int quantity) {
        return price * quantity;
    }
}
