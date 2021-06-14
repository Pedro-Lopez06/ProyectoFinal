
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
 * @author Emmanuel Ruiz
 */
public class ConsultasCliente extends Conexion{
    Connection Con = getConexion();
    
    public boolean insertar(ModeloCliente Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "insert into cliente (Codigo, Nombre, Direccion, Ciudad, Edad, Correo, FechaIngreso, Telefono) values (?,?,?,?,?,?,?,?)";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       Ps.setString(2,Modelo.getNombre()); //Interrogante 2
       Ps.setString(3,Modelo.getDireccion()); //Interrogante 3
       Ps.setString(4,Modelo.getCiudad()); //Interrogante 4
       Ps.setString(5,Modelo.getEdad()); //Interrogante 5
       Ps.setString(6,Modelo.getCorreo()); //Interrogante 6
       Ps.setString(7,Modelo.getFechaIngreso()); //Interrogante 7
       Ps.setString(8,Modelo.getTelefono()); //Interrogante 8
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n "+e);
       return false; //Algo salió mal
   }
   }

   public boolean modificar (ModeloCliente Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "update cliente set Nombre=?, Direccion=?, Ciudad=?, Edad=?, Correo=?, FechaIngreso=?, Telefono=? where Codigo=?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setString(1,Modelo.getNombre()); //Interrogante 1
       Ps.setString(2,Modelo.getDireccion()); //Interrogante 2
       Ps.setString(3,Modelo.getCiudad()); //Interrogante 3
       Ps.setString(4,Modelo.getEdad()); //Interrogante 4
       Ps.setString(5,Modelo.getCorreo()); //Interrogante 5
       Ps.setString(6,Modelo.getFechaIngreso()); //Interrogante 6
       Ps.setString(7,Modelo.getTelefono()); //Interrogante 7
       Ps.setInt(8,Modelo.getCodigo()); //interrogante 8
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n "+e);
       return false; //Algo salió mal
   }
}
   public boolean eliminar (ModeloCliente Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "delete from  cliente where Codigo=?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n "+e);
       return false; //Algo salió mal
   }
}
   public boolean buscar(ModeloCliente Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "SELECT * FROM cliente where Codigo = ?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       ResultSet Rs = Ps.executeQuery();//Para obtener resultados
       if (Rs.next()) {
           Modelo.setCodigo(Rs.getInt("Codigo"));
           Modelo.setNombre(Rs.getString("Nombre"));
           Modelo.setDireccion(Rs.getString("Direccion"));
           Modelo.setCiudad(Rs.getString("Ciudad"));
           Modelo.setEdad(Rs.getString("Edad"));
           Modelo.setCorreo(Rs.getString("Correo"));
           Modelo.setFechaIngreso(Rs.getString("FechaIngreso"));
           Modelo.setTelefono(Rs.getString("Telefono"));
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
        String SQL = "select * from cliente order by Codigo";
        Ps = Con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Rs.getMetaData().getColumnCount();
        while (Rs.next()) {
            Object Fila[] = new Object[numeroDeCampos];
            Fila[0] = Rs.getInt("Codigo");
            Fila[1] = Rs.getString("Nombre");
            Fila[2] = Rs.getString("Direccion");
            Fila[3] = Rs.getString("Ciudad");
            Fila[4] = Rs.getString("Edad");
            Fila[5] = Rs.getString("Correo");
            Fila[6] = Rs.getString("FechaIngreso");
            Fila[7] = Rs.getString("Telefono");
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
        String SQL = "select * from cliente where Codigo like '%"+
                TxtConsultar.getText()+"%'";
        Ps = Con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Ps.getMetaData().getColumnCount();
        ModeloTabla.setRowCount(0);
        while(Rs.next()){
            String Fila[] = new String[numeroDeCampos];
            Fila[0] = Rs.getInt("Codigo")+"";
            Fila[1] = Rs.getString("Nombre"+"");
            Fila[2] = Rs.getString("Direccion")+"";
            Fila[3] = Rs.getString("Ciudad"+"");
            Fila[4] = Rs.getString("Edad"+"");
            Fila[5] = Rs.getString("Correo");
            Fila[6] = Rs.getString("FechaIngreso");
            Fila[7] = Rs.getString("Telefono");
            ModeloTabla.addRow(Fila);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: buscarFrase()\n"+ e);
    }
        }

}
