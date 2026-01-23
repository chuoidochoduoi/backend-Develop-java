package Session8.Bai1s8.Bai4s8;

public class main {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(6, 3);
        Rectangle r3 = new Rectangle(7, 8);

        r1.displayInfo();
        r2.displayInfo();
        r3.displayInfo();

        Rectangle maxRectangle = r1;

        if (r2.getArea() > maxRectangle.getArea()) {
            maxRectangle = r2;
        }
        if (r3.getArea() > maxRectangle.getArea()) {
            maxRectangle = r3;
        }

        System.out.println("Hình chữ nhật có diện tích lớn nhất:");
        maxRectangle.displayInfo();
    }
}
