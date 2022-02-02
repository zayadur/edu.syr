//*************************************************
// ComputingExpressions.java Author: Baruch
// Edited by Zayadur Khan
// What will be the output?
//*************************************************
public class ComputingExpressions
{
 public static void main (String[] args)
 {
 int ants = 41, bees;
 final int BIG = 1000;
 char y = 'S' ,z = 'U';
 double k = 6.2;
 
 System.out.println("1. " + ( 3 + ants * 2) );
 System.out.println("2. " + ( (3 + ants) * 2) );
 bees = ants % 35;
 System.out.println("3. " + bees );
 bees = ants % 5;
 System.out.println("4. " + bees ); 
 ants = BIG + 5;
 bees = BIG - 1;
 System.out.println("5. ants = " + ants + " bees = " + bees );
 System.out.println("6. Go " + y + z );
 System.out.println("7. Doubles can be variables " + k +
 " or literals "+ 4.5);
 /* Integer arithmetic */
 System.out.println("8. 3/4 = " + (3/4));
 System.out.println("9. 53/10 = " + (53/10));
 System.out.println("10. Remainders: 53%10 = " + (53%10));
 }
}