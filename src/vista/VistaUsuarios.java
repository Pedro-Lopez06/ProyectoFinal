/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Ryzen
 */
public class VistaUsuarios extends JDialog implements Colores,Fuentes{
    ImageIcon Search = new ImageIcon(getClass().getResource("/imagenes/busqueda.png"));
    //etiquetas
    JLabel LblTitulo = new JLabel("ABC De Usuario");
    JLabel LblUser = new JLabel("User: ");
    JLabel LblPassword = new JLabel("Password: ");
    JLabel LblNombre = new JLabel("Nombre: ");
    JLabel LblTipo = new JLabel("Tipo: ");
    public JLabel LblSearch = new JLabel(Search);

    //TextField
    public TextField TxtUser = new TextField(10);
    public TextField TxtPassword = new TextField(50);
    public TextField TxtNombre = new TextField(30);
    public TextField TxtTipo = new TextField(20);


    //Botones
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");
    public VistaUsuarios(Frame owner, boolean modal) {
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
        this.setTitle("ABC de Usuarios");
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
        this.add(TxtUser);
        TxtUser.setBounds(350,100,250,25);
        this.add(TxtPassword);
        TxtPassword.setBounds(350,150,250,25);
        this.add(TxtNombre);
        TxtNombre.setBounds(350,200,250,25);
        this.add(TxtTipo);
        TxtTipo.setBounds(350,250,250,25);
    }

    private void etiquetas() {
        LblTitulo.setFont(FUENTE_TITULOS);
        LblUser.setFont(FUENTE_LABELS);
        LblNombre.setFont(FUENTE_LABELS);
        LblTipo.setFont(FUENTE_LABELS);


        LblTitulo.setBounds(280,15,500,40);
        this.add(LblTitulo);
        LblUser.setBounds(250,100,80,20);
        this.add(LblUser);
        LblPassword.setBounds(250,150,80,20);
        this.add(LblPassword);
        LblNombre.setBounds(250,200,80,20);
        this.add(LblNombre);
        LblTipo.setBounds(250,250,80,20);
        this.add(LblTipo);

        this.add(LblSearch);
        LblSearch.setBounds(180,100,80,30);
    }
}
