
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emmanuel Ruiz
 */
public class ModeloTablaCliente {
    
    DefaultTableModel ModeloTabla = new DefaultTableModel();
    
    //Configura los encabezados de la tabla
   public ModeloTablaCliente(){
       ModeloTabla.addColumn("Codigo");
       ModeloTabla.addColumn("Nombre");
       ModeloTabla.addColumn("Direccion");
       ModeloTabla.addColumn("Ciudad");
       ModeloTabla.addColumn("Edad");
       ModeloTabla.addColumn("Correo");
       ModeloTabla.addColumn("FechaIngreso");
       ModeloTabla.addColumn("Telefono");
   }
    //Retorna el modelo de la tabla 

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
   
}
