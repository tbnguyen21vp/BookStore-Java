package bookstorre.Model;

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

    // Getters and setters for all properties
    // ...

    // Implement createOrder
    // public void createOrder(OrderDetails orderDetails) {
    //     // Logic to create an order using the provided orderDetails
    // }

    // Implement updateOrder
    // public void updateOrder(OrderDetails orderDetails) {
    //     // Logic to update the order using the provided orderDetails
    // }

    // Implement calculateTotalCost
    public double calculateTotalCost() {
        // Logic to calculate the total cost of the order
        return totalCost - discount;
    }

    // Getters and Setters (auto-generated for brevity)
    // ...
}
