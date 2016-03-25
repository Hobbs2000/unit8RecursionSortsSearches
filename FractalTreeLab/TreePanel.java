import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

public class TreePanel extends JPanel
{
    private final int WIDTH = 1200;
    private final int HEIGHT = 1000;
    
    private int order = 1;
    private int topX, topY;
    private int botX, botY;
    private int angle = 0;
    private int angleShift = 0;
    private double multiplier = 0.7;
    private double length = 20;
    
    private Random numGen;
    public TreePanel(int startOrder, int x1, int y1, int x2, int y2)
    {
        botX = x1;
        botY = y1;
        
        topX = x2;
        topY = y2;
        
        order = startOrder;
        
        numGen = new Random();
        
        //this.setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    
    public void setOrder(int newOrder)
    {
        order = newOrder;
    }
    
    
    public void setAngle(int newAngle)
    {
        angle = newAngle;
    }
    
    public void setAngleShift(int shift)
    {
        angleShift = shift;
    }
    
    public void setLength(int newLength)
    {
        length = newLength ;
    }
    
    
    public void paintComponent(Graphics g)
    {
        
        g.setColor(Color.RED);
        
        draw(g, order, topX, topY, 0, angle, angleShift, length, multiplier);
    }
   
    
    public void draw(Graphics g, int order, int x1, int y1, double angle, double angleChange, double angleShift, double length, double multiplier) 
    {
        int x2, y2, x3, y3; 

        double newAngle = Math.toRadians(angle); //Get degrees in radians
        
        //Get a random color value
        int r_val = numGen.nextInt(254);
        int g_val = numGen.nextInt(254);
        int b_val = numGen.nextInt(254);
        g.setColor(new Color(r_val, g_val, b_val));

        if ((order == 1)) //|| (x1 > WIDTH) || (x1 < 0) || (y1 > HEIGHT) || (y1 < 0))
        {
            return;
        }
        else
        {  
            //Calculate coordinates for new line
            x2 = (x1 - (int)Math.round(Math.sin(newAngle) *  length));
            y2 = (y1 - (int)Math.round(Math.cos(newAngle) * length));
            
            g.drawLine(x1, y1, x2, y2);
            
            //Start 2 more branches
            draw(g, order-1, x2, y2, (angle + angleChange + angleShift), angleChange, angleShift, length*multiplier, multiplier);
            draw(g, order-1, x2, y2, (angle + angleChange - angleShift), angleChange, angleShift, length*multiplier, multiplier);
            
        }
    }
}