package HomeWork.Session1;

public class Bai2 {
    public void calculator(int n1, int n2) {
        System.out.println("\n--- Kết quả từ Function ---");
        System.out.println("Tổng: " + (n1 + n2));
        System.out.println("Hiệu: " + (n1 - n2));
        System.out.println("Tích: " + (n1 * n2));

        // Kiểm tra tránh lỗi chia cho 0
        if (n2 != 0) {
            System.out.println("Thương: " + (n1 / n2));
            System.out.println("Phần dư: " + (n1 % n2));
        } else {
            System.out.println("Không thể thực hiện phép chia vì số thứ hai bằng 0.");
        }
    }
}
