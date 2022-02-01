// Driver.java
// Edited by Zayadur Khan for ECS-102
public class  Driver
{
  public static void main(String[] args)
  {
    Person him = new Person();
    System.out.println(him);
    
    Person her = new Person("Jane", 45);
    System.out.println(her);

    Child boy = new Child("Sam", 9, "play soccer", 4);
    System.out.println(boy);
   
    Child girl = new Child("Sally", 7, "do math", 2);
    System.out.println(girl);
    
    System.out.println();
    her.identify();
    her.eat();
    girl.identify();
    girl.eat();
    girl.play();
  }
}

/* OUTPUT
 * 
> run Driver
Person:
   name: Ghost   age: 1000 
Person:
   name: Jane   age: 45 
Child:
NAME: Sam   AGE: 9
I love to play soccer
I am in grade 4. 
Child:
NAME: Sally   AGE: 7
I love to do math
I am in grade 2. 

My name is Jane 
Mmm. Tastes good. 
My name is Sally 
Chomp Chomp 
> */
