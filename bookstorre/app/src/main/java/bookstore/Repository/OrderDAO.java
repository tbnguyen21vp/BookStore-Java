package bookstore.Repository;

public class OrderDAO {
    private String orderID;
    private String userID;
    private String bookID;
    private String orderDate;
    private String status;

    public OrderDAO(String orderID, String userID, String bookID, String orderDate, String status) {
        this.orderID = orderID;
        this.userID = userID;
        this.bookID = bookID;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
