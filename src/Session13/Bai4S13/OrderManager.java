package Session13.Bai4S13;
import java.util.ArrayList;

public class OrderManager implements Manage<Order> {

    private ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void add(Order item) {
        orders.add(item);
    }

    @Override
    public void update(int index, Order item) {
        if (index >= 0 && index < orders.size()) {
            orders.set(index, item);
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < orders.size()) {
            orders.remove(index);
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            System.out.println(i + ". " + orders.get(i));
        }
    }
}