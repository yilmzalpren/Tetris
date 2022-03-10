
package tetris ; 

import java.util.Random ; 

public class Main { 
    // for keycode ... A - 65   D-68    S-83
    private final static int KEYCODE_A = 65 ; 
    private final static int KEYCODE_D = 68 ; 
    private final static int KEYCODE_S = 83 ;
    private final static int radiusOfShapes = 5 ;
    private final static double horizontolVelocity = .2 ; 
    private final static double verticalVelocity = .2  ;
    //---------------------------------------
    
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
                               // the thing we create feature , we define radius of this things.
        
        // coordinate x and coordinate y for where thing will be created in screen.
        double c_x = 50.0 ;                           // in coordinate 0 things will be created.
        double c_y = 100.0 - radiusOfShapes ;                 // in coordinate (1.0-.05) things will be created.
        
        
        
        
        
       
        while(true){ 
            
            while(c_y > (0.0 + radiusOfShapes)){
                
                // in order to use this instruction is create square.
                StdDraw.filledSquare(c_x, c_y, radiusOfShapes);
                
                // we describe it in above section, because of using this instructions 
                // we use doublebuffering.
                setScreenGrid();
                StdDraw.show();
                
                if(StdDraw.isKeyPressed(KEYCODE_A) && (c_x > (0.0 + radiusOfShapes))){
                    c_x -= horizontolVelocity ; 
                }
                if(StdDraw.isKeyPressed(KEYCODE_D) && (c_x < (100.0 - radiusOfShapes))){
                    c_x += horizontolVelocity ; 
                }
                if(StdDraw.isKeyPressed(KEYCODE_S) && c_y > (0.0 + radiusOfShapes)){
                    c_y -=2*verticalVelocity ; 
                }
                else {
                   c_y -= verticalVelocity ; 
                }
                
               
                // we clear screen because we wanna sharp appear.
                StdDraw.clear();
            }
            
            // we restart the position of shape
            c_x = 50.0 ; 
            c_y = 100.0 - radiusOfShapes ; 
           
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
    private static void setScreenGrid() {
    	StdDraw.setPenColor(StdDraw.BLACK);
    	for(int i= 0 ; i<10 ; ++i) {
    		for(int j= 0 ; j<10 ; ++j) {
    			StdDraw.square(5+10*j,5+10*i,radiusOfShapes);
    		}
    	}
    }
} 

