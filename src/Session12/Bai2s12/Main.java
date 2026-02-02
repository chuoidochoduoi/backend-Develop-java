package Session12.Bai2s12;



import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AssetManager manager = new AssetManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- QUẢN LÝ TÀI SẢN CNTT ---");
            System.out.println("1. Nhập tài sản | 2. Xuất báo cáo | 3. Tìm kiếm | 4. Sửa giá | 5. Thoát");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Loại (1.PC - 2.Network): ");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.print("Mã: "); String code = sc.nextLine();
                    System.out.print("Tên: "); String name = sc.nextLine();
                    System.out.print("Giá mua: "); double price = Double.parseDouble(sc.nextLine());

                    if (type == 1) {
                        System.out.print("RAM: "); int ram = Integer.parseInt(sc.nextLine());
                        manager.addAsset(new Computer(code, name, price, ram, "i7"));
                    } else {
                        System.out.print("Số cổng: "); int ports = Integer.parseInt(sc.nextLine());
                        manager.addAsset(new NetworkDevice(code, name, price, ports));
                    }
                    break;

                case 2:
                    for (Asset a : manager.getList()) manager.showValue(a);
                    break;

                case 3:
                    System.out.print("Tìm theo (1.Mã - 2.Giá tối thiểu): ");
                    int subChoice = Integer.parseInt(sc.nextLine());
                    if (subChoice == 1) {
                        System.out.print("Nhập mã: "); manager.search(sc.nextLine());
                    } else {
                        System.out.print("Nhập giá: "); manager.search(Double.parseDouble(sc.nextLine()));
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã cần sửa: ");
                    String editCode = sc.nextLine();
                    for (Asset a : manager.getList()) {
                        if (a.assetCode.equals(editCode)) {
                            System.out.print("Giá mới: ");
                            a.purchasePrice = Double.parseDouble(sc.nextLine());
                        }
                    }
                    break;

                case 5: return;
            }
        }
    }
}