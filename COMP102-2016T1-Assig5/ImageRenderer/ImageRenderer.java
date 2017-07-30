// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 5
 * Name: Zhancheng Gan      
 * Usercode: ganzhan
 * ID: 300378961
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** Renders plain ppm images onto the graphics panel
 *  ppm images are the simplest possible colour image format.
 */

public class ImageRenderer{
    public static final int top = 20;   // top edge of the image
    public static final int left = 20;  // left edge of the image
    public static final int pixelSize = 2;  

    /** Core:
     * Renders a ppm image file.
     * Asks for the name of the file, then calls renderImageHelper.
     */
    public void renderImageCore(){
        String fileName = UIFileChooser.open("Choose a file");
        UI.println("Printing contents of "+ fileName);
        UI.println("--------------------------------------");
        try {
            Scanner scan = new Scanner(new File(fileName));
            this.renderImageHelper(scan);
        }
        catch(IOException e){UI.println("File reading failed");}
        UI.println("--------------------------------------");
    }

    /** Core:
     * Renders a ppm image file.
     * Renders the image at position (left, top).
     * Each pixel of the image  is rendered by a square of size pixelSize
     * Assumes that
     * - the colour depth is 255,
     * - there is just one image in the file (not "animated"), and
     * - there are no comments in the file.
     * The first four tokens are "P3", number of columns, number of rows, 255
     * The remaining tokens are the pixel values (red, green, blue for each pixel)
     */
    public void renderImageHelper(Scanner sc){
        double x = left;
        double y =top;
        double z = pixelSize;
        int row=0;
        int column=0;
        String name = sc.next();
        int columns=sc.nextInt();
        int rows=sc.nextInt();
        int maxcolor = sc.nextInt();
        while(row<rows){
            while(column<columns){
                int red = sc.nextInt();
                int green = sc.nextInt();
                int blue = sc.nextInt();
                Color color = new Color(red,green,blue);
                UI.setColor(color);
                UI.fillRect(x,y,z,z);
                x=x+z;
                column++;
            }
            y=y+z;
            x=x-column*z;
            column=0;
            row++;
        }
    }

    /** Completion
     * Renders a ppm image file which may be animated (multiple images in the file)
     * Asks for the name of the file, then renders the image at position (left, top).
     * Each pixel of the image  is rendered by a square of size pixelSize
     * Renders each image in the file in turn with 200 mSec delay.
     * Repeats the sequence 3 times.
     */
    public void renderAnimatedImage(){
        String fileName = UIFileChooser.open("Choose a file");
        try {  
            int count =0;
            while(count<3){
                Scanner scan = new Scanner(new File(fileName));
                while(scan.hasNext()){
                    double x = left;
                    double y = top;
                    double z = pixelSize;
                    int column = 0;
                    int row = 0;
                    String name = scan.next();
                    int columns=scan.nextInt();
                    int rows=scan.nextInt();
                    int maxc = scan.nextInt();
                    while(row<rows){
                        while(column<columns){
                            int red = scan.nextInt();
                            int green = scan.nextInt();
                            int blue = scan.nextInt();
                            Color color = new Color(red,green,blue);
                            UI.setColor(color);
                            UI.fillRect(x,y,z,z);
                            x=x+z;
                            column++;
                        }
                        y=y+z;
                        x=x-column*z;
                        column=0;
                        row++;
                    }
                    UI.sleep(0.2000);

                }
                count++;
            }
        }
        catch(IOException e) {UI.printf("File Failure %s \n", e);}
    }

    public void renderChallenge(){
        String fileName = UIFileChooser.open("Choose a file");
        try {  
            int count =0;
            while(count<3){
                Scanner scan = new Scanner(new File(fileName));
                while(scan.hasNext()){
                    double x = left;
                    double y = top;
                    double z = pixelSize;
                    int column = 0;
                    int row = 0;
                    String name = scan.next();
                    while(scan.next().equals("#")||scan.next().startsWith("#")){
                        scan.nextLine();
                        Scanner scanline = new Scanner (scan.nextLine());
                        
                    }
                    int columns=scan.nextInt();
                    while(scan.next().equals("#")||scan.next().startsWith("#")){
                        Scanner scanline = new Scanner (scan.nextLine());
                        scanline.nextInt();
                    }
                    int rows=scan.nextInt();
                    while(scan.next().equals("#")||scan.next().startsWith("#")){
                        Scanner scanline = new Scanner (scan.nextLine());
                        scanline.nextInt();
                    }
                    int maxc = scan.nextInt();
                    while(scan.next().equals("#")||scan.next().startsWith("#")){
                        Scanner scanline = new Scanner (scan.nextLine());
                        scanline.nextInt();
                    }
                    while(row<rows){
                        while(column<columns){
                            int red = scan.nextInt();
                            int green = scan.nextInt();
                            int blue = scan.nextInt();
                            Color color = new Color(red,green,blue);
                            UI.setColor(color);
                            UI.fillRect(x,y,z,z);
                            x=x+z;
                            column++;
                        }
                        y=y+z;
                        x=x-column*z;
                        column=0;
                        row++;
                    }
                    UI.sleep(0.2000);

                }
                count++;
            }
        }
        catch(IOException e) {UI.printf("File Failure %s \n", e);}
    }

    /** ---------- The code below is already written for you ---------- **/
    // Constructor
    public ImageRenderer() {
        UI.initialise();
        UI.addButton("Clear", UI::clearGraphics );
        UI.addButton("Render (core)", this::renderImageCore );
        UI.addButton("Render (compl)", this::renderAnimatedImage );
        UI.addButton("Render (challenge)", this::renderChallenge );
        UI.addButton("Quit", UI::quit );
        UI.setWindowSize(850, 700);
        UI.setDivider(0.0);
    }

}
