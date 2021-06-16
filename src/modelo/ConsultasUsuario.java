package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasUsuario extends Conexion{
    Connection Con = getConexion();
    
    public boolean buscarLogin(ModeloUsuario Modelo) throws SQLException{
        try {
            PreparedStatement Ps;
            String SQL = "select * from usuario where User = ? and Password = ?";
            Ps = Con.prepareCall(SQL);
            
            //remplaza a los ? del String Sql con los datos del modelo
            Ps.setString(1, Modelo.getUsuario());
            Ps.setString(2, Modelo.getPasswors());
            ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) {
                Modelo.setNombre(Rs.getString("nombre"));
                Modelo.setTipo(Rs.getString("tipo"));
                return true;
            }
            return false;
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Error: " +e);
        return false;
    }
    }

    public boolean insertar(ModeloUsuario modeloUsuario){
        try {
            PreparedStatement Ps;
            String SQL =
                    "insert into usuario (User, Password,Nombre,Tipo) values (?,?,?,?)";
            Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setString(1,modeloUsuario.getUsuario()); //interrogante 1
            Ps.setString(2,modeloUsuario.getPasswors()); //Interrogante 2
            Ps.setString(3,modeloUsuario.getNombre()); //Interrogante 3
            Ps.setString(4,modeloUsuario.getTipo()); //Interrogante 4
            Ps.executeUpdate(); //Ejecutar la consulta SQL
            return true;
        } catch (SQLException e) {//Se cacha un posible error
            JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n "+e);
            return false; //Algo salió mal
        }
    }

    public boolean modificar (ModeloUsuario modeloUsuario){
        try {
            PreparedStatement Ps;
            String SQL =
                    "update usuario set Password=?,Nombre=?, Tipo=? where User=?";
            Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setString(1,modeloUsuario.getPasswors()); //interrogante 1
            Ps.setString(2,modeloUsuario.getNombre()); //Interrogante 2
            Ps.setString(3,modeloUsuario.getTipo()); //Interrogante 3
            Ps.setString(4,modeloUsuario.getUsuario()); //Interrogante 4
            Ps.executeUpdate(); //Ejecutar la consulta SQL
            return true;
        } catch (SQLException e) {//Se cacha un posible error
            JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n "+e);
            return false; //Algo salió mal
        }
    }
    public boolean eliminar (ModeloUsuario modeloUsuario){
        try {
            PreparedStatement Ps;
            String SQL =
                    "delete from usuario where User=?";
            Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setString(1,modeloUsuario.getUsuario()); //interrogante 1
            Ps.executeUpdate(); //Ejecutar la consulta SQL
            return true;
        } catch (SQLException e) {//Se cacha un posible error
            JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n "+e);
            return false; //Algo salió mal
        }
    }
    public boolean buscar(ModeloUsuario modeloTemporal){
        try {
            PreparedStatement Ps;
            String SQL =
                    "SELECT * FROM usuario where User = ?";
            Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setString(1,modeloTemporal.getUsuario()); //interrogante 1
            ResultSet Rs = Ps.executeQuery();//Para obtener resultados
            if (Rs.next()) {
                modeloTemporal.setPasswors(Rs.getString("password"));
                modeloTemporal.setNombre(Rs.getString("nombre"));
                modeloTemporal.setTipo(Rs.getString("tipo"));
                return true;//Todo está bien
            }
            return false; //No encontro el dato buscado
        } catch (SQLException e) {//Se cacha un posible error
            JOptionPane.showMessageDialog(null,"Error SQL: buscar()\n "+e);
            return false; //Algo salió mal
        }
    }
}