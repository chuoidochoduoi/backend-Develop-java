package Session5;

import java.util.Scanner;

public class Bai1S5 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String email =sc.nextLine();


    email =        email.trim();


        if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            System.out.println("Hợp lệ");
        }else {
            System.out.println("ko hợp lệ");
        }
    }


}
