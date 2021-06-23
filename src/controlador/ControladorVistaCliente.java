
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasCliente;
import modelo.ModeloCliente;
import modelo.ModeloTablaCliente;
import vista.VistaBusquedaPorDescripcion;
import vista.VistaCliente;


/**
 *
 * @author Emmanuel Ruiz
 */
public class ControladorVistaCliente implements MouseListener{
    ModeloCliente ModeloCliente;
    VistaCliente VistaCliente;
    
    private ConsultasCliente consultasCliente = new ConsultasCliente();

    public ControladorVistaCliente(ModeloCliente ModeloCliente, VistaCliente VistaCliente) {
        this.ModeloCliente = ModeloCliente;
        this.VistaCliente = VistaCliente;
        oyentesVista();
        this.VistaCliente.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==VistaCliente.BtnGuardar){
            guardar();
        }else if(me.getSource()==VistaCliente.BtnActualizar){
            modificar();
        }else if(me.getSource()==VistaCliente.BtnEliminar){
            eliminar();
        }else if(me.getSource()==VistaCliente.BtnBuscar){
            buscar();
        }else if(me.getSource()==VistaCliente.BtnSalir){
            salir(); 
        }else if(me.getSource()==VistaCliente.LblSearch){
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
        if(me.getSource()==VistaCliente.LblSearch){
            VistaCliente.LblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    private void oyentesVista() {
        VistaCliente.BtnActualizar.addMouseListener(this);
        VistaCliente.BtnBuscar.addMouseListener(this);
        VistaCliente.BtnEliminar.addMouseListener(this);
        VistaCliente.BtnGuardar.addMouseListener(this);
        VistaCliente.BtnSalir.addMouseListener(this);
        VistaCliente.LblSearch.addMouseListener(this);
    }
        private void llenarModeloConVista() {
        ModeloCliente.setCodigo(Integer.parseInt(VistaCliente.TxtCodigo.getText()));
        ModeloCliente.setNombre(VistaCliente.TxtNombre.getText());
        ModeloCliente.setDireccion(VistaCliente.TxtDireccion.getText());
        ModeloCliente.setCiudad(VistaCliente.TxtCiudad.getText());
        ModeloCliente.setEdad(VistaCliente.TxtEdad.getText());
        ModeloCliente.setCorreo(VistaCliente.TxtCorreo.getText());
        ModeloCliente.setFechaIngreso(VistaCliente.TxtFechaIngreso.getText());
        ModeloCliente.setTelefono(VistaCliente.TxtTelefono.getText());
        
     }
    private void llenarVistaConModelo(){
        VistaCliente.TxtCodigo.setText(ModeloCliente.getCodigo()+"");
        VistaCliente.TxtNombre.setText(ModeloCliente.getNombre()+"");
        VistaCliente.TxtDireccion.setText(ModeloCliente.getDireccion()+"");
        VistaCliente.TxtCiudad.setText(ModeloCliente.getCiudad()+"");
        VistaCliente.TxtEdad.setText(ModeloCliente.getEdad()+"");
        VistaCliente.TxtCorreo.setText(ModeloCliente.getCorreo()+"");
        VistaCliente.TxtFechaIngreso.setText(ModeloCliente.getFechaIngreso()+"");
        VistaCliente.TxtTelefono.setText(ModeloCliente.getTelefono()+"");
    }
    private void limpiarCampos(){
        VistaCliente.TxtCodigo.setText("");
        VistaCliente.TxtNombre.setText("");
        VistaCliente.TxtDireccion.setText("");
        VistaCliente.TxtCiudad.setText("");
        VistaCliente.TxtEdad.setText("");
        VistaCliente.TxtCorreo.setText("");
        VistaCliente.TxtFechaIngreso.setText("");
        VistaCliente.TxtTelefono.setText("");
        
    }
    //valida que no este vacio el campo codigo
    private boolean validarCampoCodigo(){
        if(VistaCliente.TxtCodigo.getText().isEmpty())
            return false;
        else
            return true;
    }
    //valida que no  esten vacios ningunos de los campos
    private boolean validarTodosLosCampos(){
        if(VistaCliente.TxtCodigo.getText().isEmpty()||
           VistaCliente.TxtNombre.getText().isEmpty()||
           VistaCliente.TxtDireccion.getText().isEmpty()||
           VistaCliente.TxtCiudad.getText().isEmpty()||
           VistaCliente.TxtEdad.getText().isEmpty()||
           VistaCliente.TxtCorreo.getText().isEmpty()||
           VistaCliente.TxtFechaIngreso.getText().isEmpty()||
           VistaCliente.TxtTelefono.getText().isEmpty())
            return false;
        else 
            return true;
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloCliente.setCodigo(Integer.parseInt(VistaCliente.TxtCodigo.getText()));
            if (consultasCliente.buscar(ModeloCliente)==true) {
                JOptionPane.showMessageDialog(VistaCliente,"Ese proveedor ya existe");
            }else{
                llenarModeloConVista();
                if (consultasCliente.insertar(ModeloCliente)==true) {
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
            
            ModeloCliente ModeloTemporal = new ModeloCliente();
            ModeloTemporal.setCodigo(Integer.parseInt(VistaCliente.TxtCodigo.getText()));
            
            if (consultasCliente.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaCliente,"Ese producto no existe");
            }else{
                if (consultasCliente.modificar(ModeloCliente)) {
                   JOptionPane.showMessageDialog(VistaCliente,"Registro modificado correctamente");
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
            ModeloCliente.setCodigo(Integer.parseInt(VistaCliente.TxtCodigo.getText()));
            if (consultasCliente.buscar(ModeloCliente)==false) {
               JOptionPane.showMessageDialog(VistaCliente,"Ese proveedor no existe");
            }else{
                if (consultasCliente.eliminar(ModeloCliente)) {
                    JOptionPane.showMessageDialog(VistaCliente,"Registro eliminado correctamente");
                   limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaCliente,"Error al eliminar el registro");
            }
        }
        }else{
            JOptionPane.showMessageDialog(null,"El campo codigo no debe de estar vacio");
        }
    }

    private void buscar() {
        if (validarCampoCodigo()) {
            ModeloCliente.setCodigo(Integer.parseInt(VistaCliente.TxtCodigo.getText()));
            if (consultasCliente.buscar(ModeloCliente)==true) {
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(VistaCliente,"registro no existe");
            }  
        }else{
            JOptionPane.showConfirmDialog(null,"Los campos no debe de estar vacio");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaCliente,"¿Deseas salir de Clientes?","ALERTA!",0,1);
        if (opc == 0)VistaCliente.dispose(); 
    }
    private void busquedaMVC(){
        ModeloTablaCliente ModeloTablaCliente = new ModeloTablaCliente();
        
        VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion = new VistaBusquedaPorDescripcion(new JFrame(), true);
        
        //controlador
        ContoladorBusquedaPorDescripcion ControladorSearch = new ContoladorBusquedaPorDescripcion(ModeloTablaCliente, ModeloCliente, VistaBusquedaPorDescripcion);
        llenarVistaConModelo();
    }
    //public static void main(String[] args) {
        //VistaProveedor v = new VistaProveedor(null, false);
        //ModeloProveedor m = new ModeloProveedor();
        //ControladorVistaProveedor p = new ControladorVistaProveedor(m, v);
    //}

}
