package Session4;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai4S4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();

        for (int num : arr) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }

        int index = 0;
        for (int num : evens) {
            arr[index++] = num;
        }
        for (int num : odds) {
            arr[index++] = num;
        }

        System.out.print("Mảng sau khi sắp xếp: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + (i == n - 1 ? "" : " "));
        }

        scanner.close();
    }


}
