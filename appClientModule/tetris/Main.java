
package tetris ; 

import java.util.Random ; 

public class Main { 
    // for keycode ... A - 65   D-68    S-83
    private final static int KEYCODE_A = 65 ; 
    private final static int KEYCODE_D = 68 ; 
    private final static int KEYCODE_S = 83 ;
    
    public static void main(String[] args) {
        // x and y coordinates have been initialized.
        StdDraw.setXscale(0.0, 100.0);               // for x 
        StdDraw.setYscale(0.0, 100.0);               // for y 
        
        // PenColor has been initialized.
        StdDraw.setPenColor(StdDraw.BLACK);         // color of pen is black.
        
        // DoubleBuffering for more clean display.
        StdDraw.enableDoubleBuffering();            // for more clean displaying we apply double buffereing.
        /*
            When enableDoubleBuffering() you have to call StdDraw.show() method to 
        flush buffer to screen (output device.)
            If you don't enable double buffering , it's no necessary to do this.
        */
        
        // radius for shapes.
        double radius = .05 ;                       // the thing we create feature , we define radius of this things.
        
        // coordinate x and coordinate y for where thing will be created in screen.
        double c_x = 50.0 ;                           // in coordinate 0 things will be created.
        double c_y = 100.0 - radius ;                 // in coordinate (1.0-.05) things will be created.
        
        
        
        
        
        while(true){ 
            
            while(c_y > (-1.0 + radius)){
                
                // in order to use this instruction is create square.
                StdDraw.filledSquare(c_x, c_y, radius);
                
                // we describe it in above section, because of using this instructions 
                // we use doublebuffering.
                StdDraw.show();
                
                if(StdDraw.isKeyPressed(KEYCODE_A) && (c_x > (-1.0 + radius))){
                    c_x -= .002 ; 
                }
                if(StdDraw.isKeyPressed(KEYCODE_D) && (c_x < (1.0 - radius))){
                    c_x += .002 ; 
                }
                if(StdDraw.isKeyPressed(KEYCODE_S) && c_y > (-1.0 + radius)){
                    c_y -=.004 ; 
                }
                else{
                   c_y -= .002 ; 
                }
                
               
                // we clear screen because we wanna sharp appear.
                StdDraw.clear();
            }
            
            // we restart the position of shape
            c_x = .0 ; 
            c_y = 1.0 - radius ; 
            setRandomPenColor();
        }
        
    }
    private static void setRandomPenColor(){
        // Random number for which color will be used for pen color.
        Random random = new Random();
        int randomNumber = random.nextInt(5) ; 
        switch(randomNumber){
            case 0 :
                StdDraw.setPenColor(StdDraw.BLACK);
                break ; 
            case 1 : 
                StdDraw.setPenColor(StdDraw.BLUE);
                break ;
            case 2 : 
                StdDraw.setPenColor(StdDraw.CYAN);
                break ; 
            case 3 : 
                StdDraw.setPenColor(StdDraw.ORANGE);
                break ; 
            case 4 : 
                StdDraw.setPenColor(StdDraw.YELLOW);
                break ; 
            default : 
                break ; 
             
        }
        
    }
} 

