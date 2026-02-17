package Session13.Bai3S13;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Manage<Invoice> manager = new InvoiceManager();

        while (true) {

            System.out.println("""
                    ===== QUẢN LÝ HÓA ĐƠN =====
                    1. Thêm hóa đơn
                    2. Sửa hóa đơn
                    3. Xóa hóa đơn
                    4. Hiển thị danh sách
                    5. Thoát
                    """);

            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Nhập mã hóa đơn: ");
                    String id = scanner.nextLine();

                    System.out.print("Nhập số tiền: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    manager.add(new Invoice(id, amount));
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập vị trí cần sửa: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập mã mới: ");
                    String newId = scanner.nextLine();

                    System.out.print("Nhập số tiền mới: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine();

                    manager.update(updateIndex, new Invoice(newId, newAmount));
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