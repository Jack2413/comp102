// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 3 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/** Program to create simple animated cartoon strips using the
 *  CartoonFigure class.  
 */

public class CartoonStrip{

    /** animate creates two cartoon figures on the window.
     *  Then animates them according to a fixed script by calling a series
     *  of methods on the figures.
     */
    public void animate(){
        CartoonFigure g1=new CartoonFigure("girl1",400,100);
        CartoonFigure b1=new CartoonFigure("guy1",100,100);
        g1.boilWater(5);
        g1.toast();
        g1.useComputer(30);
        b1.vacuum(10);
        b1.watchTV(30,20);
        b1.bake(20);
        double power = g1.getPowerBill();
        UI.sleep(2000);
        g1.payPowerBill();
        b1.getPowerBill();
        double power2 =b1.getPowerBill();
        UI.sleep(2000);
        b1.payPowerBill();
        /*# YOUR CODE HERE */

    }

    /** For the completion, the story must be a gamebook story
     *      where the user is asked to make decisions about what the characters will do.
     *   At the end it must print out the users power bill for the story that they chose.
     */
    public void animateCompletion(){
        String character = UI.askString("Are you a boy or a gilr?");
        if(character.equals("boy")){
            CartoonFigure boy=new CartoonFigure("guy1",100,100);
            String answer =UI.askString("What are you doing at home usually?");
            int count= UI.askInt("how many things you mainly doing at home per day?");
            while(count>1){
                if(answer.equals("use vacuum")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    boy.vacuum(minutes);
                }
                else if(answer.equals("use computer")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    boy.useComputer(minutes);
                }
                else if(answer.equals("use oven")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    boy.bake(minutes); 
                }
                else if(answer.equals("boil water")){
                    int times = UI.askInt("how many times you boilWater per day?");
                    boy.boilWater(times);
                }
                else if(answer.equals("use toaster")){
                    boy.toast();
                }
                else if(answer.equals("reheat food")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int wattage = UI.askInt("what is the wattage of the micware?");
                    boy.reheatFood(minutes,wattage);
                }
                else if(answer.equals("watch TV")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int size = UI.askInt("what is the screen size of your TV? (size in inches)");
                    boy.watchTV(minutes,size);
                }
                else if(answer.equals("washload")){
                    boolean frontType = UI.askBoolean("frontType  true if the washing machine is a front loader, false if it's a top loader");
                    String temperature = UI.askString("setting for the temperature (can be cold, warm, or hot)");
                    boy.washLoad(frontType,temperature);
                }
                else {
                    UI.println("Error, sorry can't find value, valid value as follow(use vacuum,use computer,use oveb,boil water,use toaster reheat food, watch TV and washload. please enter again.)" );
                    animateCompletion();
                }
                String next; answer = UI.askString("What else are you doing at home?");
                count=count-1;
            }
            boy.getPowerBill();
            UI.sleep(1000);
            boy.payPowerBill();
            /*# YOUR CODE HERE */
        }
        else if(character.equals("girl")){
            CartoonFigure girl=new CartoonFigure("girl1",400,100);
            String answer =UI.askString("What are you doing at home usually?");
            int count= UI.askInt("how many things you mainly doing at home per day?");
            while(count>1){
                if(answer.equals("use vacuum")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    girl.vacuum(minutes);
                }
                else if(answer.equals("use computer")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    girl.useComputer(minutes);
                }
                else if(answer.equals("use oven")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    girl.bake(minutes); 
                }
                else if(answer.equals("boil water")){
                    int times = UI.askInt("how many times you boilWater per day?");
                    girl.boilWater(times);
                }
                else if(answer.equals("use toaster")){
                    girl.toast();
                }
                else if(answer.equals("reheat food")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int wattage = UI.askInt("what is the wattage of the micware?");
                    girl.reheatFood(minutes,wattage);
                }
                else if(answer.equals("watch TV")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int size = UI.askInt("what is the screen size of your TV? (size in inches)");
                    girl.watchTV(minutes,size);
                }
                else if(answer.equals("washload")){
                    boolean frontType = UI.askBoolean("frontType  true if the washing machine is a front loader, false if it's a top loader");
                    String temperature = UI.askString("setting for the temperature (can be cold, warm, or hot)");
                    girl.washLoad(frontType,temperature);
                }
                else {
                    UI.println("Error, sorry can't find value, valid value as follow(use vacuum, use computer,use oven,boil water,use toaster reheat food, watch TV and washload. please enter again.)" );
                    animateCompletion();
                }
                String next; answer = UI.askString("What else the min are you doing at home?");
                count=count-1;
            }
            girl.getPowerBill();
            UI.sleep(1000);
            girl.payPowerBill();
        }
        else {
            UI.println("Error,only can enter boy or girl,please enter again.");
            animateCompletion();
        }
    }

