package Session13.Bai2S13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manage<Student> manager = new AttendanceManager();

        while (true) {

            System.out.println("""
                    ===== MENU =====
                    1. Thêm sinh viên
                    2. Sửa sinh viên
                    3. Xóa sinh viên
                    4. Hiển thị danh sách
                    5. Thoát
                    """);

            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    manager.add(new Student(name, age));
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập vị trí cần sửa: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Tên mới: ");
                    String newName = scanner.nextLine();

                    System.out.print("Tuổi mới: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    manager.update(updateIndex, new Student(newName, newAge));
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập vị trí cần xóa: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();

                    manager.delete(deleteIndex);
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Thoát chương trình...");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
