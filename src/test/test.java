package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> ds = new ArrayList();


        for (int i = 0; i < 3; i++) {
            ds.add(scanner.nextLine());

        }

        System.out.println(ds.get(2));
        System.out.println("sua ten");

        ds.set(1, "Hồ Đức Minh");

        System.out.println("xoa 1 sinh vien");
        ds.remove(0);


        System.out.println("them 1 sinh vien theo vi tri");

        int index = scanner.nextInt();
        scanner.nextLine();
        ds.set(index,scanner.nextLine());


        System.out.println("tim kiem cac  sinh vien chua ten văn");


        for (String s : ds) {


            if (s.contains("văn")) {
                System.out.println("da tim thay" + ds.get(index));


            } else {
                for (int i = 0; i < ds.size(); i++) {
                    System.out.println(ds.get(i));
                }
            }

        }


    }

}
