/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umbralizacionrgb;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class UmbralizarImagen {

    private ArrayList<Histograma> histogramas;
    private BufferedImage imagenOriginal, imagenNueva;
 
    public UmbralizarImagen(BufferedImage image) {
        this.imagenOriginal = image;
        this.imagenNueva = new BufferedImage(image.getWidth(), image.getHeight(), 
                BufferedImage.TYPE_INT_RGB);
        this.histogramas = new ArrayList<>();
        calculaHistogramas();
    }

    public void actualizarRojo(int min, int max, boolean inside) {
        /// actualizar la imagen original y el histograma
        // vericar el valor de inside
        System.out.println();
        for (int x = 0; x < this.imagenOriginal.getWidth(); x++) {
            for (int y = 0; y < this.imagenOriginal.getHeight(); y++) {
                // obteniendo el color
                Color aux = new Color(this.imagenOriginal.getRGB(x, y));
                // verificar el rango
                if (inside) {
                    if (aux.getRed() < min || aux.getRed() > max) {
                        // seteo a blanco a imagen 
                        this.imagenNueva.setRGB(x, y, new Color(255, 255, 255).getRGB());
                        this.histogramas.get(0).getValores()[aux.getRed()] = -1;
                    } else {
                        // mantener los color originales 
                        this.imagenNueva.setRGB(x, y, aux.getRGB());
                    }
                } else {
                    // mantener lo que esta afuera 
                    if (aux.getRed() > min && aux.getRed() < max) {
                        // seteo a blanco a imagen 
                        this.imagenNueva.setRGB(x, y, new Color(255, 255, 255).getRGB());
                        this.histogramas.get(0).getValores()[aux.getRed()] = -1;
                    } else {
                        // mantener los color originales 
                        this.imagenNueva.setRGB(x, y, aux.getRGB());
                    }
                }
            }
        }
        System.out.println();
    }

    public void actualizarVerde(int min, int max, boolean inside) {
        for (int x = 0; x < this.imagenOriginal.getWidth(); x++) {
            for (int y = 0; y < this.imagenOriginal.getHeight(); y++) {
                // obteniendo el color
                Color aux = new Color(this.imagenOriginal.getRGB(x, y));
                // verificar el rango
                if (inside) {
                    if (aux.getGreen() < min || aux.getGreen() > max) {
                        // seteo a blanco a imagen 
                        this.imagenNueva.setRGB(x, y, new Color(255, 255, 255).getRGB());
                        this.histogramas.get(1).getValores()[aux.getGreen()] = -1;
                    } else {
                        // mantener los color originales 
                        this.imagenNueva.setRGB(x, y, aux.getRGB());
                    }

                } else {
                    // mantener lo que esta afuera 
                    if (aux.getGreen() > min && aux.getGreen() < max) {
                        // seteo a blanco a imagen 
                        this.imagenNueva.setRGB(x, y, new Color(255, 255, 255).getRGB());
                        this.histogramas.get(1).getValores()[aux.getGreen()] = -1;
                    } else {
                        // mantener los color originales 
                        this.imagenNueva.setRGB(x, y, aux.getRGB());
                    }
                }

            }
        }
        System.out.println();
    }

    public void actualizarAzul(int min, int max, boolean inside) {
        for (int x = 0; x < this.imagenOriginal.getWidth(); x++) {
            for (int y = 0; y < this.imagenOriginal.getHeight(); y++) {
                // obteniendo el color
                Color aux = new Color(this.imagenOriginal.getRGB(x, y));
                // verificar el rango
                if (inside) {
                    if (aux.getBlue() < min || aux.getBlue() > max) {
                        // seteo a blanco a imagen 
                        this.imagenNueva.setRGB(x, y, new Color(255, 255, 255).getRGB());
                        this.histogramas.get(2).getValores()[aux.getBlue()] = -1;
                    } else {
                        // mantener los color originales 
                        this.imagenNueva.setRGB(x, y, aux.getRGB());
                    }

                } else {
                    // mantener lo que esta afuera 
                    if (aux.getBlue() > min && aux.getBlue() < max) {
                        // seteo a blanco a imagen 
                        this.imagenNueva.setRGB(x, y, new Color(255, 255, 255).getRGB());
                        this.histogramas.get(2).getValores()[aux.getBlue()] = -1;
                    } else {
                        // mantener los color originales 
                        this.imagenNueva.setRGB(x, y, aux.getRGB());
                    }

                }

            }
        }
        System.out.println();
    }

    private void calculaHistogramas() {
        Histograma.imagen = this.imagenOriginal;
        this.histogramas.add(new Histograma("Rojo", Histograma.Canal.ROJO));
        this.histogramas.add(new Histograma("Verde", Histograma.Canal.VERDE));
        this.histogramas.add(new Histograma("Azul", Histograma.Canal.AZUL));
    }

    public void generaFraficoHistograma() {
        Grafica grafica = new Grafica("Canales RGB - histogramas", "Frecuencia", "Nivel Color");
        for (Histograma aux : this.histogramas) {
            grafica.agregarSerie(aux.getValores(), aux.getNombre());
        }
        grafica.creaYmuestraGrafica();
    }

    /**
     * @return the imagenNueva
     */
    public BufferedImage getImagenNueva() {
        return imagenNueva;
    }
}