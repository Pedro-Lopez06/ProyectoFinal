/*
 * Vista para proveedor
 */
package vista;

import interfaces.Colores;
import interfaces.Fuentes;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;



/**
 *
 * @author Pedro Lopez
 */
public class VistaProveedor extends JDialog implements Colores,Fuentes{
    ImageIcon Search = new ImageIcon(getClass().getResource("/imagenes/busqueda.png"));
    //Etiquetas
    JLabel LblTitulo = new JLabel("ABC De Proveedor");
    JLabel LblCodigo = new JLabel("Código: ");
    JLabel LblNombre = new JLabel("Nombre: ");
    JLabel LblEmpresa = new JLabel("Empresa: ");
    JLabel LblTelefono = new JLabel("Télefono: ");
    JLabel LblCorreo = new JLabel("Correo: ");
    JLabel LblDireccion = new JLabel("Dirección: ");
    JLabel LblRFC = new JLabel("RFC: ");
    JLabel LblCel = new JLabel("Cel: ");
    public JLabel LblSearch = new JLabel(Search);
    
   
    //TextFields
    public TextField TxtCodigo = new TextField(10);
    public TextField TxtNombre = new TextField(50);
    public TextField TxtEmpresa = new TextField(30);
    public TextField TxtTelefono = new TextField(20);
    public TextField TxtCorreo = new TextField(50);
    public TextField TxtDireccion = new TextField(30);
    public TextField TxtRFC = new TextField(10);
    public TextField TxtCel = new TextField(20);
    
    //Botones
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");
    public VistaProveedor(Frame owner, boolean modal) {
        super(owner, modal);
        config();
        etiquetas();
        textFields();
        botones();
    }

    private void config() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800,600);//tamaño de ventana
        this.setLayout(null);//diseño libre
        this.setLocationRelativeTo(null);//centro
        this.setTitle("ABC de Proveedores");
        this.getContentPane().setBackground(new Color(46,144,232));
        
    }

    private void botones() {
        this.add(BtnSalir);
        BtnSalir.setBounds(580,500,100,40);
        this.add(BtnActualizar);
        BtnActualizar.setBounds(470,500,100,40);
        this.add(BtnEliminar);
        BtnEliminar.setBounds(360,500,100,40);
        this.add(BtnBuscar);
        BtnBuscar.setBounds(250,500,100,40);
        this.add(BtnGuardar);
        BtnGuardar.setBounds(140,500,100,40);
    }

    private void textFields() {
        this.add(TxtCodigo);
        TxtCodigo.setBounds(350,100,250,25);
        this.add(TxtNombre);
        TxtNombre.setBounds(350,150,250,25);
        this.add(TxtEmpresa);
        TxtEmpresa.setBounds(350,200,250,25);
        this.add(TxtTelefono);
        TxtTelefono.setBounds(350,250,250,25);
        this.add(TxtCorreo);
        TxtCorreo.setBounds(350,300,250,25);
        this.add(TxtDireccion);
        TxtDireccion.setBounds(350,350,250,25);
        this.add(TxtRFC);
        TxtRFC.setBounds(350,400,250,25);
        this.add(TxtCel);
        TxtCel.setBounds(350,450,250,25);
    }

    private void etiquetas() {
      LblTitulo.setFont(FUENTE_TITULOS);
      LblCodigo.setFont(FUENTE_LABELS);
      LblNombre.setFont(FUENTE_LABELS);
      LblEmpresa.setFont(FUENTE_LABELS);
      LblTelefono.setFont(FUENTE_LABELS);
      LblCorreo.setFont(FUENTE_LABELS);
      LblDireccion.setFont(FUENTE_LABELS);
      LblRFC.setFont(FUENTE_LABELS);
      LblCel.setFont(FUENTE_LABELS);
      
      LblTitulo.setBounds(280,15,500,40);
      this.add(LblTitulo);
      LblCodigo.setBounds(250,100,80,20);
      this.add(LblCodigo);
      LblNombre.setBounds(250,150,80,20);
      this.add(LblNombre);
      LblEmpresa.setBounds(250,200,80,20);
      this.add(LblEmpresa);
      LblTelefono.setBounds(250,250,80,20);
      this.add(LblTelefono);
      LblCorreo.setBounds(250,300,80,20);
      this.add(LblCorreo);
      LblDireccion.setBounds(250,350,80,20);
      this.add(LblDireccion);
      LblRFC.setBounds(250,400,80,20);
      this.add(LblRFC);
      LblCel.setBounds(250,450,80,20);
      this.add(LblCel);
      this.add(LblSearch);
      LblSearch.setBounds(180,100,80,30);
     
    }
    
}
