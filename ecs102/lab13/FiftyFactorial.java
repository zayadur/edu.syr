//public class FiftyFactorial FOR
//{
//  public static void main(String[] args)
//  {
//    int ip = 1;
//    int n;
//    
//    for (n=1; n<=50; n++)
//    {
//      ip*=n;
//      System.out.println("n = " + n + "; product = " + ip);
//    }
//  }
//}

//public class FiftyFactorial WHILE
//{
//  public static void main(String[] args)
//  {
//    int ip = 1;
//    double dp = 1.0;
//    int n = 0;
//    
//    while (n++<=50)
//    {
//      ip*=n;
//      dp*=n;
//      System.out.println("n = " + n + "; product = " + ip
//                        + "\t double product =" + dp);
//    }
//  }
//}

public class FiftyFactorial //DO...WHILE
{
  public static void main(String[] args)
  {
    int ip = 1;
    double dp = 1.0;
    int n = 1;
    
    do
    {
      ip*=n;
      dp*=n;
      System.out.println("n = " + n + "; product = " + ip
                        + "\t double product =" + dp);
    }
    while(n++<50);
  }
}