    public void animateChallenge(){
        UI.println("Welcome to the minion world, now you can choose the minion you like.");
        UI.sleep(1000);
        CartoonFigure m1=new CartoonFigure("minion1",100,100);
        CartoonFigure m2=new CartoonFigure("minion2",400,100);
        CartoonFigure m3=new CartoonFigure("minion3",700,100);
        String minion = UI.askString("which minion you want to choose? minion1, minion2 or minion3?");
        if(minion.equals("minion1")){
            UI.clearGraphics();
            String next; m1=new CartoonFigure("minion1",100,100);
            String answer =UI.askString("What you want the mionion do at home usually?");
            int count= UI.askInt("how many things he mainly doing at home per day?");
            while(count>1){
                if(answer.equals("use vacuum")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m1.vacuum(minutes);
                }
                else if(answer.equals("use computer")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m1.useComputer(minutes);
                }
                else if(answer.equals("use oven")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m1.bake(minutes); 
                }
                else if(answer.equals("boil water")){
                    int times = UI.askInt("how many times you boilWater per day?");
                    m1.boilWater(times);
                }
                else if(answer.equals("use toaster")){
                    m1.toast();
                }
                else if(answer.equals("reheat food")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int wattage = UI.askInt("what is the wattage of the micware?");
                    m1.reheatFood(minutes,wattage);
                }
                else if(answer.equals("watch TV")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int size = UI.askInt("what is the screen size of your TV? (size in inches)");
                    m1.watchTV(minutes,size);
                }
                else if(answer.equals("washload")){
                    boolean frontType = UI.askBoolean("frontType  true if the washing machine is a front loader, false if it's a top loader");
                    String temperature = UI.askString("setting for the temperature (can be cold, warm, or hot)");
                    m1.washLoad(frontType,temperature);
                }
                else if(answer.equals("use heater")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m1.heater(minutes); 
                }
                else if(answer.equals("use shower")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m1.shower(minutes); 
                }
                else {
                    UI.println("Error, sorry can't find value, valid value as follow(use vacuum, use computer,use oven,boil water,use toaster reheat food,use shower,use shower watch TV and washload. please enter again.)" );
                    animateChallenge();
                }
                String hasnext; answer = UI.askString("What else the minion doing at home?");
                count=count-1;
            }
            m1.getPowerBill();
            UI.sleep(1000);
            m1.payPowerBill();
        }
        else if(minion.equals("minion2")){
            UI.clearGraphics();
            String next; m2=new CartoonFigure("minion2",100,100);
            String answer =UI.askString("What you want the mionion do at home usually?");
            int count= UI.askInt("how many things he mainly doing at home per day?");
            while(count>1){
                if(answer.equals("use vacuum")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m2.vacuum(minutes);
                }
                else if(answer.equals("use computer")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m2.useComputer(minutes);
                }
                else if(answer.equals("use oven")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m2.bake(minutes); 
                }
                else if(answer.equals("boil water")){
                    int times = UI.askInt("how many times you boilWater per day?");
                    m2.boilWater(times);
                }
                else if(answer.equals("use toaster")){
                    m2.toast();
                }
                else if(answer.equals("reheat food")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int wattage = UI.askInt("what is the wattage of the micware?");
                    m2.reheatFood(minutes,wattage);
                }
                else if(answer.equals("watch TV")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int size = UI.askInt("what is the screen size of your TV? (size in inches)");
                    m2.watchTV(minutes,size);
                }
                else if(answer.equals("washload")){
                    boolean frontType = UI.askBoolean("frontType  true if the washing machine is a front loader, false if it's a top loader");
                    String temperature = UI.askString("setting for the temperature (can be cold, warm, or hot)");
                    m2.washLoad(frontType,temperature);
                }
                else if(answer.equals("use heater")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m2.heater(minutes); 
                }
                else if(answer.equals("use shower")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m2.shower(minutes); 
                }
                else {
                    UI.println("Error, sorry can't find value, valid value as follow(use vacuum, use computer,use oven,boil water,use toaster reheat food,use shower,use shower watch TV and washload. please enter again.)" );
                    animateChallenge();
                }
                String hasnext; answer = UI.askString("What else the minion doing at home?");
                count=count-1;
            }
            m2.getPowerBill();
            UI.sleep(1000);
            m2.payPowerBill();
        }
        else if(minion.equals("minion3")){
            UI.clearGraphics();
            String next; m3=new CartoonFigure("minion3",100,100);
            String answer =UI.askString("What you want the mionion do at home usually?");
            int count= UI.askInt("how many things he mainly doing at home per day?");
            while(count>1){
                if(answer.equals("use vacuum")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m3.vacuum(minutes);
                }
                else if(answer.equals("use computer")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m3.useComputer(minutes);
                }
                else if(answer.equals("use oven")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m3.bake(minutes); 
                }
                else if(answer.equals("boil water")){
                    int times = UI.askInt("how many times you boilWater per day?");
                    m3.boilWater(times);
                }
                else if(answer.equals("use toaster")){
                    m3.toast();
                }
                else if(answer.equals("reheat food")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int wattage = UI.askInt("what is the wattage of the micware?");
                    m3.reheatFood(minutes,wattage);
                }
                else if(answer.equals("watch TV")){
                    int minutes = UI.askInt("how many minutes you spend on" + answer + "?");
                    int size = UI.askInt("what is the screen size of your TV? (size in inches)");
                    m3.watchTV(minutes,size);
                }
                else if(answer.equals("washload")){
                    boolean frontType = UI.askBoolean("frontType  true if the washing machine is a front loader, false if it's a top loader");
                    String temperature = UI.askString("setting for the temperature (can be cold, warm, or hot)");
                    m3.washLoad(frontType,temperature);
                }
                else if(answer.equals("use heater")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m3.heater(minutes); 
                }
                else if(answer.equals("use shower")){
                    int minutes = UI.askInt("how many minutes you spend on " + answer + "?");
                    m3.shower(minutes); 
                }
                else {
                    UI.println("Error, sorry can't find value, valid value as follow(use vacuum, use computer,use oven,boil water,use toaster reheat food,use shower,use shower watch TV and washload. please enter again.)" );
                    animateChallenge();
                }
                String hasnext; answer = UI.askString("What else the minion doing at home?");
                count=count-1;
            }
            m3.getPowerBill();
            UI.sleep(1000);
            m3.payPowerBill();
        }
        else {
            UI.println("Error,only can enter minion1, minion2 or minion3,please enter again.");
            animateChallenge();
        }
    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public CartoonStrip(){
        UI.initialise();
        UI.addButton("Clear", UI::clearGraphics );
        UI.addButton("Animate", this::animate );
        UI.addButton("Animate Completion", this::animateCompletion );
        UI.addButton("Animate Challenge", this::animateChallenge);
        UI.addButton("Quit", UI::quit );
        UI.setDivider(0);       // Expand the graphics area
    }

}
