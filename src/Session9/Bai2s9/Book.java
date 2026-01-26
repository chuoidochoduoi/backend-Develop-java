package Session9.Bai2s9;

public class Book {

    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("Tên sách  : " + title);
        System.out.println("Tác giả   : " + author);
        System.out.println("Giá tiền  : " + price);
        System.out.println("----------------------");
    }
}
