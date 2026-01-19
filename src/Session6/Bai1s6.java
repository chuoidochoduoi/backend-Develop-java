package Session6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai1s6 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Double> diemSV = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            menu();
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    nhapDiem();
                    break;
                case 2:
                    inDanhSach();
                    break;
                case 3:
                    tinhDiemTrungBinh();
                    break;
                case 4:
                    timMaxMin();
                    break;
                case 5:
                    demDatTruot();
                    break;
                case 6:
                    sapXepTangDan();
                    break;
                case 7:
                    thongKeGioiXuatSac();
                    break;
                case 8:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 8);
    }

    static void menu() {
        System.out.println("\n********** QUẢN LÝ ĐIỂM SV **********");
        System.out.println("1. Nhập danh sách điểm sinh viên");
        System.out.println("2. In danh sách điểm");
        System.out.println("3. Tính điểm trung bình");
        System.out.println("4. Tìm điểm cao nhất và thấp nhất");
        System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
        System.out.println("6. Sắp xếp điểm tăng dần");
        System.out.println("7. Thống kê sinh viên giỏi và xuất sắc");
        System.out.println("8. Thoát");
    }

    static void nhapDiem() {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        diemSV.clear();

        for (int i = 0; i < n; i++) {
            double diem;
            do {
                System.out.print("Nhập điểm SV " + (i + 1) + ": ");
                diem = sc.nextDouble();
            } while (diem < 0 || diem > 10);

            diemSV.add(diem);
        }
    }

    static void inDanhSach() {
        if (diemSV.isEmpty()) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }
        System.out.println("Danh sách điểm:");
        for (double d : diemSV) {
            System.out.print(d + "  ");
        }
        System.out.println();
    }

    static void tinhDiemTrungBinh() {
        if (diemSV.isEmpty()) return;

        double sum = 0;
        for (double d : diemSV) {
            sum += d;
        }
        System.out.println("Điểm trung bình: " + (sum / diemSV.size()));
    }

    static void timMaxMin() {
        if (diemSV.isEmpty()) return;

        double max = Collections.max(diemSV);
        double min = Collections.min(diemSV);

        System.out.println("Điểm cao nhất: " + max);
        System.out.println("Điểm thấp nhất: " + min);
    }

    static void demDatTruot() {
        int dat = 0, truot = 0;

        for (double d : diemSV) {
            if (d >= 5) dat++;
            else truot++;
        }

        System.out.println("Số SV đạt: " + dat);
        System.out.println("Số SV trượt: " + truot);
    }

    static void sapXepTangDan() {
        Collections.sort(diemSV);
        System.out.println("Đã sắp xếp điểm tăng dần!");
        inDanhSach();
    }

    static void thongKeGioiXuatSac() {
        int gioi = 0, xuatSac = 0;

        for (double d : diemSV) {
            if (d >= 9) xuatSac++;
            else if (d >= 8) gioi++;
        }

        System.out.println("Số SV giỏi: " + gioi);
        System.out.println("Số SV xuất sắc: " + xuatSac);
    }
}
