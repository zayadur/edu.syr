import java.util.Scanner;

public class DrawStars
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.print("How many stars would you like? ");
    int amt = input.nextInt();
    amt = amt * 2;
    
    for(int i=1;i<=amt;i++)
    {
      System.out.print("*");
    }
  }
}