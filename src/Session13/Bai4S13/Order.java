package Session13.Bai4S13;

public class Order {
    private String orderId;
    private String customerName;

    public Order() {
    }

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Mã đơn: " + orderId + " | Khách hàng: " + customerName;
    }
}