package Session11.Bai2s11;

public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void pay();

    public void printAmount() {
        System.out.println("Số tiền: " + amount);
    }
}
