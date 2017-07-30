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

/** The snake is created at a random position with a random direction.
 * The constructor does not have any parameters.
 * It can move
 *  - makes it go forward one step in its current direction.
 *  - if outside arena boundaries, makes it go backward one step, and then turn to a new (random)
 *         direction.
 *  The walls of the arena are determined by the constants:
 *    FrogSnakeGame.TopWall, FrogSnakeGame.BotWall, FrogSnakeGame.LeftWall and FrogSnakeGame.RightWall
 * It can report its current position (x and y) with the
 *  getX() and getY() methods.
 *  draw() will make it draw itself,
 *  erase() will make it erase itself
 */

public class Snake{
    String position;
    private double randomx;
    private double randomy;
    private double SnakeSize=Frog.INITIAL_SIZE;
    public double X;
    public double Y;

    public double snakex;
    public double snakey;
    public double SPEED = 1;

    public String dir = "up";

    public Snake(){
        this.randomx = FrogSnakeGame.LeftWall + SnakeSize/2 + Math.random()*(FrogSnakeGame.ArenaSize-SnakeSize/2);
        this.randomy = FrogSnakeGame.TopWall + SnakeSize/2 + Math.random()*(FrogSnakeGame.ArenaSize-SnakeSize/2);
        this.snakex=this.randomx-SnakeSize;
        this.snakey=this.randomy-SnakeSize;
    }

    public void draw(){
        UI.drawImage("Snake.jpg", snakex, snakey, SnakeSize, SnakeSize);
    }

    public void move(double level){
        //directions;
        if(this.dir.equals("right")){
            this.snakex=this.snakex + (SPEED+level/2);
        }
        if(this.dir.equals("left")){
            this.snakex=this.snakex - (SPEED+level/2);
        }
        if(this.dir.equals("up")){
            this.snakey=this.snakey - (SPEED+level/2);
        }
        if(this.dir.equals("down")){
            this.snakey=this.snakey + (SPEED+level/2);
        }
        
        if(this.dir.equals("upright")){
            this.snakey=this.snakey - (SPEED+level/2);
            this.snakex=this.snakex + (SPEED+level/2);
        }
        if(this.dir.equals("upleft")){
            this.snakex=this.snakex - (SPEED+level/2);
            this.snakey=this.snakey - (SPEED+level/2);
        }
        if(this.dir.equals("downright")){
            this.snakex=this.snakex + (SPEED+level/2);
            this.snakey=this.snakey + (SPEED+level/2);
        }
        if(this.dir.equals("downleft")){
            this.snakex=this.snakex - (SPEED+level/2);
            this.snakey=this.snakey + (SPEED+level/2);
        }
        
        //if the snake touch the wall, the snack change directions.
        if(this.snakey<=FrogSnakeGame.TopWall){
            int num =(int) (Math.random()*3);
            
            if(num==0){
                dir = "downright";
            }
            if(num==1){
                dir = "downleft";
            }
            if(num==2){
                dir = "down";
            }
        }

        if(this.snakex<=FrogGame.LeftWall){
            int num =(int) (Math.random()*3);
            
            if(num==0){
                dir = "right";
            }
            if(num==1){
                dir = "upright";
            }
            if(num==2){
                dir = "downright";
            }
        }

        if(this.snakey+SnakeSize>=FrogGame.BotWall){
            int num =(int) (Math.random()*3);
            
            if(num==0){
                dir = "upright";
            }
            if(num==1){
                dir = "upleft";
            }
            if(num==2){
                dir = "up";
            }
        }

        if(this.snakex+SnakeSize>=FrogGame.RightWall){
            int num =(int) (Math.random()*3);
            
            if(num==0){
                dir = "upleft";
            }
            if(num==1){
                dir = "left";
            }
            if(num==2){
                dir = "downleft";
            }
        }
        draw();
    }

    public double getX(){
        return snakex+SnakeSize/2;
    }

    public  double getY(){
        return snakey+SnakeSize/2;
    }
}
