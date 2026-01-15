package Session5;

import java.util.Random;
import java.util.Scanner;

public class Bai4S5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n (1 ≤ n ≤ 1000): ");
        int n = sc.nextInt();

        if (n < 1 || n > 1000) {
            System.out.println("n không hợp lệ!");
            return;
        }

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";

        Random random = new Random();
        StringBuilder result = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = random.nextInt(chars.length());
            result.append(chars.charAt(index));
        }

        System.out.println("Chuỗi ngẫu nhiên:");
        System.out.println(result.toString());
    }
}
