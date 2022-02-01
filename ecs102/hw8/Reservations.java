import java.util.*;

public class Reservations
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    String response = "";
    String selection = "";
    String firstName = "";
    String lastName = "";
    boolean[] seats = new boolean[10];
    int empty;
    
    System.out.println("Welcome to the reservation system" +
                       "\nThis program will help you reserve your seat" +
                       "\nPlease follow the onscreen instructions carefully");
    System.out.println();
    
    while (!(response.equalsIgnoreCase("N")))
    {
      if (findEmptySeat(seats, 0, 4) == -1 && findEmptySeat(seats, 4, 10) == -1)
      {
        System.out.println("There are no more empty seats on this plane");
        return;
      }
      
      System.out.println("You will now be selecting your class" +
                         "\nEnter '1' for First Class or enter '2' for Economy Class" +
                         "\nEnter '8' to view available seats or '9' to view occupied seats");
      selection = input.nextLine();
      
      if (selection.equals("1"))
      {
        empty = findEmptySeat(seats, 0, 4);
        
        if (empty > -1)
        {
          System.out.println("You have reserved Seat " + (empty+1) + " in First Class");
          System.out.println();
          seats[empty] = true;
          
          System.out.println("BOARDING PASS: " +
                                 "\nSeat #: " + (empty+1) +
                                 "\nClass: First Class");
          System.out.println();
        }
        
        else
        {
          System.out.println("There are no First Class seats available" +
                             "\nWould you like a seat in the other section?");
          System.out.print("Enter Y for Yes or N for No");
          String choice = input.nextLine();
          
          if (choice.equalsIgnoreCase("Y"))
          {
            empty = findEmptySeat(seats, 4, 10);
            if (empty > -1)
            {
              System.out.println("You have reserved Seat " +  (empty+1) + " in Economy Class");
              System.out.println();
              seats[empty] = true;
              
              System.out.println("BOARDING PASS: " +
                                 "\nSeat #: " + (empty+1) +
                                 "\nClass: Economy Class");
              System.out.println();
            }
          }
          else 
            System.out.println("Next flight leaves in 3 hours");
        }
      }
      
      else if (selection.equals("2"))
      {
        empty = findEmptySeat(seats, 4, 10);
        
        if (empty > -1)
        {
          System.out.println("You have reserved Seat " + (empty+1) + " in Economy Class");
          System.out.println();
          seats[empty] = true;
          
          System.out.println("BOARDING PASS: " +
                                 "\nSeat #: " + (empty+1) +
                                 "\nClass: Economy Class");
          System.out.println();
        }
        
        else
        {
          System.out.println("There are no Economy Class seats available." +
                             "\nWould you like a seat in the other section?");
          System.out.print("Enter Y for Yes or N for No");
          String choice = input.nextLine();
          
          if (choice.equalsIgnoreCase("Y"))
          {
            empty = findEmptySeat(seats, 0, 4);
            if (empty > -1) {
              System.out.println("You have reserved Seat " + (empty+1) + " in First Class");
              System.out.println();
              seats[empty] = true;
              
              System.out.println("BOARDING PASS: " +
                                 "\nSeat #: " + (empty+1) +
                                 "\nClass: First Class");
              System.out.println();
            }
          }
          else 
            System.out.println("Next flight leaves in 3 hours");
        }
      }
      
      else if (selection.equals("9"))
      {
        System.out.print("Occupied seats in first class are: ");
        displayOccupied(seats, 0, 4);
        System.out.print("Occupied seats in economy class are: ");
        displayOccupied(seats, 5, 10);
      }
      
      else if (selection.equals("8"))
      {
        System.out.print("Open seats in first class are: ");
        displayOpen(seats, 0, 4);
        System.out.print("Open seats in economy class are: ");
        displayOpen(seats, 4, 10);
      }
      
      System.out.println("Would you like to continue?");
      System.out.print("Enter Y for Yes or N for No");
      response = input.nextLine();
    }
  }
  
  public static int findEmptySeat (boolean[] seats, int start, int length)
  {
    for (int i = start; i < length; i++)
    {
      if (seats[i] == false) 
        return i;
    }
    return -1;
  }
  
  public static void displayOccupied (boolean[] seats, int start, int length)
  {
    for (int i = start; i < length; i++)
    {
      if (seats[i] == true)
        System.out.print(i+1 + " ");
    }
    System.out.println();
  }
  
  public static void displayOpen (boolean[] seats, int start, int length)
  {
    for (int i = start; i < length; i++)
    {
      if (seats[i] == false)
        System.out.print(i+1 + " ");
    }
    System.out.println();
  }
}