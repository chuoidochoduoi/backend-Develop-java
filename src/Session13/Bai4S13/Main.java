package Session13.Bai4S13;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Manage<Order> manager = new OrderManager();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã đơn: ");
                    String id = scanner.nextLine();

                    System.out.print("Nhập tên khách hàng: ");
                    String name = scanner.nextLine();

                    Order order = new Order(id, name);
                    manager.add(order);
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập vị trí cần sửa: ");
                    int updateIndex = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập mã đơn mới: ");
                    String newId = scanner.nextLine();

                    System.out.print("Nhập tên khách hàng mới: ");
                    String newName = scanner.nextLine();

                    manager.update(updateIndex, new Order(newId, newName));
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập vị trí cần xóa: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());

                    manager.delete(deleteIndex);
                    break;

                case 4:
                    manager.display();
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }
}