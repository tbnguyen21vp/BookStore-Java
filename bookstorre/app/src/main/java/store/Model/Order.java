package store.Model;

import java.util.Date;

public class Order {
    private String orderID;
    private Date date;
    private String customerID;
    private String employeeID;
    private Double totalCost;
    private Double discount;
    private String status;

    // Constructor
    public Order(String orderID, Date date, String customerID, String employeeID, Double totalCost, Double discount,
            String status) {
        this.orderID = orderID;
        this.date = date;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.totalCost = totalCost;
        this.discount = discount;
        this.status = status;
    }

    // Getters
    public String getOrderID() {
        return orderID;
    }

    public Date getDate() {
        return date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public Double getDiscount() {
        return discount;
    }

    public String getStatus() {
        return status;
    }

    // Setters

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
