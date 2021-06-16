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
 * @author Ryzen
 */
public class ConsultasEmpleado extends Conexion{
    Connection con = getConexion();
     
    public boolean insertar(ModeloEmpleado Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
            "insert into empleado (Codigo,Nombre,Direccion,Entrada,Salida,Telefono,Sueldo) values (?,?,?,?,?,?,?)";
            Ps = con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
            Ps.setString(2,Modelo.getNombre());
            Ps.setString(3, Modelo.getDireccion());
            Ps.setString(4, Modelo.getEntrada());
            Ps.setString(5, Modelo.getSalida());
            Ps.setString(6, Modelo.getTelefono());
            Ps.setFloat(7, Modelo.getSueldo());
            Ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n "+e);
            return false; //Algo salió mal
        }
       
    }
    public boolean modificar (ModeloEmpleado Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
            "update empleado set Nombre=?,Direccion=?,Entrada=?,Salida=?,Telefono=?,Sueldo=? where Codigo=?";
            Ps = con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setInt(7,Modelo.getCodigo()); //interrogante 1
            Ps.setString(1,Modelo.getNombre());
            Ps.setString(2, Modelo.getDireccion());
            Ps.setString(3, Modelo.getEntrada());
            Ps.setString(4, Modelo.getSalida());
            Ps.setString(5, Modelo.getTelefono());
            Ps.setFloat(6, Modelo.getSueldo());
            Ps.executeUpdate(); //Ejecutar la consulta SQL
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n "+e);
            return false; //Algo salió mal
        }
    }
    public boolean eliminar (ModeloEmpleado Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
            "delete from empleado where Codigo=?";
            Ps = con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
            Ps.executeUpdate(); //Ejecutar la consulta SQL
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n "+e);
            return false; //Algo salió mal
        }
    }
    public boolean buscar(ModeloEmpleado Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
            "SELECT * FROM empleado WHERE Codigo=?";
            Ps = con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
            ResultSet Rs = Ps.executeQuery();//Para obtener resultados
            if (Rs.next()) {
                Modelo.setCodigo(Rs.getInt("Codigo"));
                Modelo.setNombre(Rs.getString("Nombre"));
                Modelo.setDireccion(Rs.getString("Direccion"));
                Modelo.setEntrada(Rs.getString("Entrada"));
                Modelo.setSalida(Rs.getString("Salida"));
                Modelo.setTelefono(Rs.getString("Telefono"));
                Modelo.setSueldo(Rs.getFloat("Sueldo"));
                return true;//Todo está bien
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: buscar()\n "+e);
            return false; //Algo salió mal
        }
    }
    public boolean buscarTodosLosEmpleados(DefaultTableModel Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "select * from empleado order by Nombre";
            Ps = con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Rs.getMetaData().getColumnCount();
            while (Rs.next()) {                
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getInt("Codigo");
                Fila[1] = Rs.getString("Nombre");
                Fila[2] = Rs.getString("Direccion");
                Fila[3] = Rs.getString("Entrada");
                Fila[4] = Rs.getString("Salida");
                Fila[5] = Rs.getString("Telefono");
                Fila[6] = Rs.getFloat("Sueldo");
                Modelo.addRow(Fila);
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: buscarTodosLosProductos()\n "+e);
            return false;
        }
    }
    public void buscarFrase(JTextField TxtConsultar, DefaultTableModel ModeloTabla) throws SQLException{
        
        try {
            PreparedStatement Ps;
            String SQL = "select * from empleado where Nombre like '%" + 
                    TxtConsultar.getText()+"%'";
            Ps = con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Ps.getMetaData().getColumnCount();
            ModeloTabla.setRowCount(0);
            while (Rs.next()) {            
                String Fila[] = new String[numeroDeCampos];
                Fila[0] =Rs.getInt("Codigo")+"";
                Fila[1] = Rs.getString("Nombre");
                Fila[2] = Rs.getString("Direccion");
                Fila[3] = Rs.getString("Entrada");
                Fila[4] = Rs.getString("Salida");
                Fila[5] = Rs.getString("Telefono");
                Fila[6] = Rs.getString("Sueldo")+"";
                
                ModeloTabla.addRow(Fila);
        } 
                         
        }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error SQL: buscarFrase()\n "+e);
        }
    }
}
