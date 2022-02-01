//******************************************************************** 
//  RollingDice.java       Author: Lewis/Loftus 
// 
//  Demonstrates the creation and use of a user-defined class. 
//********************************************************************  
public class RollingDice 
{    
//-----------------------------------------------------------------    
//  Creates two Die objects and rolls them several times.    
//-----------------------------------------------------------------    
  public static void main (String[] args)    
  {       
    Die die1, die2;       
    int sum; 
    
    die1 = new Die();       
    die2 = new Die(); 
    
    die1.roll();       
    die2.roll();       
    System.out.println ("Die One: " + die1 + ", Die Two: " + die2);

    
    die1.roll();       
    die2.setFaceValue(6);
    die1.setFaceValue(1);
    System.out.println ("Die One: " + die1 + ", Die Two: " + die2); 

    
    sum = die1.getFaceValue() + die2.getFaceValue();       
    System.out.println ("Sum: " + sum);  
    

    sum = die1.roll() + die2.roll();       
    System.out.println ("Die One: " + die1 + ", Die Two: " + die2);       


    System.out.println ("New sum: " + sum);   

    System.out.println("" + die1 + die2);
  } 
}