/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacionnosupervisada;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author CANALEIJA
 */
public class AbrirImagen {

  
    public static BufferedImage abrirImagen() throws IOException{
    
        // definir un filtro jpg
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "png", "jpg", "bmp");
        //Declaramos el selector de archivos
        JFileChooser seleccion = new JFileChooser();
        //Asignamos el filtro
        seleccion.addChoosableFileFilter(filter);
        //Especificamos que solo puede abrir archivos
        seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        //Ejecutamos el selector de archivos
        int resultado = seleccion.showOpenDialog(null);
        //Si el evento fue de cancelar
        if (resultado == javax.swing.JFileChooser.CANCEL_OPTION) {
            return null;
        }
        //Cargamos el archivo
        java.io.File archivo = seleccion.getSelectedFile();
                //Convertimos la imagen en un bufferImage
        BufferedImage imagen = ImageIO.read(archivo);

        return imagen;
  
    }

}
