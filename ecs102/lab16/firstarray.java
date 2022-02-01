// firstarray.java
// edited by Zayadur Khan, ECS-102
import java.util.*;
public class firstarray
{
  public static final int size=5;
  public static void main(String[] arg)
  {
    int i, top;
    int[] m = new int[size];
    double[] y= new double[size];
    
    //fill the array m with even numbers
    for (i=0; i<size; i++)
      m[i] = 2*i;
    
    //print the array
    for (i=0; i<size; i++)
      System.out.println(m[i]);
    
    top = 3; //we don't have to use the whole array
    for (i=0; i<top; i++)
    {
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a real number: ");
      y[i]=scan.nextDouble();
    }
    
    //print the filled part of the array
    System.out.println("index  value\n");
    for (i=0; i<top; i++)
      System.out.println("  " + i + "     " + y[i]);  
  }
}
