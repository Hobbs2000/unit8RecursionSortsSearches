import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.Color;

public class TreeViewer extends JFrame
{
    private final int HEIGHT = 1080;
    private final int WIDTH = 1900;
    
    private int order = 1;
    
    private TreePanel drawer;
    private JPanel holder;
    private JButton increase;
    private JButton decrease;
    private JScrollBar editAngle;
    
    public TreeViewer()
    {
        super("Fractal Tree");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        holder = new JPanel();
        
        increase = new JButton("Increase");
        increase.addActionListener(new ClickListener());
        holder.add(increase);
        
        decrease = new JButton("Decrease");
        decrease.addActionListener(new ClickListener());
        holder.add(decrease);
        
        editAngle = new JScrollBar();
        editAngle.setMinimum(0);
        editAngle.setMaximum(360);
        editAngle.setUnitIncrement(10);
        editAngle.addAdjustmentListener(new ScrollListener());
        holder.add(editAngle);
        
        
        drawer = new TreePanel(order, 700, 1000, 700, 1000);
        holder.add(drawer);
        
        this.add(holder);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        JFrame frame = new TreeViewer();
        frame.setBackground(Color.WHITE);
        frame.repaint();
    }
    
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == increase)
            {
                order++;
                drawer.setOrder(order);
                repaint();
            }
            else
            {
                order--;
                drawer.setOrder(order);
                repaint();
            }
        }
    }
    
    public class ScrollListener implements AdjustmentListener
    {
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
            int newAngle = e.getValue();
            System.out.println("New Angle:"+newAngle);
            drawer.setAngle(newAngle);
            repaint();
        }
    }
    
    
}