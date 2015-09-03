/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
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
            System.out.println("Size en bytes: "+longitud(file));
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
            System.out.println(longitud(file));
        }
    }
    
    boolean crearArchivo()throws IOException{
        return file.createNewFile();
    }
    
    boolean crearFolder(){
        return file.mkdirs();
    }
    
    boolean borrar(){
        return file.delete();
    }
    
    void dir(){
        if(file.isDirectory()){
            File childs[] = file.listFiles();
            int files=0,dirs=0,bytes=0;
            
            for(File child : childs){
                if(!child.isHidden()){
                    //ultima fecha
                    System.out.print(new Date(child.lastModified())+"\t");
                    //tipo
                    if(child.isDirectory()){
                        dirs++;
                        System.out.print("<DIR>\t ");
                    }
                    else{
                        files++;
                        System.out.print("     \t"+child.length()+" ");
                        bytes += child.length();
                    }
                    //name
                    System.out.println(child.getName());
                }
            }
            //estadistica
            System.out.println(files+ " archivos\t"+bytes+" bytes");
            System.out.println(dirs+" directorios\t"+file.getFreeSpace()+ 
                    " bytes libres.");
        }
    }

    public void tree() {
        tree(file,"");
    }

    private void tree(File dir, String tab) {
        if(dir.isDirectory()){
            System.out.println(tab+dir.getName());
            for(File child : dir.listFiles()){
                tree(child,tab+"\t");
            }
        }
    }

    private long longitud(File file) {
        if(file.isDirectory()){
            long bytes =0;
            for(File child : file.listFiles())
                bytes += longitud(child);
            return bytes;
        }
        return file.length();
    }
}
