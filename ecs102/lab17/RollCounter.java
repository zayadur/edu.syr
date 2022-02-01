import java.io.*;
import java.util.*;

public class RollCounter
{
  public static void main(String[] args)
  {
    Die d1 = new Die();
    
    Scanner input = new Scanner(System.in);
    int counter[] = new int[7];
    
    int count = die1.roll();
    counter[count]++;
    
    for (int i = 0; i < counter.length; i++)
    {
      System.out.println(i + "\t" + counter[i]);
    }
  }