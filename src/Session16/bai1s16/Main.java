package Session16.bai1s16;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void showMenu() {
        System.out.println("\n--- Product Management System ---");
        System.out.println("1. Add Product");
        System.out.println("2. Edit Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Display Products");
        System.out.println("5. Filter Products (Price > 100)");
        System.out.println("6. Total Value of Products");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        HashMap<Integer, Product> productHashMap = new HashMap<Integer, Product>();
        do {
            showMenu();
            choice = sc.nextInt();


            switch (choice) {
                case 1:


                    System.out.println("Add Product selected.");


                    System.out.print("Enter Product Id: ");

                    int id = sc.nextInt();
                    sc.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Product Price: ");
                        double price = sc.nextDouble();

                        sc.nextLine();
                    Product product = new Product(id,name,price);

                    productHashMap.put(product.id, product);

                    break;
                case 2:
                    System.out.println("Edit Product selected.");

                    System.out.print("Enter Product Id: ");
                   Product product1= productHashMap.get(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    name = sc.nextLine();
                    product1.name = name;
                    System.out.print("Enter Product Price: ");
                    price = sc.nextDouble();
                    sc.nextLine();
                    product1.price = price;


                    break;
                case 3:
                    System.out.println("Delete Product selected.");

                    System.out.print("Enter Product Id: ");

                    productHashMap.remove(sc.nextInt());
                    sc.nextLine();

                    break;
                case 4:
                    System.out.println("Display Products selected.");
                    for (Product p : productHashMap.values()) {
                        System.out.println(p.toString());
                    }



                    break;
                case 5:
                    System.out.println("Filter Products selected.");

                    productHashMap.values().stream().filter(product2 -> product2.price>100)
                            .forEach(p -> System.out.println(p.toString()));
                    break;
                case 6:
                    System.out.println("Total Value selected.");
                    productHashMap.values().stream().mapToDouble(Product::getPrice)
                            .sum();

                    System.out.println("Total Value of Products: " +productHashMap.values().stream().mapToDouble(Product::getPrice)
                            .sum());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
    }

