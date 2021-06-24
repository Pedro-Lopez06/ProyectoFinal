/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import vista.VistaLogin;
import vista.VistaPantallaPrincipal;

public class ControladorVistaLogin implements MouseListener{
    VistaLogin VistaLogin;
    ModeloUsuario ModeloUsuario;
    ConsultasUsuario ConsultasUsuario = new ConsultasUsuario();
    ControladorVistaLogin(VistaLogin VistaLogin, ModeloUsuario ModeloUsuario ) {
        this.VistaLogin = VistaLogin;
        this.ModeloUsuario = ModeloUsuario;
        VistaLogin.setVisible(true);
        oyentes();
    }

    ControladorVistaLogin(VistaLogin vistaLogin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void oyentes() {
        VistaLogin.enter.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== VistaLogin.enter) {
            try {
                buscarUsuarioPassWord();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error:"+ e);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControladorVistaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public boolean camposValidos(){
        if (VistaLogin.nick.getText().isEmpty() || VistaLogin.password.getPassword().length==0) {
            return false;
           
        }else
           return true;
    }
    private void llenarModeloConCampos() throws NoSuchAlgorithmException{
        ModeloUsuario.setUsuario(VistaLogin.nick.getText());
        //encriptar password
        String PasswordSinEncriptar = new String(VistaLogin.password.getPassword());
        String PasswordEncriptado = encriptarPassword(PasswordSinEncriptar);
        ModeloUsuario.setPasswors(PasswordEncriptado);
        System.out.println(PasswordEncriptado);
        ModeloUsuario.setNombre("");
        ModeloUsuario.setTipo("");
    }
    
    private void buscarUsuarioPassWord() throws SQLException, NoSuchAlgorithmException{
        if (camposValidos()==true) {
            llenarModeloConCampos();
            if (ConsultasUsuario.buscarLogin(ModeloUsuario)==true){
                JOptionPane.showMessageDialog(null, "Bienvenido: "+ModeloUsuario.getNombre(), "Tipo: "+ModeloUsuario.getTipo(),1); 
            //matar a la vista login
            this.VistaLogin.dispose();
            
            //cargar la vista y el controlador de la panatalla principal
                VistaPantallaPrincipal VistaPantallaPrincipal = new VistaPantallaPrincipal();
                ControladorVistaPantallaPrincipal ControladorVistaPantallaPrincipal = new ControladorVistaPantallaPrincipal(VistaPantallaPrincipal);
                if (!(ModeloUsuario.getTipo().equals("SuperAdministrador"))) {
                    VistaPantallaPrincipal.LblUsuario.setVisible(false);
                    VistaPantallaPrincipal.PanelArriba.setLayout(new GridLayout(1,5));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o Password Incorrecto");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debes de colocar texto en los campos Usuario y Password");
        }
    }
    //Metodo para encriptar Password con MD5
    private String encriptarPassword(String Password) throws NoSuchAlgorithmException{
        MessageDigest Md = MessageDigest.getInstance("MD5");
        Md.update(Password.getBytes(),0,Password.length());
        return new BigInteger(1,Md.digest()).toString(16); //retorna la cadena encriptada
    }
}