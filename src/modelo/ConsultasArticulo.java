/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jony_
 */

public class ConsultasArticulo extends Conexion{
    Connection Con = getConexion();
    
    public boolean insertar(ModeloArticulo Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "insert into articulo (Codigo, Descripcion, Marca, Color, PrecioPublico, PrecioProveedor, Stock) values (?,?,?,?,?,?,?)";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       Ps.setString(2,Modelo.getDescripcion()); //Interrogante 2
       Ps.setString(3,Modelo.getMarca()); //Interrogante 3
       Ps.setString(4,Modelo.getColor()); //Interrogante 4
       Ps.setInt(5,Modelo.getPrecioPublico()); //Interrogante 5
       Ps.setInt(6,Modelo.getPrecioProveedor()); //Interrogante 6
       Ps.setString(7,Modelo.getStock()); //Interrogante 7
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n "+e);
       return false; //Algo salió mal
   }
   }

   public boolean modificar (ModeloArticulo Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "update articulo set Codigo=?, Descripcion=?, Marca=?, Color=?, PrecioPublico=?, PrecioProveedor=?, Stock=?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       Ps.setString(2,Modelo.getDescripcion()); //Interrogante 2
       Ps.setString(3,Modelo.getMarca()); //Interrogante 3
       Ps.setString(4,Modelo.getColor()); //Interrogante 4
       Ps.setInt(5,Modelo.getPrecioPublico()); //Interrogante 5
       Ps.setInt(6,Modelo.getPrecioProveedor()); //Interrogante 6
       Ps.setString(7,Modelo.getStock()); //Interrogante 7
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n "+e);
       return false; //Algo salió mal, o no!!
   }
}
   public boolean eliminar (ModeloArticulo Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "delete from articulo where Codigo=?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n "+e);
       return false; //Algo salió mal
   }
}
   public boolean buscar(ModeloArticulo Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "SELECT * FROM articulo where Codigo = ?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       ResultSet Rs = Ps.executeQuery();//Para obtener resultados
       if (Rs.next()) {
           Modelo.setCodigo(Rs.getInt("Codigo"));
           Modelo.setDescripcion(Rs.getString("Descripcion"));
           Modelo.setColor(Rs.getString("Marca"));
           Modelo.setMarca(Rs.getString("Color"));
           Modelo.setPrecioProveedor(Rs.getInt("PrecioPublico"));
           Modelo.setPrecioPublico(Rs.getInt("PrecioProveedor"));
           Modelo.setStock(Rs.getString("Stock"));
           return true;//Todo está bien
       }
       return false; //No encontro el dato buscado
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: buscar()\n "+e);
       return false; //Algo salió mal
   }
   }
   public boolean buscarTodosLosProductos(DefaultTableModel Modelo) {
    try {
        PreparedStatement Ps;
        String SQL = "select * from articulo order by Codigo";
        Ps = Con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Rs.getMetaData().getColumnCount();
        while (Rs.next()) {
            Object Fila[] = new Object[numeroDeCampos];
            Fila[0] = Rs.getInt("Codigo");
            Fila[1] = Rs.getString("Descripcion");
            Fila[2] = Rs.getString("Marca");
            Fila[3] = Rs.getString("Color");
            Fila[4] = Rs.getInt("PrecioPublico");
            Fila[5] = Rs.getInt("PrecioProveedor");
            Fila[6] = Rs.getString("Stock");
            Modelo.addRow(Fila);
            }
        return true;
    } catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: buscarTodosLosProductos()\n"+ e);
         return false;
    }
   } 
   public void buscarFrase (JTextField TxtConsultar, DefaultTableModel ModeloTabla){
    try {
        PreparedStatement Ps;
        String SQL = "select * from articulo where Codigo like '%"+
                TxtConsultar.getText()+"%'";
        Ps = Con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Ps.getMetaData().getColumnCount();
        ModeloTabla.setRowCount(0);
        while(Rs.next()){
            String Fila[] = new String[numeroDeCampos];
            Fila[0] = Rs.getInt("Codigo")+"";
            Fila[1] = Rs.getString("Descripcion");
            Fila[2] = Rs.getString("Marca");
            Fila[3] = Rs.getString("Color");
            Fila[4] = Rs.getInt("PrecioPublico")+"";
            Fila[5] = Rs.getInt("PrecioProveedor")+"";
            Fila[6] = Rs.getString("Stock");
            ModeloTabla.addRow(Fila);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: buscarFrase()\n"+ e);
    }
        }

}
