/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasEmpleado;
import modelo.ModeloBusquedaEmpleados;
import modelo.ModeloEmpleado;
import vista.VistaBusquedaEmpleados;
import vista.VistaEmpleado;


/**
 *
 * @author Ryzen
 */
public class ControladorVistaEmpleado implements MouseListener{
    ModeloEmpleado ModeloEmpleado;
    VistaEmpleado VistaEmpleado;
    
    private ConsultasEmpleado ConsultasEmpleado = new ConsultasEmpleado();

    public ControladorVistaEmpleado(ModeloEmpleado ModeloEmpleado, VistaEmpleado VistaEmpleado) {
        this.ModeloEmpleado = ModeloEmpleado;
        this.VistaEmpleado = VistaEmpleado;
        oyentes();
        this.VistaEmpleado.setVisible(true);
    }

    

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==VistaEmpleado.BtnGuardar){
            guardar();
        }else if(me.getSource()==VistaEmpleado.BtnActualizar){
            modificar();
        }else if(me.getSource()==VistaEmpleado.BtnEliminar){
            eliminar();
        }else if(me.getSource()==VistaEmpleado.BtnBuscar){
            buscar();
        }else if(me.getSource()==VistaEmpleado.BtnSalir){
            salir(); 
        }else if(me.getSource()==VistaEmpleado.LblSearch){
            busquedaMVC();
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
        if(me.getSource()==VistaEmpleado.LblSearch){
            VistaEmpleado.LblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }    
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    private void oyentes() {
        VistaEmpleado.BtnActualizar.addMouseListener(this);
        VistaEmpleado.BtnBuscar.addMouseListener(this);
        VistaEmpleado.BtnEliminar.addMouseListener(this);
        VistaEmpleado.BtnGuardar.addMouseListener(this);
        VistaEmpleado.BtnSalir.addMouseListener(this);
        VistaEmpleado.LblSearch.addMouseListener(this);
    }
    
   private void llenarModeloConVista() {
        ModeloEmpleado.setCodigo(Integer.parseInt(VistaEmpleado.TxtCodigo.getText()));
        ModeloEmpleado.setNombre(VistaEmpleado.TxtNombre.getText());
        ModeloEmpleado.setDireccion(VistaEmpleado.TxtDireccion.getText());
        ModeloEmpleado.setEntrada(VistaEmpleado.TxtEntrada.getText());
        ModeloEmpleado.setSalida(VistaEmpleado.TxtSalida.getText());
        ModeloEmpleado.setTelefono(VistaEmpleado.TxtTelefono.getText());
        ModeloEmpleado.setSueldo(Float.parseFloat(VistaEmpleado.TxtSueldo.getText()));
    }
   
   private void llenarVistaConModelo(){
        VistaEmpleado.TxtCodigo.setText(ModeloEmpleado.getCodigo()+"");
        VistaEmpleado.TxtNombre.setText(ModeloEmpleado.getNombre()+"");
        VistaEmpleado.TxtDireccion.setText(ModeloEmpleado.getDireccion()+"");
        VistaEmpleado.TxtEntrada.setText(ModeloEmpleado.getEntrada()+"");
        VistaEmpleado.TxtSalida.setText(ModeloEmpleado.getSalida()+"");
        VistaEmpleado.TxtTelefono.setText(ModeloEmpleado.getTelefono()+"");
        VistaEmpleado.TxtSueldo.setText(ModeloEmpleado.getSueldo()+"");
    }
   
   private void limpiarCampos(){
        VistaEmpleado.TxtCodigo.setText("");
        VistaEmpleado.TxtNombre.setText("");
        VistaEmpleado.TxtDireccion.setText("");
        VistaEmpleado.TxtEntrada.setText("");
        VistaEmpleado.TxtSalida.setText("");
        VistaEmpleado.TxtTelefono.setText("");
        VistaEmpleado.TxtSueldo.setText("");
        VistaEmpleado.TxtCodigo.requestFocus();
    }
   

   private boolean validarCampoCodigo(){
        if(VistaEmpleado.TxtCodigo.getText().isEmpty())
            return false;
        else
            return true;
    }
   
   private boolean validarTodosLosCampos(){
        if(VistaEmpleado.TxtCodigo.getText().isEmpty()||
           VistaEmpleado.TxtNombre.getText().isEmpty()||
           VistaEmpleado.TxtDireccion.getText().isEmpty()||
           VistaEmpleado.TxtEntrada.getText().isEmpty()||
           VistaEmpleado.TxtSalida.getText().isEmpty()||
           VistaEmpleado.TxtTelefono.getText().isEmpty()||
           VistaEmpleado.TxtSueldo.getText().isEmpty())
            return false;
        else 
            return true;
    }
   
    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloEmpleado.setCodigo(Integer.parseInt(VistaEmpleado.TxtCodigo.getText()));
            if (ConsultasEmpleado.buscar(ModeloEmpleado)==true) {
                JOptionPane.showMessageDialog(VistaEmpleado,"Ese Empleado ya existe");
            }else{
                llenarModeloConVista();
                if (ConsultasEmpleado.insertar(ModeloEmpleado)==true) {
                    JOptionPane.showMessageDialog(null,"Registro guardado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(null,"El campo codigo no debe estar vacio");
                    
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"El campo codigo no debe estar vacio");
            
        }
    }

    private void modificar() {
         if (validarTodosLosCampos()) {
            llenarModeloConVista();
            
            ModeloEmpleado ModeloTemporal = new ModeloEmpleado();
            ModeloTemporal.setCodigo(Integer.parseInt(VistaEmpleado.TxtCodigo.getText()));
            
            if (ConsultasEmpleado.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaEmpleado,"Ese Empleado no existe");
            }else{
                if (ConsultasEmpleado.modificar(ModeloEmpleado)) {
                   JOptionPane.showMessageDialog(VistaEmpleado,"Registro modificado correctamente");
                   limpiarCampos();
               }else{
                    JOptionPane.showMessageDialog(null,"Error al modificar el registro");
                }
            }
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Los campos no deben estar vacíos");
        }
    }
    

    private void eliminar() {
        if (validarCampoCodigo()) {
            ModeloEmpleado.setCodigo(Integer.parseInt(VistaEmpleado.TxtCodigo.getText()));
            if (ConsultasEmpleado.buscar(ModeloEmpleado)==false) {
               JOptionPane.showMessageDialog(VistaEmpleado,"Ese Empleado no existe");
            }else{
                if (ConsultasEmpleado.eliminar(ModeloEmpleado)) {
                    JOptionPane.showMessageDialog(VistaEmpleado,"Registro eliminado correctamente");
                   limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaEmpleado,"Error al eliminar el registro");
            }
        }
        }else{
            JOptionPane.showMessageDialog(null,"El campo codigo no debe de estar vacio");
        }
    }

    private void buscar() {
        if (validarCampoCodigo()) {
            ModeloEmpleado.setCodigo(Integer.parseInt(VistaEmpleado.TxtCodigo.getText()));
            if (ConsultasEmpleado.buscar(ModeloEmpleado)==true) {
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(VistaEmpleado,"registro no existe");
            }  
        }else{
            JOptionPane.showConfirmDialog(null,"Los campos no debe de estar vacio");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaEmpleado,"¿Deseas salir de Empleados?","ALERTA!",0,1);
        if (opc == 0)VistaEmpleado.dispose();
    }

    private void busquedaMVC() {
        ModeloBusquedaEmpleados ModeloBusquedaEmpleados = new ModeloBusquedaEmpleados();
        
        VistaBusquedaEmpleados VistaBusquedaEmpleados = new VistaBusquedaEmpleados(new JFrame(),true);
        
        ControladorVistaBusquedaEmpleados ControladorSerach = new ControladorVistaBusquedaEmpleados(ModeloBusquedaEmpleados, ModeloEmpleado,VistaBusquedaEmpleados);
        
        llenarVistaConModelo();
    }
    
    
    
    
    
}
