import java.util.Scanner; 
public class DrawTriangle 
{ 
  public static void main(String[] args) 
  { 
    Scanner scan = new Scanner(System.in); 
    int sym; 
    int t; 
    int sp; 
    
    System.out.println("Enter the height of your triangle: "); 
    sym = scan.nextInt(); 
    t = 0; 
    if (sym <5) 
    { 
      for (sym = sym -1; sym >= t; sym--) 
      { 
        for (sp =0; sp <= sym;sp++) 
        { 
          System.out.print("*"); 
        } 
        System.out.println(""); 
      } 
    } 
    if (sym >=5) 
    { 
      for (sym = sym -1; sym >= t; sym--) 
      { 
        for (sp =0; sp <= sym;sp++) 
        { 
          System.out.print("O"); 
        } 
        System.out.println(""); 
      } 
    } 
  } 
}