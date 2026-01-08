package Session2;

public class                                                                            S2Bai3 {

    public void CalAll(int n) {




        int temp = (n < 0) ? -n : n;
        int sum = 0;


        while (temp > 0) {
            int unitsDigit = temp % 10;
            sum += unitsDigit;
            temp /= 10;
        }

        System.out.println("Tổng các chữ số của " + n + " là: " + sum);


    }

}
