//eventTester
//edited by: Zayadur Khan, ECS-102s
public class EventTester
{
  public static void main(String [] args)
  {
    //create some timesOfDay and test methods
    TimeOfDay t= new TimeOfDay(390);
    System.out.println("time: " + t);
    TimeOfDay t2 = new TimeOfDay();
    t2.setTime("4:15");
    System.out.println(t2);
    int duration = t2.duration(t);
    
    //create some Events and test methods
    Event learn= new Event(480, 570, "math");
    Event play= new Event(1200,  "soccer", 120);
    Event eat = new Event(720, "lunch", 45);
    Event.setDayOfMonth(20);
    Event.setMonth("October");
    System.out.println(learn);
    System.out.println(play);
    System.out.println(eat);
    
    /* Testing for parts B-E */
    System.out.println();
    //B
    System.out.println(duration);
    //C
    System.out.println(t.duration(t2));
    //D
    System.out.println(learn.printEventWDuration());
    //E
    TimeOfDay time1 = new TimeOfDay(200);
    TimeOfDay time2 = new TimeOfDay(600);
    System.out.println(time2.compareTo(time1));
    play.combine(eat);
  }
}

/* OUTPUT
 * 
time: 6:30 
4:15 
math: 8:00-9:30, October 20 
soccer: 20:00-22:00, October 20 
lunch: 12:00-12:45, October 20 
 
135 
-135 
Title: math
Start time: 8:00
End time: 9:30 
400 
These events do not overlap. 
 *
 */