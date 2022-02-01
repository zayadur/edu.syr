//SortTester.java
import java.util.*;
import java.io.*;
public class SortTester {
  public static void main(String[] args) throws IOException
  {
    int[] numbers={5, 2, 30, 45, 2, -1, 3};
    Sorting.intSort(numbers);
    
    //print the sorted array
    for(int each : numbers)
    { System.out.println(each ); }
    
    
    //Create a Scanner that reads from System.in (the keyboard)
    Scanner input = new Scanner(System.in);
    
    //Declare an array of 4 Rectangles
    Rectangle[] arr = new Rectangle[4];
    
    //Use a loop to construct the 4 rectangles and 
    //  read their values from the keyboard
    for(int i = 0; i < arr.length; i++)
    {
      System.out.print("Enter the height: ");
      int height = input.nextInt();
      input.nextLine();
      System.out.print("Enter the width: ");
      int width = input.nextInt();
      arr[i] = new Rectangle(height, width);
      
      //Rectangle.read();
    }
    
    //Sort the array of 4 Rectangle
    Sorting.ComparableSort(arr);
    
    //Use a for each loop to print each Rectangle, and its area,
    // to the console window.
    for(Rectangle rect : arr)
    {
      System.out.print(rect);
      System.out.println(" Area " + rect.getArea());
    }    
    
    //Create a Scanner that read from the file "rectangleData.txt
    Scanner fileScan = new Scanner(new File("rectangleData.txt"));
    
    //Declare an array, rects, of 10 Rectangles
    Rectangle[] arrr = new Rectangle[10];
    
    //Use a loop to construct the 10 Rectangles and read their values
    //   from the file rectangleData.txt
    
    while(fileScan.hasNext())
    {
      for(int i = 0; i < arrr.length; i++)
      {
        int height = fileScan.nextInt();
        int width = fileScan.nextInt();
        arrr[i] = new Rectangle(height, width);
      }
    }
    
    //Sort the array of 10 Rectangles
    Sorting.ComparableSort(arrr);
    
    //Use a for each loop to print each Rectangle, and its area,
    // to the console window.
    for(Rectangle rects : arrr)
    {
      System.out.print(rects);
      System.out.println(" Area: " + rects.getArea());
    }
    
    //Use a for each loop to print each Rectangle in the array rects,
    //   and its area, to the file sortedRects.txt
    PrintWriter outfile = new PrintWriter("sortedRects.txt");
    for(Rectangle rectangle : arrr)
    {
      outfile.print(rectangle);
      outfile.println(" Area: " + rectangle.getArea());
    }
    outfile.close();
    
    System.out.print("Enter the taget area: ");
    int target = input.nextInt();
    Searching.binarySearch(arrr, target);
    
  }// end main
} //end SortTester

/* OUTPUT
-1
2
2
3
5
30
45
h: 1 w: 2 Area: 2
h: 2 w: 4 Area: 8
h: 3 w: 6 Area: 18
h: 4 w: 8 Area: 32
h: 5 w: 10 Area: 50
h: 6 w: 12 Area: 72
h: 7 w: 14 Area: 98
h: 8 w: 16 Area: 128
h: 9 w: 18 Area: 162
h: 10 w: 20 Area: 200
*/
