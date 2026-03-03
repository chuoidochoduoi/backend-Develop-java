package Session18.Bai1s18;
import java.sql.*;
import java.util.Scanner;
import java.util.TimeZone;

public class ProductManagementApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(org.postgresql.Driver.class.getPackage().getImplementationVersion());

        System.out.println(TimeZone.getDefault());
        while (true) {
            System.out.println("\n===== PRODUCT MANAGEMENT =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Cập nhật sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Tìm kiếm theo tên");
            System.out.println("5. Thống kê theo danh mục");
            System.out.println("6. Hiển thị tất cả");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> updateProduct();
                case 3 -> deleteProduct();
                case 4 -> searchProduct();
                case 5 -> statisticByCatalog();
                case 6 -> displayAll();
                case 0 -> {
                    System.out.println("Thoát chương trình");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    static void addProduct() {
        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            System.out.print("Tên: ");
            String name = sc.nextLine();

            System.out.print("Giá: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("Mô tả: ");
            String title = sc.nextLine();

            System.out.print("Ngày tạo (yyyy-mm-dd): ");
            String created = sc.nextLine();

            System.out.print("Danh mục: ");
            String catalog = sc.nextLine();

            String sql = """
                    INSERT INTO product
                    (product_name, product_price, product_title,
                     product_created, product_catalog)
                    VALUES (?, ?, ?, ?, ?)
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, title);
            ps.setDate(4, Date.valueOf(created));
            ps.setString(5, catalog);

            ps.executeUpdate();
            conn.commit();

            System.out.println("Thêm thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void updateProduct() {
        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            System.out.print("Nhập ID sản phẩm cần sửa: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Tên mới: ");
            String name = sc.nextLine();

            System.out.print("Giá mới: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("Mô tả mới: ");
            String title = sc.nextLine();

            System.out.print("Danh mục mới: ");
            String catalog = sc.nextLine();

            String sql = """
                UPDATE product
                SET product_name = ?,
                    product_price = ?,
                    product_title = ?,
                    product_catalog = ?
                WHERE product_id = ?
                """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, title);
            ps.setString(4, catalog);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                conn.commit();
                System.out.println("Cập nhật thành công!");
            } else {
                conn.rollback();
                System.out.println("Không tìm thấy sản phẩm!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void deleteProduct() {
        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            System.out.print("Nhập ID sản phẩm cần xóa: ");
            int id = sc.nextInt();
            sc.nextLine();

            String sql = "DELETE FROM product WHERE product_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                conn.commit();
                System.out.println("Xóa thành công!");
            } else {
                conn.rollback();
                System.out.println("Không tìm thấy sản phẩm!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void searchProduct() {
        try (Connection conn = DBConnection.getConnection()) {

            System.out.print("Nhập từ khóa: ");
            String keyword = sc.nextLine();

            String sql =
                    "SELECT * FROM product WHERE product_name ILIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getDouble("product_price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void statisticByCatalog() {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = """
                    SELECT product_catalog,
                           COUNT(*) AS total
                    FROM product
                    GROUP BY product_catalog
                    ORDER BY total DESC
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("product_catalog")
                                + " | Số lượng: "
                                + rs.getInt("total")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void displayAll() {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM product";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getDouble("product_price") + " | " +
                                rs.getString("product_catalog")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}