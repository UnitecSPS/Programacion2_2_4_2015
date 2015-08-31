/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestFile {
    public static void main(String[] args) {
        int op=0;
        
        MiFile mf = new MiFile();
        
        do{
            Scanner lea = new Scanner(System.in);
            System.out.println("1- Conectarse a un archivo o Folder.");
            System.out.println("2- Ver Informacion");
            System.out.println("3- Crear Archivo");
            System.out.println("Escoja opcion: ");
            
            try{
                op = lea.nextInt();
                switch(op){
                    case 1:
                        System.out.println("Ingrese Direccion: ");
                        mf.setFile(lea.next());
                        break;
                    case 2:
                        mf.verInfo();
                        break;
                }
            }
            catch(NullPointerException e){
                System.out.println("Ingrese opcion 1 primero.");
            }
            catch(SecurityException e){
                System.out.println("No tienes permisos.");
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese un dato correcto.");
            }
            catch(Exception e){
                System.out.println("Error: " + e);
            }
        }while(op!=7);
    }
}
