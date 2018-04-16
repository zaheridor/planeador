/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jago.zaheridor.planeador.web;

import jago.zaheridor.planeador.util.UtilitarioArchivo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author zaheridor
 */
@Named(value = "planeadorManagedBean")
@RequestScoped
public class PlaneadorManagedBean {
    
    private static final Logger logger = Logger.getLogger("jago.zaheridor.planeador.web.PlaneadorManagedBean");
    private String mensaje;
    private Part archivo;

    /**
     * Creates a new instance of PlaneadorManagedBean
     */
    public PlaneadorManagedBean() {
        setMensaje("Primera carga");
    }
    
    /**
     * Acción del botón de cargar archivo.
     * @return
     * @throws IOException 
     */
    public String cargaEstatica(){
        UtilitarioArchivo.cargaArchivoEstatico();

        return "";
    }
    
    public String cargaForm(){
        UtilitarioArchivo.cargaArchivoForm(archivo);
        
        return "cargarArchivo";
    }
    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Part getArchivo() {
        return archivo;
    }

    public void setArchivo(Part archivo) {
        this.archivo = archivo;
    }

}
