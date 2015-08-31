/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class MiFile {
    private File file = null;
    
    void setFile(String path) {
        file = new File(path); 
    }
    
    void verInfo(){

        if(file.exists()){
            System.out.println("--------------------------------");
            System.out.println("Existe!");
            System.out.println("Nombre: " + file.getName());
            System.out.println("Path: "+file.getPath());
            System.out.println("Path Absoluta"+file.getAbsolutePath());
            System.out.println("Parent: "+file.getAbsoluteFile().getParentFile().getName());
            System.out.println("Size en bytes: "+file.length());
            if(file.isFile())
                System.out.println("Es un ARCHIVO");
            else if(file.isDirectory())
                System.out.println("ES un DIRECTORIO");
            if(file.isHidden())
                System.out.println("Esta OCULTO");
            Date ultima = new Date(file.lastModified());
            System.out.println("Ultima Fecha de Modificacion: "+ultima);
            System.out.println("-----------------------------------------");
        }
        else{
            System.out.println("Aun No Existe!");
            System.out.println("Path Absoluta"+file.getAbsolutePath());
        }
    }
    
}
