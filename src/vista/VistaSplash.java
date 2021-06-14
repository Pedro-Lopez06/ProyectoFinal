/*
 *Imagen de bienvenida
 */
package vista;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author 52375
 */
public class VistaSplash extends JFrame{
    //convertir la imagen a objeto
    ImageIcon ImSplash = new ImageIcon(getClass().getResource("/imagenes/logo1.png"));
    public JLabel LblSplash = new JLabel(ImSplash);//agrega imagen en la etiqueta

    public VistaSplash() {
        configuracion();
        agregarSplash();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ImSplash.getIconWidth(), ImSplash.getIconHeight());
        this.setLocationRelativeTo(null);
        //Quitar decorado(borde, barra de titulo, maximizar, minimizar)
        this.setUndecorated(true);
        //quitar fondo del JFram
        AWTUtilities.setWindowOpaque(this, false);
        this.setAlwaysOnTop(true);
        
    }

    private void agregarSplash() {
        this.add(LblSplash);
    }
    
}
