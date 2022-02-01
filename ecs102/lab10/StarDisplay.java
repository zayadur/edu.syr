/* StarDisplay
 * ECS-102, Lab 10
 * By: Zayadur Khan
 */

import java.util.*;

public class StarDisplay
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int num;
    int a;
    
    System.out.print("How many stars would you like?: ");
    num = input.nextInt();
    
    for(a=1;a<=num;a++)
    {
      if(num%3==1)
      {
        System.out.print("*");
      }
      else if(num%3==2)
      {
        System.out.print("#");
      }
      else if(num%3==0)
      {
        System.out.print("%");
      }
    }
  }
}
