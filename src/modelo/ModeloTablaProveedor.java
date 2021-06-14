
package modelo;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaProveedor {
    DefaultTableModel ModeloTabla = new DefaultTableModel();
    
    //Configura los encabezados de la tabla
   public ModeloTablaProveedor(){
       ModeloTabla.addColumn("Codigo");
       ModeloTabla.addColumn("Nombre");
       ModeloTabla.addColumn("Empresa");
       ModeloTabla.addColumn("Telefono");
       ModeloTabla.addColumn("Correo");
       ModeloTabla.addColumn("Dirección");
       ModeloTabla.addColumn("RFC");
       ModeloTabla.addColumn("Cel");
   }
    //Retorna el modelo de la tabla 

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
   
}
