package Session9.Bai2s9;

public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("Lập trình Java", "Nguyễn Văn A", 120000);
        Book b2 = new Book("OOP Cơ bản", "Trần Văn B", 95000);
        Book b3 = new Book("Cấu trúc dữ liệu", "Lê Văn C", 150000);

        Book[] books = { b1, b2, b3 };

        for (Book b : books) {
            b.printInfo();
        }
    }
}
