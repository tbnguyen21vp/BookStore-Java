package bookstorre.Model;

public class OrderDetail {
    private Long idOrderDetail;
    private Long orderID;
    private Long bookID;
    private Long quantity;

    // Constructor
    public OrderDetail(Long idOrderDetail, Long orderID, Long bookID, Long quantity) {
        this.idOrderDetail = idOrderDetail;
        this.orderID = orderID;
        this.bookID = bookID;
        this.quantity = quantity;
    }

    // Getters
    public Long getIdOrderDetail() {
        return idOrderDetail;
    }

    public Long getOrderID() {
        return orderID;
    }

    public Long getBookID() {
        return bookID;
    }

    public Long getQuantity() {
        return quantity;
    }

    // Setters
    public void setIdOrderDetail(Long idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    // Additional methods for business logic, if necessary
    // ...

    // Example: A method to calculate the total cost of the order detail line
    public Double calculateTotalCost(Double bookPrice) {
        return bookPrice * this.quantity;
    }
}
