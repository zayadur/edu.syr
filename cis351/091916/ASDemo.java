/** A simpleminded demo of the ArrayStack Class.
  */
public class ASDemo {
  public static void main(String[] argv) {
    // Create an empty ArrayStack and print it
    ArrayStack as = new ArrayStack();
    System.out.println(as);
    
    // tests for add
    System.out.println("\nAdd 3, 6, ... , 30 to as");
    for(int k=3; k<=30; k=k+3) {
      as.add(k);
      System.out.println("\nas.add(" + k + ") yields: \n" + as);     
    }
    
    // a test for get
    int sum = 0;
    for(int i=0;i<as.size();i++)
      sum = sum + as.get(i);
    System.out.println("\nThe sum of the elements of as is "+sum);
    
    // tests for remove
    System.out.println("\nRemove elements from as");
    System.out.println(as); 
    int i = 7;
    while (as.size()>0) {
      i = (13*i+5)%(as.size());
      System.out.println("\nas.remove(" + i  + ") yields: ");
      as.remove(i);
      System.out.println(as);     
    }
    
  }
}