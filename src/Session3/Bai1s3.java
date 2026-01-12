package Session3;

import java.util.Scanner;

public class Bai1s3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Tên khách hàng: ");

        String n = sc.nextLine();


        System.out.print("Sản phẩm: ");
        String p = sc.nextLine();
        System.out.print("price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        System.out.print("thẻ thành viên: ");
        boolean th = sc.nextBoolean();

        double tong =    price*quantity  ;
        double tongtv= tong - tong/10 + tong/100*8;
        if(th == true){

            System.out.printf(
                    "Tên khách hàng: %s%n" +
                            "Sản phẩm: %s%n" +
                            "Quantity: %d%n" +
                            "Price: %.2f%n" +
                            "Total: %.2f%n" +
                            "Giảm thành viên (10%%): %.2f%n" +
                            "Tiền VAT (8%%): %.2f%n" +
                            "Tổng thanh toán: %.2f%n",
                    n, p, quantity, price, tong,
                    tong/10, tong * 0.08, tongtv
            );

        }
        else {
            System.out.printf(
                    "Tên khách hàng: %s%n" +
                            "Sản phẩm: %s%n" +
                            "Quantity: %d%n" +
                            "Price: %.2f%n" +
                            "Total: %.2f%n" +
                            "Giảm thành viên (10%%): %.2f%n" +
                            "Tiền VAT (8%%): %.2f%n" +
                            "Tổng thanh toán: %.2f%n",
                    n, p, quantity, price, tong,
                    tong/10, tong * 0.08, tongtv
            );
        }

    }

}
