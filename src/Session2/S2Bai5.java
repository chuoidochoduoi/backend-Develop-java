package Session2;

public class S2Bai5 {

    public  void ReadNumber(int number){

        if(number >=100 && number <=999 ){

           int hundreds, tens, units;
            hundreds = number / 100;

            tens = (number % 100)/10;

            units = number % 10;




            System.out.println(hundreds);
            System.out.println(tens);
            System.out.println(units);




        }




        else{
            System.out.println("khong hop le");

        }

    }
}
