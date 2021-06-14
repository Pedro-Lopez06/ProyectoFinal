
package vista;



import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Pedro Lopez
 */
public class VistaLogin extends JFrame{
    //ImageIcon FondoLogin = new ImageIcon(getClass().getResource("/imagenes/fondoLogin.jpg"));
    //PanelImagen Panel = new PanelImagen(FondoLogin);
    ImageIcon usr = new ImageIcon(getClass().getResource("/imagenes/user.png"));
    public JLabel lblusr = new JLabel(usr);
    ImageIcon pass = new ImageIcon(getClass().getResource("/imagenes/padlock.png"));
    public  JLabel lblpass = new JLabel(pass);
    
    public JTextField nick = new JTextField();
    public JPasswordField password = new JPasswordField();
    
    public JButton enter = new JButton("Enter");
    
    public JLabel etiquetaNick = new JLabel("Usuario");
    public JLabel etiquetaPassword = new JLabel("Contraseña");
    public JLabel rememberMe = new JLabel("Recordar");
    
    public JCheckBox check = new JCheckBox();
    
    public VistaLogin() {
        configuracion();
        botones();
        cajasDeTexto();
        etiquetas();
        checkbox();
        
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Zapateria Torres Gemelas");
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(46,144,232));
        
    }

    

    private void botones() {
         enter.setBounds(229,152,70,20);
         this.add(enter);
    }

    private void cajasDeTexto() {
        nick.setBounds(140, 50, 160, 30);
        password.setBounds(140, 120, 160, 30);
        
        this.add(nick);
        this.add(password);
    }

    private void etiquetas() {
        etiquetaNick.setBounds(140, 20, 120, 30);
        etiquetaPassword.setBounds(140, 90, 120, 30);
        lblusr.setBounds(120, 50, 16, 30);
        lblpass.setBounds(120, 120, 16, 30);
        rememberMe.setBounds(163, 145, 120, 30);
        
        this.add(etiquetaNick);
        this.add(etiquetaPassword);
        this.add(lblusr);
        this.add(lblpass);
        this.add(rememberMe);
        
    }

    private void checkbox() {
        check.setBounds(140, 152, 15, 15);
        
        check.setBackground(new Color(46,144,232));
        this.add(check);
    }


}
