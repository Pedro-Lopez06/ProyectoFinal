
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.ConsultasCliente;
import modelo.ModeloCliente;
import modelo.ModeloTablaCliente;
import vista.VistaBusquedaPorDescripcion;

/**
 *
 * @author Emmanuel Ruiz
 */
public class ContoladorBusquedaPorDescripcion implements MouseListener, KeyListener{
    ModeloTablaCliente ModeloTablaCliente;
    ModeloCliente ModeloCliente;
    VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion;
    ConsultasCliente ConsultasCliente = new ConsultasCliente();
   //public ControladorBusquedaPorDescripcion(ModeloTablaCliente ModeloTablaCliente, ModeloCliente ModeloCliente, 
           // VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion) {
    
    public ContoladorBusquedaPorDescripcion(ModeloTablaCliente ModeloTablaCliente, ModeloCliente ModeloCliente,
            VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion) {
        
        this.ModeloTablaCliente = ModeloTablaCliente;//apunta al original
        this.ModeloCliente = ModeloCliente;
        this.VistaBusquedaPorDescripcion = VistaBusquedaPorDescripcion;
        //Toma el modelo de la tabla le coloca los campos, encabezados etc...
        VistaBusquedaPorDescripcion.Tabla.setModel(ModeloTablaCliente.getModeloTabla());
        
        oyentes();
        llenarTablaCliente();
        VistaBusquedaPorDescripcion.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== VistaBusquedaPorDescripcion.BtnAceptar){
            VistaBusquedaPorDescripcion.dispose();
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==VistaBusquedaPorDescripcion.TxtNombre){
            ConsultasCliente.buscarFrase(VistaBusquedaPorDescripcion.TxtNombre, ModeloTablaCliente.getModeloTabla());
        }
    }

    private void oyentes() {
        //Oyentes del Mouse
        VistaBusquedaPorDescripcion.TxtNombre.addMouseListener(this);
        VistaBusquedaPorDescripcion.Tabla.addMouseListener(this);
        VistaBusquedaPorDescripcion.BtnAceptar.addMouseListener(this);
        
        //Oyentes del teclado
        VistaBusquedaPorDescripcion.TxtNombre.addKeyListener(this);
    }

    private void llenarTablaCliente() {
        ConsultasCliente.buscarTodosLosProductos(ModeloTablaCliente.getModeloTabla());
        VistaBusquedaPorDescripcion.Tabla.setModel(ModeloTablaCliente.getModeloTabla());
    }

    
   
}
