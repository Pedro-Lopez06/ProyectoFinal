/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Ryzen
 */
public class VistaBusquedaEmpleados extends JDialog{
    JLabel LblNombre = new JLabel("Empleado a buscar");
    public JTextField TxtNombre = new JTextField();
    public JButton BtnAceptar = new JButton("Aceptar");
    
    public JTable Tabla = new JTable();
    JScrollPane ScrollTabla = new JScrollPane(Tabla);
    
    public VistaBusquedaEmpleados(Frame owner, boolean modal){
        super(owner, modal);
        configuracionInicial();
        agregarComponentes();
    }

    private void configuracionInicial() {
        this.setSize(430,320);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }

    private void agregarComponentes() {
        LblNombre.setBounds(10, 15, 100, 40);
        TxtNombre.setBounds(130, 15, 200, 40);
        ScrollTabla.setBounds(20, 70, 378, 130);
        BtnAceptar.setBounds(150, 230, 120, 40);
        
        this.add(LblNombre);
        this.add(TxtNombre);
        this.add(ScrollTabla);
        this.add(BtnAceptar);
    }
    
}
