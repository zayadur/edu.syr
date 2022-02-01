//Conversation   Author: Baruch
//Practice with Scanner class

import java.util.Scanner; //for input

public class Conversation
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner (System.in);
      String firstName, lastName;
      int birthyear;
      double priceOrange;
      double pricePeanuts;
      double priceBread;
      double priceWatermelon;
      double totalPrice=0;
      
      String address;
      int houseNumber;
      String street;
      String city;
      String state;
      int zipCode;
      
      System.out.println("Welcome.  Type your first name and your last"
                            + " name followed by the enter key.");
      
      firstName = reader.next();
      lastName = reader.nextLine();
      
      System.out.println("First Name: " + firstName);
      System.out.println("Last Name: " + lastName);
      
      System.out.print("Enter your house number ");
      houseNumber = reader.nextInt();
      System.out.print("Spell out your street name ");
      street = reader.next();
      System.out.print("Enter your city ");
      city = reader.next();
      System.out.print("Enter your state ");
      state = reader.next();
      System.out.print("Enter your zipcode ");
      zipCode = reader.nextInt();
      
      System.out.println(firstName + " " + lastName);
      System.out.println(houseNumber + " " + street);
      System.out.println(city + " " + state + " " + zipCode);
      
      System.out.print("Enter year you were born ");
      birthyear = reader.nextInt();
      System.out.println("Approximate age: " + (2014-birthyear));
      
      System.out.print("How much do the oranges cost? $");
      priceOrange = reader.nextDouble();
      totalPrice += priceOrange;
      System.out.print("How much do the peanuts cost? $");
      pricePeanuts = reader.nextDouble();
      totalPrice += pricePeanuts;
      System.out.print("How much does the bread cost? $");
      priceBread = reader.nextDouble();
      totalPrice += priceBread;
      System.out.print("How much does the watermelon cost? $");
      priceWatermelon = reader.nextDouble();
      totalPrice += priceWatermelon;
      System.out.println("The total cost is $" + totalPrice);
    
   } // end main
}  // end class

/* Output:

First Name: Zayadur
Last Name:  Khan
Enter your house number 193
Spell out your street name Quentin
Enter your city Brooklyn
Enter your state NY
Enter your zipcode 11223
Zayadur  Khan
193 Quentin
Brooklyn NY 11223
Enter year you were born 1996
Approximate age: 18
How much do the oranges cost? $1
How much do the peanuts cost? $2
How much does the bread cost? $
3
How much does the watermelon cost? $4
The total cost is $10.0

> */