// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 4 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** The program contains two methods for analysing the readings of the level of power usage in a house over the course of a day.
 *  There are several things about the power usage level that a user may be interested in: 
 *    The maximum and the minimum power usage level at any point during the day.
 *    The average power usage level during the day.
 *
 *  The program has two methods.  They both read a sequence of levels from
 *  the user (through the terminal window).
 *  One prints a report about the levels; the other plots a graph.
 */
public class PowerAnalyser{

    /**
     * analyseLevels reads a sequence of levels from the user  and prints out
     *    maximum, minimum, and average level.
     *    
     * The sequence is terminated by any word (non-number) such as "done" or "end".
     * All the levels are integers between 0 and 8000. 
     * The method will need variables to keep track of various quantities, all of which 
     * need to be initialised to an appropriate value.
     * It will need a loop to keep reading the levels until there isn't an integer next.
     * [Core]
     *   - There is guaranteed to be at least one level,
     *   - Print the maximum, minimum, and average level
     *   - Hint, keep track of the sum of the levels using a variable of type double
     */
    public void analyseLevels() {
        UI.clearText();
        int max=0;
        int min=8000;
        int average=0;
        int sum=0;
        int count=0;
        UI.print("Enter numbers end with the word 'done'");
        while(UI.hasNextInt()){
            int num = UI.nextInt();
            if(max<num){
                max=num;
            }
            if(min>num){
                min=num;
            }
            sum = sum+num;
            count=count+1;
        }
        average = sum/count;

        UI.println("the maximum is " + max + " the minimum is " + min + " the average is " + average );
        UI.nextLine();// to clear out the input
    }

    /**
     * Reads a sequence of levels (integers) from the user (using Scanner
     * and the terminal window) and plots a bar graph of them, using narrow 
     * rectangles whose heights are equal to the level.
     * The sequence is terminated by any word (non-number) such as "done" or "end".
     * The method may assume that there are at most 24 numbers.
     * The method will need a loop to keep reading the levels until there isn't a number next.
     *  Each time round the loop, it needs to read the next level and work out where
     *  to draw the rectangle for the bar. 
     * [Completion]
     *   - The method should work even if there were no readings for the day.
     *   - Any level greater than 8000 should be plotted as if it were just 8000, putting an
     *         asterisk ("*") above it to show that it has been cut off.
     *   - Draws a horizontal line for the x-axis (or baseline) without any labels.
     * [Challenge:] 
     *   - The graph should also have labels on the axes, roughly every 50 pixels.
     *   - Make the method ask for a maximum level first, then scale the y-axis and values 
     *     so that the largest numbers just fit on the graph.
     *   - The numbers on the y axis should reflect the scaling.
     */
    public void plotLevels() {
        UI.clearText();
        UI.clearGraphics();
        UI.setColor(Color.black);
        UI.setLineWidth(1);
        UI.drawLine(100,450,650,450);
        double width = 50;
        double left = 100;//  Initialise variables and prompt for input
        // Loop, reading numbers and drawing bars
        UI.print("Enter numbers: end with the word 'done' ");
        while(UI.hasNextInt()){
            double num = UI.nextInt();
            if(num>8000){
                num=8000;
                UI.drawString("*",left+25,35);
            }
            double hight = num/20;
            double top = 450-num/20;
            UI.fillRect(left,top,width,hight);
            left=left+width*2;
        }

        UI.nextLine(); // to clear out the input
        UI.println("Done");
    }

    public void Challenge(){
        UI.clearText();
        UI.clearGraphics();
        UI.setColor(Color.black);
        UI.setLineWidth(1);
        UI.drawLine(100,450,650,450);
        UI.drawString("0",100,470);
        UI.drawString("50",150,470);
        UI.drawString("100",200,470);
        UI.drawString("150",250,470);
        UI.drawString("200",300,470);
        UI.drawString("250",350,470);
        UI.drawString("300",400,470);
        UI.drawString("350",450,470);
        UI.drawString("400",500,470);
        UI.drawString("450",550,470);
        UI.drawString("500",600,470);

        double width = 50;
        double left = 100;
        double max = 0;
        double count = 0;
        double yt = 450; //yasix top
        //  Initialise variables and prompt for input
        // Loop, reading numbers and drawing bars
        double maxlevel = UI.askDouble("what is the maxium level?");
        while(count<maxlevel/20/50){
            UI.drawLine(100,450,100,450-maxlevel/20);
            if(maxlevel/20>=0){
                UI.drawString("0",50,450);
            }
            if(maxlevel/20>=50){
                UI.drawString("1000",50,400);
            }
            if(maxlevel/20>=100){
                UI.drawString("2000",50,350);
            }
            if(maxlevel/20>=150){
                UI.drawString("3000",50,300);
            }
            if(maxlevel/20>=200){
                UI.drawString("4000",50,250);
            }
            if(maxlevel/20>=250){
                UI.drawString("5000",50,200);
            }
            if(maxlevel/20>=300){
                UI.drawString("6000",50,150);
            }
            if(maxlevel/20>=350){
                UI.drawString("7000",50,100);
            }
            if(maxlevel/20>=400){
                UI.drawString("8000",50,50);
            }

            yt=yt-50;
            count++;
        }
        UI.print("Enter numbers: end with the word 'done' ");
        while(UI.hasNextInt()){
            double num = UI.nextInt();
            if(num>maxlevel){
                num=maxlevel;
                UI.drawString("*",left+75,450-maxlevel/20-15);
            }

            double hight = num/20;
            double top = 450-num/20;
            UI.fillRect(left+50,top,width,hight);
            left=left+width*2;
        }

        UI.nextLine(); // to clear out the input
        UI.println("Done");
    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public PowerAnalyser(){
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("Analyse Levels", this::analyseLevels );
        UI.addButton("Plot Levels Completion", this::plotLevels );
        UI.addButton("Plot levels Challenge", this::Challenge );
        UI.addButton("Quit", UI::quit );
    }

}
