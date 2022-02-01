/******************
  * Earthquake
  * ECS-102, HW5
  * By Zayadur Khan
  * ***************/

import java.util.*;

public class Earthquake
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the Richter Scale Number:");
    double num = input.nextDouble();
    
    if(num<5.0)
    {
      System.out.println("Shaking, but no damage.");
    }
    else if(num>=5.0 && num<6.0)
    {
      System.out.println("Moderate damage.");
    }
    else if(num>=6.0 && num<7.0)
    {
      System.out.println("Damaging to most buildings.");
    }
    else if(num>=7.0 && num<8.0)
    {
      System.out.println("Most buildings collapse partially or completely.");
    }
    else if(num>=8.0)
    {
      System.out.println("Devastating in large area.");
    }
  }
}