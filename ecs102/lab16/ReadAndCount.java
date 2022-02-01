//ReadAndCount.java
import java.util.*;
import java.io.*;

public class ReadAndCount
{
  public static void main(String [] arg)  throws IOException
  {
    int x;
    //set up a scanner to read from a file
    Scanner fileScan = new Scanner (new File("lotsOfNumbers.txt"));
    
    //read and process each number in the file
    while (fileScan.hasNext())
    {
      x=fileScan.nextInt();
      System.out.print("  " + x);
    }
  }
}
