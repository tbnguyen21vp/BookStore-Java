package store.Model;

public class OrderDetail {
    private Long idOrderDetail;
    private Long orderID;
    private Long bookID;
    private String title;
    private Double price;
    private Long quantity;

    public OrderDetail(Long idOrderDetail, Long orderID, Long bookID, String title, Double price, Long quantity) {
        this.idOrderDetail = idOrderDetail;
        this.orderID = orderID;
        this.bookID = bookID;
        this.title = title;
        this.price = price;
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

    public void setIdOrderDetail(Long idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public void setBookID(Long bookID) {
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
