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
    
    public TreePanel(int startOrder)
    {
        order = startOrder;
        this.setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public void paintComponent(Graphics g)
    {
    }
    
    public void draw(Graphics g, int order, int topX, int topY, int botX, int botY)
    {
    }
}