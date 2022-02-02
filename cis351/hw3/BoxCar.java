/*******************************\
|   BoxCar class for Homework 3 |
|   @author                     |
|       Zayadur Khan | CIS-351  |
\*******************************/

public class BoxCar extends RailroadCar {
    protected double height;
    protected double length;
    protected double width;

    // zero-parameter constructor
    public BoxCar() {
        height = 10; length = 55; width = 9.4; weight = 6500; year = 1999;
    }

    // three-parameter constructor
    public BoxCar(double h, double l, double w, double we, double y) {
        height = h; length = l; width = w; weight = we; year = y;
    }

    // setters

    public void setHeight(double h) {
        height = h;
    }
    
    public void setLength(double l) {
        length = l;
    }

    public void setWidth(double w) {
        width = w;
    }

    public void setWeight(double we) {
        weight = we;
    }

    public void setYear(double y) {
        year = y;
    }

    // getters

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getWeight() {
        return weight;
    }

    public double getYear() {
        return year;
    }

    // class method for volume
    public static double cVolume(double height, double length, double width) {
        return height * width * length;
    }

    // instance method for volume
    public double iVolume() {
        return height * width * length;
    }

    public static void main(String[] args) {

        BoxCar b1 = new BoxCar();
        BoxCar b2 = new BoxCar(11, 9, 60, 6500, 1999);

        // class method
        System.out.println("Volume of the Boxcar 1 is: " + cVolume(10, 55, 9.4) + " cubic feet.");
        // instance method test
        System.out.println("Volume of the Boxcar 2 is: " + b2.iVolume() + " cubic feet.");
        // calculate volume with individual dimensions
        System.out.println("Calculated volume of Boxcar 1 is: " + b1.getLength()*b1.getHeight()*b1.getWidth());

        // other tests
        b1.setLength(60); b1.setHeight(9); b1.setWidth(11);
        System.out.println("Dimensions of Boxcar 1 (L, H, W): " + b1.getLength()+"  "+b1.getHeight()+"  "+b1.getWidth());

        // RailroadCar tests
        System.out.println("Weight of Boxcar 2: " + b2.getWeight());
        System.out.println("Manufacture year of Boxcar 2: " + b2.getYear());
    }
}