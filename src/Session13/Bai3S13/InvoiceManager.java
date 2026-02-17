package Session13.Bai3S13;

import Session13.Bai2S13.Manage;
import Session13.Bai2S13.Student;

import java.util.ArrayList;

public class InvoiceManager implements Manage<Invoice>, Session13.Bai3S13.Manage<Invoice> {



    private ArrayList<Invoice> list = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        list.add(item);
        System.out.println("Thêm thành công!");
    }

    @Override
    public void update(int index, Invoice item) {
        if (index >= 0 && index < list.size()) {
            list.set(index, item);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    @Override
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách hóa đơn rỗng!");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i));
        }
    }
}
