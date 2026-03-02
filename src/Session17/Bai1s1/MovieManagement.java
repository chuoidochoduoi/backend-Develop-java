package Session17.Bai1s1;
import java.sql.*;

public class MovieManagement {

    private final String URL = "jdbc:mysql://localhost:3306/MovieDB";
    private final String USER = "root";
    private final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addMovie(String title, String director, int year) {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call add_movie(?, ?, ?)}")) {

            stmt.setString(1, title);
            stmt.setString(2, director);
            stmt.setInt(3, year);

            stmt.execute();
            System.out.println("Thêm phim thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm phim: " + e.getMessage());
        }
    }

    public void listMovies() {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call list_movies()}");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("director") + " | " +
                                rs.getInt("year")
                );
            }

        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách phim: " + e.getMessage());
        }
    }

    public void updateMovie(int id, String title, String director, int year) {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call update_movie(?, ?, ?, ?)}")) {

            stmt.setInt(1, id);
            stmt.setString(2, title);
            stmt.setString(3, director);
            stmt.setInt(4, year);

            stmt.execute();
            System.out.println("Cập nhật thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật: " + e.getMessage());
        }
    }

    public void deleteMovie(int id) {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call delete_movie(?)}")) {

            stmt.setInt(1, id);
            stmt.execute();

            System.out.println("Xóa thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa: " + e.getMessage());
        }
    }
}