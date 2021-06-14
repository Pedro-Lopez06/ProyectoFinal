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
}