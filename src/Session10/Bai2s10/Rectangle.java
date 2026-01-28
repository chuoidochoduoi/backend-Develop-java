package Session10.Bai2s10;

public class Rectangle extends Shape {
private double width ;
private double height ;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double area(){
        return width * height;
    }
}
