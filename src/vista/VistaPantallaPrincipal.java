
package vista;

import interfaces.Colores;
import interfaces.Fuentes;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaPantallaPrincipal extends JFrame implements Colores,Fuentes{
    public JPanel PanelArriba = new JPanel();
    JPanel PanelAbajo = new JPanel();
    JPanel PanelCentro = new JPanel();
    
    //convertir imagenes a objetos
    ImageIcon ImUsuario = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
    ImageIcon ImCarrito = new ImageIcon(getClass().getResource("/imagenes/proveedor.png"));
    ImageIcon ImMinimizar = new ImageIcon(getClass().getResource("/imagenes/minimizar.png"));
    ImageIcon ImExit = new ImageIcon(getClass().getResource("/imagenes/exit3.png"));
    ImageIcon ImFondo = new ImageIcon(getClass().getResource("/imagenes/fondo.jpeg"));
    ImageIcon ImClientes = new ImageIcon(getClass().getResource("/imagenes/clientes2.png"));
    ImageIcon ImArticulos = new ImageIcon(getClass().getResource("/imagenes/carrito2.png"));
    ImageIcon ImEmpleados = new ImageIcon(getClass().getResource("/imagenes/empleado2.png"));
    PanelImagen Panel = new PanelImagen(ImFondo);
    
    //asiganar imagenes al JLabel
    public JLabel LblUsuario = new JLabel(ImUsuario);
    public JLabel LblExit = new JLabel(ImExit);
    public JLabel LblCarrito = new JLabel(ImCarrito);
    public JLabel LblMinimizar = new JLabel(ImMinimizar);
    public JLabel LblClientes = new JLabel(ImClientes);
    public JLabel LblArticulos = new JLabel(ImArticulos);
    public JLabel LblEmpleados = new JLabel(ImEmpleados);
    
    public VistaPantallaPrincipal(){
        config();
        paneles();
        
    }

    private void config() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //TAMAÑO DE LA PANTALLA ACTUAL
        Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width,screenSize.height);
        
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);
    }

    private void paneles() {
        PanelArriba.setBackground(PANEL_ARRIBA);
        PanelAbajo.setBackground(PANEL_ABAJO);
        PanelCentro.setBackground(PANEL_CENTRO);
        
        
        //agregar componentes a panel arriba
        PanelArriba.setLayout(new GridLayout(1,6));
        PanelArriba.add(LblUsuario);
        PanelArriba.add(LblCarrito);
        PanelArriba.add(LblArticulos);
        PanelArriba.add(LblClientes);
        PanelArriba.add(LblEmpleados);
        PanelArriba.add(LblMinimizar);
        PanelArriba.add(LblExit);
        
        
        this.add(PanelArriba,BorderLayout.NORTH);
        this.add(PanelAbajo,BorderLayout.SOUTH);
        this.add(PanelCentro,BorderLayout.CENTER);
        this.add(Panel);
    }

   

    
}
