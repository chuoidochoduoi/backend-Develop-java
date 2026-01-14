import HomeWork.Session1.Bai4;

import Session2.S2Bai3;
import Session2.S2Bai4;
import Session2.S2Bai6;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        Session1 s1 = new Session1();
//         s1.radius(6);


//        int firstNumber = scanner.nextInt();
//
//        int secondNumber = scanner.nextInt();

//        Bai2 bai2 = new Bai2();
//        bai2.calculator(firstNumber, secondNumber);


//        Bai3 bai3 = new Bai3();
//        bai3.nhapxuat(1,2,1,3);

//        Bai4 bai4 = new Bai4();
//        bai4.square(3,4);


        // Session 2

//        Bai5 bai5 = new Bai5();
//        bai5.ReadNumber(0);

//        S2Bai6 s2Bai6 = new S2Bai6();
//        s2Bai6.ArmstrongNumber(155);

//        S2Bai4 S2Bai4 = new S2Bai4();
//        S2Bai4.trigle(3,4,2);


//        S2Bai3 s2Bai3 = new S2Bai3();
//        s2Bai3.CalAll(3974);

    boolean flag = true;
    while (flag) {
        System.out.println("1. Tinhs giai thừa n\n" +
                "2.tinh tong n dau tien \n" +
                "3.tim cac uoc cua n \n" +
                "4.thoat");


        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                int n1 = scanner.nextInt();



                int count =1;
                for (int i=1;i<=n1;i++) {

                    count *= i;
                }
                System.out.println("tong la"+count);

             break;
             case 2:
                 int n2 = scanner.nextInt();

                 int count2 =0;
                 for(int i=0;i<=n2;i++){
                     count2+= i;
                 }
                 System.out.println("tong la"+count2);

                 break;
                 case 3:
                     System.out.println("cac uoc la");

                     int n3 = scanner.nextInt();

                     System.out.println("cac uoc la");
                     for (int i=1;i<=n3;i++){
                         if (n3%i==0){
                             System.out.println(i);
                         }
                     }
                     break;
                     case 4:
                         flag = false;
                         break;

        }


    }




    }
}