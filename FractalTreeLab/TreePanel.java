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
    
    public void paintComponent(Graphics g)
    {
        
        g.setColor(Color.RED);
        
        draw(g, order, topX, topY,90,20, 200.00);
    }
    
    //public void draw(Graphics g, int order, int topX, int topY, int botX, int botY, double angle)
    public void draw(Graphics g, int order, int x1, int y1, double angle, int adder, double length) 
    {
        int deltaX, deltaY, x2, y2, x3, y3; 
        //double degrees = angle + 10;
        double newAngle = Math.toRadians(angle); //Get 30 degrees in radians
        
        if (order == 1)
        {
            return;
        }
        else
        {
           
            
            //x2 = (int)Math.abs(Math.round(Math.sin(newAngle) * length) - topX);
            x2 = (x1 - (int)Math.round(Math.cos(newAngle) * order * 10));
            System.out.println("x:"+x2);
            //y2 = (int)Math.abs(Math.round(Math.cos(newAngle) * length) - topY);
            y2 = (y1 - (int)Math.round(Math.sin(newAngle) * order * 10));
            System.out.println("y:"+y2);
            
            g.drawLine(x1, y1, x2, y2);
            
            draw(g, order-1, x2, y2, angle+30, adder+2, length+20);
            draw(g, order-1, x2, y2, angle-30, adder+2, length+20);
        }
    }
}