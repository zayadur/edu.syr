import java.util.Scanner;
import java.lang.Integer;

public class IntWrapper
{
  public static void main (String[] args)
  {
    Scanner input = new Scanner(System.in);
    int num1;
    String dec1, dec2;
    
    System.out.print("Enter a number: ");
    num1 = input.nextInt();
    
    Integer bin = new Integer(num1);
    Integer hex = new Integer(num1);
    Integer oct = new Integer(num1);
    
    System.out.println("Binary: " + bin.toBinaryString(num1));
    System.out.println("Hexadecimal: " + hex.toHexString(num1));
    System.out.println("Octal: " + oct.toOctalString(num1));
    System.out.println("Max value: " + Integer.MAX_VALUE);
    System.out.println("Min value: " + Integer.MIN_VALUE);
    
    System.out.print("Enter a decimal: ");
    dec1 = input.next();
    System.out.print("Enter another decimal value: ");
    dec2 = input.next();
    System.out.println("Sum of 2 decimal strings: " + (dec1 + dec2));
    
    int decimal1 = Integer.parseInt(dec1);
    int decimal2 = Integer.parseInt(dec2);
    System.out.println("Sum of 2 decimal integers: " + (decimal1 + decimal2));
  }
}