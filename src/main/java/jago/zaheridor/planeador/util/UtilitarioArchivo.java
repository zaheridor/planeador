/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jago.zaheridor.planeador.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author zaheridor
 */
public class UtilitarioArchivo {
    
    private static final Logger logger = Logger.getLogger("jago.zaheridor.planeador.web.UtilitarioArchivo");
    private static final String ARCHIVO = "/Users/zaheridor/Documents/STUDY/proyecto_planeador/planeador/src/main/resources/archivo.csv";
    
    /**
     * 
     * @param archivo
     * @return 
     */
    public static String cargaArchivoForm(final Part archivo){
        String contenido = "";
        try {
            contenido = new Scanner(archivo.getInputStream()).useDelimiter("\\A").next();
            logger.log(Level.INFO, "contenido: {0}", contenido);
        } 
        catch (IOException e) {
            logger.warning(e.getMessage());
        }
        
        return contenido;
    }

    /**
     * 
     * @return 
     */
    public static StringBuilder cargaArchivoEstatico(){
        StringBuilder contenido = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))){
            String linea;
		
            while ((linea = br.readLine()) != null) {
                contenido.append(linea);
                logger.log(Level.INFO, "ruta: "+linea);
            }

	} 
        catch (IOException e) {
            logger.warning(e.getMessage());
	}
        
        return contenido;
    }
    
    /**
     * 
     * @param part
     * @return 
     */
    public static String getNombreArchivo(final Part part) {
        final String encabezado = part.getHeader("content-disposition");
        logger.log(Level.INFO, "Part Header = {0}", encabezado);
        
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        
        return null;
    }
    
}
