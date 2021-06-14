
package vista;

import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class VistaBusquedaPorDescripcion extends JDialog{
    JLabel LblNombre = new JLabel("Proovedor a Buscar");
    public JTextField TxtNombre = new JTextField();
    public JButton BtnAceptar = new JButton("Aceptar");
    
    //tabla donde se visualizaran todos los proveedores existentes
    public JTable Tabla = new JTable();
    //para que aparezca la barra de desplazamiento vertical
    JScrollPane ScrollTable = new JScrollPane(Tabla);
    
    public VistaBusquedaPorDescripcion(Frame owner, boolean modal){
    super(owner, modal);
    configuracionInicial();
    agregarComponentes();
}

    private void configuracionInicial() {
        this.setSize(430, 320);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }

    private void agregarComponentes() {
        //caracteristicas
        LblNombre.setBounds(10, 15, 100, 40);
        TxtNombre.setBounds(130,15,200,40);
        ScrollTable.setBounds(20,70,378,130);
        BtnAceptar.setBounds(150,230,120,40);
        
        //agregar al frame
        this.add(LblNombre);
        this.add(TxtNombre);
        this.add(ScrollTable);
        this.add(BtnAceptar);
    }
}
