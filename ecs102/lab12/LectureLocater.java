// LectureLocater.java
import java.util.*;
public class LectureLocater
{
  public static void main(String[] args)
  {
    char code;
    Scanner input = new Scanner(System.in);
    
    //get answer before while
    System.out.println("What is your major code? Press X to exit.");
    code = input.next().charAt(0);
    
    //For each person, process their answer.
    while(code != 'X')
    {
      switch(code)
      {
        case 'A':
          System.out.println("You should head to Link 105");
          break;
        case 'B':
          System.out.println("You should head to Hall of Languages 207");
          break;
        case 'C':
          System.out.println("You should head to Carnegie 313");
          break;
        case 'D':
          System.out.println("You should head to Heroy Auditorium");
          break;
        case 'E':
        case 'F':
          System.out.println("You should head to Gifford Auditorium");
          break;
        case 'G':
          System.out.println("You should head to Stolkin Auditorium");
          break;
      } // end switch
    //get answer after while
    System.out.println("What is your major code? Press X to exit.");
    code = input.next().charAt(0);
    } //end while
  } //end main
} //end class