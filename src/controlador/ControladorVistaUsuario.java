/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.ConsultasUsuario;
import modelo.ModeloBusquedaEmpleados;
import modelo.ModeloUsuario;
import modelo.ModeloUsuario;
import vista.VistaUsuarios;
import vista.VistaBusquedaEmpleados;
import vista.VistaUsuarios;


/**
 *
 * @author Ryzen
 */
public class ControladorVistaUsuario implements MouseListener{
    ModeloUsuario ModeloUsuario;
   VistaUsuarios VistaUsuarios;

    private ConsultasUsuario ConsultasUsuario = new ConsultasUsuario();

    public ControladorVistaUsuario(ModeloUsuario ModeloUsuario, VistaUsuarios VistaUsuarios) {
        this.ModeloUsuario = ModeloUsuario;
        this.VistaUsuarios = VistaUsuarios;
        oyentes();
        this.VistaUsuarios.setVisible(true);
    }
    private String encriptarPassword(String Password) throws NoSuchAlgorithmException {
        MessageDigest Md = MessageDigest.getInstance("MD5");
        Md.update(Password.getBytes(), 0, Password.length());
        return new BigInteger(1,Md.digest()).toString(16);
    }


    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==VistaUsuarios.BtnGuardar){
            try {
                guardar();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }else if(me.getSource()==VistaUsuarios.BtnActualizar){
            try {
                modificar();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }else if(me.getSource()==VistaUsuarios.BtnEliminar){
            eliminar();
        }else if(me.getSource()==VistaUsuarios.BtnBuscar){
            buscar();
        }else if(me.getSource()==VistaUsuarios.BtnSalir){
            salir();
        }else if(me.getSource()==VistaUsuarios.LblSearch){
            busquedaMVC();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource()==VistaUsuarios.LblSearch){
            VistaUsuarios.LblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    private void oyentes() {
        VistaUsuarios.BtnActualizar.addMouseListener(this);
        VistaUsuarios.BtnBuscar.addMouseListener(this);
        VistaUsuarios.BtnEliminar.addMouseListener(this);
        VistaUsuarios.BtnGuardar.addMouseListener(this);
        VistaUsuarios.BtnSalir.addMouseListener(this);
        VistaUsuarios.LblSearch.addMouseListener(this);
    }

    private void llenarModeloConVista() throws NoSuchAlgorithmException {
        ModeloUsuario.setUsuario(VistaUsuarios.TxtUser.getText());

        String PasswordSinEncriptar = new String(VistaUsuarios.TxtPassword.getText());
        String PassEnctriptado = encriptarPassword(PasswordSinEncriptar);
        // System.out.println(encriptarPassword(PasswordSinEncriptar));

        ModeloUsuario.setPasswors(PassEnctriptado);


        ModeloUsuario.setNombre(VistaUsuarios.TxtNombre.getText());
        ModeloUsuario.setTipo(VistaUsuarios.TxtTipo.getText());
    }

    private void llenarVistaConModelo(){
        VistaUsuarios.TxtUser.setText(ModeloUsuario.getUsuario()+"");
        VistaUsuarios.TxtPassword.setText(ModeloUsuario.getPasswors()+"");
        VistaUsuarios.TxtNombre.setText(ModeloUsuario.getNombre()+"");
        VistaUsuarios.TxtTipo.setText(ModeloUsuario.getTipo()+"");

    }

    private void limpiarCampos(){
        VistaUsuarios.TxtUser.setText("");
        VistaUsuarios.TxtPassword.setText("");
        VistaUsuarios.TxtNombre.setText("");
        VistaUsuarios.TxtTipo.setText("");

    }


    private boolean validarCampoCodigo(){
        if(VistaUsuarios.TxtUser.getText().isEmpty())
            return false;
        else
            return true;
    }

    private boolean validarTodosLosCampos(){
        if(VistaUsuarios.TxtUser.getText().isEmpty()||
                VistaUsuarios.TxtPassword.getText().isEmpty()||
                VistaUsuarios.TxtNombre.getText().isEmpty()||
                VistaUsuarios.TxtTipo.getText().isEmpty())
            return false;
        else
            return true;
    }

    private void guardar() throws NoSuchAlgorithmException {
        if (validarTodosLosCampos()) {
            ModeloUsuario.setUsuario(VistaUsuarios.TxtUser.getText());
            if (ConsultasUsuario.buscar(ModeloUsuario)==true) {
                JOptionPane.showMessageDialog(VistaUsuarios,"Ese Empleado ya existe");
            }else{
                llenarModeloConVista();
                if (ConsultasUsuario.insertar(ModeloUsuario)==true) {
                    JOptionPane.showMessageDialog(null,"Registro guardado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(null,"El campo codigo no debe estar vacio");

                }
            }

        }else{
            JOptionPane.showMessageDialog(null,"El campo codigo no debe estar vacio");

        }
    }

    private void modificar() throws NoSuchAlgorithmException {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();

            ModeloUsuario ModeloTemporal = new ModeloUsuario();
            ModeloTemporal.setUsuario(VistaUsuarios.TxtUser.getText());

            if (ConsultasUsuario.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaUsuarios,"Ese Empleado no existe");
            }else{
                if (ConsultasUsuario.modificar(ModeloUsuario)) {
                    JOptionPane.showMessageDialog(VistaUsuarios,"Registro modificado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(null,"Error al modificar el registro");
                }
            }


        }else{
            JOptionPane.showMessageDialog(null,"Los campos no deben estar vacíos");
        }
    }


    private void eliminar() {
        if (validarCampoCodigo()) {
            ModeloUsuario.setUsuario(VistaUsuarios.TxtUser.getText());
            if (ConsultasUsuario.buscar(ModeloUsuario)==false) {
                JOptionPane.showMessageDialog(VistaUsuarios,"Ese Empleado no existe");
            }else{
                if (ConsultasUsuario.eliminar(ModeloUsuario)) {
                    JOptionPane.showMessageDialog(VistaUsuarios,"Registro eliminado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaUsuarios,"Error al eliminar el registro");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"El campo codigo no debe de estar vacio");
        }
    }

    private void buscar() {
        if (validarCampoCodigo()) {
            ModeloUsuario.setUsuario(VistaUsuarios.TxtUser.getText());
            if (ConsultasUsuario.buscar(ModeloUsuario)==true) {
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(VistaUsuarios,"registro no existe");
            }
        }else{
            JOptionPane.showConfirmDialog(null,"Los campos no debe de estar vacio");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaUsuarios,"¿Deseas salir de Usuarios?","ALERTA!",0,1);
        if (opc == 0)VistaUsuarios.dispose();
    }

    private void busquedaMVC() {
//        ModeloBusquedaEmpleados ModeloBusquedaEmpleados = new ModeloBusquedaEmpleados();
//
//        VistaBusquedaEmpleados VistaBusquedaEmpleados = new VistaBusquedaEmpleados(new JFrame(),true);
//
//        ControladorVistaBusquedaEmpleados ControladorSerach = new ControladorVistaBusquedaEmpleados(ModeloBusquedaEmpleados, ModeloUsuario,VistaBusquedaEmpleados);
//
//        llenarVistaConModelo();
    }





}
