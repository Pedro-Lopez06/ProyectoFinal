/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import interfaces.Colores;
import interfaces.Fuentes;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Emmanuel Ruiz
 */
public class VistaCliente extends JDialog implements Colores,Fuentes{
    
    ImageIcon Search = new 
    ImageIcon(getClass().getResource("/imagenes/busqueda.png"));

    //Etiquetas
    public JLabel LblTitulo = new JLabel("ABC de Cliente");
    public JLabel LblCodigo = new JLabel("Codigo: ");
    public JLabel LblNombre  = new JLabel("Nombre: ");
    public JLabel LblDireccion = new JLabel("Dirección; ");
    public JLabel LblCiudad = new JLabel("Ciudad: ");
    public JLabel LblEdad = new JLabel("Edad: ");
    public JLabel LblCorreo = new JLabel("Correo: ");
    public JLabel LblFechaIngreso = new JLabel("FechaIngreso: ");
    public JLabel LblTelefono = new JLabel("Telefono: "); 
    public JLabel LblSearch = new JLabel(Search);   
    //Botones
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");
    //TextFields
    public JTextField TxtCodigo = new JTextField(10);
    public JTextField TxtNombre = new JTextField(40);
    public JTextField TxtDireccion = new JTextField(80);
    public JTextField TxtCiudad = new JTextField(50);
    public JTextField TxtEdad = new JTextField(10);
    public JTextField TxtCorreo = new JTextField(80);
    public JTextField TxtFechaIngreso = new JTextField(25);
    public JTextField TxtTelefono = new JTextField(30);
    
    public VistaCliente(Frame owner, boolean modal) {
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
        this.setTitle("ABC de Cliente");
    }

    private void textFields() {
        this.add(TxtCodigo);
        TxtCodigo.setBounds(350,100,250,25);
        this.add(TxtNombre);
        TxtNombre.setBounds(350,150,250,25);
        this.add(TxtDireccion);
        TxtDireccion.setBounds(350,200,250,25);
        this.add(TxtCiudad);
        TxtCiudad.setBounds(350,250,250,25);
         this.add(TxtEdad);
        TxtEdad.setBounds(350,300,250,25);
        this.add(TxtCorreo);
        TxtCorreo.setBounds(350,350,250,25);
        this.add(TxtFechaIngreso);
        TxtFechaIngreso.setBounds(350,400,250,25);
        this.add(TxtTelefono);
        TxtTelefono.setBounds(350,450,250,25);
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
        LblNombre.setFont(FUENTE_LABELS);
        LblDireccion.setFont(FUENTE_LABELS);
        LblCiudad.setFont(FUENTE_LABELS);
        LblEdad.setFont(FUENTE_LABELS);
        LblCorreo.setFont(FUENTE_LABELS);
        LblFechaIngreso.setFont(FUENTE_LABELS);
        LblTelefono.setFont(FUENTE_LABELS);
        
        LblTitulo.setBounds(280, 15, 500, 40);
        this.add(LblTitulo);
         LblCodigo.setBounds(250, 100, 80, 20);
        this.add(LblCodigo);
         LblNombre.setBounds(250, 150, 80, 20);
        this.add(LblNombre);
         LblDireccion.setBounds(250, 200, 80, 20);
        this.add(LblDireccion);
         LblCiudad.setBounds(250, 250, 80, 20);
        this.add(LblCiudad);
        LblEdad.setBounds(250, 300, 80, 20);
        this.add(LblEdad);
         LblCorreo.setBounds(250, 350, 80, 20);
        this.add(LblCorreo);
         LblFechaIngreso.setBounds(250, 400, 80, 20);
        this.add(LblFechaIngreso);
         LblTelefono.setBounds(250, 450, 80, 20);
        this.add(LblTelefono);
        LblSearch.setBounds(180,100,80,30);
        this.add(LblSearch);
    }
    
}
