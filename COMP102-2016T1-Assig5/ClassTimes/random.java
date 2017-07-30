import ecs100.*;
import java.util.*;
import java.io.*;
/**
 * Write a description of class random here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class random
{
    private int x;

    /**
     * Constructor for objects of class random
     */
    public void random()
    {
        try {
            PrintStream out = new PrintStream(new File("random.txt"));
            while(true){
                
                if(){
                    out.printf();
                }   
            }
        }
        catch(IOException e) {UI.printf("File Failure %s \n", e);}
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
       UI.addButton("Random", this::random);
    }
}
