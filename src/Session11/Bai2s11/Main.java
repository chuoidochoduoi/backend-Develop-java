package Session11.Bai2s11;

public class Main {
    public static void main(String[] args) {

        Payment[] payments = new Payment[3];
        payments[0] = new CashPayment(100);
        payments[1] = new CreditCardPayment(200);
        payments[2] = new EWalletPayment(300);

        for (Payment payment : payments) {
            payment.pay();

            if (payment instanceof Refundable) {
                ((Refundable) payment).refund();
            }

            System.out.println("----------------------");
        }
    }
}
