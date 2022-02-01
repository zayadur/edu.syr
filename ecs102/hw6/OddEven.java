/********INFO********
  * ECS-102, HW6    *
  * By Zayadur Khan *
  * OddEven.java    *
  ********************/

/************PSEUDOCODE***********
  * while there is a number > 0   *
  * > if number is divisible by 10*
  * >> add to 0 and even          *
  * > if number is divisible by 2 *
  * >> add to even                *
  * > in other cases              *
  * >> add to odd                 *
  * print out information         *
  **********************************/ 

import java.util.Scanner;

public class OddEven {
  
  public static void main(String[] args) {
    
    int num, even=0, odd=0, zero=0; //requested reults
    Scanner input; //for scanner
    
    input = new Scanner(System.in); //Initialize the scanner
    System.out.print("Enter a number: "); //Ask for number
    num = input.nextInt(); //Store number in num
    
    //Make sure there is a number!
    while (num > 0) {
      
      if ((num%10)==0) { //if number is divisible by 10, increment 0 and even
        zero++;
        even++;
      }
      else if (num%2==0) { //if number is divisible by 2, increment even
        even++;
      }
      else { //in all other cases, increment odd
        odd++;
      }
      
      num /= 10;
    } //end while
    
    //Print out all information
    System.out.println("Your number was: "+num);
    System.out.println("It has "+even+" even digit(s)");
    System.out.println("It has "+odd+" odd digit(s)");
    System.out.println("It has "+zero+" zero(es)");
    
  } //end main
} //end class