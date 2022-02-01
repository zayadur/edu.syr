//TimeOfDay.java
//edited by: Zayadur Khan, ECS-102
import java.util.Scanner;
public class TimeOfDay
{
  //data
  private int minutes;
  
  //constructors
  public TimeOfDay()
  { minutes = 0; }
  
  public TimeOfDay(int min)
  { minutes = min%(24*60); }
  
  //set the time using minutes
  public void setMinutes(int min)
  { minutes = min%(24*60);  }
  
  //obtain a String representing time
  public String toString()
  { return (minutes/60 +
    ( minutes%60 < 10 ? ":0" : ":" ) + minutes%60);}
  
  //set the time from a String
  public void setTime(String time)
  {
    Scanner scan = new Scanner(time);
    scan.useDelimiter(":");
    int hr, min;
    hr = scan.nextInt();
    min = scan.nextInt();
    minutes=hr*60+min;
  }
  
  //obtain the minutes representing a time
  public int getMinutes()
  { return minutes; }
  
  public int duration(TimeOfDay t2)
  {
    return t2.getMinutes() - minutes;
  }
  
  public int compareTo(TimeOfDay t)
  {
    return minutes - t.minutes;
  }
}