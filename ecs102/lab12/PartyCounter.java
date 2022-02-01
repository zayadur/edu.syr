// PartyCounter.java
import java.util.Scanner;
public class PartyCounter
{
  public static void main(String[] args)
  {
    char party;
    int count, demCount, repCount;
    Scanner reader = new Scanner(System.in);
    
    // initialize counters
    count = 0;
    demCount = 0;
    repCount = 0;
    
    //get answer before while
    System.out.println("What is your party? Enter");
    System.out.println("\tD for Democrat\n\tR for Republican");
    System.out.println("\tI for Independent\tU for Unaffiliated");
    System.out.println("\tX to exit.");
    party = reader.next().charAt(0);
    
    //For each person, process their answer.
    while(party != 'X')
    {
      switch(party)
      {
        case 'D':
          System.out.println("Democrat");
          demCount++;
          break;
        case 'R':
          System.out.println("Republican");
          repCount++;
          break;
        case 'I':
        case 'U': 
          System.out.println("Other");
          break;
      } // end switch 
      count++;
      
      // get answer at end of while
      System.out.println("What is your party? Enter");
      System.out.println("\tD for Democrat\n\tR for Republican");
      System.out.println("\tI for Independent\tU for Unaffiliated");
      System.out.println("\tX to exit.");
      party = reader.next().charAt(0);    
    } // end while
    
    //print summary information
    System.out.println("\n\nSummary:");
    System.out.println("Democrats: " + demCount);
    System.out.println("Republicans: " + repCount);
    System.out.println("Total respondents: " + count);
  } //end main
} //end class PartyCounter