package Session17.Bai1s2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManagement manager = new TaskManagement();

        while (true) {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Thêm công việc");
            System.out.println("2. Liệt kê");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Tên công việc: ");
                        String name = sc.nextLine();

                        System.out.print("Trạng thái (chưa hoàn thành / đã hoàn thành): ");
                        String status = sc.nextLine();

                        if (name.isEmpty() || status.isEmpty()) {
                            throw new IllegalArgumentException("Không được nhập trống!");
                        }

                        manager.addTask(name, status);
                        break;

                    case 2:
                        manager.listTasks();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Trạng thái mới: ");
                        status = sc.nextLine();

                        manager.updateTaskStatus(id, status);
                        break;

                    case 4:
                        System.out.print("ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        manager.deleteTask(id);
                        break;

                    case 5:
                        System.out.print("Tên cần tìm: ");
                        name = sc.nextLine();

                        manager.searchTaskByName(name);
                        break;

                    case 6:
                        manager.taskStatistics();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Nhập sai kiểu số!");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi hệ thống: " + e.getMessage());
            }
        }
    }
}