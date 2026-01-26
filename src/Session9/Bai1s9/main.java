package Session9.Bai1s9;

public class main {
    public static void main(String[] args) {

        Rectangle rect = new Rectangle(5.0, 3.0);

        double area = rect.getArea();
        double perimeter = rect.getPerimeter();

        System.out.println("Diện tích hình chữ nhật: " + area);
        System.out.println("Chu vi hình chữ nhật: " + perimeter);

        rect.printInfo();
    }
}
