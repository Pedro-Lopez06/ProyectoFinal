
package controlador;

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
    public ModeloCliente ModeloCliente;
    public VistaCliente VistaCliente;

    private ConsultasCliente Consutascliente = new ConsultasCliente();
    
    public ControladorVistaCliente(ModeloCliente ModeloCliente, VistaCliente vistaCliente) {
        this.ModeloCliente = ModeloCliente;
        this.VistaCliente = vistaCliente;
        vistaCliente.setVisible(true);//hacerlo visible
        
        oyentes();
    }

    private void oyentes() {
        VistaCliente.BtnGuardar.addMouseListener(this);
        VistaCliente.BtnActualizar.addMouseListener(this);
        VistaCliente.BtnEliminar.addMouseListener(this);
        VistaCliente.BtnBuscar.addMouseListener(this);
        VistaCliente.BtnSalir.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaCliente.BtnGuardar) {
            guarda();
        }else if (e.getSource()==VistaCliente.BtnActualizar) {
            modificar();
        }else if (e.getSource()==VistaCliente.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==VistaCliente.BtnBuscar) {
            buscar();
        }else if (e.getSource()==VistaCliente.BtnSalir) {
            salir();
        }else if(e.getSource()==VistaCliente.LblSearch){
            busquedaMVC();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void llenarModeloConVista(){
        ModeloCliente.setCodigo(Integer.parseInt(VistaCliente.TxtCodigo.getText()));
        ModeloCliente.setNombre(VistaCliente.TxtNombre.getText());
        ModeloCliente.setDireccion(VistaCliente.TxtDireccion.getText());
        ModeloCliente.setCiudad(VistaCliente.TxtCiudad.getText());
        ModeloCliente.setEdad(VistaCliente.TxtEdad.getText());
        ModeloCliente.setCorreo(VistaCliente.TxtCorreo.getText());
        ModeloCliente.setFechaIngreso(VistaCliente.TxtFechaIngreso.getText());
        ModeloCliente.setTelefono(VistaCliente.TxtTelefono.getText());
    }
    private void llenarVistaConModelo() {
        VistaCliente.TxtCodigo.setText(ModeloCliente.getCodigo()+"");
        VistaCliente.TxtNombre.setText(ModeloCliente.getNombre());
        VistaCliente.TxtDireccion.setText(ModeloCliente.getDireccion());
        VistaCliente.TxtCiudad.setText(ModeloCliente.getCiudad());
        VistaCliente.TxtEdad.setText(ModeloCliente.getEdad());
        VistaCliente.TxtCorreo.setText(ModeloCliente.getCorreo());
        VistaCliente.TxtFechaIngreso.setText(ModeloCliente.getFechaIngreso());
        VistaCliente.TxtTelefono.setText(ModeloCliente.getTelefono()); 
    }
    private void limpiarCampos() {
        VistaCliente.TxtCodigo.setText("");
        VistaCliente.TxtNombre.setText("");
        VistaCliente.TxtDireccion.setText("");
        VistaCliente.TxtCiudad.setText("");
        VistaCliente.TxtEdad.setText("");
        VistaCliente.TxtCorreo.setText("");
        VistaCliente.TxtFechaIngreso.setText("");
        VistaCliente.TxtTelefono.setText("");
    }
    private boolean validarCampoCodigo() {
        if (VistaCliente.TxtCodigo.getText().isEmpty()) 
           return false;
        else
            return true;
    }
    private boolean validarTodosLosCampos() {
        if (VistaCliente.TxtCodigo.getText().isEmpty()||
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
    
    private void guarda() {
         if (validarTodosLosCampos()) {
            ModeloCliente.setCodigo(Integer.parseInt(VistaCliente.TxtCodigo.getText()));
            if (Consutascliente.buscar(ModeloCliente)==true) {
                JOptionPane.showMessageDialog(VistaCliente,"Ese Cliente ya existe");
            }else{
                llenarModeloConVista();
                if (Consutascliente.insertar(ModeloCliente)==true) {
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
            
            if (Consutascliente.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaCliente,"Ese Cliente no existe");
            }else{
                if (Consutascliente.modificar(ModeloCliente)) {
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
            if (Consutascliente.buscar(ModeloCliente)==false) {
               JOptionPane.showMessageDialog(VistaCliente,"Ese Cliente no existe");
            }else{
                if (Consutascliente.eliminar(ModeloCliente)) {
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
            if (Consutascliente.buscar(ModeloCliente)==true) {
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(VistaCliente,"registro no existe");
            }  
        }else{
            JOptionPane.showConfirmDialog(null,"Los campos no debe de estar vacio");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaCliente,"¿Deseas salir de productos?","ALERTA!",0,1);
        if (opc == 0)VistaCliente.dispose(); {
            
        }
    }
    /*public static void main(String[] args){
        VistaCliente v = new VistaCliente(null, false);
        ModeloCliente m = new ModeloCliente();
        ControladorVistaCliente p = new ControladorVistaCliente(m,v);
    }*/

    private void busquedaMVC() {
        ModeloTablaCliente ModeloTablaCliente = new ModeloTablaCliente();
        
        VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion = new VistaBusquedaPorDescripcion(new JFrame(), true);
        
        //controlador
       ContoladorBusquedaPorDescripcion ContoladorBusquedaPorDescripcion = new ContoladorBusquedaPorDescripcion(ModeloTablaCliente, ModeloCliente, VistaBusquedaPorDescripcion);
        
        llenarVistaConModelo();
    }
    
}
