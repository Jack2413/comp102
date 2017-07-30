// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 9
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** creates a square grid of colours. */
public class RayBitsExercise {
    private final int size = 5;
    private Color[][] puzzle = new Color[size][size];
    private double sqSize = 30;

    // layout of the grid
    private final int gridLeft = 60;    // left edge of the grid
    private final int gridTop = 30;     // top edge of the grid
    private final int cellWidth = 30;   // width of cells in the grid
    private final int cellHeight = 30;  // height of cells in the grid

    /** Draws the puzzle */
    private void drawPuzzle(){
        UI.clearGraphics();
        for (int row = 0;row<puzzle.length;row++){
            for(int col=0;col<puzzle.length;col++){
                UI.setColor((puzzle[row][col]));
                UI.fillRect(gridLeft+col*sqSize,gridTop+row*sqSize,sqSize,sqSize);
                UI.setColor(Color.black);
                UI.drawRect(gridLeft+col*sqSize,gridTop+row*sqSize,sqSize,sqSize);

            }
        }

    }

    /** Shifts every value one step to the left, except for cells in the
     *  leftmost column, which are moved to the right most column 
     */
    public void shiftLeft() {
        for (int row = 0;row<puzzle.length;row++){
            Color temp = puzzle[row][0];
            for(int col=1;col<puzzle[row].length;col++){
                puzzle[row][col-1]=puzzle[row][col];

            }
            puzzle[row][puzzle.length-1]=temp;
        }
        this.drawPuzzle();
    }

    /** Checks whether all the colours in the specified column are the same
     *  Returns true if they are, and false otherwise. 
     */
    public boolean checkCol(int col){
        for (int row = 0;row<puzzle.length;row++){
            for( col=0;col<puzzle.length;col++){
                Color temp = puzzle[row][col];
                if((temp == puzzle[row][1] )&&(temp == puzzle[row][2])&&temp == puzzle[row][3]&&temp == puzzle[row][4]&&temp == puzzle[row][0]){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
    /** ---------- The code below is already written for you ---------- **/
    /** creates a cross-word of x columns and y rows */
    public RayBitsExercise(){
        UI.addButton("New", this::newPuzzle );
        UI.addButton("Check Cols", this::reportCols );
        UI.addButton("Shift Left", this::shiftLeft );
        UI.addButton("Quit", UI::quit );
        this.newPuzzle();
    }

    /** Makes a new puzzle with random colours selected from red, green, and blue  */
    public void newPuzzle(){
        Color[] colors = new Color[]{Color.red, Color.green, Color.blue, Color.red};
        for (int row=0; row<this.size; row++){
            for (int col=0; col<this.size; col++){
                int randomIndex = (int)(Math.random()*colors.length);
                this.puzzle[row][col] = colors[randomIndex];
            }
        }
        this.drawPuzzle();
    }

    /** Calls the checkCol method on each column */
    public void reportCols(){
        UI.clearText();
        for (int col=0; col<this.size; col++){
            UI.print("Col "+col+": ");
            if (this.checkCol(col)) {
                UI.println("Colors are all the same");
            }
            else {
                UI.println("not same");
            }
        }
    }

    public static void main(String[] args){
        RayBitsExercise obj = new RayBitsExercise();
    }    

}
