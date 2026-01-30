package Session11.Bai2s11;

public class CreditCardPayment extends Payment implements Refundable {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Thanh toán bằng thẻ tín dụng");
        printAmount();
    }

    @Override
    public void refund() {
        System.out.println("Hoàn tiền về thẻ tín dụng");
    }
}
