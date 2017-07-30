// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/** A Surprise object remembers the word it was given when it was constructed
 *   and has one method that says "Boo " followed by the word.
 *   It is a totally useless class!!!
 */
public class Surprise{
    public String word;
    //field
    /*# YOUR CODE HERE */

    /** Constructor: 
     * Stores the word it is passed in the field
     */
    public Surprise(String wd){
        this.word =wd;
        
    }

    /** sayBoo method
     * Prints out "Boo " followed by the stored word
     */
    public void sayBoo(){
        UI.println("boo" + this.word);
                
    }        
}
