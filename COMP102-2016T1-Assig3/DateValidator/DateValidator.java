// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 3
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/**
 * Reads a date from the user as three integers, and then checks that the date is valid
 */

public class DateValidator {

    /**
     * Asks user for a date, then determines whether the date
     *    specified by the three integers is a valid date.
     * For the Core, you may assume that
     * - All months have 31 days, numbered 1 to 31
     * - The months run from 1 to 12
     * - Years start from 1 
     */
    public void validateDateCore(){
        int day = UI.askInt("given day");
        int month = UI.askInt("given month");
        int year = UI.askInt("given year");
        if(day>31||day<1||month>12||month<1||year<1){
        UI.println("Is not valid,please enter again");
        validateDateCore();
     }/*# YOUR CODE HERE */
        else{
        UI.println("is valid");
    }
}

    /**
     * Asks user for a date, then determines whether the date
     *    specified by the three integers is a valid date.
     * For the Completion, you should also check that
     * - Months have the correct number of days
     * - On leap years February should have 29 days.
     *    A year is a leap year if:
     *       - The year can be evenly divided by 4 but not 100
     *       - The year can be evenly divided by 400 
     */
    public void validateDateCompletion(){
        int day = UI.askInt("given day");
        int month = UI.askInt("given month");
        int year = UI.askInt("given year");
        if(((month==1||month==3||month==5||month==7||month==8||month==10||month==12)&&(day<32&&day>0)
        ||(month==4||month==6||month==9||month==11)&&(day<31&&day>0))&&year>0){
            UI.println("The date is valid");
        }
        else if((month==2&&(day>0 && day<29)&&year>0)||((month==2&&(day>0&&day<30)&&(year%4==0)&&(!(year%100==0))&&year>0))){
            UI.println("The date is valid");     
        }
        else if((year%400==0)&&(month==2&&(day>0&&day<30))){
            UI.println("The date is valid");
        }
        else if((month==2&&(day==29))&&(year%100==0)){
            UI.println("The year you enter is not a leap year,therefore it dont have 29th in February please enter again.");
            validateDateCompletion();
        }
        else {
            UI.println("The date is not valid,please enter again");
            validateDateCompletion();
        }
        /*# YOUR CODE HERE */
        

  
}

    /**
     * For the challenge, your program should be extended to deal with the transition from the Julian to Gregorian calendar. 
     * The program should look at the date, determine whether this should be a Julian or Gregorian date, and test it appropriately. 
     * You will need to find the rules of the Julian calendar yourselves. 
     * before 1582.10.4 are using Julian calendar.
     * after 1582.10.15 are using gregorian calendar.
     * between 1582.10.4 ~ 1582.10.15 are no date.
     */
    public void validateDateChallenge(){
        int day = UI.askInt("given day");
        int month = UI.askInt("given month");
        int year = UI.askInt("given year");
        if(year==1582 && month==10 && day<15 && day>4){
            UI.println("There is no date between 1582.10.4 ~ 1582.10.15, because in this time julian calendar has been change to gregorian calendar. 10 days has been cancel out.");
        }
        else if(((month==1||month==3||month==5||month==7||month==8||month==10||month==12)&&(day<32&&day>0)
        ||(month==4||month==6||month==9||month==11)&&(day<31&&day>0))&&year>0){
            UI.println("The date is valid");/*# YOUR CODE HERE */
        }
        else if(month==2 && day<=28 && day>0 && year>0){
            UI.println("The date is valid");
        }
        else if(month==2 && day==29 && year>0 && year<=1582 && year%4==0){
            UI.println("The date is valid");
        }
        else if(month==2 && day==29 && year>1582 && year%4==0 && (!(year%100==0))){
            UI.println("The date is valid");
        }
        else if((year%400==0)&& month==2 && day==29 && year>1582){
            UI.println("The date is valid");
        }
        else{
            UI.println("The date is not vaiid, please enter again.");
            validateDateChallenge();
        }
}

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public DateValidator(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Validate Date Core", this::validateDateCore );
        UI.addButton("Validate Date Completion", this::validateDateCompletion );
        UI.addButton("Validate Date Challenge", this::validateDateChallenge );
        UI.addButton("Quit", UI::quit ); 
        UI.setDivider(1);       // Expand the text area
    }


}

