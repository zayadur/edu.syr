/********INFO********
  * ECS-102, HW6    *
  * By Zayadur Khan *
  * RPS.java        *
  ********************/

/************PSEUDOCODE***********
  * main
  * > run result=pickWinner
  * > if result = 1
  * >> win
  * > if result = 2
  * >> lose
  * > if result = 3
  * >> tie
  * 
  * computerPlay
  * > random double
  * > if double is 1/3
  * >> R
  * > if double 2/3
  * >> P
  * >> S
  * 
  * personPlay
  * > take input
  * 
  * pickWinner
  * > if input is R
  * >> if computer is R
  * >>> result = 3
  * >> if computer is P
  * >>> result = 2
  * >> if computer is S
  * >>> result = 1
  * 
  * > if input is P
  * >> if computer is R
  * >>> result = 1
  * >> if computer is P
  * >>> result is 3
  * >> if computer is S
  * >>> result is 2
  * 
  * > if input is S
  * >> if computer is R
  * >>> result = 2
  * >> if computer is P
  * >>> result = 1
  * >> if computer is S
  * >>> result = 3
  ********************************/ 

import java.util.Random;
import java.util.Scanner;


public class RPS {
  
  public static void main(String[] args) {
    
    String c = computerPlay(); //assign computerPlay to c
    String p = personPlay(); //assign personPlay to p
    //System.out.print(pickWinner(c, p));
    
    int result=pickWinner(c, p); //set result to defining method
    
    if(result==1) {
      System.out.println("You beat the computer!");
    }
    else if(result==2) {
      System.out.println("The computer has beat you!");
    }
    else if(result==3) {
      System.out.println("It's a tie!");
    }
    
  } //end main
  
  public static String computerPlay() {
    
    String comp;
    double d = Math.random();
    
    if(d<.33) {
      comp="R"; //chance of R is 1/3
    }
    else if(d<.66) {
      comp="P"; //chance of P is 1/3
    }
    else {
      comp="S"; //chance of S is 1/3
    }
    
    //System.out.print(d); //testing random value
    return comp;
    
  } //end computerPlay
  
  public static String personPlay() { //ask for user input and store in play
    
    Scanner input = new Scanner(System.in);
    System.out.print("Choose rock (R), paper (P), or scissor (S)");
    String play = input.next();
    return play; 
    
  } //end personPlay
  
  public static int pickWinner(String comp, String play) { //grab computer and user input and decide results
    
    int result=0;
    if(play.equalsIgnoreCase("R")) {
      
      if(comp.equalsIgnoreCase("P")) {
        result=2;
      }
      else if(comp.equalsIgnoreCase("S")) {
        result=1;
      }
      else if(comp.equalsIgnoreCase("R")) {
        result=3;
      }
    }
    
    if(play.equalsIgnoreCase("P")) {
      
      if(comp.equalsIgnoreCase("P")) {
        result=3;
      }
      else if(comp.equalsIgnoreCase("S")) {
        result=2;
      }
      else if(comp.equalsIgnoreCase("R")) {
        result=1;
      }
    }
    
    if(play.equalsIgnoreCase("S")) {
      
      if(comp.equalsIgnoreCase("P")) {
        result=1;
      }
      else if(comp.equalsIgnoreCase("S")) {
        result=3;
      }
      else if(comp.equalsIgnoreCase("R")) {
        result=2;
      }
    }
    
    return result;
    
  } //end pickWinner
  
} //end class