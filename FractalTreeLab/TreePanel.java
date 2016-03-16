import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class TreePanel extends JPanel
{
    private final int WIDTH = 550;
    private final int HEIGHT = 550;
    
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
    
    public void paintComponent(Graphics g)
    {
        
        g.setColor(Color.RED);
        
        draw(g, order, topX, topY,90,10);
    }
    
    //public void draw(Graphics g, int order, int topX, int topY, int botX, int botY, double angle)
    public void draw(Graphics g, int order, int x1, int y1, double angle, int adder) 
    {
        int deltaX, deltaY, x2, y2, x3, y3; 
        double length;
        //double degrees = angle + 10;
        double newAngle = Math.toRadians(angle); //Get 30 degrees in radians
        
        if (order == 1)
        {
            return;
        }
        else
        {
            
            length = 10;
            
            //x2 = (int)Math.abs(Math.round(Math.sin(newAngle) * length) - topX);
            x2 = (x1 - (int)Math.round(Math.cos(newAngle) * order * 5));
            //y2 = (int)Math.abs(Math.round(Math.cos(newAngle) * length) - topY);
            y2 = (y1 - (int)Math.round(Math.sin(newAngle) * order * 5));
            
            g.drawLine(x1, y1, x2, y2);
            
            if ((x2 % 7) == 0)
            {
                g.setColor(Color.GREEN);
            }
            else
            {
                g.setColor(Color.BLACK);
            }
            draw(g, order-1, x2, y2, angle-adder, adder+2);
            draw(g, order-1, x2, y2, angle+adder, adder+2);
        }
    }
}