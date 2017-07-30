// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** FrogSnakeGame: Completion
 *  Game with two frogs that race to get to the bug first in order to eat it, and must avoid snakes.
 *  (uses keys: player 1: W/A/S/D for up/left/down/right; controls the "light" frog
 *              player 2: I/J/K/L for up/left/down/right; controls the "dark" frog
 *  Frogs move around at a constant speed in an arena with an enclosing wall.
 *  When one of the frog reaches the bug, the frog eats it (grows in size),
 *       and a new bug appears at a random position within the arena walls.
 *
 *  The game has two snakes that constantly move in a random direction until they hits a wall.
 *    In which case the snake changes direction.
 * When a frog touches a snakes, it shrinks back to its original size.
 *
 *  Controls:
 *  - key to start (space)
 *  - keys to turn the two frogs  (w/a/s/d  and i/j/k/l)
 *
 *  Display:
 *   program constantly shows
 *   - the arena, the bug,  the frogs and the snakes
 *
 *  Constants:
 *    This class should contain constants specifying the various parameters of
 *    the game, including the geometry of the arena and obstacle.
 */

public class FrogSnakeGame{

    // Constants for the Geometry of the game.
    // (You may change or add to these if you wish)

    public static final int ArenaSize = 400;
    public static final int LeftWall = 30;
    public static final int RightWall = LeftWall+ArenaSize;
    public static final int TopWall = 50;
    public static final int BotWall = TopWall+ArenaSize;
    public static final int BugSize = 15;

    public static final int DELAY = 20;  // milliseconds to delay each step.
    // Fields to store the two frogs 
    private Frog frog1;
    private Frog frog2;
    private String doAIfrog = "normal";

    // Fields to store the two snakes
    private Snake snake1;
    private Snake snake2;

    // Fields to position of the centre of the bug
    private double xBug;
    private double yBug;

    //AIfrog

    boolean AIfrog = false;

    //scoreboard
    private int frog1score;
    private int frog2score;

    private String Frog1score;
    private String Frog2score;

    private int frog1growth;
    private int frog2growth;

    private String Frog1growth;
    private String Frog2growth;

    private int frog1lifes;
    private int frog2lifes;

    private String Frog1lifes;
    private String Frog2lifes;

    private int level;
    private String Level;

    /** Constructor
     * Set up the GUI,
     * Draw the arena and the bug
     */
    public FrogSnakeGame(){
        UI.initialise();
        UI.setImmediateRepaint(false);
        UI.setKeyListener(this::doKey);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0);
        UI.printMessage("Move mouse to arena and press p to start");
        this.drawArenaBug();
        UI.repaintGraphics();
    }

    /**
     * Respond to keys.
     * the space key should reset the game to have two new frogs
     * the w/a/s/d keys should make the light frog turn up, to the left, down or to the right
     * the i/j/k/l keys should make the dark frog turn up, to the left, down or to the right
     */
    public void doKey(String key){
        if (key.equals("p")) {
            restartGame();
        }
        else if (key.equals("w") ){
            this.frog1.turnUp();
        }
        else if (key.equals("a") ){
            this.frog1.turnLeft();
        }

        if(key.equals("q") ){
            this.frog1.turnUpLeft();
        }
        if(key.equals("e") ){
            this.frog1.turnUpRight();
        }
        if(key.equals("z") ){
            this.frog1.turnDownLeft();
        }
        if(key.equals("c") ){
            this.frog1.turnDownRight();
        }

     
        if (key.equals("s") ){
            this.frog1.turnDown();
        }
        else if (key.equals("d") ){
            this.frog1.turnRight();
        }
        else if (key.equals("i") ){
            this.frog2.turnUp();
        }
        else if (key.equals("j") ){
            this.frog2.turnLeft();
        }
        if (key.equals("k") ){
            this.frog2.turnDown();
        }
        else if (key.equals("l") ){
            this.frog2.turnRight();
        }
        
         if(key.equals("u") ){
            this.frog2.turnUpLeft();
        }
        if(key.equals("o") ){
            this.frog2.turnUpRight();
        }
        if(key.equals("m") ){
            this.frog2.turnDownLeft();
        }
        if(key.equals(".") ){
            this.frog2.turnDownRight();
        }
        //AIforg
        if(key.equals("y")){
            becomeAIfrog();
        }

    }

    /**
     * Reset the game with two new frogs in the starting positions,
     *   and two snakes at a random position.
     * Loop forever
     *  - move each frog one step,
     *  - move each snake one step,
     *  - if any frog has caught the bug, it grows, and a new bug appears somewhere else.
     *  - if any frog was caught by a snake, it shrinks back to its original position.
     *  - redraw the game (frogs, snakes, arena, and bug)
     */
    private void restartGame(){
        // make sure that the current game ends (if it is running)
        this.frog1 = null;
        this.frog2 = null;
        this.snake1 = null;
        this.snake2 = null;

        UI.sleep(3*DELAY);
        // puts a bug at a random position
        this.newBug();

        // make new frogs
        this.frog1 = new Frog(LeftWall+30, (TopWall+BotWall)/2, "Up", "light");
        this.frog2 = new Frog(RightWall-30, (TopWall+BotWall)/2, "Left", "dark");

        // add 2 snakes
        this.snake1 = new Snake ();
        this.snake2 = new Snake ();

        // call redraw
        this.redraw();

        //scoreboard
        this.frog1lifes=100;
        this.frog2lifes=100;
        this.frog1growth=0;
        this.frog1growth=0;
        this.frog1score= 0; 
        this.frog2score= 0;
        this.level=0;

        UI.printMessage("press y dark frog become AI frog press y again become noraml frog");

        // Run the game
        while (this.frog1!=null && this.frog2!=null) {
            this.frog1.move();
            if(this.doAIfrog.equals("AIfrog")){
                this.frog2.AImove(xBug,yBug,level);
            }
            else{
                this.frog2.move();
            }
            this.snake1.move(level);
            this.snake2.move(level);
            if (this.frog1.touching(xBug, yBug)) {
                this.frog1.grow();
                this.newBug();
                this.frog1growth=this.frog1.growth();
                this.frog1score= this.frog1.score(frog1growth); 
            }
            else if (this.frog2.touching(xBug, yBug)) {
                this.frog2.grow();
                this.newBug();
                this.frog2growth=this.frog2.growth();
                this.frog2score=this.frog2.score(frog2growth); 
            }
            if (this.frog1.touching(this.snake1.getX(), this.snake1.getY()) ||
            this.frog1.touching(this.snake2.getX(), this.snake2.getY()) ) {
                this.frog1.shrink();
                this.frog1lifes=this.frog1.lifes();
                this.frog1growth=0;
            }
            if (this.frog2.touching(this.snake1.getX(), this.snake1.getY()) ||
            this.frog2.touching(this.snake2.getX(), this.snake2.getY()) ) {
                this.frog2.shrink();
                this.frog2lifes=this.frog2.lifes();
                this.frog2growth=0;
            }
            this.redraw();
            UI.sleep(DELAY);
        }

    }

    /**
     * Redraws
     * - the arena
     * - the bug
     * - the two frogs
     * - the two snakes
     */
    private void redraw(){
        UI.clearGraphics();
        this.drawArenaBug();
        this.frog1.draw();
        this.frog2.draw();
        this.snake1.draw();
        this.snake2.draw();
        this.levelup();
        this.drawscoreboard();
        UI.repaintGraphics();
    }

    /**
     * Draw the arena as a rectangle with a bug in it
     */
    public void drawArenaBug(){
        UI.setColor(Color.black);
        UI.setLineWidth(2);
        UI.drawRect(LeftWall, TopWall, ArenaSize, ArenaSize);
        UI.setLineWidth(1);
        UI.drawImage("bug.png", xBug-BugSize/2, yBug-BugSize/2, BugSize, BugSize);
    }

    /**
     * Defines new position for the bug and draws it
     */
    public void newBug(){
        xBug = LeftWall + BugSize/2 + Math.random()*(ArenaSize-BugSize/2);
        yBug = TopWall + BugSize/2 + ?*(ArenaSize-BugSize/2);
    }

    /**
     * Create a new FrogSnakeGame object (which will set up the interface)
     * and then call the run method on it, which will start the game running
     */
    public static void main(String[] arguments){
        new FrogSnakeGame();
    }

    private void becomeAIfrog(){
        if(AIfrog){
            this.doAIfrog="normal";
            this.AIfrog=false;
        }
        else{
            this.doAIfrog="AIfrog";
            this.AIfrog=true;
        }
    }

    private void levelup(){
        this.level=frog1score/10;
    }

    private void scoreboard(){
        this.Frog1score = Integer.toString(this.frog1score);
        this.Frog2score = Integer.toString(this.frog2score);
        this.Frog1growth = Integer.toString(this.frog1growth);
        this.Frog2growth = Integer.toString(this.frog2growth);
        this.Frog1lifes = Integer.toString(this.frog1lifes);
        this.Frog2lifes = Integer.toString(this.frog2lifes);
        this.Level = Integer.toString(this.level);
    }

    private void drawscoreboard(){
        this.scoreboard();
        UI.drawString("Light frog",450,50);
        UI.drawString("Score",450,70);
        UI.drawString(this.Frog1score, 560,70);
        UI.drawString("Growth",450,90);
        UI.drawString(this.Frog1growth, 560,90);
        UI.drawString("HP",450,110);
        UI.drawString(this.Frog1lifes, 560,110);

        UI.drawString("Dark frog",450,150);
        UI.drawString("Score",450,170);
        UI.drawString(this.Frog2score, 560,170);
        UI.drawString("Growth",450,190);
        UI.drawString(this.Frog2growth, 560,190);
        UI.drawString("HP",450,210);
        UI.drawString(this.Frog2lifes, 560,210);

        UI.drawString("level",200,30);
        UI.drawString(Level,250,30);
        //Gamerules
        
        UI.drawString("FrogSnakeGame Introduction",450,250);
        UI.drawString("1.Press Y turn dark frog become AIforg",450,270);
        UI.drawString("2.When you touch the snake you will lose HP when HP equals 0 you lose game)",450,290);
        UI.drawString("3.When you eat the bug(touch) you will get score and growth)",450,310);
        UI.drawString("4.When the snake touching you,you will back to initial size",450,330);
        UI.drawString("5.The one who gets 100 point frist it win the game",450,350);
        UI.drawString("6.Press WADSQEZC to cotrol light frog, press JIKLUONM. to control darkfrog GL HF : )",450,370);
        if(this.frog1lifes<=0||this.frog2lifes<=0||this.frog1score>=100||this.frog2score>=100){
            this.endgame();
        }
    }

    private void endgame(){

        if(this.frog1lifes<=0||this.frog2score>=100){
            UI.drawString("You Lose",210,250);
            UI.drawString("Hint:large size you got more point you get :)",130,270);
        }
        else{
            UI.drawString("You Win",210,250);
        }
        UI.printMessage("Move mouse to arena and press p to restart");

    }
}
