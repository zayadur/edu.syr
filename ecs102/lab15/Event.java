// event.java
// edited by: Zayadur Khan, ECS-102
// Times are in minutes from the previous midnight
public class Event
{
  //data
  private String title;
  private TimeOfDay startTime;
  private TimeOfDay endTime;
  private static int dayOfMonth;
  private static String month;
  
  //constructors
  public Event(int start, int end, String eventTitle)
  {
    title= eventTitle;
    startTime=new TimeOfDay(start);
    endTime=new TimeOfDay(end);
  }
  
  public Event(int start, String eventTitle, int duration)
  {
    if (start+duration <=24*60) //if endtime will be today
    {
      title=eventTitle;
      startTime=new TimeOfDay(start);
      endTime=new TimeOfDay(startTime.getMinutes()+duration);
    }
  }
  
  //obtain a String version of the startTime
  public String getStartTime()
  { return startTime.toString();}
  
  //obtain a String version of the endTime
  public String getEndTime()
  { return endTime.toString();}
  
  //get the duration of an event, in minutes
  
  
  //obtain a String representing the date
  public static String getDate()
  { return month + " " + dayOfMonth; }
  
  //obtain a String representation of the Event
  public String toString()
  {
    return (title+": " + startTime+"-"+endTime+
            ", "+ getDate());
  }
  
  //set the Month
  public static void setMonth(String mo)
  { month=mo; }
  
  //set the day of the month
  public static void setDayOfMonth(int d)
  { dayOfMonth = d; }
  
  public int getDuration()
  {
    return startTime.duration(endTime);
  }
  
  public String printEventWDuration()
  {
    return "Title: " + title + "\nStart time: " + startTime + "\nEnd time: " + endTime;
  }
  
  public Event combine(Event e)
  {
    if(((((this.startTime).compareTo(e.startTime)) < 0)))
    {
      if((this.startTime.getMinutes()) > (e.startTime.getMinutes()))
        (this.startTime).setMinutes(e.startTime.getMinutes());
      if((this.endTime.getMinutes()) < (e.endTime.getMinutes()))
        (this.endTime).setMinutes(e.endTime.getMinutes());
      e.title = "nothing"; e.startTime.setMinutes(0);
      e.endTime.setMinutes(0);
      return (this);
    }
    else
    {
      System.out.println("These events do not overlap.");
      return this;
    }
  }
}