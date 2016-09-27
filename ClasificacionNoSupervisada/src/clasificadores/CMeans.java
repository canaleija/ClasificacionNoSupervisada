/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import java.util.ArrayList;
import java.util.Random;
import objetos.Herramientas;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class CMeans {
    
    // conjunto de instancias
    private ArrayList<Patron> instancias;
    // numero de clusters
    private int c;
    // centroides 
    private ArrayList<Patron[]> centroides;

    public CMeans(ArrayList<Patron> instancias, int c) {
        this.instancias = instancias;
        this.c = c;
    }
   
    public void clasifica (){
     // generar mis centroides iniciales aleatorios 
     Random ran = new Random();
     Patron[] centroides = new Patron[c];
     for (int x=0; x < this.c;x++){
       int pos = ran.nextInt(this.instancias.size());
       centroides[x] = new Patron(this.instancias.get(pos).getVector().clone(),"Centroide "+x);
     }
     // agregamos a la coleccion de centroides los centroides iniciales
     this.centroides.add(centroides);
     // etiquetar por primera ocasión (clasificar por primera ocasión)
     
    }
    
    private void etiquetar (Patron[] centroides){
    // recorrer las instancias y etiquetar 
    // cada una de ellas en base a distancias
    for (Patron patron: this.instancias){
       double menor = Herramientas.calculaDistanciaEcuclidiana(patron,centroides[0]);
       patron.setClase(centroides[0].getClase());
       for (int x=1; x < this.c; x++){
       // calculamos distancias
       double dist = Herramientas.calculaDistanciaEcuclidiana(patron,centroides[x]);
       if (dist< menor){
       menor = dist;
       patron.setClase(centroides[x].getClase());
       }
       }
    }
    }
    
    
    
    
    
}
