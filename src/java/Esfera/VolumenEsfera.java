/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esfera;

import Evento.DAOEvento;
import Evento.DTOEvento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author USER
 */
@WebService(serviceName = "VolumenEsfera")
public class VolumenEsfera {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Volumen")
    public Double volumen(@WebParam(name = "radio") Double radio) {
        return (4.0 / 3.0) * (Math.PI) * (Math.pow(radio, 3));
    }

    @WebMethod(operationName = "FicheroWeb")
   public String readFile(@WebParam(name = "archivo") File fileName) throws IOException {
//    BufferedReader br = new BufferedReader(new FileReader(fileName.getAbsolutePath().replace("\\", "\\\\")));
     BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\Documents\\NetBeansProjects\\LisyxEventsDesktop\\src\\lisyxeventsdesktop\\datos.txt"));

    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

//         DTOEvento dtoEvento = new DTOEvento();
//           String[] datos = new String[5];
//           int l=0;
//            
        while (line != null) {
            sb.append(line);
            sb.append("<br>");
//            datos[l] = line;
            line = br.readLine();
//            l++;
        }
        
//        for(int i = 0;i <=datos.length;i++){
//            dtoEvento.setIdEvento(Integer.parseInt(datos[i]));
//            dtoEvento.setNombre_evento(datos[i]);
//            dtoEvento.setFecha_evento(datos[i]);
//            dtoEvento.setNo_participantes(Integer.parseInt(datos[i]));
//            dtoEvento.setDescripcion(datos[i]);
//            dtoEvento.setEstatus(Integer.parseInt(datos[i]));
//        }
        
//        try{
//             new DAOEvento().nuevoEvento(dtoEvento);
//         } catch (Exception e) {
//            System.out.println(""+e);
//        } finally {
//            System.out.println("Esperando..");  
//        }
        return sb.toString();
    } finally {
        br.close();
    }
}
    
    @WebMethod(operationName = "Fichero")
    public String fichero(@WebParam(name = "archivo") File rootCompleted) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
        String contenido = null;
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(rootCompleted.getAbsolutePath());
            fr = new FileReader(archivo.toString());
            br = new BufferedReader(fr);
            // Lectura del fichero            
            while ((linea = br.readLine()) != null) {
                contenido = contenido +" . "+ linea;
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return archivo.toString().replace("\\", "\\\\");
    }
}
