/*
 * 
 */
package controlador;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;
import modelo.ModeloEmpleado;
import modelo.ModeloProveedor;
import modelo.ModeloUsuario;
import vista.VistaCliente;
import vista.VistaEmpleado;
import vista.VistaPantallaPrincipal;
import vista.VistaProveedor;
import vista.VistaUsuarios;

public class ControladorVistaPantallaPrincipal implements MouseListener{
    //variables globales
     VistaPantallaPrincipal VistaPantallaPrincipal;//no es el original
     
     //MV usuarios
     ModeloUsuario ModeloUsuario = new ModeloUsuario();
     //VistaUsuario VistaUsuario = new VistaUsuario();
     //MV Proveedor
     ModeloProveedor ModeloProveedor = new ModeloProveedor();
     VistaProveedor VistaProveedor = new VistaProveedor(new JFrame(),true);

    public ControladorVistaPantallaPrincipal(VistaPantallaPrincipal VistaPantallaPrincipal) {
        this.VistaPantallaPrincipal = VistaPantallaPrincipal;
        this.VistaPantallaPrincipal.setVisible(true);
        oyentes();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==VistaPantallaPrincipal.LblExit) {
            int opc = JOptionPane.showConfirmDialog(null,"¿Deseas Salir?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(opc==0) 
                System.exit(0);
        }else if(me.getSource()== VistaPantallaPrincipal.LblCarrito){
            ModeloProveedor ModeloProveedor = new ModeloProveedor();
            VistaProveedor VistaProveedor = new VistaProveedor(new JFrame(),true);
            ControladorVistaProveedor CVP = new ControladorVistaProveedor(ModeloProveedor, VistaProveedor);
        }else if(me.getSource()== VistaPantallaPrincipal.LblUsuario){
            ModeloUsuario ModeloUsuario = new ModeloUsuario();
            VistaUsuarios VistaUsuarios = new VistaUsuarios(new JFrame(), true);
            ControladorVistaUsuario CVU = new ControladorVistaUsuario(ModeloUsuario, VistaUsuarios);
            
        }else if(me.getSource()== VistaPantallaPrincipal.LblMinimizar){
            VistaPantallaPrincipal.setExtendedState(Frame.ICONIFIED);
        }else if(me.getSource()==VistaPantallaPrincipal.LblEmpleados){
            ModeloEmpleado ModeloEmpleado = new ModeloEmpleado();
            VistaEmpleado VistaEmpleado = new VistaEmpleado(new JFrame(),true);
            ControladorVistaEmpleado CVE = new ControladorVistaEmpleado(ModeloEmpleado, VistaEmpleado);
        }else if(me.getSource()==VistaPantallaPrincipal.LblClientes){
            ModeloCliente ModeloCliente = new ModeloCliente();
            VistaCliente VistaCliente = new VistaCliente(new JFrame(), true);
            ControladorVistaCliente CVC = new ControladorVistaCliente(ModeloCliente, VistaCliente);
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
        if(me.getSource()==VistaPantallaPrincipal.LblExit){
            VistaPantallaPrincipal.LblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            VistaPantallaPrincipal.LblExit.setToolTipText("Salir del Sistema");
        }else if(me.getSource()==VistaPantallaPrincipal.LblCarrito){
            VistaPantallaPrincipal.LblCarrito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            VistaPantallaPrincipal.LblCarrito.setToolTipText("Proveedores");
        }else if(me.getSource()==VistaPantallaPrincipal.LblUsuario){
            VistaPantallaPrincipal.LblUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            VistaPantallaPrincipal.LblUsuario.setToolTipText("Administración de Usuarios");
        }else if(me.getSource()==VistaPantallaPrincipal.LblMinimizar){
            VistaPantallaPrincipal.LblMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            VistaPantallaPrincipal.LblMinimizar.setToolTipText("Minimizar");
        }else if(me.getSource()==VistaPantallaPrincipal.LblArticulos){
            VistaPantallaPrincipal.LblArticulos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            VistaPantallaPrincipal.LblArticulos.setToolTipText("Articulos");
        }else if(me.getSource()==VistaPantallaPrincipal.LblClientes){
            VistaPantallaPrincipal.LblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            VistaPantallaPrincipal.LblClientes.setToolTipText("Clientes");
        }else if(me.getSource()==VistaPantallaPrincipal.LblEmpleados){
            VistaPantallaPrincipal.LblEmpleados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            VistaPantallaPrincipal.LblEmpleados.setToolTipText("Empleados");}
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    private void oyentes() {
        VistaPantallaPrincipal.LblExit.addMouseListener(this);
        VistaPantallaPrincipal.LblCarrito.addMouseListener(this);
        VistaPantallaPrincipal.LblMinimizar.addMouseListener(this);
        VistaPantallaPrincipal.LblUsuario.addMouseListener(this);
        VistaPantallaPrincipal.LblArticulos.addMouseListener(this);
        VistaPantallaPrincipal.LblClientes.addMouseListener(this);
        VistaPantallaPrincipal.LblEmpleados.addMouseListener(this);
    }
    

}
