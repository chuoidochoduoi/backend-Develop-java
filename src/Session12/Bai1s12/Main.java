package Session12.Bai1s12;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {public static void main(String[] args) {
    ArrayList<Staff> listStaff = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.println("\n--- HỆ THỐNG QUẢN LÝ NHÂN SỰ ---");
        System.out.println("1. Thêm mới Giảng viên/Nhân viên");
        System.out.println("2. Hiển thị danh sách (Tính lương)");
        System.out.println("3. Cập nhật thông tin theo ID");
        System.out.println("4. Xóa nhân sự theo ID");
        System.out.println("5. Thoát");
        System.out.print("Chọn chức năng: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Chọn loại (1-Giảng viên, 2-Hành chính): ");
                int type = Integer.parseInt(sc.nextLine());
                System.out.print("ID: "); String id = sc.nextLine();
                System.out.print("Tên: "); String name = sc.nextLine();
                System.out.print("Lương cơ bản: "); double salary = Double.parseDouble(sc.nextLine());

                if (type == 1) {
                    System.out.print("Giờ dạy: "); int hours = Integer.parseInt(sc.nextLine());
                    listStaff.add(new Lecturer(id, name, salary, hours));
                } else {
                    System.out.print("Thưởng: "); double bonus = Double.parseDouble(sc.nextLine());
                    listStaff.add(new AdminStaff(id, name, salary, bonus));
                }
                break;

            case 2:
                System.out.println("DANH SÁCH NHÂN SỰ:");
                for (Staff s : listStaff) {
                    // Tính đa hình: Tự động gọi đúng phương thức tính lương của từng lớp con
                    System.out.println(s + " | Tổng lương nhận: " + s.calculateTotalSalary());
                }
                break;

            case 3:
                System.out.print("Nhập ID cần sửa: ");
                String editId = sc.nextLine();
                for (Staff s : listStaff) {
                    if (s.id.equals(editId)) {
                        System.out.print("Nhập tên mới: "); s.name = sc.nextLine();
                        System.out.print("Nhập lương cơ bản mới: "); s.baseSalary = Double.parseDouble(sc.nextLine());
                        System.out.println("Cập nhật thành công!");
                    }
                }
                break;

            case 4:
                System.out.print("Nhập ID cần xóa: ");
                String delId = sc.nextLine();
                listStaff.removeIf(s -> s.id.equals(delId));
                System.out.println("Đã xóa!");
                break;

            case 5:
                System.out.println("Tạm biệt!");
                System.exit(0);
        }
    }
}
}