//NestedLoops.java
public class NestedLoops
{
  public static void main(String[] args)
  {
    int row;
    int column;
    
//    for (row = 10; row <= 40; row +=10) COMMENTED FOR P"A"RT E
//    {    
//      for (column = 1;column <=3; column++)
//      {
//         System.out.println("row: "+row+" column "+column);
//      }
/* Part C */
//      for (column = 1;column <=1; column++)
//      {
//         System.out.print("row: "+row+" column "+column);
//      }
//      
//      for (column = 2;column <=2; column++)
//      {
//         System.out.print(" "+column);
//      }
//      
//      for (column = 3;column <=3; column++)
//      {
//         System.out.println(" "+column);
//      }
/* Part D */
//      for (column = 1;column <=1; column++)
//      {
//         System.out.print(row+column);
//      }
//      for (column = 2;column <=2; column++)
//      {
//         System.out.print(" "+(row+column));
//      }
//      for (column = 3;column <=3; column++)
//      {
//         System.out.println(" "+(row+column));
//      }
/* Part E */
    for (row = 0; row <= 70; row+= 10)
    {
//      for (column = 0;column <=0; column++)
//      {
//         System.out.print((row+column));
//      }
//      for (column = 1;column <=1; column++)
//      {
//         System.out.print(" "+(row+column));
//      }
//      for (column = 2;column <=2; column++)
//      {
//         System.out.print(" "+(row+column));
//      }
//      for (column = 3;column <=3; column++)
//      {
//         System.out.print(" "+(row+column));
//      }
//      for (column = 4;column <=4; column++)
//      {
//         System.out.print(" "+(row+column));
//      }
//      for (column = 5;column <=5; column++)
//      {
//         System.out.print(" "+(row+column));
//      }
//      for (column = 6;column <=6; column++)
//      {
//         System.out.print(" "+(row+column));
//      }
//      for (column = 7;column <=7; column++)
//      {
//         System.out.print(" "+(row+column));
//      }
//      for (column = 8;column <=8; column++)
//      {
//         System.out.print(" "+(row+column));
//      }
//      for (column = 9;column <=9; column++)
//      {
//         System.out.println(" "+(row+column));
//      }
/* Part II */
      for (column = 1;column <=1; column++)
      {
         System.out.print(" "+column+"A");
      }
      for (column = 2;column <=2; column++)
      {
         System.out.print(" "+column+"B");
      }
      for (column = 3;column <=3; column++)
      {
         System.out.print(" "+column+"C");
      }
      for (column = 4;column <=4; column++)
      {
         System.out.print(" "+column+"D");
      }
      for (column = 5;column <=5; column++)
      {
         System.out.print(" "+column+"E");
      }
      for (column = 6;column <=6; column++)
      {
         System.out.println(" "+column+"F");
      }
    }
  }
}

/* OUTPUTS
 * PART C
 > run NestedLoops
 row: 10    columns:     1   2   3
 row: 20    columns:     1   2   3
 row: 30    columns:     1   2   3
 row: 40    columns:     1   2   3
 >
 * PART D
 > run NestedLoops
 11  12  13
 21  22  23
 31  32  33
 41  42  43
 >
 * PART E
 > run NestedLoops
 0   1   2   3   4   5   6   7   8   9
 10  11  12  13  14  15  16  17  18  19
 20  21  22  23  24  25  26  27  28  29
 30  31  32  33  34  35  36  37  38  39
 40  41  42  43  44  45  46  47  48  49
 50  51  52  53  54  55  56  57  58  59
 60  61  62  63  64  65  66  67  68  69
 70  71  72  73  74  75  76  77  78  79
 >
 * PART II
 > run NestedLoops
 1A 2B 3C 4D 5E 6F
 1A 2B 3C 4D 5E 6F
 1A 2B 3C 4D 5E 6F
 1A 2B 3C 4D 5E 6F
 1A 2B 3C 4D 5E 6F
 1A 2B 3C 4D 5E 6F
 1A 2B 3C 4D 5E 6F
 1A 2B 3C 4D 5E 6F
 >
 */