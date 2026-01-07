package HomeWork.Session1;

public class Bai4 {

    public void square(double width, double height) {


      double  perimeter = (width + height) * 2;

      double  area = width * height;

        System.out.println("\n--- Kết quả hình chữ nhật ---");
        System.out.printf("Chiều rộng: %.2f%n", width);
        System.out.printf("Chiều cao: %.2f%n", height);
        System.out.printf("Chu vi: %.2f%n", perimeter);
        System.out.printf("Diện tích: %.2f%n", area);
    }
}
