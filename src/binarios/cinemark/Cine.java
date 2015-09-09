/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios.cinemark;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class Cine {
    static Scanner lea = new Scanner(System.in);
    static Cinemark cine = new Cinemark();
    
    public static void main(String[] args) {
        int op=0;
        do{
            System.out.println("1- Agregar Pelicula");
            System.out.println("2- Listar Peliculas");
            System.out.println("3- Agregar Sala");
            System.out.println("4- Imprimir Sala");
            System.out.print("Escoja: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        agregar();
                        break;
                    case 2:
                        listar();
                        break;
                    case 3:
                        agregarSala();
                        break;
                    case 4:
                        printSala();
                        break;
                }
            }
            catch(InputMismatchException e){
                lea.next();
                System.out.println("Escriba un entero");
            }
            catch(IllegalArgumentException e){
                System.out.println("Ingresa una opcion correcta");
            }
            catch(IOException e){
                System.out.println("Error en Disco: "+e.getMessage());
            }
            catch(Exception e){
                System.out.println("Error: " + e);
            }
            
        }while(op!=7);
    }

    private static void agregar() throws IOException{
        System.out.println("Nombre: ");
        String n = lea.next();
        System.out.print("Rating ");
        for(Rating ts : Rating.values())
            System.out.print("["+ts.name()+"]");
        System.out.println(" : ");
        Rating r = Rating.valueOf(lea.next().toUpperCase());
        
        System.out.print("Tipo ");
        for(TypeMovie ts : TypeMovie.values())
            System.out.print("["+ts.name()+"]");
        System.out.println(" : ");
        TypeMovie t = TypeMovie.valueOf(lea.next().toUpperCase());
        
        System.out.println("Duracion en horas:");
        double d = lea.nextDouble();
        
        cine.addMovie(n, r, t, d);
    }

    private static void listar()throws IOException {
        System.out.println("0=ALL 1=ACTIVE 2=INACTIVE: ");
        int t = lea.nextInt();
        cine.printMovies(t);
    }

    private static void agregarSala()throws IOException {
        System.out.print("Tipo Sala ");
        for(TypeSala ts : TypeSala.values())
            System.out.print("["+ts.name()+"]");
        System.out.print(" : ");
        TypeSala ts = TypeSala.valueOf(lea.next());
        System.out.println("Horario: ");
        String h = lea.next();
        System.out.println("Cantidad Asientos: ");
        int c = lea.nextInt();
        cine.addSala(ts, h, c);
    }

    private static void printSala()throws IOException {
        System.out.println("Numero de sala: ");
        int n = lea.nextInt();
        cine.printSalaInfo(n);
    }
    
}