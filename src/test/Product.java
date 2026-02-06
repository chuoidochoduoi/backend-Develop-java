package test;

public class Product {
    int id;
    String name;
    int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println(id + " | " + name + " | " + price);

    }
}
