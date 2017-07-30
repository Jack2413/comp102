// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 3
 * Name:Zhancheng Gan
 * Usercode:
 * ID:30078961
 * 
 */

import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;

/** TricolourFlagDrawer: draws a series of tricolour flags */
public class TricolourFlagDrawer{

    public static final double width = 200;
    public static final double height = 133;

    /**
     * asks user for a position and three colours, then calls the 
     * drawThreeColourFlagCore method, passing the appropriate arguments
     *
     * CORE
     */
    public void testCore(){
        double left = UI.askDouble("left of flag");
        double top = UI.askDouble("top of flag");
        UI.println("Now choose the colours");
        Color stripe1 = JColorChooser.showDialog(null, "First Stripe", Color.white);
        Color stripe2 = JColorChooser.showDialog(null, "Second Stripe", Color.white);
        Color stripe3 = JColorChooser.showDialog(null, "Third Stripe", Color.white);
        this.drawThreeColourFlagCore(left, top, stripe1, stripe2, stripe3 );
    }

    /**
     * draws a three colour flag consisting of three vertical equal-width stripes
     * at the given position
     *
     * CORE
     */
    public void drawThreeColourFlagCore(double left, double top, Color stripe1, Color stripe2, Color stripe3 ){

        UI.setColor(stripe1);
        UI.fillRect(left,top,width,height);
        UI.setColor(stripe2);
        UI.fillRect(left,top,width,height*2/3);
        UI.setColor(stripe3);
        UI.fillRect(left,top,width,height*1/3);
        UI.setColor(Color.black);
        UI.setLineWidth(1);
        UI.drawRect(left,top,width,height);

    }

    /**
     * draws multiple flag made up of three equal size stripes by calling the
     * drawThreeColourFlagCompletion method, passing the appropriate arguments
     *
     * COMPLETION
     */
    public void testCompletion(){
        double left=100;
        double top=20;
        this.drawThreeColourFlagCompletion(true, 20, 50, Color.black, Color.yellow, Color.red);               // Belgium
        this.drawThreeColourFlagCompletion(false, 250, 100, Color.black, Color.red, Color.yellow);            // Germany
        this.drawThreeColourFlagCompletion(true, 140, 430, Color.blue, Color.white, Color.red);               // France
        this.drawThreeColourFlagCompletion(false, 470, 30, Color.red, Color.white, Color.blue);               // The Netherlands
        this.drawThreeColourFlagCompletion(false, 50, 250, Color.white, Color.blue, Color.red);               // Russia
        this.drawThreeColourFlagCompletion(true, 290, 270, Color.red, Color.yellow, Color.green.darker());    // Guinea
    }

    /**
     * draws a three colour flag consisting of three equal-size stripes
     * at the given position
     * The stripes can be either vertical or horizontal
     *
     * COMPLETION
     */
    public void drawThreeColourFlagCompletion(boolean horizontal, double left, double top, Color c1, Color c2, Color c3 ){
        if(horizontal){
            UI.setColor(c3);
            UI.fillRect(left,top,width,height);
            UI.setColor(c2);
            UI.fillRect(left,top,width*2/3,height);
            UI.setColor(c1);
            UI.fillRect(left,top,width*1/3,height);
            UI.setColor(Color.black);
            UI.setLineWidth(1);
            UI.drawRect(left,top,width,height);
        }else{

            UI.setColor(c3);
            UI.fillRect(left,top,width,height);
            UI.setColor(c2);
            UI.fillRect(left,top,width,height*2/3);
            UI.setColor(c1);
            UI.fillRect(left,top,width,height*1/3);
            UI.setColor(Color.black);
            UI.setLineWidth(1);
            UI.drawRect(left,top,width,height);
        }

    }

    public void testChallenge(){
        double left = 50;
        double top = 50;
        this.drawThreeColourFlagChallenge(true, 50, 50, Color.black, Color.yellow, Color.red, "Belgim");               // Belgium
        this.drawThreeColourFlagChallenge(false, 300, 50, Color.black, Color.red, Color.yellow,"Germany");            // Germany
        this.drawThreeColourFlagChallenge(true, 550, 50, Color.blue, Color.white, Color.red,"France");               // France
        this.drawThreeColourFlagChallenge(false, 50, 250, Color.red, Color.white, Color.blue,"The Netherlands");               // The Netherlands
        this.drawThreeColourFlagChallenge(false, 300, 250, Color.white, Color.blue, Color.red,"Russia");               // Russia
        this.drawThreeColourFlagChallenge(true, 550, 250, Color.red, Color.yellow, Color.green.darker(),"Guinea");    // Guinea
        this.drawThreeColourFlagChallenge(true, 50, 450, Color.red, Color.white, Color.green, "Ltaly");               // ltaly
        this.drawThreeColourFlagChallenge(false, 300, 450, Color.red, Color.blue, Color.yellow,"Colombia" );               // Colombia
        this.drawThreeColourFlagChallenge(false, 550 ,450, Color.blue, Color.black, Color.white,"Estonia" );              // Estonia

    }
    
    public void drawThreeColourFlagChallenge(boolean horizontal, double left, double top, Color c1, Color c2, Color c3, String name){
        if(horizontal){
            UI.setColor(c3);
            UI.fillRect(left,top,width,height);
            UI.setColor(c2);
            UI.fillRect(left,top,width*2/3,height);
            UI.setColor(c1);
            UI.fillRect(left,top,width*1/3,height);
            UI.setColor(Color.black);
            UI.setLineWidth(1);
            UI.drawRect(left,top,width,height);
        }else{

            UI.setColor(c3);
            UI.fillRect(left,top,width,height);
            UI.setColor(c2);
            UI.fillRect(left,top,width,height*2/3);
            UI.setColor(c1);
            UI.fillRect(left,top,width,height*1/3);
            UI.setColor(Color.black);
            UI.setLineWidth(1);
            UI.drawRect(left,top,width,height);
        }
        int len=name.length();
        UI.drawString (name,left+width/2-len*3.0,top+height+15);
    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public TricolourFlagDrawer(){
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("Core", this::testCore );
        UI.addButton("Completion", this::testCompletion );
        UI.addButton("Challenge", this ::testChallenge );
        UI.addButton("Quit", UI::quit );
    }

}
