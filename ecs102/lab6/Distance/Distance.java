// ************************************************************
// Distance.java  Name:               Section:  
//
// Computes the distance between two points
// ************************************************************
import java.util.Scanner;
public class Distance
{
  public static void main (String[] args)
  {
    double x1, y1, x2, y2; // coordinates of two points
    double distance; // distance between the points
    double difx;
    double dify;
    
    Scanner scan = new Scanner(System.in);
    
// Read in the two points
    System.out.print("Enter the coordinates of the first point " + 
                     "(put a space between them): ");
    x1 = scan.nextDouble();
    y1 = scan.nextDouble();
    System.out.print("Enter the coordinates of the second point: ");
    x2 = scan.nextDouble();
    y2 = scan.nextDouble();
    
// Compute the distance
    difx = (x2-x1)*(x2-x1);
    dify = (y2-y1)*(y2-y1);
    distance = Math.sqrt(difx + dify);
// Print out the answer
    System.out.printf("Distance: " + "%.4f", distance);
  }
}

/* Output
> run Distance
Enter the coordinates of the first point (put a space between them):  [DrJava Input Box]
Enter the coordinates of the second point:  [DrJava Input Box]
Distance: 1.0000>
*/
