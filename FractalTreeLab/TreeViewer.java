import javax.swing.JFrame;

public class TreeViewer extends JFrame
{
    private final int HEIGHT = 600;
    private final int WIDTH = 800;
    
    public TreeViewer()
    {
        super("Fractal Tree");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        JFrame frame = new TreeViewer();
    }
}