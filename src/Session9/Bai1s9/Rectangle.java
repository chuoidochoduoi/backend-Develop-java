package Session9.Bai1s9;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return (width + height) * 2;
    }

    public void printInfo() {
        System.out.println("Chiều rộng: " + width);
        System.out.println("Chiều cao: " + height);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }
}
