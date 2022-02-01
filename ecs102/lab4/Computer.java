// Computer.java   Author: Baruch
// Understand:  integer arithmetic, casting, remainder operator

public class Computer
{
   public static void main(String[] args)
   {
      int aInt, cInt;
      double bDoub;
      System.out.println("Part 1");
      bDoub = 5/2;
      aInt = (int) 3.2;
      cInt = (int) 3.9;
      
      System.out.println("aInt = " + aInt);
      System.out.println("cInt = " + cInt);
      System.out.println("bDoub = " + bDoub);
      
      System.out.println("\nPart 2");
      aInt = 15 % 3;
      cInt = 3 % 15;
      System.out.println("aInt = " + aInt);
      System.out.println("cInt = " + cInt);
      
      System.out.println("\nPart 3");
      aInt = 15 / 3;
      cInt = 3 / 15;
      System.out.println("aInt = " + aInt);
      System.out.println("cInt = " + cInt);
      
      System.out.println("\nPart 4");
      bDoub= 5.1;
      aInt = (int) bDoub;
      System.out.println("aInt = " + aInt);
      System.out.println("bDoub = " + bDoub);
   } // end main
} //end class