/************************
  * Seconds.java
  * Part of: ECS-102 HW2
  * By: Zayadur Khan
  * *********************/

import java.util.Scanner;

public class Seconds
{
  public static void main(String[] args)
  {
    int seconds;
    int minutes;
    int hours;
    int time;
    
    Scanner input = new Scanner(System.in);
    
    System.out.print("Please enter the number of seconds: ");
    seconds = input.nextInt();
    System.out.print("Please enter the number of minutes: ");
    minutes = input.nextInt();
    System.out.print("Please enter the number of hours: ");
    hours = input.nextInt();
    
    time = seconds+(minutes*60)+(hours*3600);
    
    System.out.println("Based on your input of " + seconds + " seconds, " + minutes + " minutes, " + hours + " hours, ");
    System.out.println("the total number of seconds is: " + time);
  }
}