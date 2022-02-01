import java.util.Scanner;

public class DrawBoxes
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.print("How many boxes would you like? ");
    int amt = input.nextInt();
    
    for (int i = 1; i <= amt; i++)
    {
      System.out.print("\n-----");
      System.out.print("\n|   |\n|   |");
      System.out.print("\n-----");
    }
  }
}