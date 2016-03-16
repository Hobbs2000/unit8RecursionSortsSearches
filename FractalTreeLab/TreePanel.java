import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class TreePanel extends JPanel
{
    private final int WIDTH = 1200;
    private final int HEIGHT = 1000;
    
    private int order = 1;
    private int topX, topY;
    private int botX, botY;
    private int angle = 0;
    
    public TreePanel(int startOrder, int x1, int y1, int x2, int y2)
    {
        botX = x1;
        botY = y1;
        
        topX = x2;
        topY = y2;
        
        order = startOrder;
        
        this.setBackground(Color.BLACK);
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
    
    
    public void paintComponent(Graphics g)
    {
        
        g.setColor(Color.RED);
        
        draw(g, order, topX, topY, 0, angle, 100, 0.618);
    }
   
    
    public void draw(Graphics g, int order, int x1, int y1, double angle, double angleChange, double length, double multiplier) 
    {
        int x2, y2, x3, y3; 

        double newAngle = Math.toRadians(angle); //Get degrees in radians
        
        if (order == 1)
        {
            return;
        }
        else
        {
           
            

            x2 = (x1 - (int)Math.round(Math.sin(newAngle) * multiplier * length));
            System.out.println("x:"+x2);

            y2 = (y1 - (int)Math.round(Math.cos(newAngle) * multiplier * length));
            System.out.println("y:"+y2);
            
            g.drawLine(x1, y1, x2, y2);
            
            draw(g, order-1, x2, y2, angle + angleChange, angleChange, length, multiplier);
            draw(g, order-1, x2, y2, angle - angleChange, angleChange, length, multiplier);
        }
    }
}