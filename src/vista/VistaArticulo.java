/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author jony_jejejee
 * */


import interfaces.Colores;
import interfaces.Fuentes;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class VistaArticulo extends JDialog implements Colores,Fuentes{
    
    ImageIcon Search = new 
    ImageIcon(getClass().getResource("/imagenes/busqueda.png"));
    
    //Etiquetas
    public JLabel LblTitulo = new JLabel("ABC de Articulo");
    public JLabel LblCodigo = new JLabel("Codigo: ");
    public JLabel LblDescripcion  = new JLabel("Descripcion: ");
    public JLabel LblMarca = new JLabel("Marca ");
    public JLabel LblColor = new JLabel("Color: ");
    public JLabel LblPrecioPublico = new JLabel("Precio Publico: ");
    public JLabel LblPrecioProveedor = new JLabel("Precio Proveedor: ");
    public JLabel LblStock = new JLabel("Stock: ");
    public JLabel LblSearch = new JLabel(Search);  
    
    //Botones
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");
    //TextFields
    public JTextField TxtCodigo = new JTextField(10);
    public JTextField TxtDescripcion = new JTextField(70);
    public JTextField TxtMarca = new JTextField(80);
    public JTextField TxtColor = new JTextField(50);
    public JTextField TxtPrecioPublico = new JTextField(10);
    public JTextField TxtPrecioProveedor = new JTextField(80);
    public JTextField TxtStock = new JTextField(25);
    
    public VistaArticulo(Frame owner, boolean modal) {
        super(owner, modal);
        config();
        etiquetas();
        textFields();
        botones();
    }

    private void config() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//Cerrar solo la ventana
        this.setSize(800,600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("ABC de Articulo");
        this.getContentPane().setBackground(new Color(46,144,232));
    }

    private void textFields() {
        this.add(TxtCodigo);
        TxtCodigo.setBounds(350,100,250,25);
        this.add(TxtDescripcion);
        TxtDescripcion.setBounds(350,150,250,25);
        this.add(TxtMarca);
        TxtMarca.setBounds(350,200,250,25);
        this.add(TxtColor);
        TxtColor.setBounds(350,250,250,25);
         this.add(TxtPrecioPublico);
        TxtPrecioPublico.setBounds(350,300,250,25);
        this.add(TxtPrecioProveedor);
        TxtPrecioProveedor.setBounds(350,350,250,25);
        this.add(TxtStock);
        TxtStock.setBounds(350,400,250,25);
       
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

    private void etiquetas() {
        LblTitulo.setFont(FUENTE_TITULOS);
        LblCodigo.setFont(FUENTE_LABELS);
        LblDescripcion.setFont(FUENTE_LABELS);
        LblPrecioProveedor.setFont(FUENTE_LABELS);
        LblPrecioPublico.setFont(FUENTE_LABELS);
        LblMarca.setFont(FUENTE_LABELS);
        LblStock.setFont(FUENTE_LABELS);
        LblColor.setFont(FUENTE_LABELS);
        
        LblTitulo.setBounds(280, 15, 500, 40);
        this.add(LblTitulo);
         LblCodigo.setBounds(250, 100, 80, 20);
        this.add(LblCodigo);
         LblDescripcion.setBounds(250, 150, 80, 20);
        this.add(LblDescripcion);
         LblMarca.setBounds(250, 200, 80, 20);
        this.add(LblMarca);
         LblColor.setBounds(250, 250, 80, 20);
        this.add(LblColor);
        LblPrecioProveedor.setBounds(250, 300, 80, 20);
        this.add(LblPrecioProveedor);
         LblPrecioPublico.setBounds(250, 350, 80, 20);
        this.add(LblPrecioPublico);
         LblStock.setBounds(250, 400, 80, 20);
        this.add(LblStock);
        LblSearch.setBounds(180,100,80,30);
        this.add(LblSearch);
    }
    
}
