/**********INFO*********
  * ECS102, HW6
  * Pig.java
  * By Zayadur Khan
  * *********************/

/***PSEUDOCODE***
  * create scanner and totalscore variable
  * for 5 turns
  * >take response
  * >variable for turnscore, print score turn and turn number
  * >>roll dice 1 and 2 and print
  * >>prompt to roll again
  * >>add up total score
  * >print total score
  * >method to set dice roll to random between 1 and 6
  * **************/

import java.util.Scanner;

public class Pig
{
  public static void main (String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int totalScore = 0;
    
      for (int turns1=1; turns1<=5; turns1++) //run for 5 turns
      {
        String response = ""; //object for 
        System.out.println();
        System.out.println("Turn " + turns1); //display turn number
        int turnScore = 0;
        
        do
        {   
          int roll1 = rollDie();
          int roll2 = rollDie();
          System.out.println("  You rolled a " + roll1 + " and a " + roll2); //display dice values
          turnScore += (roll1 + roll2);
          System.out.print("  Enter R to roll "); //prompt user to roll die
          response = scan.nextLine();
        }
        while (response.equals("") && turnScore>0);
        {
          System.out.println("Turn score: " + turnScore); //print turn's score
          totalScore += turnScore; //set value of total score
        }
      }
      
      System.out.println();
      System.out.print("Total score: " + totalScore);
      System.out.println();
    }

  
  public static int rollDie()
  {
    return (int)(6*Math.random()) + 1;
  }
}
