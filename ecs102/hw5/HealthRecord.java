import java.lang.String;
import java.lang.Math;

public class HealthRecord
{
  private int weight, height, month, day, year;
  private String firstName, lastName;
  
  public void HealthRecord (String firstName, String lastName, int weight, int height, int month, int day, int year) {}
  
  public void HealthRecord (String firstName, String lastName, int month, int day, int year)
  {
    firstName = firstName;
    lastName = lastName;
    month = month;
    day = day;
    year = year;
  }
  
  public String toString ()
  { 
    return getFirstName() + " " + getLastName() + " " + getBirthdate();
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public String getLastName()
  {
    return lastName;
  }
  
  public int getWeight ()
  {
    return weight;
  }
  
  public int getHeight ()
  {
    return height;
  }
  
  public int getMonth ()
  {
    return month;
  }
  
  public int getDay ()
  {
    return day;
  }
  
  public int getYear ()
  {
    return year;
  }
  
  public void setFirstName (String fName)
  {
    firstName = fName;
  }
  
  public void setLastName (String lName)
  {
    lastName = lName;
  }
  
  public void setWeight (int weight)
  {
    weight = weight;
  }
  
  public void setHeight (int height)
  {
    height = height;
  }
 
  public void setMonth (int month)
  {
    month = month;
  }
  
  public void setDay (int day)
  {
    day = day;
  }
  
  public void setYear(int year)
  {
    year = year;
  }
  
  public int getAge()
  {
    int age = 2014-getYear();
    return (age);
  }
  
  public String getBirthdate()
  {
    return month + "/" + day + "/" + year%100;
  }
  
  public int getMaxHeartrate()
  {
    return 220-getAge();
  }
  
  public String getTargetHeartRate()
  { 
    return getMaxHeartrate()*.50 + "-" + getMaxHeartrate()*.85 + "%";
  }
  
  public double getBMI ()
  {
    return ((getWeight() / (Math.pow(getHeight(),2))) * 703);
  }
  
}