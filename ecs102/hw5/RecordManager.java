import java.lang.*;
import java.util.*;

public class RecordManager
{
  public static void main (String[] args)
  {
    String firstName = "";
    String lastName = "";
    int month = 0;
    int day = 0;
    int year = 0;
    int height = 0;
    int weight = 0;
    
    HealthRecord record = new HealthRecord(firstName, lastName, month, day, year);
    
    Scanner input = new Scanner(System.in);
    
    System.out.print("What is your first name?");
    record.setFirstName(input.nextLine());
    
    System.out.print("What is your last name?");
    record.setLastName(input.nextLine());
    
    System.out.print("What number month were you born?");
    record.setMonth(input.nextInt());
    
    System.out.print("What day were you born?");
    record.setDay(input.nextInt());
    
    System.out.print("What year were you born?");
    record.setYear(input.nextInt());
    
    String birthDate = record.getBirthdate();
    
    record.toString();
    
    System.out.println("Age: " + record.getAge());
    System.out.println("Maximum Heart Rate: " + record.getMaxHeartrate());
    System.out.println("Target Heart Rate: " + record.getTargetHeartRate());
    
    System.out.println("What is your height (inches)?");
    record.setHeight(input.nextInt());
    
    System.out.println("What is your weight (pounds)?");
    record.setWeight(input.nextInt());
    
    System.out.println("Height: " + record.getHeight());
    
    System.out.println("Weight: " + record.getWeight());
    
    System.out.println("BMI: " + record.getBMI());
  }
}