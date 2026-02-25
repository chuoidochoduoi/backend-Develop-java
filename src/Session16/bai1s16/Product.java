package Session16.bai1s16;

public class Product {

    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public String toString() {
        return "id=" + id + ", name=" + name + ", price=" + price;
    }
}
