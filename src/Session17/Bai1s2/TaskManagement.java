package Session17.Bai1s2;

import java.sql.*;

public class TaskManagement {

    private final String URL = "jdbc:mysql://localhost:3306/todo_db";
    private final String USER = "root";
    private final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addTask(String taskName, String status) {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call add_task(?, ?)}")) {

            stmt.setString(1, taskName);
            stmt.setString(2, status);
            stmt.execute();

            System.out.println("Thêm công việc thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi thêm task: " + e.getMessage());
        }
    }
    public void updateTaskStatus(int taskId, String status) {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call update_task_status(?, ?)}")) {

            stmt.setInt(1, taskId);
            stmt.setString(2, status);
            stmt.execute();

            System.out.println("Cập nhật thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật: " + e.getMessage());
        }
    }
    public void listTasks() {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call list_tasks()}");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status")
                );
            }

        } catch (SQLException e) {
            System.out.println("Lỗi hiển thị: " + e.getMessage());
        }
    }

    public void deleteTask(int taskId) {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call delete_task(?)}")) {

            stmt.setInt(1, taskId);
            stmt.execute();

            System.out.println("Xóa thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi xóa: " + e.getMessage());
        }
    }
    public void searchTaskByName(String taskName) {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call search_task_by_name(?)}")) {

            stmt.setString(1, taskName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status")
                );
            }

        } catch (SQLException e) {
            System.out.println("Lỗi tìm kiếm: " + e.getMessage());
        }
    }
    public void taskStatistics() {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("{call task_statistics()}");
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                System.out.println("Đã hoàn thành: " + rs.getInt("completed"));
                System.out.println("Chưa hoàn thành: " + rs.getInt("not_completed"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi thống kê: " + e.getMessage());
        }
    }
}