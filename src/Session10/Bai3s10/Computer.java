package Session10.Bai3s10;

public class Computer {
    public double calculatePrice(double basePrice) {
        System.out.println("Công thức: Giá gốc");
        return basePrice;
    }

    public double calculatePrice(double basePrice, double tax) {
        System.out.println("Công thức: Giá gốc + Thuế");
        return basePrice + basePrice * tax;
    }

    public double calculatePrice(double basePrice, double tax, double discount) {
        System.out.println("Công thức: Giá gốc + Thuế - Giảm giá");
        return basePrice + basePrice * tax - discount;
    }
}
