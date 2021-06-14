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
 * @author 52375
 */
public class ConsultasProveedor extends Conexion{
    Connection con = getConexion(); 
    
    public boolean insertar(ModeloProveedor Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "insert into proveedores (codigo, Nombre, Direccion, Empresa, Cel, Correo, RFC, Telefono) values (?,?,?,?,?,?,?,?)";
       Ps = con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       Ps.setString(2,Modelo.getNombre()); //Interrogante 2
       Ps.setString(3,Modelo.getDireccion()); //Interrogante 3
       Ps.setString(4,Modelo.getEmpresa()); //Interrogante 4
       Ps.setString(5,Modelo.getCel()); //Interrogante 5
       Ps.setString(6,Modelo.getCorreo()); //Interrogante 6
       Ps.setString(7,Modelo.getRFC()); //Interrogante 7
       Ps.setString(8,Modelo.getTelefono()); //Interrogante 8
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n "+e);
       return false; //Algo salió malSAsa
   }
   }
     public boolean modificar (ModeloProveedor Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "update proveedores set Nombre=?,Empresa=?,Telefono=?,Correo=?,Direccion=?,RFC=?,Cel=? where codigo=?";
       Ps = con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setString(1,Modelo.getNombre()); //interrogante 1
       Ps.setString(2,Modelo.getEmpresa()); //Interrogante 2
       Ps.setString(3,Modelo.getTelefono()); //Interrogante 3
       Ps.setString(4,Modelo.getCorreo()); //Interrogante 4
       Ps.setString(5,Modelo.getDireccion()); //Interrogante 5
       Ps.setString(6,Modelo.getRFC()); //Interrogante 6
       Ps.setString(7,Modelo.getCel()); //Interrogante 7
       Ps.setInt(8,Modelo.getCodigo()); //Interrogante 8
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n "+e);
       return false; //Algo salió mal
   }
}
     public boolean eliminar (ModeloProveedor Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "delete from proveedores where codigo=?";
       Ps = con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n "+e);
       return false; //Algo salió mal
   }
}
     
   public boolean buscar(ModeloProveedor Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "SELECT * FROM proveedores WHERE codigo=?";
       Ps = con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       ResultSet Rs = Ps.executeQuery();//Para obtener resultados
       if (Rs.next()) {
           Modelo.setCodigo(Rs.getInt("codigo"));
           Modelo.setNombre(Rs.getString("Nombre"));
           Modelo.setEmpresa(Rs.getString("Empresa"));
           Modelo.setTelefono(Rs.getString("Telefono"));
           Modelo.setCorreo(Rs.getString("Correo"));
           Modelo.setDireccion(Rs.getString("Direccion"));
           Modelo.setRFC(Rs.getString("RFC"));
           Modelo.setCel(Rs.getString("Cel"));
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
        String SQL = "select * from proveedores order by codigo";
        Ps = con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Rs.getMetaData().getColumnCount();
        while (Rs.next()) {
            Object Fila[] = new Object[numeroDeCampos];
            Fila[0] = Rs.getInt("codigo");
            Fila[1] = Rs.getString("Nombre");
            Fila[2] = Rs.getString("Empresa");
            Fila[3] = Rs.getString("Telefono");
            Fila[4] = Rs.getString("Correo");
            Fila[5] = Rs.getString("Direccion");
            Fila[6] = Rs.getString("RFC");
            Fila[7] = Rs.getString("Cel");
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
        String SQL = "select * from proveedores where codigo like '%"+
                TxtConsultar.getText()+"%'";
        Ps = con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Ps.getMetaData().getColumnCount();
        ModeloTabla.setRowCount(0);
        while(Rs.next()){
            String Fila[] = new String[numeroDeCampos];
            Fila[0] = Rs.getInt("codigo")+"";
            Fila[1] = Rs.getString("Nombre"+"");
            Fila[2] = Rs.getString("Empresa")+"";
            Fila[3] = Rs.getString("Telefono"+"");
            Fila[4] = Rs.getString("Correo"+"");
            Fila[5] = Rs.getString("Direccion");
            Fila[6] = Rs.getString("RFC");
            Fila[7] = Rs.getString("Cel");
            ModeloTabla.addRow(Fila);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: buscarFrase()\n"+ e);
    }
}
   
}
