
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import modelo.ModeloUsuario;
import vista.VistaLogin;
import vista.VistaSplash;

/**
 *
 * @author 52375
 */
public class ControladorVistaSplash implements MouseListener, MouseMotionListener {
   private VistaSplash VistaSplash;
   int x,y;//capturar coordenadas

    public ControladorVistaSplash(VistaSplash VistaSplash) { //vista original
        this.VistaSplash = VistaSplash;
        oyentes();
        VistaSplash.setVisible(true);
        matarSplash(5);     
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==VistaSplash.LblSplash) {
            x = e.getX();
            y = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==VistaSplash.LblSplash) {
            VistaSplash.LblSplash.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    private void oyentes() {
        //oyentes MouseListener
        VistaSplash.LblSplash.addMouseListener(this);
        //oyentes MouseMotionListener
        VistaSplash.LblSplash.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource()==VistaSplash.LblSplash) {
            VistaSplash.setLocation(VistaSplash.getLocation().x + e.getX() - x,
                                    VistaSplash.getLocation().y + e.getY() - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    private void matarSplash(int i) {
        try {
            Thread.sleep(i*900);
            VistaSplash.dispose();//Mata al JFrame
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        } finally{
            ModeloUsuario ModeloUsuario = new ModeloUsuario();
            VistaLogin vistaLogin = new VistaLogin();
            ControladorVistaLogin ControladorVistaLogin = new ControladorVistaLogin(vistaLogin, ModeloUsuario );
            
        }
    }

    
    }