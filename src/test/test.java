package test;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {


        String[]  Student = new String[10];


        Student[0] = "An";
        Student[1] = "Binh";
        Student[2] = "Cuong";
        Student[3] = "Dung";
        Student[4] = "Hanh";
        Student[5] = "Khanh";
        Student[6] = "Linh";
        Student[7] = "Minh";
        Student[8] = "Nam";
        Student[9] = "Trang";

        System.out.println("------ MENU ------");
        System.out.println("1. Hiển thị danh sách tên sinh viên");
        System.out.println("2. Tìm kiếm sinh viên theo tên");
        System.out.println("3. Sắp xếp sinh viên theo tên (A-Z || Z-A)");
        System.out.println("4. Thoát");
        System.out.print("Chọn: ");
        Scanner in = new Scanner(System.in);
        int ch = in.nextInt();
        in.nextLine();


        int check = 1;
        switch (check)
        {
            case 1:

                for (int i = 0; i < Student.length; i++) {
                    System.out.println(Student[i]);
                }
                break;
            case 2:

                String search = in.nextLine();
                for (int i = 0; i < Student.length; i++) {
                    if (search.equals(Student[i])) {
                        System.out.println(Student[i]);
                    }
                }

                break;
            case 3:




                break;
            case 4:
                break;
        };


    }

}
