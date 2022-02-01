/* numArray.java for ECS-102, lab 16
 * By: Zayadur Khan
 * Creates array of multiple values and sums them up at the end */

import java.util.*;

public class numArray
{
  public static void main(String[] args)
  {
    int[] data = new int[16];
    data[0] = 5;
    data[1] = 10;
    data[2] = 15;
    data[3] = 20;
    data[4] = 25;
    data[5] = 30;
    data[6] = 35;
    data[7] = 40;
    
    for(int i = 0; i < 8; i++)
    {
      System.out.print("" + "\t" + data[i]);
    }
    
    data[8] = (int) Math.pow(0, 2);
    data[9] = (int) Math.pow(1, 2);
    data[10] = (int) Math.pow(2, 2);
    data[11] = (int) Math.pow(3, 2);
    data[12] = (int) Math.pow(4, 2);
    data[13] = (int) Math.pow(5, 2);
    data[14] = (int) Math.pow(6, 2);
    data[15] = (int) Math.pow(7, 2);
    
    for(int i = 8; i < 16; i++)
    {
      System.out.println("" + "\t" + data[i]);
      System.out.println();
    }
    
    int sum = 0;
    
    for(int i = 0; i < data.length; i++)
    {
      sum += data[i];
    }
    
    System.out.println("Sum: " + sum);
  }
}

/* Output
> run numArray
 
 5 10 15 20 25 30 35 40 0

 1

 4

 9

 16

 25

 36

 49

Sum: 320
*/