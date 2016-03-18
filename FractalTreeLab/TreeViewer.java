import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
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
    private JScrollBar length;
    private JScrollBar editAngle;
    private JScrollBar shiftAngle;
    private JTextField editLength;
    
    private JButton stopper;
    private boolean looping = true;
    
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
        editAngle.setUnitIncrement(1);
        editAngle.addAdjustmentListener(new ScrollListener());
        holder.add(editAngle);
        
        shiftAngle = new JScrollBar();
        shiftAngle.setMinimum(0);
        shiftAngle.setMaximum(360);
        shiftAngle.setUnitIncrement(1);
        shiftAngle.addAdjustmentListener(new ScrollListener());
        holder.add(shiftAngle);
        
        length = new JScrollBar();
        length.setMinimum(0);
        length.setMaximum(1000);
        length.setUnitIncrement(1);
        length.addAdjustmentListener(new ScrollListener());
        holder.add(length);
        
        
        editLength = new JTextField();
        holder.add(editLength);
        
        stopper = new JButton("Stop");
        stopper.addActionListener(new ClickListener());
        holder.add(stopper);
        
        
        
        drawer = new TreePanel(order, 700, 1000, 700, 700);
        holder.add(drawer);
        
        this.add(holder);
        
        this.setVisible(true);
        
        loop();
    }
    
    public void loop()
    {
        int scroll_1 = 0;
        int scroll_2 = 0;
        while (looping == true)
        {
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
            if (scroll_1 >= 360)
            {
                scroll_1 = 0;
            }
            else
            {
                scroll_1+=2;
                editAngle.setValue(scroll_1);
                drawer.setAngle(scroll_1);
            }
            
            if (scroll_2 >= 360)
            {
                scroll_2 = 0;
            }
            else
            {
                scroll_2++;
                shiftAngle.setValue(scroll_2);
                drawer.setAngleShift(scroll_2);
            }
            
            repaint();
        }
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
            else if (event.getSource() == decrease)
            {
                order--;
                drawer.setOrder(order);
                repaint();
            }
            else if (event.getSource() == stopper)
            {
                looping = false;
            }
        }
    }
    
    public class ScrollListener implements AdjustmentListener
    {
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
            if (e.getSource() == editAngle)
            {
                int newAngle = e.getValue();
                drawer.setAngle(newAngle);
                repaint();
            }
            else if (e.getSource() == shiftAngle)
            {
                int shiftAngle = e.getValue();
                drawer.setAngleShift(shiftAngle);
                repaint();
            }
            else
            {
                int newLength = e.getValue();
                drawer.setLength(newLength);
                repaint();
            }
        }
    }
    
    }
