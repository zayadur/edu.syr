import java.util.*;

public class MusicLovers
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    BandBooster a = new BandBooster();
    a.name = "Samantha";
    a.boxesSold = 25;
    
    System.out.println("" + a.name + ": " + a.boxesSold + " boxes");
    
    BandBooster b = new BandBooster();
    BandBooster c = new BandBooster();
    System.out.print("Enter person 2's name: ");
    b.name = input.nextLine();
    System.out.print("Enter person 3's name: ");
    c.name = input.nextLine();
    System.out.println("Enter the number of boxes sold by " + b.name);
    b.boxesSold = input.nextInt();
    System.out.println("Enter the number of boxes sold by " + c.name);
    c.boxesSold = input.nextInt();
    
    b.boxesSold = b.boxesSold * 3;
    c.boxesSold = c.boxesSold * 3;
    
    System.out.println(b.name + " " + b.boxesSold);
    System.out.println(c.name + " " + c.boxesSold);
  }
}