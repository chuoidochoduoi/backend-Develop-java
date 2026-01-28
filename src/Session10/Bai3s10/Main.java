package Session10.Bai3s10;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();

        double basePrice = 1000;
        double tax = 0.1;
        double discount = 50;

        double price1 = computer.calculatePrice(basePrice);
        System.out.println("Giá phải trả: " + price1);
        System.out.println();

        double price2 = computer.calculatePrice(basePrice, tax);
        System.out.println("Giá phải trả: " + price2);
        System.out.println();

        double price3 = computer.calculatePrice(basePrice, tax, discount);
        System.out.println("Giá phải trả: " + price3);
    }
}
