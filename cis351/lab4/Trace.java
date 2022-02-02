/*****************\
* @author         *
*   Zayadur Khan  *
* @version        *
*   093016        *
\*****************/

import java.io.*;

public class Trace {
  ////////////////////////////////////////////////////////////////////////
  // Class variables
  private static int d;

  ////////////////////////////////////////////////////////////////////////
  // Instance variables
  String name;
  
  ////////////////////////////////////////////////////////////////////////
  // This constructor stores the name String and prints out an
  // ``Entering'' message
  
  public Trace(String n) {
    name = n;
    System.out.println(">> Entering: " + name);
  }
  
  ////////////////////////////////////////////////////////////////////////
  // This constructor stores the name String and prints out an
  // `Entering'' message using the name and the extra information
  // supplied in the String with.
  
  public Trace(String n, String with) {
    name = n;
    while(true) {
      Spaces(d);
      d++;
      if(d > 10) break;
    }
    System.out.println(">> Entering: " + name + " with: " + with);
  }
  
  ////////////////////////////////////////////////////////////////////////
  // This method prints a farewell message when invoked.
  public void bye(int result) {
    while(d > result) {
      Spaces(d);
      d--;
      if(d < 0) break;
    }
    System.out.println("<< Leaving:  " + name + " with result: " + result);
  }
  
  ////////////////////////////////////////////////////////////////////////
  // Given an integer n, this method prints n blank spaces on the
  // current line of output.
  
  private void Spaces(int n) {
    for (int i=0; i<n; i++ ) System.out.print(" ");
  }
  ////////////////////////////////////////////////////////////////////////
}
