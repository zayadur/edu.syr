/***********************************\
|   TankCar class for Homework 3    |
|   @author                         |
|       Zayadur Khan | CIS-351      |
\***********************************/

public class TankCar extends RailroadCar {
    protected double length;
    protected double radius;

    // zero-parameter constructor
    public TankCar() {
        length = 50;
        radius = 5;
    }

    // three-parameter constructor
    public TankCar(double l, double r, double w, double y) {
        length = l; radius = r; weight = w; year = y;
    }

    // setters
    
    public void setLength(double l) {
        length = l;
    }

    public void setRadius(double r) {
        radius = r;
    }

    public void setWeight(double w) {
        weight = w;
    }
    
    public void setYear(double y) {
        year = y;
    }

    // getters

    public double getLength() {
        return length;
    }

    public double getRadius() {
        return radius;
    }

    public double getWeight() {
        return weight;
    }

    public double getYear() {
        return year;
    }

    // class method for volume
    public static double cVolume(double length, double radius) {
        return Math.PI * Math.pow(radius,2) * length;
    }

    // instance method for volume
    public double iVolume() {
        return Math.PI * Math.pow(radius,2) * length;
    }

    public static void main(String[] args) {

        TankCar t1 = new TankCar();
        TankCar t2 = new TankCar(60, 10, 10450, 1984);

        // class method
        System.out.println("Volume of Tankcar 1 is: " + cVolume(50, 5) + " cubic feet.");
        // instance method test
        System.out.println("Volume of Tankcar 2 is: " + t2.iVolume() + " cubic feet.");
        // calculate volume with individual dimensions
        System.out.println("Calculated volume of Tankcar 1 is: " + Math.PI * Math.pow(t1.getRadius(),2) * t1.getLength());

        // other tests
        t1.setLength(70); t1.setRadius(10);
        System.out.println("Dimensions of Tankcar 1: " + t1.getLength()+"  "+t1.getRadius());

        // RailroadCar tests
        System.out.println("Weight of Toxcar 2: " + t2.getWeight());
        System.out.println("Manufacture year of Toxcar 2: " + t2.getYear());
    }
}