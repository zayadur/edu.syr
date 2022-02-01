/************************
  * Change.java
  * Part of: ECS-102 HW2
  * By: Zayadur Khan
  * *********************/

import java.util.Scanner;

public class Change
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in); //New scanner instance to accept input
    
    //Initial values for variables
    int tenDollar = 0;
    int fiveDollar = 0;
    int oneDollar = 0;
    int quarters = 0;
    int dimes = 0;
    int nickels = 0;
    int pennies = 0;
    double money;
    double moneyLeft;
    
    //Ask for money, program begins here
    System.out.print("Enter your balance: ");
    moneyLeft = input.nextDouble();
    money = moneyLeft;
    moneyLeft = moneyLeft * 100;
    
    tenDollar = (int) moneyLeft/1000; 
    moneyLeft -= tenDollar*1000;
      
    fiveDollar = (int) moneyLeft/500;
    moneyLeft -= fiveDollar*500;
      
    oneDollar = (int) moneyLeft/100;
    moneyLeft -= oneDollar*100;
    
    quarters = (int) moneyLeft/25;
    moneyLeft = moneyLeft - quarters*25;
    
    dimes = (int) moneyLeft/10;
    moneyLeft = moneyLeft - dimes*10;
    
    nickels = (int) moneyLeft/5;
    moneyLeft = moneyLeft - nickels*5;
    
    pennies = (int) moneyLeft/1;
    moneyLeft = moneyLeft - pennies*1;
    
    //Display efficient change
    System.out.println("\t" + tenDollar + " $10 bills,");
    System.out.println("\t" + fiveDollar + " $5 bills,");
    System.out.println("\t" + oneDollar + " $1 bills,");
    System.out.println("\t" + quarters + " quarters,");
    System.out.println("\t" + dimes + " dimes,");
    System.out.println("\t" + nickels + " nickels,");
    System.out.println("\t" + pennies + " and pennies");
  }
}
    
      