/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ryzen
 */
public class ModeloBusquedaEmpleados {
    DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloBusquedaEmpleados() {
        ModeloTabla.addColumn("Codigo");
        ModeloTabla.addColumn("Nombre");
        ModeloTabla.addColumn("Direccion");
        ModeloTabla.addColumn("Entrada");
        ModeloTabla.addColumn("Salida");
        ModeloTabla.addColumn("Telefono");
        ModeloTabla.addColumn("Sueldo");
    }
    
     
    //

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}
