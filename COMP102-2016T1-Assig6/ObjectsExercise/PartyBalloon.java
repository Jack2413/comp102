// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** A PartyBalloon object represents a small round balloon on the graphics pane.
 *   It remembers its current position and its color.
 *   Its initial position and its color are set when it is constructed
 *   The diameter of a balloon should be 30.
 *   It has three methods:
 *     draw(),      which draws the balloon at its current position
 *     riseLeft(),  which makes the balloon rise up by 20, and move 5 to the left
 *     riseRight(), which makes the balloon rise up by 20, and move 5 to the right
 */
public class PartyBalloon{

    //fields
    double x;
    double y;
    Color color;
    final int diam;
    /*# YOUR CODE HERE */

    /** Constructor: passed the intial position and color.
     * Initialises the fields
     * draws the balloon.
     */
    public PartyBalloon(int x,int y,Color color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.diam = 30;
        draw();
      
    }

    /** draw method (no parameters)
     * draws the balloon at its current position, of the right colour.
     */
    public void draw(){
        UI.setColor(this.color);
        UI.fillOval(x,y,diam,diam);

    }
    
    /** riseLeft method (no parameters)
     * changes the position of the balloon up and to the left
     * Does not erase or redraw!!
     */
    public void riseLeft(){
        this.x = this.x - 20;
        this.y = this.y - 20;

    }

    /** riseRight method (no parameters)
     * Makes balloon move up and to the right
     * Does not erase or redraw
     */
    public void riseRight(){
        this.x = this.x + 20;
        this.y = this.y + 20;
    }

    /*# YOUR CODE HERE */
}