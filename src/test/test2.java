package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {


    public static void main(String[] args) {


        List<Product> products = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);



        boolean chon = true;
while (chon) {
    System.out.println("------ Menu ------");
    System.out.println("1. In danh sach san pham");
    System.out.println("2. Them moi 1 san pham");
    System.out.println("3. Xoa 1 san pham");
    System.out.println("4. Tim kiem san pham theo ten");
    System.out.println("5. Thoat");
    System.out.print("Chon: ");
int choice = scanner.nextInt();
scanner.nextLine();
    switch (choice) {
        case 1:
            if(products.isEmpty()) {
                System.out.println("danh sách trống");
            }else {
        for (Product product : products) {
            product.display();
        }
                }
            break;
        case 2:
            System.out.println("id");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("price");
            int price = scanner.nextInt();
            scanner.nextLine();

            Product product = new Product(id, name, price);

            products.add(product);
            break;
        case 3:
            System.out.println("san phâm cần xóa ở thứ tự ");

            int rem = scanner.nextInt();
            scanner.nextLine();
            for (Product p : products) {
                if (p.id == rem){
                    System.out.println("đã xoa");
                }else {
                    System.out.println("ko ton tai de xoa");
                }
            }

            break;
        case 4:
            String name1 = scanner.nextLine();

            for (Product p : products) {
                if (p.name.contains(name1)){
                    System.out.println("da tim thay ");
                }else {
                    System.out.println("ko ton tai de thay");
                }
            }

            break;
        case 5:
            System.out.println("Thoat");
            chon = false;
            break;
    }

}


    }

}
