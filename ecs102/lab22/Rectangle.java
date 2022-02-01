//Rectangle.java
//A Rectangle is bigger if its area is bigger.
//implements Comparable, ie. has a compareTo method
import java.util.*;  //for Scanner
public class Rectangle implements Comparable<Rectangle>
{
  //member data
  int height, width;
  
  //constructors
  //0-parameter constructor.
  //set all member data to 0
  public Rectangle()
  { height = 0; width = 0; }
  
  //2-parameter constructor
  //pass h for height and w for width
  public Rectangle(int h, int w)
  { height = h; 
    width = w; }
  
  //to allow a rectangle to be printed in format
  // h:  45    w: 13
  public String toString()
  { return "h: " + height + "\tw: " + width;
  } //end toString
  
  //return negative if this rectangle's area is less than r's area
  //return positive if this rectangle's area is greater than r's area
  //return 0 if this rectangle's area equals r's area
  public int compareTo(Rectangle r)  
  { 
    if(this.getArea() < r.getArea())
    {
      return -1;
    }
    else if(this.getArea() > r.getArea())
    {
      return 1;
    }
    return 0;
  }
  
  //compute the area and return the area
  public int getArea()
  { 
    int area = height*width;
    return area;
  }
  
  //read from a file or keyboard
  //rectangle data in the form
  //height width
  public void read(Scanner scan) 
  { 
    height = scan.nextInt();
    width = scan.nextInt();
  }
} //end Rectangle
