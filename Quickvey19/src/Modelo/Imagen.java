package Modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Imagen extends javax.swing.JPanel {
    String rutaImagen;
    
    public Imagen (int x, int y, String rutaImagen) {
        this.setSize(x, y);
        this.rutaImagen = rutaImagen;
    }
    
    public void paint(Graphics g){
        Dimension dimension = this.getSize();
        ImageIcon imagen = new ImageIcon(getClass().getResource(this.rutaImagen));
        g.drawImage(imagen.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
