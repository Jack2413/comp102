// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 2 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/** Program for calculating how much you can save on your power bill */
// http://www.powerwise.co.nz/why-choose-led-light-bulbs/led-light-bulb-facts/

public class PowerCalculator{

    public static final double priceKWh = 0.2034;         // dollars //Price per kilowatt hour (priceKWh) is 20.34 cents
    public static final int incandescentLifeSpan = 1000; // hours
    public static final int ledLifeSpan = 25000;         // hours
    public static final double incadescentPrice = .99;   // dollars

    /** Calculates and prints how long it would take you to amortise your cost of switching
     *  to energy saving bulbs
     */
    
    public void calculateCostSaverCore(){
        UI.println
        ("Calculate Cost Saver Core");
        double oldbulb = UI.askDouble ("watts of the old bulb used"); /*# YOUR CODE HERE */
        double newbulb = UI.askDouble ("watts of the new bulb used");
        int number = UI.askInt ("number of old bulb to replace");
        UI.println 
        ("The number of kilowatts they are now saving is"+ (oldbulb-newbulb)*number/1000 + "killowatts.");
        double hours = UI.askDouble("how many hours each day the light is on?");
        double days = UI.askDouble("how many days it's used per week?");
        double weeks = UI.askDouble("how many weeks it's used per year?");
        UI.println
        ("The total kilowatt-hours of energy saved each year is" + (oldbulb-newbulb)/1000*number*hours*days*weeks + "hours.");
        UI.println
        ("The total dollars saved on their power bill each year is"+ (oldbulb-newbulb)/1000*number*hours*days*weeks*priceKWh + "dollar");
        double cost = UI.askDouble("the cost of each new LED bulb");
        UI.println
        ("The number of years to break even is " + (cost*number)/((oldbulb-newbulb)/1000*number*hours*days*weeks*priceKWh) + "years.");
    }     
    /** Calculates and prints how long it would take you to amortise your cost of switching
     *  to energy saving bulbs
     *  For the Completion part consider the life span of each type of bulbs and prints
     *  how much saving will be done after numYears years
     *  
     */
    public void calculateCostSaverCompletion(){
        double years = UI.askDouble ("how many years to calculate the savings over?");
        if (years < 0){
            UI.println("please enter the real value");}
        double number = UI.askDouble ("number of light blub used?");
        double hours = UI.askDouble("how many hours each day the light is on?");
        double days = UI.askDouble("how many days it's used per week?");
        double weeks = UI.askDouble("how many weeks it's used per year?");
        double Iwattes = UI.askDouble("how many wattes the incandescent bulbs used?");
        double Itimes = (years*days*weeks*hours/1000); 
        double Answer1;
        double Answer2;
        double saving;
        /*times to replacing incandescent bulbs**/
        if (years*days*weeks*hours<incandescentLifeSpan){
        Answer1=Iwattes/1000*number*years*days*weeks*hours*priceKWh;
        UI.println("The cost of running and replacing incandescent bulbs is" + Iwattes/1000*number*years*days*weeks*hours*priceKWh + "dollar");
        }else{
        Answer1=Iwattes/1000*number*years*days*weeks*hours*priceKWh + incadescentPrice*number*Itimes;    
        UI.println("The cost of running and replacing incandescent bulbs is" + Iwattes/1000*number*years*days*weeks*hours*priceKWh + incadescentPrice*number*Itimes+ "dollar");
        }
        double Lwattes = UI.askDouble ("how many wattes the LED bulbs used?");
        double Ltimes = (years*days*weeks*hours/25000);
        if (years*days*weeks*hours<ledLifeSpan){
        Answer2=Lwattes/1000*number*years*days*weeks*hours*priceKWh;
        UI.println("The cost of running and replacing LED bulbs is" + Lwattes/1000*number*years*days*weeks*hours*priceKWh + "dollar");
        }else{
        Answer2=Lwattes/1000*number*years*days*weeks*hours*priceKWh + ledLifeSpan*number*Ltimes;
        UI.println("The cost of running and replacing LED bulbs is" + Lwattes/1000*number*years*days*weeks*hours*priceKWh + ledLifeSpan*number*Ltimes+ "dollar");
        }
        saving=Answer1-Answer2;
        UI.println 
        ("The saving form changing light blub is"+saving+"doller" );
        } 
    /** ---------- The code below is already written for you ---------- **/
    /** Constructor, sets up the user interface */
    public PowerCalculator(){
        UI.initialise();
        UI.addButton("Core", this::calculateCostSaverCore); 
        UI.addButton("Completion", this::calculateCostSaverCompletion );
        UI.addButton("Clear Date", UI::clearPanes);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1);    // Expand the Text pane
    }


}
