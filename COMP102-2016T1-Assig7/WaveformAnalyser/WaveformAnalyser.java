// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 7 
 * Name: 
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.io.*;
import java.util.*;
import java.awt.Color;

/**
 * This is related to your program from assignment 4 which analysed polution levels
 * However, instead of reading data from the user, it reads the data from
 * a file into an ArrayList, which means that it can analyse the numbers
 * more easily and in more different ways.
 * It can also cope with much larger sets of numbers.
 * The numbers are guaranteed to be integers but the values can be
 *   negative and the signal swings above and below zero.
 *
 * There are 11 methods you are to complete, all focusing on the ArrayList of data.
 * CORE
 *  doRead:              reads numbers into an ArrayList.
 *  doDisplay:           displays the waveform.
 *  doReportDistortion:  prints out the fraction of time the signal is distorted.
 * COMPLETION
 *  doSpread:            displays the spread with two horizontal lines and returns its value.
 *  doDisplayDistortion: shows in red the distorted part of the signal.
 *  doHighlightPeaks:    plots the peaks with small green circles.
 * CHALLENGE
 *  doNormalise:         normalises all the values down so there is no distortion.
 *  upperEnvelope:       displays the upper envelope.
 *  lowerEnvelope:       displays the lower envelope.
 *  doSave:              saves the current waveform values into a file.
 *  select and edit:     let the user select a regions of the waveform with the mouse
 *                       to remove them.  Add a save button to save the edited values.
 */

public class WaveformAnalyser{
    // Fields 
    private ArrayList<Double> waveform;   // the field to hold the ArrayList of values

    // Constant: the threshold for the distortionLevel and showDistortion methods
    public static final double THRESHOLD = 200;

    // Constants: the dimensions of the graph for the displayWaveform method
    public static final int GRAPH_LEFT = 10;
    public static final int ZERO_LINE = 260;

    // Constant fields holding the size of the circles for the highlightPeaks method
    public static final int SIZE_CIRCLE = 10;

    private int select;

    double x;
    double y;
    double X;
    double Y;
    double pressedX;
    double pressedY;
    double releasedX;
    double releasedY;
    double startX;
    double startY;
    double endX;
    double endY;

    /**
     * [CORE]
     * Clears the panes, 
     * Creates an ArrayList stored in a field, then
     * Asks user for a waveform file (eg waveform1.txt) 
     * Reads data from the file into the ArrayList
     */
    public void doRead(){
        UI.clearPanes();
        String fname = UIFileChooser.open();
        this.waveform = new ArrayList<Double>();
        try{
            Scanner sc = new Scanner (new File(fname));
            while(sc.hasNext()){
                this.waveform.add(sc.nextDouble());
            }
        } catch (IOException e){UI.println("File reading failed");}
        UI.println("Read "+ this.waveform.size()+" data points from " + fname);
    }

    /**
     * [CORE]
     * Displays the waveform as a line graph,
     * The n'th value in waveform is displayed at
     *    x-position is GRAPH_LEFT + n
     *    y-position is ZERO_LINE - the value
     * Plots a line graph of all the points with a blue line between
     *  each pair of adjacent points
     * Draw the horizontal line representing the value zero.
     * Uses GRAPH_LEFT and ZERO_LINE for the dimensions and positions of the graph.
     * Don't worry if the lines go off the window
     */
    public void doDisplay(){
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        UI.clearGraphics();
        boolean run = true;
        for (int i=0; i<waveform.size(); i++){
            this.x = GRAPH_LEFT + i;
            this.y = ZERO_LINE-waveform.get(i);
            if(run){
                this.X=x;
                this.Y=y;
                run=false;
            }
            UI.setColor(Color.blue);
            UI.drawLine(X,Y,x,y);
            this.X=x;
            this.Y=y;
        }
        // draw x axis (showing where the value 0 will be)
        UI.setColor(Color.black);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size() , ZERO_LINE); 

