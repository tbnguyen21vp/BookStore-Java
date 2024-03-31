package store.Model;

public class OrderDetail {
    private int idOrderDetail;
    private int orderID;
    private int bookID;
    private String title;
    private Double price;
    private Long quantity;
    
    // Getters

    public OrderDetail(int idOrderDetail, int bookID, int orderID, Long quantity, String title, Double price) {
        this.idOrderDetail = idOrderDetail;
        this.orderID = orderID;
        this.bookID = bookID;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Long getQuantity() {
        return quantity;
    }

    // Setters

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override

    public String toString() {
        return " \n OrderDetail{" +
                "idOrderDetail=" + idOrderDetail +
                ", orderID=" + orderID +
                ", bookID=" + bookID +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                " \n" +
                '}';
    }

    public Double getTotal() {
        return price * quantity;
    }

    
}
