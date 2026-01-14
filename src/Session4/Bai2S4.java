package Session4;

import java.util.Scanner;

public class Bai2S4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số hàng: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Nhập phần tử [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();

                if (matrix[i][j] % 2 == 0) {
                    sumEven += matrix[i][j];
                } else {
                    sumOdd += matrix[i][j];
                }
            }
        }

        System.out.println("Tổng các số chẵn: " + sumEven);
        System.out.println("Tổng các số lẻ: " + sumOdd);

        scanner.close();
    }
}
