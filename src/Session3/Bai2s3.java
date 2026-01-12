package Session3;

import java.util.Scanner;

public class Bai2s3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        double sum = 0;
        double max = -1;
        double min = 11;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Nhập điểm (-1 để kết thúc): ");
                        double diem = sc.nextDouble();

                        if (diem == -1) {
                            break;
                        }

                        if (diem < 0 || diem > 10) {
                            System.out.println(" Điểm không hợp lệ, nhập lại!");
                            continue;
                        }

                        // Cập nhật thống kê
                        count++;
                        sum += diem;
                        if (diem > max) max = diem;
                        if (diem < min) min = diem;

                        // Xếp loại
                        System.out.println(" Học lực: " + xepLoai(diem));
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println(" Chưa có dữ liệu");
                    } else {
                        System.out.println("\n--- THỐNG KÊ ---");
                        System.out.println("Số học viên: " + count);
                        System.out.printf("Điểm trung bình: %.2f%n", sum / count);
                        System.out.println("Điểm cao nhất: " + max);
                        System.out.println("Điểm thấp nhất: " + min);
                    }
                    break;

                case 3:
                    System.out.println(" Thoát chương trình");
                    return;

                default:
                    System.out.println(" Lựa chọn không hợp lệ");
            }
        }
    }

    // Hàm xếp loại học lực
    public static String xepLoai(double diem) {
        if (diem < 5) return "Yếu";
        else if (diem < 7) return "Trung bình";
        else if (diem < 8) return "Khá";
        else if (diem < 9) return "Giỏi";
        else return "Xuất sắc";
    }
}
