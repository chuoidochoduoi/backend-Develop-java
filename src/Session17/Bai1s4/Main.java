package Session17.Bai1s4;

import java.sql.*;
import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private int publishedYear;
    private double price;

    public Book() {}

    public Book(String title, String author, int publishedYear, double price) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public Book(int id, String title, String author, int publishedYear, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPublishedYear() { return publishedYear; }
    public void setPublishedYear(int publishedYear) { this.publishedYear = publishedYear; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

class BookManager {
    private final String URL = "jdbc:mysql://localhost:3306/library_db";
    private final String USER = "root";
    private final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addBook(Book book) {
        String checkSql = "SELECT COUNT(*) FROM books WHERE title=? AND author=?";
        String insertSql = "INSERT INTO books(title, author, published_year, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setString(1, book.getTitle());
            checkStmt.setString(2, book.getAuthor());

            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("Sach da ton tai");
                return;
            }

            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, book.getTitle());
            insertStmt.setString(2, book.getAuthor());
            insertStmt.setInt(3, book.getPublishedYear());
            insertStmt.setDouble(4, book.getPrice());

            insertStmt.executeUpdate();
            System.out.println("Them sach thanh cong");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBook(int id, Book book) {
        String checkSql = "SELECT * FROM books WHERE id=?";
        String updateSql = "UPDATE books SET title=?, author=?, published_year=?, price=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Khong tim thay sach");
                return;
            }

            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setString(1, book.getTitle());
            updateStmt.setString(2, book.getAuthor());
            updateStmt.setInt(3, book.getPublishedYear());
            updateStmt.setDouble(4, book.getPrice());
            updateStmt.setInt(5, id);

            updateStmt.executeUpdate();
            System.out.println("Cap nhat thanh cong");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0)
                System.out.println("Xoa thanh cong");
            else
                System.out.println("Khong tim thay sach");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void findBooksByAuthor(String author) {
        String sql = "SELECT * FROM books WHERE author LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + author + "%");
            ResultSet rs = stmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getInt("published_year") + " | " +
                                rs.getDouble("price")
                );
            }

            if (!found)
                System.out.println("Khong tim thay sach");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listAllBooks() {
        String sql = "SELECT * FROM books";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getInt("published_year") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager();

        while (true) {
            System.out.println("1. Them sach");
            System.out.println("2. Cap nhat sach");
            System.out.println("3. Xoa sach");
            System.out.println("4. Tim theo tac gia");
            System.out.println("5. Hien thi tat ca");
            System.out.println("0. Thoat");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Nhap sai dinh dang");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Ten sach: ");
                        String title = scanner.nextLine();
                        System.out.print("Tac gia: ");
                        String author = scanner.nextLine();
                        System.out.print("Nam xuat ban: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.print("Gia: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        if (title.isEmpty() || author.isEmpty()) {
                            System.out.println("Khong duoc de trong");
                            break;
                        }

                        manager.addBook(new Book(title, author, year, price));
                    } catch (Exception e) {
                        System.out.println("Nhap sai du lieu");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("ID sach: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ten moi: ");
                        String title = scanner.nextLine();
                        System.out.print("Tac gia moi: ");
                        String author = scanner.nextLine();
                        System.out.print("Nam moi: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.print("Gia moi: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        manager.updateBook(id, new Book(title, author, year, price));
                    } catch (Exception e) {
                        System.out.println("Nhap sai du lieu");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("ID sach: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        manager.deleteBook(id);
                    } catch (Exception e) {
                        System.out.println("Nhap sai du lieu");
                    }
                    break;

                case 4:
                    System.out.print("Nhap tac gia: ");
                    String author = scanner.nextLine();
                    manager.findBooksByAuthor(author);
                    break;

                case 5:
                    manager.listAllBooks();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}