        // plot points: blue line between each pair of values

    }

    /**
     * [CORE]
     * Computes and prints out the fraction of time the signal is distorted. 
     * This fraction of time is defined as the number of distorted values, divided by the number of values. 
     * A distorted value is defined as one whose absolute
     * value is greater than the value of THRESHOLD 
     * [Hint] You may find Math.abs() useful for this method - it computes the absolute value
     */
    public void doReportDistortion() {
        if (this.waveform == null){ //there is no data to analyse
            UI.println("No signal to analyse and report on");
            return;
        }
        double fraction = 0;
        double count=0;
        for (int i = 0; i<waveform.size();i++){
            this.Y = Math.abs(waveform.get(i));
            if(Y>THRESHOLD){
                count++;
            }
        }
        fraction=count/waveform.size();
        UI.printf("Fraction of time the signal is distorted %4.3f\n", fraction);

    }

    /**
     * [COMPLETION]
     * The spread is the difference between the maximum and minimum values of the waveform.
     * Finds the maximum and minimum values, then
     * Displays the spread by drawing two horizontal lines on top of the waveform: 
     *   one green line for the maximum value, and
     *   one red line for the minimum value.
     */
    public void doSpread() {
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        this.doDisplay();
        double min=999;
        double max=0;

        for (int i=0; i<waveform.size(); i++){
            this.x = GRAPH_LEFT + i;
            this.y = ZERO_LINE-waveform.get(i);

            min=Math.min(min,y);
            max=Math.max(max,y);
            //UI.println(min);

        }
        UI.setColor(Color.red);
        UI.drawLine(GRAPH_LEFT, max, GRAPH_LEFT + this.waveform.size() , max); 
        UI.setColor(Color.green);
        UI.drawLine(GRAPH_LEFT, min, GRAPH_LEFT + this.waveform.size() , min); 

    }

    /**
     * [COMPLETION]  [Fancy version of doDisplay]
     * Display the waveform as a line graph. 
     * Draw a line between each pair of adjacent points
     *   * If neither of the points is distorted, the line is BLUE
     *   * If either of the two end points is distorted, the line is RED
     * Draw the horizontal lines representing the value zero and thresholds values.
     * Uses THRESHOLD to determine distorted values.
     * Uses GRAPH_LEFT and ZERO_LINE for the dimensions and positions of the graph.
     * [Hint] You may find Math.abs(int a) useful for this method.
     * You may assume that all the values are between -250 and +250.
     */
    public void doDisplayDistortion() {
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        UI.clearGraphics();

        // draw zero axis
        UI.setColor(Color.black);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size() , ZERO_LINE); 

        // draw thresholds
        boolean run = true;
        UI.setColor(Color.green);
        UI.drawLine(GRAPH_LEFT,ZERO_LINE-THRESHOLD, GRAPH_LEFT + this.waveform.size() ,ZERO_LINE-THRESHOLD);
        UI.drawLine(GRAPH_LEFT,ZERO_LINE+THRESHOLD, GRAPH_LEFT + this.waveform.size() , ZERO_LINE+THRESHOLD); 

        double value = 0;
        double value_abs = 0;

        for (int i=0; i<waveform.size(); i++){
            this.x = GRAPH_LEFT + i;
            value = waveform.get(i);
            this.y = ZERO_LINE-value;
            if(run){
                this.X=x;
                this.Y=y;
                run=false;
            }
            value_abs = Math.abs(value);
            if(value_abs>THRESHOLD){
                UI.setColor(Color.red);
            }
            else{
                UI.setColor(Color.blue);
            }
            UI.drawLine(X,Y,x,y);
            this.X=x;
            this.Y=y;

        }

    }

    /**
     * [COMPLETION]
     * Plots the peaks with small green circles. 
     *    A peak is defined as a value that is greater or equals to both its
     *    neighbouring values.
     * Note the size of the circle is in the constant SIZE_CIRCLE
     * You may assume that peaks values differ from their neighbouring points.
     */
    public void doHighlightPeaks() {
        this.doDisplayDistortion();//use doDisplay if doDisplayDistortion isn't complete

        for ( int i = 1; i < waveform.size()-1; i ++){
            this.x = GRAPH_LEFT + i;
            double peak = ZERO_LINE-waveform.get(i);
            double value1 = ZERO_LINE-waveform.get(i-1);
            double value2 = ZERO_LINE-waveform.get(i+1);

            if (peak<value1&&peak<value2){
                UI.setColor(Color.green);
                UI.drawOval(this.x-SIZE_CIRCLE/2,peak-SIZE_CIRCLE/2,SIZE_CIRCLE,SIZE_CIRCLE);

            }

        } 

    }

    /**
     * [CHALLENGE]
     * Finds the largest value (positive or negative) in the waveform, and
     * normalises all the values down so that the largest value is now equal to
     * the distortion threshold.
     * Then redraws the waveform.
     */
    public void doNormalise() {
        double max=0;

        for (int i=0; i<waveform.size(); i++){

            this.x = GRAPH_LEFT + i;
            this.y = waveform.get(i);

            double absY=Math.abs(y);
            max=Math.max(max,absY);
            UI.println(max);

        }
        UI.println(max);

        double rate =THRESHOLD/max;

        for (int i=0; i<waveform.size(); i++){
            this.x = GRAPH_LEFT + i;
            this.y = ZERO_LINE-waveform.get(i);

            waveform.set(i,(rate*(waveform.get(i))));

        }

        this.doDisplayDistortion(); //use doDisplay if doDisplayDistortion isn't complete
    }

    public void doEnvelope(){
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        this.doDisplay();  // display the waveform
        this.upperEnvelope();
        this.lowerEnvelope();
    }

    /**
     * [CHALLENGE]
     * Displays the upper envelope with GREEN lines connecting all the peaks.
     *    A peak is defined as a point that is greater or equal to *both* neighbouring points.
     * DO NOT clear the graphics as we also want to view the waveform.
     */
    public void upperEnvelope() {
        boolean run = true;
        for ( int i = 1; i < waveform.size()-1; i ++){
            this.x = GRAPH_LEFT + i;
            double peak = ZERO_LINE-waveform.get(i);
            double value1 = ZERO_LINE-waveform.get(i-1);
            double value2 = ZERO_LINE-waveform.get(i+1);

            //run for 1 times.

            if (peak<value1&&peak<value2){
                if(run){
                    this.X=GRAPH_LEFT + i;
                    this.Y=peak;
                    run= false;

                }
                this.y=peak;
                UI.setColor(Color.green);
                UI.drawLine(this.X,this.Y,this.x,this.y);
                this.X=this.x;
                this.Y=this.y;

            }

        } 
    }

    /**
     * [CHALLENGE]
     * Displays the lower envelope with RED lines connecting all the "negative" peaks.
     *    A "negative" peak is defined as a point that is smaller or equal to *both* neighbouring points.
     * DO NOT clear the graphics as we also want to view the waveform.
     */
    public void lowerEnvelope() {
        boolean run = true;
        for ( int i = 1; i < waveform.size()-1; i ++){
            this.x = GRAPH_LEFT + i;
            double peak = ZERO_LINE-waveform.get(i);
            double value1 = ZERO_LINE-waveform.get(i-1);
            double value2 = ZERO_LINE-waveform.get(i+1);

            //run for 1 times.

            if (peak>value1&&peak>value2){
                if(run){
                    this.X=GRAPH_LEFT + i;
                    this.Y=peak;
                    run= false;

                }
                this.y=peak;
                UI.setColor(Color.red);
                UI.drawLine(this.X,this.Y,this.x,this.y);
                this.X=this.x;
                this.Y=this.y;

            }

        } 
    }

    /**
     * [CHALLENGE]
     * Saves the current waveform values into a file
     */
    public void doSave(){
        try{
            PrintStream out = new PrintStream(new File(UIFileChooser.save()));
            for(int i = 0; i < waveform.size(); i ++){
                out.printf("%s \n",waveform.get(i));

            }
        }
        catch(IOException e) {UI.printf("File Failure %s \n", e);}
    }

    private int index1;
    /**
     * [CHALLENGE]
     * Lets user select a region of the waveform with the mouse
     * and deletes that section of the waveform.
     */
    public void doMouse(String action, double x, double y){
        
        if(action.equals("pressed")){
            this.pressedX=x;
            this.pressedY=y;
        }

        else if(action.equals("released")){
            this.releasedX=x;
            this.releasedY=y;
            this.startX = Math.min(pressedX,releasedX);
            this.startY = Math.min(pressedY,releasedY);
            this.endX = Math.max(pressedY,releasedY);
            this.endY = Math.max(pressedY,releasedY);
            for ( int i = this.waveform.size()-1; i >= 0; i --){
                this.x = GRAPH_LEFT + i;
                this.y = ZERO_LINE-waveform.get(i);
                if(endX>this.x &&startX<this.x){
                    this.waveform.remove(i);
                    UI.clearGraphics();
                    
                }
            }
            this.doDisplayDistortion(); 
        }
    }
    /** ---------- The code below is already written for you ---------- **/
    /** Constructor:
     * Set up the ten buttons and mouselistener
     */
    public WaveformAnalyser(){
        //core
        UI.addButton("Read Data", this::doRead);
        UI.addButton("Display Waveform", this::doDisplay);
        UI.addButton("Report Distortion", this::doReportDistortion);
        //completion
        UI.addButton("Spread", this::doSpread);
        UI.addButton("Display Distortion", this::doDisplayDistortion);
        UI.addButton("Peaks", this::doHighlightPeaks);
        //challenge
        UI.addButton("Normalise", this::doNormalise);
        UI.addButton("Envelope", this::doEnvelope);
        UI.addButton("Save", this::doSave);
        UI.addButton("Quit", UI::quit);
        UI.setMouseListener(this::doMouse);   // only for challenge

    }


    // Main
    public static void main(String[] arguments){
        new WaveformAnalyser();
    }   

}
