import java.io.*;
import java.util.Scanner;

public class CCount {
  /** Counts the number of characters making up the file in.   
    * Note: FileReader is class for reading character files.   
    * If in is a FileReader, in.next() returns the next char   
    * (as an int).  When the end-of-file is reached, in.next() 
    * returns -1.                                              
    */
  public static int countChars(FileReader in) 
    throws IOException 
  {
    int count = 0;  
    while (in.read() != -1) count++;
    in.close();
    return count;
  }

  /** Prompt the use for the name of a text file and 
    * then report the number of characters in that file. 
    */
  public static void main(String argv[]) 
    throws IOException 
  {
    boolean done = false;    // may be useful
    int attempt = 0;         // may be useful
    final int tryLimit = 2;  // may be useful
    
    String fileName;
    Scanner stdin = new Scanner(System.in);
    FileReader infile;
    
    System.out.print("Name of the input file: ");  // user prompt
   
    /** Beginning of the part to play with   **/

    try {
      fileName = stdin.next();                       // get name from user
      infile   = new FileReader(new File(fileName)); // open that file as a FileReader
      System.out.println("That file has " + countChars(infile) + " characters.");
    } catch (FileNotFoundException f1) {
      System.out.println("Caught: " + f1 + "\ntry again...");
      try {
        fileName = stdin.next();                       // get name from user
        infile   = new FileReader(new File(fileName)); // open that file as a FileReader
        System.out.println("That file has " + countChars(infile) + " characters.");
      } catch (FileNotFoundException f2) {
          System.out.println("Caught: " + f2);
          //fileName = stdin.next();                       // get name from user
          //infile   = new FileReader(new File(fileName)); // open that file as a FileReader
          //System.out.println("That file has " + countChars(infile) + " characters.");
          done = true;
      } finally {
          if(done == true) System.out.println("Sorry, too many bad inputs");
          return;
        }
      }
    
      
    /**  Ending of the part to play with     **/ 
      

    stdin.close();
  }
}