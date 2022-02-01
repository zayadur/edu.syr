/*averagefromfile.java */
/* Compute the average temperature and the high temperature for a month
 from data stored in a file.  Record the answers on the console. */

import java.util.Scanner;
import java.io.*;
import java.text.*;

public class avgHighLow
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(new File("Jan05temps.dat"));
    displayTemp(input);
  }
  
  public static double computeAvg(Scanner input)
  {
    int count; /*for counting the items*/
    count = 0;
    double avg; /*for the sum of the temps */
    int temp; /* the temperature read from file */
    int sum;  /* the sum of the temperatures */
    sum = 0;
    int high; /* the high temperature */
    high = -100;
    while (input.hasNext())
    {
      temp = input.nextInt(); /*read next temperature*/
      count++;
      sum += temp; /* same as sum = sum + temp; */
      if (temp > high)
        high = temp; /* Update high if this temp is
         highest so far. */    
    } /* end of while */
    
    /* do final calculations */
    avg = (double)sum/count;
    return avg;
  }
  
  public static int highTemp(Scanner input)
  {
    int count; /*for counting the items*/
    count = 0;
    double avg; /*for the sum of the temps */
    int temp; /* the temperature read from file */
    int sum;  /* the sum of the temperatures */
    sum = 0;
    int high; /* the high temperature */
    high = -100;
    while (input.hasNext())
    {
      temp = input.nextInt(); /*read next temperature*/
      count++;
      if (temp > high)
        high = temp; /* Update high if this temp is
         highest so far. */    
    } /* end of while */
    
    return high;
  }
  
  public static int lowTemp(Scanner input)
  {
    int count; /*for counting the items*/
    count = 0;
    double avg; /*for the sum of the temps */
    int temp; /* the temperature read from file */
    int sum;  /* the sum of the temperatures */
    sum = 0;
    int low; /* the high temperature */
    low = 100;
    while (input.hasNext())
    {
      temp = input.nextInt(); /*read next temperature*/
      count++;
      if (temp > low)
        low = temp; /* Update high if this temp is
         highest so far. */    
    } /* end of while */
    
    /* do final calculations */
    return low;
  }
  
  public static void displayTemp(Scanner input)
  {
    computeAvg(input);
    highTemp(input);
    lowTemp(input);
  }
}
