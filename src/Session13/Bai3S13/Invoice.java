package Session13.Bai3S13;

public class Invoice {

    private String id;
    private double amount;

    public Invoice(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Mã hóa đơn: " + id + " | Số tiền: " + amount;
    }
}
