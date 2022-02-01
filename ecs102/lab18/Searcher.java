import java.io.*;
import java.util.*;

public class Searcher
{
  public static void main(String[] args) throws IOException
  {
    int id[] = new int[15]; //array for IDs
    double gpa[] = new double[15]; //array for GPAs
    
    
    Scanner fileScan = new Scanner(new File("gradepoints.txt"));
    int a = 0, b = 0;
    
    while(fileScan.hasNext())
    {
      id[a++] = fileScan.nextInt();
      gpa[b++] = fileScan.nextDouble();
    }
    
    int start = 0;
    double target = 0;
    
    //printParallel(id, gpa); testing printParallel method
    
    Scanner input = new Scanner(System.in);
//    System.out.print("Enter the ID: ");
//    int target = input.nextInt();
    System.out.print("Enter the start index: ");
    start = input.nextInt();
    
    System.out.print("Enter the GPA: ");
    target = input.nextDouble();
    
    int arrSize = 15;
    
    //System.out.println(search(id, arrSize, target));
    //System.out.println(search(gpa, arrSize, target));
    search(gpa, arrSize, start, target);
    search(gpa, arrSize, start, target);
  }
  
  public static void printArray(double[] gpa) throws IOException
  {
    Scanner fileScan = new Scanner(new File("gradepoints.txt"));
    int a = 0;
    
    while(fileScan.hasNext())
    {
      gpa[a++] = fileScan.nextInt();
    }
  }
  
  public static void printParallel(int[] id, double[] gpa) throws IOException
  {
    Scanner fileScan = new Scanner(new File("gradepoints.txt")); //scan gradepoints file
    int a = 0, b = 0; //counters
    
    while(fileScan.hasNext())
    {
      id[a++] = fileScan.nextInt(); //parse all ints into ID array
      gpa[b++] = fileScan.nextDouble(); //parse all doubles into GPA array
    }
    
    for(int c = 0; c < id.length; c++)
    {
      System.out.print(id[c]); //print IDs
      System.out.println("\t" + gpa[c]); //print GPAs then move to next line
    }
  }
  
  public static int search(int[] id, int arrSize, int target) throws IOException
  {
    for(int i = 0; i < id.length; i++)
    {
      if(id[i] == target)
      {
        System.out.print("ID " + target + " at index ");
        return i;
      }
    }
    return -1;
  }

  public static int search(double[] gpa, int arrSize, double target) throws IOException
  {
    for(int i = 0; i < gpa.length; i++)
    {
      if(gpa[i] == target)
      {
        System.out.print("GPA " + target + " at index ");
        return i;
      }
    }
    return -1;
  }
  
  public static int search(double[] gpa, int arrSize, int start, double target) throws IOException
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter start index: ");
    for(start = input.nextInt(); start < gpa.length-1; start++)
    {
      if(gpa[start] == target)
      {
        System.out.print("GPA " + target + " at index / ");
        return start;
      }
    }
    return -1;
  }
}

/*OUTPUT
> run Searcher
Enter the start index:  3
Enter the GPA:  3.8
GPA 3.8 at index 13 /
Enter start index: 13
GPA 3.8 at index 14 /
>
 */