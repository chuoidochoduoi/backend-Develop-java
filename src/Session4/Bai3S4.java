package Session4;

import java.util.Arrays;
import java.util.Scanner;

public class Bai3S4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + i + ": ");
            arr[i] = scanner.nextInt();
        }

        selectionSortDescending(arr);

        System.out.println("\nMảng sau khi sắp xếp giảm dần: " + Arrays.toString(arr));

        System.out.print("\nNhập số cần tìm: ");
        int x = scanner.nextInt();

        int linearResult = linearSearch(arr, x);
        System.out.println("Kết quả tìm kiếm tuyến tính: " +
                (linearResult != -1 ? "Tìm thấy tại chỉ số " + linearResult : "Không tìm thấy"));

        int binaryResult = binarySearchDescending(arr, x);
        System.out.println("Kết quả tìm kiếm nhị phân: " +
                (binaryResult != -1 ? "Tìm thấy tại chỉ số " + binaryResult : "Không tìm thấy"));

        scanner.close();
    }

    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    public static int binarySearchDescending(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) return mid;

            if (arr[mid] < x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
