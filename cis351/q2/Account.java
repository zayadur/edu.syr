public class Account {
  // static variables
  static int REWARD = 1000000;   // for part (c)
  // instance variables
  private int balance;           // the balance of the account
  private int points;            // for part (c)
  
  //////////////////////////////////////////////////////////////
  // Constructor: Creates a new Account with balance set to 
  // initBal. We assume initBal >= 0.
  public Account(int initBal) { balance = initBal; points = 0; }
  
  //////////////////////////////////////////////////////////////
  // Deposits an amount into the account.
  //   If amt>=0, then that amt is added to the balance.
  //   Else if amt<0, the balance is unchanged.  
  public void deposit(int amt) { 
    if (amt>0) {
      balance = balance + amt;
      points  = points  + amt;
      while (points>=REWARD) {  // an if was OK here
        balance = balance + 500;
        points  = points - REWARD;
      }
    }
  }
  
  //////////////////////////////////////////////////////////////
  // Withdraws an amount from the account.
  //   If amt < 0, the balanced is unchanged and 0 is returned.
  //   Else if 0 <= amt <= balance, then amt is subtracted from  
  //     balance and 0 is returned. 
  //   Else if amt > balance (i.e., we want to withdraw more 
  //     than what is in the account), then we compute: 
  //     overdraft = amt - balance, set balance to 0, and return 
  //     the overdraft value.
  public int withdraw(int amt) { 
    if (amt<0) return 0;
    else if (amt <= balance) {
      balance = balance - amt;
      return 0;
    }
    else { // we must have amt > balance
      int over = amt - balance;
      balance = 0;
      return over;
    }
  }
      
  //////////////////////////////////////////////////////////////
  // Transfers all the funds from an account into this one. 
  // Move all the funds in the acnt  into this account and then 
  //    zero out acnt.
  public void transfer(Account acnt) { 
    balance = balance + acnt.balance;
    acnt.balance = 0;
  }

}