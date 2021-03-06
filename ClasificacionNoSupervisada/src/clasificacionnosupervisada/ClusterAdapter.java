/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacionnosupervisada;

import clasificadores.CMeans;
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
        
        CMeans clasificador  = new CMeans(instancias, c);
        clasificador.clasifica();
        Patron[] centroidesUltimos = clasificador.getCentroides().get(clasificador.getCentroides().size()-1);
        // vamos a modificar los valores de la instancias 
        BufferedImage imagenClusterizada = 
                new BufferedImage(this.imagenOriginal.getWidth(),
                        this.imagenOriginal.getHeight(),BufferedImage.TYPE_INT_RGB);
        //recorremos las instancias 
        for (Patron patron: instancias){
          String nombre = patron.getClase();
          // recorremos los ultimos centroides
          for(int y = 0; y < centroidesUltimos.length;y++){
             if (nombre.equals(centroidesUltimos[y].getClase())){
               // mandamos los valores al pixel de la imagen nueva
               int rgb = centroidesUltimos[y].obtenerRGB();
               imagenClusterizada.setRGB(patron.getX(), patron.getY(), rgb);
             break;
             }
          
          }
         
        }
              
        return imagenClusterizada;
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
            Patron paux = new Patron(valores, "Desconocidos");
            paux.setX(x);
            paux.setY(y);
            instancias.add(paux);
           }   
        
        return instancias;
    }
    
    
            
    
    
}
