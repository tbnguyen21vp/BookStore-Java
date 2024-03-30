package store.Model;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderID;
    private Date date;
    private Long customerID;
    private Long employeeID;
    private Double totalCost;
    private Double discount;
    private String status;
    private List<OrderDetail> orderDetails;

    public Order(String orderID, Date date, Long customerID, Long employeeID, Double totalCost, Double discount,
            String status) {
        this.orderID = orderID;
        this.date = date;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.totalCost = totalCost;
        this.discount = discount;
        this.status = status;
    }

    public Order(String orderID, Date date, Long customerID, Long employeeID, Double totalCost, Double discount,
            String status, List<OrderDetail> orderDetails) {
        this.orderID = orderID;
        this.date = date;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.totalCost = totalCost;
        this.discount = discount;
        this.status = status;
        this.orderDetails = orderDetails;
    }

    // Getters
    public String getOrderID() {
        return orderID;
    }

    public Date getDate() {
        return date;
    }

    public Long getCustomerID() {
        return customerID;
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

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    // Setters

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
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

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", date=" + date +
                ", customerID=" + customerID +
                ", employeeID=" + employeeID +
                ", totalCost=" + totalCost +
                ", discount=" + discount +
                ", status='" + status + '\'' +
                ", orderDetails=" + orderDetails +
                "} \n";
    }

}
