package Session17.Bai1s3;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static final String URL = "jdbc:mysql://localhost:3306/shop_db";
    static final String USER = "root";
    static final String PASSWORD = "123456";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ================== ENTITY ==================
    static class Product {
        int id;
        String name;
        double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    static class Customer {
        int id;
        String name;
        String email;

        public Customer(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    static class Order {
        int id;
        int customerId;
        LocalDate orderDate;
        double totalAmount;

        public Order(int customerId, LocalDate orderDate, double totalAmount) {
            this.customerId = customerId;
            this.orderDate = orderDate;
            this.totalAmount = totalAmount;
        }
    }

    static class OrderManager {

        public void addProduct(Product product) {
            try (Connection conn = getConnection()) {

                PreparedStatement check = conn.prepareStatement(
                        "SELECT * FROM products WHERE name = ?");
                check.setString(1, product.name);
                ResultSet rs = check.executeQuery();

                if (rs.next()) {
                    System.out.println("Sản phẩm đã tồn tại!");
                    return;
                }

                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO products(name, price) VALUES (?, ?)");
                stmt.setString(1, product.name);
                stmt.setDouble(2, product.price);
                stmt.executeUpdate();

                System.out.println("Thêm sản phẩm thành công!");

            } catch (SQLException e) {
                System.out.println("Lỗi thêm sản phẩm: " + e.getMessage());
            }
        }

        public void updateCustomer(int id, Customer customer) {
            try (Connection conn = getConnection()) {

                PreparedStatement check = conn.prepareStatement(
                        "SELECT * FROM customers WHERE id = ?");
                check.setInt(1, id);
                ResultSet rs = check.executeQuery();

                if (!rs.next()) {
                    System.out.println("Khách hàng không tồn tại!");
                    return;
                }

                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE customers SET name=?, email=? WHERE id=?");
                stmt.setString(1, customer.name);
                stmt.setString(2, customer.email);
                stmt.setInt(3, id);
                stmt.executeUpdate();

                System.out.println("Cập nhật thành công!");

            } catch (SQLException e) {
                System.out.println("Lỗi cập nhật: " + e.getMessage());
            }
        }

        public void createOrder(int customerId, int productId, int quantity) {
            try (Connection conn = getConnection()) {

                // lấy giá sản phẩm
                PreparedStatement pStmt = conn.prepareStatement(
                        "SELECT price FROM products WHERE id=?");
                pStmt.setInt(1, productId);
                ResultSet prs = pStmt.executeQuery();

                if (!prs.next()) {
                    System.out.println("Sản phẩm không tồn tại!");
                    return;
                }

                double price = prs.getDouble("price");
                double total = price * quantity;

                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO orders(customer_id, order_date, total_amount) VALUES (?, ?, ?)");
                stmt.setInt(1, customerId);
                stmt.setDate(2, Date.valueOf(LocalDate.now()));
                stmt.setDouble(3, total);
                stmt.executeUpdate();

                System.out.println("Tạo đơn hàng thành công!");

            } catch (SQLException e) {
                System.out.println("Lỗi tạo đơn hàng: " + e.getMessage());
            }
        }

        public void listAllOrders() {
            try (Connection conn = getConnection()) {

                String sql = """
                        SELECT o.id, c.name, o.order_date, o.total_amount
                        FROM orders o
                        JOIN customers c ON o.customer_id = c.id
                        """;

                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +
                                    rs.getString("name") + " | " +
                                    rs.getDate("order_date") + " | " +
                                    rs.getDouble("total_amount")
                    );
                }

            } catch (SQLException e) {
                System.out.println("Lỗi hiển thị: " + e.getMessage());
            }
        }

        public void getOrdersByCustomer(int customerId) {
            try (Connection conn = getConnection()) {

                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT * FROM orders WHERE customer_id=?");
                stmt.setInt(1, customerId);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +
                                    rs.getDate("order_date") + " | " +
                                    rs.getDouble("total_amount")
                    );
                }

            } catch (SQLException e) {
                System.out.println("Lỗi tìm kiếm: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderManager manager = new OrderManager();

        while (true) {
            System.out.println("\n===== SHOP MANAGEMENT =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Cập nhật khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Hiển thị đơn hàng");
            System.out.println("5. Tìm đơn theo khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Tên sản phẩm: ");
                        String pname = sc.nextLine();
                        System.out.print("Giá: ");
                        double price = Double.parseDouble(sc.nextLine());

                        if (pname.isEmpty())
                            throw new IllegalArgumentException("Không được để trống!");

                        manager.addProduct(new Product(pname, price));
                        break;

                    case 2:
                        System.out.print("ID khách hàng: ");
                        int cid = Integer.parseInt(sc.nextLine());
                        System.out.print("Tên mới: ");
                        String cname = sc.nextLine();
                        System.out.print("Email mới: ");
                        String email = sc.nextLine();

                        manager.updateCustomer(cid, new Customer(cname, email));
                        break;

                    case 3:
                        System.out.print("ID khách hàng: ");
                        cid = Integer.parseInt(sc.nextLine());
                        System.out.print("ID sản phẩm: ");
                        int pid = Integer.parseInt(sc.nextLine());
                        System.out.print("Số lượng: ");
                        int quantity = Integer.parseInt(sc.nextLine());

                        manager.createOrder(cid, pid, quantity);
                        break;

                    case 4:
                        manager.listAllOrders();
                        break;

                    case 5:
                        System.out.print("ID khách hàng: ");
                        cid = Integer.parseInt(sc.nextLine());
                        manager.getOrdersByCustomer(cid);
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Sai kiểu dữ liệu!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi hệ thống: " + e.getMessage());
            }
        }
    }
}