import java.util.Date;

public class Order {
    private String orderId;
    private Product product;
    private Customer customer;
    private int quantity;
    private Date orderDate;

    public Order(String orderId, Product product, Customer customer, int quantity, Date orderDate) {
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

}
