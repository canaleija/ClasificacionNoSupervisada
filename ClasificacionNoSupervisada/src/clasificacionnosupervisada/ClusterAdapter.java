/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacionnosupervisada;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import objetos.Patron;
import sun.java2d.pipe.hw.BufferedContextProvider;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ClusterAdapter {
    
    private BufferedImage imagenOriginal;
    private int c;

    public ClusterAdapter(BufferedImage imagenOriginal, int c) {
        this.imagenOriginal = imagenOriginal;
        this.c = c;
    }
    // clusterizar
    public BufferedImage clusterizar(){
        
        // generar las instancias que necesitará C-means
        ArrayList<Patron> instancias = generaInstancias();
        // imagen resultante de la clusterización
        BufferedImage imagenClusterizada = null;

         
        return this.imagenOriginal;
    }

 
    private ArrayList<Patron> generaInstancias() {
        ArrayList<Patron> instancias = new ArrayList<>();
              
        for (int x=0; x < this.imagenOriginal.getWidth();x++)
           for (int y=0; y < this.imagenOriginal.getHeight();y++){
            Color color = new Color(this.imagenOriginal.getRGB(x, y));
            double[] valores = new double[3];
            valores[0] = color.getRed();
            valores[1] = color.getGreen();
            valores[2] = color.getBlue();
            instancias.add(new Patron(valores, "Desconocidos"));
           }   
        
        return instancias;
    }
    
    
            
    
    
}
