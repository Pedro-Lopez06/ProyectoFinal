/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author 52375
 */
public class PanelImagen extends  JPanel{
    ImageIcon ImagenFondo;

    public PanelImagen(ImageIcon ImagenFondo) {
        this.ImagenFondo = ImagenFondo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension tam = getSize();
        g.drawImage(ImagenFondo.getImage(),0,0,tam.width,tam.height,null);
    }
    
}
