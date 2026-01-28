package Session10.Bai4s10;

public class Car {

    int currentSpeed = 0;

    public void  accelerate(){
        currentSpeed += 10;
        System.out.println("Car accelerates by default: +10 km/h");
    }
    public void  accelerate(int speed){
        currentSpeed += speed;

        System.out.println("Car accelerates by "+ speed +  "km/h");
    }
    public void  accelerate(int speed, int seconds){
      int  increase = speed * seconds;
        currentSpeed += increase;
        System.out.println("Car accelerates  "+increase+" km/h");
    }

    public void printstatus(){
        System.out.println("Current speed: X km/h" + currentSpeed + "km/h");
    }
}
