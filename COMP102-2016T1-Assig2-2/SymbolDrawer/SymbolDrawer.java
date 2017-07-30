// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 2  COMP102
 * Name:Zhancheng Gan
 * Usercode:
 * ID:300378961
 */

import ecs100.*;
import java.awt.Color;

/**
 * Draws various symbols: flags, signs, and car logos
 *
 * The correct dimensions of the official flags varies from country to country,
 * The exact colours of the flags will also be difficult to match;
 * It is fine to use the standard colours: red, green, blue, orange, etc
 * You can find lots of flag details (including the correct dimensions and colours)
 * from   http://www.crwflags.com/fotw/flags/    
 */
public class SymbolDrawer{

    public static final double top = 100;
    public static final double left = 50;

    /** The flag of France has three vertical stripes;
     *  The left is blue, the right is red and the middle is white.
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     *  CORE
     */
    public void franceFlag(){
        double Width = UI.askDouble("width for indonesiaFalg");
        double Height = (Width*2/3);
        double x = (top+Width);
        double y = (left+Height);
        UI.setColor(Color.black);
        UI.setLineWidth(1);
        UI.setColor(Color.blue.darker());
        UI.fillRect(top,left,Width,Height);
        UI.setColor(Color.white);
        UI.fillRect(top+Width*1/3,left,Width*2/3,Height);
        UI.setColor(Color.red.darker());
        UI.fillRect(top+Width*2/3,left,Width*1/3,Height);
        
        
        /*# YOUR CODE HERE */

    }

    /** The hospital sign consists of a blue square with a big white centred H
     *  The H consists of 3 rectangles (width is the size divided by 7.5
     *  A square means that the hight and the width are of equal size
     *  CORE
     */
    public void hospitalSign() {
        double width = UI.askDouble("width for indonesiaFalg");
        double height = (width);
        UI.setColor(Color.blue);
        UI.fillRect(left,top,width,height);
        UI.setColor(Color.white);
        UI.fillRect(left+width/4,top+width/5,width/7.5,width*0.6);
        UI.fillRect((left+width*3/4)-width/7.5,top+width/5,width/7.5,width*0.6);
        UI.fillRect(left+width/4,(top+width/2)-width/7.5/2,width/2,width/7.5);
        UI.setColor(Color.black);
        UI.setLineWidth(1);
        UI.drawLine(left,top,left+width,top);
        UI.drawLine(left,top,left,top+height);
        UI.drawLine(left+width,top,left+width,top+height);
        UI.drawLine(left,top+height,left+width,top+height);
        /*# YOUR CODE HERE */

    } 

    /**
     *  The flag of Laos has three horizontal stripes with a white circle in the centre;
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     *  The top and bottom stripes are red, and they are each 1/4 of the height of the flag.
     *  The middle stripe is blue and it is 1/2 of the height of the flag.
     *  The diameter of white circle is 4/5 the height of blue strip, 
     *       eg 2/5 of the total height.
     *  CORE
     */
    public void laosFlag() {
        double width = UI.askDouble("(width for Laosfalg");
        double height = (width*2/3);
        UI.setColor(Color.red);
        UI.fillRect(left,top,width,height);
        UI.setColor(Color.blue.darker());
        UI.fillRect(left,top+height/4,width,height/2);
        UI.setColor(Color.white);
        UI.fillOval(left+width/2-height/5,top+height*3/10,height*2/5,height*2/5);
        UI.setColor(Color.black);
        UI.setLineWidth(1);
        UI.drawLine(left,top,left+width,top);
        UI.drawLine(left,top,left,top+height);
        UI.drawLine(left+width,top,left+width,top+height);
        UI.drawLine(left,top+height,left+width,top+height);
        
       /*# YOUR CODE HERE */

    }

    /**
     *  The flag of the United Arab Emirates is divided into four rectangular parts.
     *  The first red rectangle is the vertical band nearest to the mast, its length being
     *  equivalent to the height of the flag, while its width is one quarter of the length of
     *  the entire flag.
     *  The other three parts are three horizontal stripes of equal size.
     *  The top most is green, the middle is white and the lower is black.
     *  The flag is 1/2 as high as it is wide (ratio 1:2).
     *  COMPLETION
     */
    public void uaeFlag() {
        double width = UI.askDouble("(width for Laosfalg");
        double height = (width*2/3);
        UI.setColor(Color.black);
        UI.fillRect(left,top,width,height);
        UI.setColor(Color.white);
        UI.fillRect(left,top,width,height*2/3);
        UI.setColor(Color.green);
        UI.fillRect(left,top,width,height*1/3);
        UI.setColor(Color.red);
        UI.fillRect(left,top,width/4,height);
        UI.setColor(Color.black);
        UI.setLineWidth(1);
        UI.drawLine(left,top,left+width,top);
        UI.drawLine(left,top,left,top+height);
        UI.drawLine(left+width,top,left+width,top+height);
        UI.drawLine(left,top+height,left+width,top+height);/*# YOUR CODE HERE */

    }

