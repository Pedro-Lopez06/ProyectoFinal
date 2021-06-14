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
import modelo.ConsultasProveedor;
import modelo.ModeloProveedor;
import modelo.ModeloTablaProveedor;
import vista.VistaBusquedaPorDescripcion;
import vista.VistaProveedor;

/**
 *
 * @author Pedro López
 */
public class ControladorVistaProveedor implements MouseListener{
    ModeloProveedor ModeloProveedor;
    VistaProveedor VistaProveedor;
    
    private ConsultasProveedor ConsultasProveedor = new ConsultasProveedor();

    public ControladorVistaProveedor(ModeloProveedor ModeloProveedor, VistaProveedor VistaProveedor) {
        this.ModeloProveedor = ModeloProveedor;
        this.VistaProveedor = VistaProveedor;
        oyentesVista();
        this.VistaProveedor.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==VistaProveedor.BtnGuardar){
            guardar();
        }else if(me.getSource()==VistaProveedor.BtnActualizar){
            modificar();
        }else if(me.getSource()==VistaProveedor.BtnEliminar){
            eliminar();
        }else if(me.getSource()==VistaProveedor.BtnBuscar){
            buscar();
        }else if(me.getSource()==VistaProveedor.BtnSalir){
            salir(); 
        }else if(me.getSource()==VistaProveedor.LblSearch){
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
        if(me.getSource()==VistaProveedor.LblSearch){
            VistaProveedor.LblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    private void oyentesVista() {
        VistaProveedor.BtnActualizar.addMouseListener(this);
        VistaProveedor.BtnBuscar.addMouseListener(this);
        VistaProveedor.BtnEliminar.addMouseListener(this);
        VistaProveedor.BtnGuardar.addMouseListener(this);
        VistaProveedor.BtnSalir.addMouseListener(this);
        VistaProveedor.LblSearch.addMouseListener(this);
    }
        private void llenarModeloConVista() {
        ModeloProveedor.setCodigo(Integer.parseInt(VistaProveedor.TxtCodigo.getText()));
        ModeloProveedor.setNombre(VistaProveedor.TxtNombre.getText());
        ModeloProveedor.setEmpresa(VistaProveedor.TxtEmpresa.getText());
        ModeloProveedor.setTelefono(VistaProveedor.TxtTelefono.getText());
        ModeloProveedor.setCorreo(VistaProveedor.TxtCorreo.getText());
        ModeloProveedor.setDireccion(VistaProveedor.TxtDireccion.getText());
        ModeloProveedor.setRFC(VistaProveedor.TxtRFC.getText());
        ModeloProveedor.setCel(VistaProveedor.TxtCel.getText());
     }
    private void llenarVistaConModelo(){
        VistaProveedor.TxtCodigo.setText(ModeloProveedor.getCodigo()+"");
        VistaProveedor.TxtNombre.setText(ModeloProveedor.getNombre()+"");
        VistaProveedor.TxtEmpresa.setText(ModeloProveedor.getEmpresa()+"");
        VistaProveedor.TxtTelefono.setText(ModeloProveedor.getTelefono()+"");
        VistaProveedor.TxtCorreo.setText(ModeloProveedor.getCorreo()+"");
        VistaProveedor.TxtDireccion.setText(ModeloProveedor.getDireccion()+"");
        VistaProveedor.TxtRFC.setText(ModeloProveedor.getRFC()+"");
        VistaProveedor.TxtCel.setText(ModeloProveedor.getCel()+"");
    }
    private void limpiarCampos(){
        VistaProveedor.TxtCodigo.setText("");
        VistaProveedor.TxtNombre.setText("");
        VistaProveedor.TxtEmpresa.setText("");
        VistaProveedor.TxtTelefono.setText("");
        VistaProveedor.TxtCorreo.setText("");
        VistaProveedor.TxtDireccion.setText("");
        VistaProveedor.TxtCel.setText("");
        VistaProveedor.TxtRFC.setText("");
        VistaProveedor.TxtCodigo.requestFocus();
    }
    //valida que no este vacio el campo codigo
    private boolean validarCampoCodigo(){
        if(VistaProveedor.TxtCodigo.getText().isEmpty())
            return false;
        else
            return true;
    }
    //valida que no  esten vacios ningunos de los campos
    private boolean validarTodosLosCampos(){
        if(VistaProveedor.TxtCodigo.getText().isEmpty()||
           VistaProveedor.TxtCel.getText().isEmpty()||
           VistaProveedor.TxtDireccion.getText().isEmpty()||
           VistaProveedor.TxtEmpresa.getText().isEmpty()||
           VistaProveedor.TxtCorreo.getText().isEmpty()||
           VistaProveedor.TxtNombre.getText().isEmpty()||
           VistaProveedor.TxtRFC.getText().isEmpty()||
           VistaProveedor.TxtTelefono.getText().isEmpty())
            return false;
        else 
            return true;
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloProveedor.setCodigo(Integer.parseInt(VistaProveedor.TxtCodigo.getText()));
            if (ConsultasProveedor.buscar(ModeloProveedor)==true) {
                JOptionPane.showMessageDialog(VistaProveedor,"Ese proveedor ya existe");
            }else{
                llenarModeloConVista();
                if (ConsultasProveedor.insertar(ModeloProveedor)==true) {
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
            
            ModeloProveedor ModeloTemporal = new ModeloProveedor();
            ModeloTemporal.setCodigo(Integer.parseInt(VistaProveedor.TxtCodigo.getText()));
            
            if (ConsultasProveedor.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaProveedor,"Ese producto no existe");
            }else{
                if (ConsultasProveedor.modificar(ModeloProveedor)) {
                   JOptionPane.showMessageDialog(VistaProveedor,"Registro modificado correctamente");
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
            ModeloProveedor.setCodigo(Integer.parseInt(VistaProveedor.TxtCodigo.getText()));
            if (ConsultasProveedor.buscar(ModeloProveedor)==false) {
               JOptionPane.showMessageDialog(VistaProveedor,"Ese proveedor no existe");
            }else{
                if (ConsultasProveedor.eliminar(ModeloProveedor)) {
                    JOptionPane.showMessageDialog(VistaProveedor,"Registro eliminado correctamente");
                   limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaProveedor,"Error al eliminar el registro");
            }
        }
        }else{
            JOptionPane.showMessageDialog(null,"El campo codigo no debe de estar vacio");
        }
    }

    private void buscar() {
        if (validarCampoCodigo()) {
            ModeloProveedor.setCodigo(Integer.parseInt(VistaProveedor.TxtCodigo.getText()));
            if (ConsultasProveedor.buscar(ModeloProveedor)==true) {
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(VistaProveedor,"registro no existe");
            }  
        }else{
            JOptionPane.showConfirmDialog(null,"Los campos no debe de estar vacio");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaProveedor,"¿Deseas salir de productos?","ALERTA!",0,1);
        if (opc == 0)VistaProveedor.dispose(); 
    }
    private void busquedaMVC(){
        ModeloTablaProveedor ModeloTablaProveedor = new ModeloTablaProveedor();
        
        VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion = new VistaBusquedaPorDescripcion(new JFrame(), true);
        
        //controlador
        ControladorBusquedaPorDescripcion ControladorSearch = new ControladorBusquedaPorDescripcion(ModeloTablaProveedor,
                ModeloProveedor, VistaBusquedaPorDescripcion);
        
        llenarVistaConModelo();
    }
    //public static void main(String[] args) {
        //VistaProveedor v = new VistaProveedor(null, false);
        //ModeloProveedor m = new ModeloProveedor();
        //ControladorVistaProveedor p = new ControladorVistaProveedor(m, v);
    //}

}
