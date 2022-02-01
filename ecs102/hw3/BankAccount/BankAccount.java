/*******************
  * ECS-102, HW3
  * BankAccount.java
  * By Zayadur Khan
  * ****************/

import java.util.*;

public class BankAccount
{
  public static void main(String[] args)
  {
    Random rnd = new Random();
    int randNum1 = rnd.nextInt((99 - 10) + 1) + 10;
    int randNum2 = rnd.nextInt((99 - 10) + 1) + 10;
    int randNum3 = rnd.nextInt((99 - 10) + 1) + 10;
    String alpha = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    int slot = alpha.length();
    int pos = (randNum1 + randNum2 + randNum3) % 26;
    char chrctr = alpha.charAt(pos);
    
    System.out.println("***" + randNum1 + randNum2 + randNum3 + chrctr + "***");
  }
}