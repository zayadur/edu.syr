//*************
//AccountDriver.java
//test the Account class
//*************
public class AccountDriver
{
  public static void main(String[] args)
  {
    Account a = new Account(100.0, "Max", 12345);
    a.withdraw(5.0);
    System.out.println("after withdrawal: balance = " + a.getBalance());
    a.deposit(20.0);
    System.out.println("after deposit: balance = " + a.getBalance());
    System.out.println ("account: " + a );
    a.changeName("newName");
    a.chargeFee();
  }
}
