/**
 * Author: M. Allen
 *
 * A simple JFrame-using class to create a window to display Triangle objects
 */
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Color;

@SuppressWarnings( "serial" )
public class Window extends JFrame
{
    /**
     * post: JFrame created with ( getTitle() == "Window" ) && ( getX() == 50 )
     * && ( getY() == 50 ) && ( getWidth() == 200 ) && ( getHeight() == 100 ) &&
     * ( getLayout() == null ) && ( getBackground() == Color.white ) &&
     * isVisible() && !isResizable()
     */
    public Window()
    {
        super( "Window" );
        setLocation( 50, 50 );
        setSize( 200, 100 );
        setLayout( null );
        getContentPane().setBackground( Color.white );
        setResizable( false );
        setVisible( true );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    /**
     * post: width and height set with window insets (like title bar)
     *       taken into account, so visible array of size ( w x h )
     */
    @Override
    public void setSize( int w, int h )
    {
        super.setSize( w + getInsets().left + getInsets().right,
                      h + getInsets().top + getInsets().bottom );
    }
    
    /**
     * post: width and height set with window insets (like title bar)
     *       taken into account, so visible array of size ( w x h )
     */
    @Override
    public void setBounds( int x, int y, int w, int h )
    {
        w = w + getInsets().left + getInsets().right;
        h = h + getInsets().top + getInsets().bottom;
        super.setBounds( x, y, w, h );
    }
    
    /**
     * @return getHeight() of display area
     */
    @Override
    public int getHeight()
    {
        return super.getHeight() - getInsets().bottom - getInsets().top;
    }
    
    /**
     * @return getWidth() of display area
     */
    @Override
    public int getWidth()
    {
        return super.getWidth() - getInsets().left - getInsets().right;
    }
    
    /**
     * post: window.getContentPane().getBackground() == col
     */
    @Override
    public void setBackground( Color col )
    {
        getContentPane().setBackground( col );
        repaint();
    }
    
    /**
     * @return : Color of contentPane()
     */
    @Override
    public Color getBackground()
    {
        return getContentPane().getBackground();
    }
    
    /**
     * post: adds input graphical JComponent,
     * like a Triangle or Oval
     */
    public void add( JComponent component )
    {
        super.add( component, 0 );
        component.repaint();
    }
}
