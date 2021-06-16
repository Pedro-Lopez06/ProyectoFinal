/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.ConsultasEmpleado;
import modelo.ModeloBusquedaEmpleados;
import modelo.ModeloEmpleado;
import vista.VistaBusquedaEmpleados;

/**
 *
 * @author Ryzen
 */
public class ControladorVistaBusquedaEmpleados implements MouseListener,KeyListener{
    ModeloBusquedaEmpleados ModeloBusquedaEmpleados;
    ModeloEmpleado ModeloEmpleado;
    VistaBusquedaEmpleados VistaBusquedaEmpleados;
    ConsultasEmpleado ConsultasEmpleado = new ConsultasEmpleado();

    public ControladorVistaBusquedaEmpleados() {
    }
    
    public ControladorVistaBusquedaEmpleados(ModeloBusquedaEmpleados ModeloBusquedaEmpleados, ModeloEmpleado ModeloEmpleado, VistaBusquedaEmpleados VistaBusquedaEmpleados) {
        this.ModeloBusquedaEmpleados = ModeloBusquedaEmpleados;
        this.ModeloEmpleado = ModeloEmpleado;
        this.VistaBusquedaEmpleados = VistaBusquedaEmpleados;
       
        VistaBusquedaEmpleados.Tabla.setModel(ModeloBusquedaEmpleados.getModeloTabla());
        
        oyentes();
        llenarTablaProductos();
        VistaBusquedaEmpleados.setVisible(true);
    }

    private void oyentes(){
        VistaBusquedaEmpleados.TxtNombre.addMouseListener(this);
        VistaBusquedaEmpleados.Tabla.addMouseListener(this);
        VistaBusquedaEmpleados.BtnAceptar.addMouseListener(this);
        
        VistaBusquedaEmpleados.TxtNombre.addKeyListener(this);
        
    }
    private void llenarTablaProductos(){
        ConsultasEmpleado.buscarTodosLosEmpleados(ModeloBusquedaEmpleados.getModeloTabla());
        
        VistaBusquedaEmpleados.Tabla.setModel(ModeloBusquedaEmpleados.getModeloTabla());
    }
    
    private void LlenarModeloConSeleccionFilaTabla(){
        int filaSeleccionada = VistaBusquedaEmpleados.Tabla.getSelectedRow();
        
        if (filaSeleccionada!=-1) {
            int Codigo = Integer.parseInt(ModeloBusquedaEmpleados.getModeloTabla().
                    getValueAt(filaSeleccionada, 0).toString());
            String Nombre = ModeloBusquedaEmpleados.getModeloTabla().
                    getValueAt(filaSeleccionada, 1).toString();
            String Direccion = ModeloBusquedaEmpleados.getModeloTabla().
                    getValueAt(filaSeleccionada, 1).toString();
            String Entrada = ModeloBusquedaEmpleados.getModeloTabla().
                    getValueAt(filaSeleccionada, 1).toString();
            String Salida = ModeloBusquedaEmpleados.getModeloTabla().
                    getValueAt(filaSeleccionada, 1).toString();
            String Telefono = ModeloBusquedaEmpleados.getModeloTabla().
                    getValueAt(filaSeleccionada, 1).toString();
            Float Sueldo = Float.parseFloat(ModeloBusquedaEmpleados.getModeloTabla().
                    getValueAt(filaSeleccionada, 0).toString());
            
            ModeloEmpleado.setCodigo(Codigo);
            ModeloEmpleado.setNombre(Nombre);
            ModeloEmpleado.setDireccion(Direccion);
            ModeloEmpleado.setEntrada(Entrada);
            ModeloEmpleado.setSalida(Salida);
            ModeloEmpleado.setTelefono(Telefono);
            ModeloEmpleado.setSueldo(Sueldo);
            
            
            
        }
    }
    
            
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==VistaBusquedaEmpleados.BtnAceptar) {
            LlenarModeloConSeleccionFilaTabla();
            VistaBusquedaEmpleados.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        try {
                ConsultasEmpleado.buscarFrase(VistaBusquedaEmpleados.TxtNombre, ModeloBusquedaEmpleados.getModeloTabla());
            }catch (Exception e){

            }
    }
}
