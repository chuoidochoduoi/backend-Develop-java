package Session12.Bai1s12;

// Interface định nghĩa hành vi kiểm tra hiệu suất
interface ICapability {
    void checkPerformance();
}

// Abstract Class đóng vai trò bộ khung và lưu trữ trạng thái chung
abstract class Staff {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Staff(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Phương thức trừu tượng bắt buộc các lớp con phải ghi đè logic tính lương
    public abstract double calculateTotalSalary();

    public String getId() { return id; }

    @Override
    public String toString() {
        return "ID: " + id + ", Tên: " + name + ", Lương cơ bản: " + baseSalary;
    }
}