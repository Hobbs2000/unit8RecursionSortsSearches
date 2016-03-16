import javax.swing.JFrame;

public class TreeViewer extends JFrame
{
    private final int HEIGHT = 1080;
    private final int WIDTH = 1900;
    
    private TreePanel drawer;
    
    public TreeViewer()
    {
        super("Fractal Tree");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        drawer = new TreePanel(20, 700, 900, 700, 900);
        this.add(drawer);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        JFrame frame = new TreeViewer();
        frame.repaint();
    }
}