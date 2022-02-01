//looper program for lab 10
//practice using loops

public class Looper
{
  public static void main(String[] args)
  {
    int i;
    double sum;
    int n;
    
    //initialize sum and counter
    sum = 0;
    n = 1;
    i = 1/n;
    
    //add the squares of integers from 1 to (whatever is after <=)
    while (n<=1001)
    {
      sum = sum += i*i;
      n++;
    }
    
    System.out.println("The sum of the squares is " + sum);
  }
}
