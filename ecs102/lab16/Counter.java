/* Counter.java for ECS-102, lab 16
 * By: Zayadur Khan
 * Counts the number of elements in a file and displays their frequencies
 */

import java.io.*;
import java.util.*;

public class Counter
{
  public static void main(String[] args) throws IOException
  {
    //set up a scanner to read from a file
    Scanner fileScan = new Scanner (new File("lotsOfNumbers_.txt")); //lotsOfNumbers renamed to process new file with more data
    int counter[] = new int[16];
    int count;
    
    while (fileScan.hasNext())
    {
      count=fileScan.nextInt();
      counter[count]++;
    }
    for (int i = 0; i < counter.length; i++)
    {
      System.out.println(i + "\t" + counter[i]);
    }
  }
}