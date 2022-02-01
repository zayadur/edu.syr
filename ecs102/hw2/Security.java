/************************
  * Security.java
  * Part of: ECS-102 HW2
  * By: Zayadur Khan
  * *********************/

import java.util.Scanner;

public class Security
{
  public static void main(String[] args)
  {
    int first; //First sequence of numbers
    int middle; //Second sequence of numbers
    int last; //Third sequence of numbers
    String ss; //Social security number
    
    Scanner input = new Scanner(System.in); //New scanner instance to accept input
    
    System.out.print("Please enter the first 3 digits of your SS number: ");
    first = input.nextInt();
    System.out.print("Please enter the next 2 digits of your SS number: ");
    middle = input.nextInt();
    System.out.print("Please enter the last 4 digits of your SS number: ");
    last = input.nextInt();
    
    ss = first + "-" + middle + "-" + last; //Set the SS number to inputs
    
    System.out.println("Your social security number is: " + ss);
    System.out.println("Be careful! \"Don't give your SS number over the phone!\"");
  }
}
