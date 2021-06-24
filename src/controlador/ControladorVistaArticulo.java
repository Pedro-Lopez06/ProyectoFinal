/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author jony_
 *
*/

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasArticulo;
import modelo.ModeloArticulo;
//import modelo.ModeloTablaArticulo;
import vista.VistaArticulo;
import vista.VistaBusquedaPorDescripcion;



public class ControladorVistaArticulo implements MouseListener {
    ModeloArticulo ModeloArticulo;
    VistaArticulo VistaArticulo;
    
    private ConsultasArticulo ConsultasArticulo = new ConsultasArticulo();

    public ControladorVistaArticulo(ModeloArticulo ModeloArticulo, VistaArticulo VistaArticulo) {
        this.ModeloArticulo = ModeloArticulo;
        this.VistaArticulo = VistaArticulo;
        oyentesVista();
        this.VistaArticulo.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==VistaArticulo.BtnGuardar){
            guardar();
        }else if(me.getSource()==VistaArticulo.BtnActualizar){
            modificar();
        }else if(me.getSource()==VistaArticulo.BtnEliminar){
            eliminar();
        }else if(me.getSource()==VistaArticulo.BtnBuscar){
            buscar();
        }else if(me.getSource()==VistaArticulo.BtnSalir){
            salir(); 
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
        if(me.getSource()==VistaArticulo.LblSearch){
            VistaArticulo.LblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    private void oyentesVista() {
        VistaArticulo.BtnActualizar.addMouseListener(this);
        VistaArticulo.BtnBuscar.addMouseListener(this);
        VistaArticulo.BtnEliminar.addMouseListener(this);
        VistaArticulo.BtnGuardar.addMouseListener(this);
        VistaArticulo.BtnSalir.addMouseListener(this);
        VistaArticulo.LblSearch.addMouseListener(this);
    }
        private void llenarModeloConVista() {
        ModeloArticulo.setCodigo(Integer.parseInt(VistaArticulo.TxtCodigo.getText()));
        ModeloArticulo.setDescripcion(VistaArticulo.TxtDescripcion.getText());
        ModeloArticulo.setMarca(VistaArticulo.TxtMarca.getText());
        ModeloArticulo.setColor(VistaArticulo.TxtColor.getText());
        ModeloArticulo.setPrecioPublico(Integer.parseInt(VistaArticulo.TxtPrecioPublico.getText()));
        ModeloArticulo.setPrecioPublico(Integer.parseInt(VistaArticulo.TxtPrecioProveedor.getText()));
        ModeloArticulo.setStock(VistaArticulo.TxtStock.getText());
     }
    private void llenarVistaConModelo(){
        VistaArticulo.TxtCodigo.setText(ModeloArticulo.getCodigo()+"");
        VistaArticulo.TxtDescripcion.setText(ModeloArticulo.getDescripcion()+"");
        VistaArticulo.TxtMarca.setText(ModeloArticulo.getMarca()+"");
        VistaArticulo.TxtColor.setText(ModeloArticulo.getColor()+"");
        VistaArticulo.TxtPrecioPublico.setText(ModeloArticulo.getPrecioPublico()+"");
        VistaArticulo.TxtPrecioProveedor.setText(ModeloArticulo.getPrecioProveedor()+"");
        VistaArticulo.TxtStock.setText(ModeloArticulo.getStock()+"");
    }
    private void limpiarCampos(){
        VistaArticulo.TxtCodigo.setText("");
        VistaArticulo.TxtDescripcion.setText("");
        VistaArticulo.TxtMarca.setText("");
        VistaArticulo.TxtColor.setText("");
        VistaArticulo.TxtPrecioPublico.setText("");
        VistaArticulo.TxtPrecioProveedor.setText("");
        VistaArticulo.TxtStock.setText("");
    }
    //valida que no este vacio el campo codigo
    private boolean validarCampoCodigo(){
        if(VistaArticulo.TxtCodigo.getText().isEmpty())
            return false;
        else
            return true;
    }
    //valida que no  esten vacios ningunos de los campos
    private boolean validarTodosLosCampos(){
        if(VistaArticulo.TxtCodigo.getText().isEmpty()||
           VistaArticulo.TxtDescripcion.getText().isEmpty()||
           VistaArticulo.TxtMarca.getText().isEmpty()||
           VistaArticulo.TxtColor.getText().isEmpty()||
           VistaArticulo.TxtPrecioPublico.getText().isEmpty()||
           VistaArticulo.TxtPrecioProveedor.getText().isEmpty()||
           VistaArticulo.TxtStock.getText().isEmpty())
            return false;
        else 
            return true;
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloArticulo.setCodigo(Integer.parseInt(VistaArticulo.TxtCodigo.getText()));
            if (ConsultasArticulo.buscar(ModeloArticulo)==true) {
                JOptionPane.showMessageDialog(VistaArticulo,"Ese proveedor ya existe");
            }else{
                llenarModeloConVista();
                if (ConsultasArticulo.insertar(ModeloArticulo)==true) {
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
            
            ModeloArticulo ModeloTemporal = new ModeloArticulo();
            ModeloTemporal.setCodigo(Integer.parseInt(VistaArticulo.TxtCodigo.getText()));
            
            if (ConsultasArticulo.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaArticulo,"Ese producto no existe");
            }else{
                if (ConsultasArticulo.modificar(ModeloArticulo)) {
                   JOptionPane.showMessageDialog(VistaArticulo,"Registro modificado correctamente");
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
            ModeloArticulo.setCodigo(Integer.parseInt(VistaArticulo.TxtCodigo.getText()));
            if (ConsultasArticulo.buscar(ModeloArticulo)==false) {
               JOptionPane.showMessageDialog(VistaArticulo,"Ese articulo no existe");
            }else{
                if (ConsultasArticulo.eliminar(ModeloArticulo)) {
                    JOptionPane.showMessageDialog(VistaArticulo,"Registro eliminado correctamente");
                   limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaArticulo,"Error al eliminar el registro");
            }
        }
        }else{
            JOptionPane.showMessageDialog(null,"El campo codigo no debe de estar vacio");
        }
    }

    private void buscar() {
        if (validarCampoCodigo()) {
            ModeloArticulo.setCodigo(Integer.parseInt(VistaArticulo.TxtCodigo.getText()));
            if (ConsultasArticulo.buscar(ModeloArticulo)==true) {
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(VistaArticulo,"registro no existe");
            }  
        }else{
            JOptionPane.showConfirmDialog(null,"Los campos no debe de estar vacio");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaArticulo,"¿Deseas salir de articulos?","ALERTA!",0,1);
        if (opc == 0)VistaArticulo.dispose(); 
    }
    
    
    /* private void busquedaMVC() {
        ModeloTablaArticulo ModeloTablaArticulo = new ModeloTablaArticulo();
        
        VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion = new VistaBusquedaPorDescripcion(new JFrame(), true);
        
        //controlador
       ContoladorBusquedaPorDescripcion ContoladorBusquedaPorDescripcion = new ContoladorBusquedaPorDescripcion(ModeloTablaArticulo, ModeloArticulo, VistaBusquedaPorDescripcion);
        
        llenarVistaConModelo();
    }
    
    */
    /*private void busquedaMVC(){
        ModeloTablaArticulo ModeloTablaArticulo = new ModeloTablaArticulo();
        
        VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion = new VistaBusquedaPorDescripcion(new JFrame(), true);
        
        //controlador
        ControladorBusquedaPorDescripcion ControladorSearch = new ControladorBusquedaPorDescripcion(ModeloTablaProveedor,
                ModeloArticulo, VistaBusquedaPorDescripcion);
        
        llenarVistaConModelo();
    }
    //public static void main(String[] args) {
        //VistaProveedor v = new VistaProveedor(null, false);
        //ModeloProveedor m = new ModeloProveedor();
        //ControladorVistaProveedor p = new ControladorVistaProveedor(m, v);
    //}*/

}

