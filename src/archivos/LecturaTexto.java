/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class LecturaTexto {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        System.out.println("Direccion?: ");
        String path = lea.nextLine();
        File f = new File(path);
        
        try(FileReader fr = new FileReader(f)){
            char buffer[] = new char[(int)f.length()];
            int bytes = fr.read(buffer);
            System.out.println("Contenido:\n-----------------");
            System.out.println(buffer);
            System.out.println("Bytes leidos: "+bytes);
            //fr.skip(10);
            //otra vez!---
            System.out.println("\nAhora con Scaner\n-------------");
            Scanner lector = new Scanner(f);
            while(lector.hasNext()){
                System.out.println(lector.nextLine());
            }
           
        }
        catch(IOException e){
            System.out.println(e);
        }
                
    }
}
