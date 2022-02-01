//*******************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, and get a String representation
// of the account.
//*******************************************************

import java.util.Random;
public class Account
{
  private double balance;
  private String name;
  private long acctNum;
  private static int numAccounts;
  private static int numDeposits;
  private static int totalDeposits;
  private static int numWithdrawals;
  private static int totalWithdrawals;
  Random generator = new Random();
  
  //----------------------------------------------
  //Constructor -- initializes balance, owner, and account number 
  //----------------------------------------------
  
  public Account (double initBal, String owner, long number) 
  { 
    balance = initBal;
    name = owner;
    acctNum = Math.abs(generator.nextLong());
    numAccounts++;
  }
  
  public Account(double initBal, String owner)
  {
    balance = initBal;
    name = owner;
    acctNum = Math.abs(generator.nextLong());
    numAccounts++;
  }
  
  public Account(String owner)
  {
    balance = 100.0;
    name = owner;
    acctNum = Math.abs(generator.nextLong());
    numAccounts++;
  }
  
  //----------------------------------------------
  // Checks to see if balance is sufficient for withdrawal.
  // If so, decrements balance by amount; if not, prints message.
  //----------------------------------------------
  public void withdraw(double amount)
  {
    if (balance >= amount)
      balance -= amount;
    else
      System.out.println("Insufficient funds.");
    numWithdrawals++;
    totalWithdrawals++;
  }
  
  public void withdraw(double amount, double fee)
  {
    if (balance >= (amount+fee))
      balance -= (amount+fee);
    else
      System.out.println("Insufficient funds.");
    numWithdrawals++;
    totalWithdrawals++;
  }
  //----------------------------------------------
  // Adds deposit amount to balance.
  //----------------------------------------------
  public void deposit(double amount)
  {
    balance += amount;
    numDeposits++;
    totalDeposits++;
  }
  
  //----------------------------------------------
  // Returns balance.
  //----------------------------------------------
  public double getBalance()
  {
    return balance;
  }
  //----------------------------------------------
  //Returns number of accounts created
  //----------------------------------------------
  public static int getNumAccounts()
  {
    return numAccounts;
  }
  
  //----------------------------------------------
  // Returns name on the account
  //----------------------------------------------
  public String getName()
  {
    return name;
  }
  
  //----------------------------------------------
  // Returns account number
  //----------------------------------------------
  public long getAcctNum()
  {
    return acctNum;
  }
  
  public static int getNumDeposits()
  {
    return numDeposits;
  }
  
  public static int getTotalDeposits()
  {
    return totalDeposits;
  }
  
  public static int getNumWithdrawals()
  {
    return numWithdrawals;
  }
  
  public static int getTotalWithdrawals()
  {
    return totalWithdrawals;
  }
  
  //----------------------------------------------
  // Close the current account.
  //----------------------------------------------
  public void close()
  {
    System.out.println("" + name + " CLOSED");
    balance = 0;
    System.out.println("Balance = $" + balance);
    numAccounts--;
  }
  
  //----------------------------------------------
  // Consolidates two accounts into one account.
  //----------------------------------------------
  public Account consolidate(Account acct1, Account acct2)
  {
    if (acct1.name.equalsIgnoreCase(acct2.name) && acct1.acctNum != acct2.acctNum)
    {
      Account newAccount = new Account(0, acct1.name);
      newAccount.balance = acct1.getBalance() + acct2.getBalance();
      acctNum = Math.abs(generator.nextLong());
      acct1.close();
      acct2.close();
      return newAccount;
    } 
    else
    {
//      System.out.println("Sorry, you can't consolidate these 2 accounts. " +
//                         "Please check the ownerships or the account numbers.");
      return null;
    }
  }
  
  //----------------------------------------------
  // Returns a string containing the name, account number, and balance.
  //----------------------------------------------
  public String toString()
  {
    return "Name: " + name + 
      "\nAccount Number: " + acctNum +
      "\nBalance: $" + getBalance(); 
  }
}
