/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacionnosupervisada;

import clasificadores.CMeans;
import java.io.IOException;
import objetos.Patron;
import sun.misc.CEFormatException;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ClasificacionNoSupervisada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // pCreamos las instancias 
        CMeans cm = new CMeans(Tokenizador.abrirFile(), 2);
        cm.clasifica();
    }
        
        

}
