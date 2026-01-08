package Session2;


public class S2Bai6 {


    public  void ArmstrongNumber (int number){


        int sum = 0;
        int temp = number;
        int n = String.valueOf(number).length();
        while (temp != 0) {
            sum += (int) Math.pow(temp % 10,n);
            temp /= 10;
        }


        if (sum  == number) {
            System.out.println(sum);

        }
        else {
            System.out.println("khong phai so armstrong");

        }


    }
}
