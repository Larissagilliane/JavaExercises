import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - provides a demonstration of the
 * BouncingBall and Canvas classes. 
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2010.11.30
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private static  int WIDTH = 600;
    private static  int HEIGHT = 500;

    /**
     * Create a BallDemo object.
     * Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", WIDTH, HEIGHT);
        myCanvas.setVisible(true);
    }
 

    /**
     * Draws a frame with a distance of 20 pixels from the border.
     */
    public void drawFrame()
    {
        myCanvas.setForegroundColor(Color.pink);
        
        Rectangle rectangleErase = new Rectangle(20,20, WIDTH - 40, HEIGHT-40 );
        myCanvas.eraseOutline(rectangleErase);
        
        Dimension size = myCanvas.getSize();
        WIDTH = size.width;
        HEIGHT = size.height;
        Rectangle rectangle = new Rectangle(20,20, size.width - 40, size.height-40 );
        myCanvas.draw(rectangle);
    }

    /**
     * Simulate a number of bouncing balls
     * 
     * @param total the total number of bouncing balls
     */
    public void bounce(int total)
    {   
        ArrayList<Color> cores = new ArrayList();
        cores.add(Color.black);
        cores.add(Color.blue);
        cores.add(Color.cyan);
        cores.add(Color.gray);
        cores.add(Color.green);
        cores.add(Color.magenta);
        cores.add(Color.orange);
        cores.add(Color.pink);
        cores.add(Color.red);
        cores.add(Color.yellow);
        
        if(total >0)
        {
            Dimension d = myCanvas.getSize();
            int ground = d.height - 20 - 50;  // position of the ground line
            int xStart = 20+5;    // x-start of the ground line
            int xLimit = d.width -20 -5;   // x-limit of the ground line
            
            Rectangle rectErase = new Rectangle(0, 0, d.width, d.height);
            myCanvas.erase(rectErase);

            myCanvas.setVisible(true);
    
            // draw the ground
            myCanvas.setForegroundColor(Color.pink);
            myCanvas.drawLine(xStart, ground, xLimit, ground);
    
            drawFrame();

            // crate and show the balls
            ArrayList<BouncingBall> list = new ArrayList();
            Random generator = new Random();
            int x,y, c;
            for(int i =0; i< total; i++)
            {
                x = generator.nextInt(d.width);
                y = generator.nextInt(d.height/2);
                c = generator.nextInt(10);
                list.add(new BouncingBall(x, y, 16, cores.get(c), ground, myCanvas));
            }

            for(BouncingBall ball : list)
            {
                ball.draw();
            }
            
            // Make them bounce until both have gone beyond the xLimit.
            boolean finished =  false;
            int aux=0;
            while(!finished) 
            {
                myCanvas.wait(50);           // small delay
                for(BouncingBall ball: list)
                {
                    ball.move();
                    if(ball.getXPosition() >= xLimit)
                    {
                        aux++;
                    }
                }
                
                // stop once ball has travelled a certain distance on x axis
                if(aux==total) 
                {
                    finished = true;
                }else
                {
                    aux=0;
                }
            }
            for(BouncingBall ball : list)
            {
                ball.erase();
            }
        }else{
            System.out.println("A quantidade de bolas deverá ser maior que 0");
        }
    }    
}
