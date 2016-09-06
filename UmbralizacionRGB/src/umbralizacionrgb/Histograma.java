/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umbralizacionrgb;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Histograma {

    
    
    public enum Canal {ROJO,VERDE,AZUL}
    
    public static BufferedImage imagen; 
    private int[] valores;
    private String nombre;
    private Canal canal;

    public Histograma(String nombre, Canal canal) {
     this.nombre = nombre;
     this.canal = canal;
     this.valores = new int[256];
     calculaHistograma();
    }

    private void calculaHistograma() {
      for (int x=0; x< imagen.getWidth();x++ ){
         for (int y=0; y <imagen.getHeight();y++){
          int  valorRGB = imagen.getRGB(x, y);
          Color color = new Color(valorRGB);
             switch (this.canal){
                
                 case ROJO:{
                     int v = color.getRed();
                     if (v>255){
                     System.out.println(""+x+","+y+","+v+","+valorRGB);
                     }
                     this.getValores()[v]++;          
                    break;}
                 case VERDE:{
                     this.getValores()[color.getGreen()]++;  
                     break;}
                 case AZUL:{
                     this.getValores()[color.getBlue()]++;  
                     break;}
                 default:{this.valores = new int[256];}
                           
             }
           }
      }
    }

    @Override
    public String toString() {
        String aux = "";
        for (int x=0; x < this.getValores().length;x++){
         aux+=x+"\n";
        }
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the valores
     */
    public int[] getValores() {
        return valores;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
   
   
    
    
    
    
    
}
