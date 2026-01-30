package Session11.Bai1s11;

public class Main {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[2];
        shapes[0] = new Rectangle(4, 5);
        shapes[1] = new Circle(3);

        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println("Diện tích: " + shape.getArea());
            System.out.println("Chu vi: " + shape.getPerimeter());

            // Gọi draw()
            if (shape instanceof Drawable) {
                ((Drawable) shape).draw();
            }

            System.out.println("--------------------");
        }
    }
}
