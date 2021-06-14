
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.ConsultasProveedor;
import modelo.ModeloProveedor;
import modelo.ModeloTablaProveedor;
import vista.VistaBusquedaPorDescripcion;


public class ControladorBusquedaPorDescripcion implements MouseListener, KeyListener{
    ModeloTablaProveedor ModeloTablaProveedor;//Modelo para la tabla
    ModeloProveedor ModeloProveedor;//Modelo Provvedor
    VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion;//vista para la ventana de busqueda
    ConsultasProveedor ConsultasProveedor = new ConsultasProveedor();//objeto para hacer consultas

    //public ControladorBusquedaPorDescripcion(ModeloTablaProveedor ModeloTablaProveedor, ModeloProveedor ModeloProveedor, 
           // VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion) {
    
    
    public ControladorBusquedaPorDescripcion(ModeloTablaProveedor ModeloTablaProveedor, ModeloProveedor ModeloProveedor,
            VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion) {
        
        this.ModeloTablaProveedor = ModeloTablaProveedor;//apunta al original
        this.ModeloProveedor = ModeloProveedor;
        this.VistaBusquedaPorDescripcion = VistaBusquedaPorDescripcion;
        //Toma el modelo de la tabla le coloca los campos, encabezados etc...
        VistaBusquedaPorDescripcion.Tabla.setModel(ModeloTablaProveedor.getModeloTabla());
        
        oyentes();
        llenarTablaProveedor();
        VistaBusquedaPorDescripcion.setVisible(true);
    }

    
    

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==VistaBusquedaPorDescripcion.BtnAceptar) {
            VistaBusquedaPorDescripcion.dispose();
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
        if (ke.getSource()==VistaBusquedaPorDescripcion.TxtNombre) {
            ConsultasProveedor.buscarFrase(VistaBusquedaPorDescripcion.TxtNombre, ModeloTablaProveedor.getModeloTabla());
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

    private void llenarTablaProveedor() {
        //consulta la tabla proveedor y llena el modelo con todos los registros
        ConsultasProveedor.buscarTodosLosProductos(ModeloTablaProveedor.getModeloTabla());
        //actiliaza la vista de la tabla con el modelo y todos los datos agregados
        VistaBusquedaPorDescripcion.Tabla.setModel(ModeloTablaProveedor.getModeloTabla());
    }
    
}
