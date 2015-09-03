/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class EscrituraTexto {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("Direccion?: ");
            String path = lea.nextLine();
            System.out.println("Append?(s/n): ");
            char append = lea.next().toLowerCase().charAt(0);
            
            try{
                FileWriter fw = new FileWriter(path,append=='s');
                
                String texto;
                do{
                    texto = lea.nextLine();
                    if(!texto.equals("#$%")){
                        fw.write(texto+"\r\n");
                        fw.flush();
                    }
                    else
                        break;
                    
                }while(true);
                
                fw.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
            
        }while(true);
    }
}
