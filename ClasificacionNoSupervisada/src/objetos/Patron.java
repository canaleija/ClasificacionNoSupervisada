/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.awt.Color;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Patron {
    
    // arreglo de doubles para crear como tal el patron
    private double[] vector;
    private String clase,claseRes;
    private int x,y;

    // constructor por defecto
    public Patron(int n) {
        this.vector = new double[n];
        this.clase = "Desconocida";
        this.claseRes = null;
        this.x = -1;
        this.y = -1;
    }
    public Patron(int n,String clase){
        this.vector = new double[n];
        this.clase = clase;
        this.claseRes = null;
        this.x = -1;
        this.y = -1;
    }
    public void setVector(double[] vector)
    {
        this.vector=vector;
    }

    public Patron(double[] vector, String clase) {
        this.vector = vector;
        this.clase = clase;
    }

    public Patron(Patron patron) {
        this.vector = patron.getVector().clone();
        this.clase = patron.getClase();
        this.x = patron.getX();
        this.y = patron.getY();
        
    }
    
    

    /**
     * @return the vector
     */
    public double[] getVector() {
        return vector;
    }

    /**
     * @param vector the vector to set
     */

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
       String aux="[";
       for (int x=0; x < this.vector.length;x++){
         aux+=this.vector[x]+",";
       
       }
       aux+="]= "+this.clase;
        
        return aux; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param claseRes the claseRes to set
     */
    public void setClaseRes(String claseRes) {
        this.claseRes = claseRes;
    }
    
    
    public boolean verificaClasificacion(){
      return clase.equals(claseRes);
     
    }

    @Override
    public boolean equals(Object obj) {
        Patron patron = (Patron)obj;
        
        for (int x=0; x<patron.getVector().length;x++){
           if(this.vector[x]!=patron.getVector()[x])
               return false;
        
        }
        return true; 
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    
    public int obtenerRGB (){
         Color aux = new Color((int)vector[0],(int) vector[1],(int)vector[2]);
       return aux.getRGB();
    
    }
    
    
    
    
}
