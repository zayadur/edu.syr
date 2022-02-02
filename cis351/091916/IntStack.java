import java.util.EmptyStackException;
import java.util.Arrays;

public class IntStack {
  // instance variable
  private ArrayStack s;
  
  // Constructor 
  public IntStack() {
    s = new ArrayStack();
  }
   
  // instance methods
  public boolean empty() {
    return (s.size()==0);
  }
  
  public int peek() {
    if (s.isEmpty()) throw new EmptyStackException();
    else return s.get(s.size()-1);
  }
  
  public int pop() {
    if (s.isEmpty()) throw new EmptyStackException();
    else return s.remove(s.size()-1);
  }
  
  public int push(int e) {
    s.add(e);
    return e;
  }
  
  /** a simple-minded demo of the IntStack class */
  public static void main(String[] argv) {
    int[] nums = {0,2,4,8,23,34,39,51,99};
    int[] rev  = new int[nums.length];

    // Reverse the elements in nums by pushing them all into a stack
    //   then popping them off that stack. 
    IntStack s = new IntStack();
    
    for (int i=0; i<nums.length;i++)
      s.push(nums[i]);

    for(int i = 0; !s.empty(); i++) 
      rev[i] = s.pop();

    System.out.println(Arrays.toString(nums) +"\n"+ Arrays.toString(rev));
  }
  
}