    /** The flag of Greenland is a rectangle whose top half is white
     *  and bottom half is red. There is a circle in the middle (off-set to left) 
     *  which is also half white/red but on the opposite sides.
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     *  COMPLETION
     */
    public void greenlandFlag() {
        double width = UI.askDouble("(width for Laosfalg");
        double height = (width*2/3);
        UI.setColor(Color.red);
        UI.fillRect(left,top,width,height);
        UI.setColor(Color.white);
        UI.fillRect(left,top,width,height/2);
        UI.setColor(Color.white);
        UI.fillArc(left+width/2-height/5,top+height*3/10,height*2/5,height*2/5,90,270);
        UI.setColor(Color.red);
        UI.fillArc(left+width/2-height/5,top+height*3/10,height*2/5,height*2/5,0,180);
        UI.setColor(Color.black);
        UI.setLineWidth(1);
        UI.drawLine(left,top,left+width,top);
        UI.drawLine(left,top,left,top+height);
        UI.drawLine(left+width,top,left+width,top+height);
        UI.drawLine(left,top+height,left+width,top+height);
       /*# YOUR CODE HERE */

    }

    /** Mitsubishi
     * 
     *  CHALLENGE
     */
    public void mitsubishiLogo() {
        double width = UI.askDouble("(width for mitsubishilog");
        double height = (width);
        UI.setColor(Color.red);
        UI.setColor(Color.red);
        double [] x1 = new double [4];
        double [] y1 = new double [4];
        x1[1]=left+width/2;
        y1[1]=top+height/10;
        x1[2]=left+width*3/10;
        y1[2]=top+height*3/10;
        x1[3]=left+width*7/10;
        y1[3]=top+height*3/10;
        x1[4]=left+width/2;
        y1[4]=top+height*7/10;
        UI.fillPolygon(x1,y1,4);
        double [] x2 = new double [4];
        double [] y2 = new double [4];
        x2[1]=left+width*2/10;
        y2[1]=top+height*7/10;
        x2[2]=left+width/2;
        y2[2]=top+height*7/10;
        x2[3]=left+width*1/10;
        y2[3]=top+height*9/10;
        x2[4]=left+width*3/10;
        y2[4]=top+height*9/10;
        UI.fillPolygon(x2,y2,4);
        double [] x3 = new double [4];
        double [] y3 = new double [4];
        x3[1]=left+width/2;
        y3[1]=top+height*7/10;
        x3[2]=left+width*8/10;
        y3[2]=top+height*7/10;
        x3[3]=left+width*7/10;
        y3[3]=top+height*9/10;
        x3[4]=left+width*9/10;
        y3[4]=top+height*9/10;
        UI.fillPolygon(x3,y3,4);
        UI.setColor(Color.black);
        UI.setColor(Color.black);
        UI.setLineWidth(1);
        UI.drawLine(left,top,left+width,top);
        UI.drawLine(left,top,left,top+height);
        UI.drawLine(left+width,top,left+width,top+height);
        UI.drawLine(left,top+height,left+width,top+height);/*# YOUR CODE HERE */

    }

    /** The Koru flag belongs to the long list of new flags designs
     *  It has been designed by Sven Baker from Wellington
     *  The flag is 1/2 as high as it is wide (ratio 1:2).
     *  CHALLENGE
     */
    public void koruFlag() {
        double width = UI.askDouble("(width for Laosfalg");
        double height = (width*1/2);
        UI.setColor(Color.blue.darker());
        UI.fillRect(left,top,width,height);
        UI.setColor(Color.red);
        UI.fillRect(left,top,width/2,height);
        UI.setColor(Color.white);
        UI.fillOval(left+width/4,top-height/16,height+height/8,height+height/8);
        UI.setColor(Color.blue.darker());
        UI.fillOval(left+width*5/16,top+height/16,height-height/8,height-height/8);
        UI.fillOval(left+width*21/32,top+height*0.414,width*0.167,width*0.167);
        UI.setColor(Color.white);
        UI.fillOval(left+width*41/64,top+height*0.32374,width*0.167,width*0.167);
        
        
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor, sets up the user interface */
    public SymbolDrawer(){
        UI.initialise();

        // CORE
        UI.addButton("Core: Flag of France", this::franceFlag);
        UI.addButton("Core: Hospital Sign", this::hospitalSign);
        UI.addButton("Core: Flag of Laos", this::laosFlag);

        // COMPLETION
        UI.addButton("Completion: Flag of UAE", this::uaeFlag);
        UI.addButton("Completion: Flag of Greenland", this::greenlandFlag);

        // CHALLENGE
        UI.addButton("Challenge: Mitsubishi", this::mitsubishiLogo);
        UI.addButton("Challenge: Koru Flag", this::koruFlag);
        UI.addButton("Clear",UI::clearGraphics);
        UI.addButton("Quit", UI::quit);
    }


}
