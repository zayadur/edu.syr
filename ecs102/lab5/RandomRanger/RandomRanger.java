// **************************************************
// RandomRanger.java
//
// To generate random numbers and understand range
// and shift
// **************************************************
import java.util.Random;
public class RandomRanger
{
  public static void main (String[] args)
  {
    Random generator = new Random();
    int redDie, greenDie, sum;
// Generate some random integers, from the whole range of integers
    System.out.println("Random Integers:");
    System.out.print(generator.nextInt());
    System.out.print("\t " + generator.nextInt());
    System.out.print("\t " + generator.nextInt());
    System.out.println("\t " + generator.nextInt());
    
//Generate some random doubles, from 0 to (but not including) 1, 
    System.out.println("Random Doubles:");
    System.out.print(generator.nextDouble());
    System.out.print("\t " + generator.nextDouble());
    System.out.print("\t " + generator.nextDouble());
    System.out.println("\t " + generator.nextDouble());
    
//Generate some random integers from 0 to (but not including) 5
    System.out.println("Random Integers from 0 through 4");
    System.out.print(generator.nextInt(5));
    System.out.print("\t " + generator.nextInt(5));
    System.out.print("\t " + generator.nextInt(5));
    System.out.print("\t " + generator.nextInt(5));
    System.out.print("\t " + generator.nextInt(5));
    System.out.println("\t " + generator.nextInt(5));
    
//Shift the random numbers up.  lowVal is the lowest value and hiVal is the highest value. 
//Figure out what these values are.
 System.out.println("Random Integers from lowVal1 through hiVal1");
    System.out.print(generator.nextInt(5)+10);
    System.out.print("\t " + (generator.nextInt(5)+10));
    System.out.print("\t " + (generator.nextInt(5)+10));
    System.out.print("\t " + (generator.nextInt(5)+10));
    System.out.print("\t " + (generator.nextInt(5)+10));
    System.out.println("\t " + (generator.nextInt(5)+10));
    
    
//Shift the random numbers down
    System.out.println("Random Integers from lowVal2 through hiVal2");
    System.out.print(generator.nextInt(5)-10);
    System.out.print("\t " + (generator.nextInt(5)-10));
    System.out.print("\t " + (generator.nextInt(5)-10));
    System.out.print("\t " + (generator.nextInt(5)-10));
    System.out.print("\t " + (generator.nextInt(5)-10));
    System.out.println("\t " + (generator.nextInt(5)-10));
    
//Roll one die
    redDie=generator.nextInt(6)+1;
    System.out.println("Red die: " + redDie);
    greenDie=generator.nextInt(6) + 1;
    System.out.println("Green die: " + greenDie);
    
//print out the sum
    sum = redDie + greenDie;
    System.out.println("total: " + sum );
    
  }
}