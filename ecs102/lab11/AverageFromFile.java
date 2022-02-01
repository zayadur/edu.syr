/*averagefromfile.java */
/* Compute the average temperature and the high temperature for a month
 from data stored in a file.  Record the answers on the console. */

import java.util.Scanner;
import java.io.*;
import java.text.*;

public class AverageFromFile
{
  public static void main(String [] args) throws IOException
  {
    
    /* declare Scanner for reading from a file */
    Scanner myin = new Scanner(new File("Jan05temps.dat"));
    
    DecimalFormat fmt = new DecimalFormat("#.##");
    
    int count; /*for counting the items*/
    double avg; /*for the sum of the temps */
    int temp; /* the temperature read from file */
    int sum;  /* the sum of the temperatures */
    int high; /* the high temperature */
    
    /* initialize variables */
    count = 0;
    sum = 0;
    high = -100; /* an unreasonably low value */
    
    /* process each valid temperature */
    while (myin.hasNext())
    {
      temp = myin.nextInt(); /*read next temperature*/
      count++;
      sum += temp; /* same as sum = sum + temp; */
      if (temp > high)
        high = temp; /* Update high if this temp is
         highest so far. */    
    } /* end of while */
    
    /* do final calculations */
    avg = (double)sum/count;
    
    /* print to the screen */
    System.out.print("The average temperature for the month ");
    System.out.println("was "+fmt.format(avg)+" degrees Farenheit");
    System.out.print("The highest temperature was "+ high);
    System.out.println(" degrees Farenheit\n");
    System.out.println("Count = "+ count);    
  }
}
