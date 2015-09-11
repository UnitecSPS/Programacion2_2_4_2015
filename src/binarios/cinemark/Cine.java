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
            System.out.println("4- Asignar Pelicula");
            System.out.println("5- Imprimir Sala");
            System.out.println("6- Vender Ticket");
            System.out.println("7- Imprimir Tickets Vendidos");
            System.out.println("8- Imprimir Cartelera");
            System.out.println("9- Desactivar Pelicula");
            System.out.println("10- Boletos Vendidos");
            System.out.println("11- Limpiar Sala");
            System.out.println("12- Salir");
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
                        asignar();
                        break;
                    case 5:
                        printSala();
                        break;
                    case 6:
                        ventaTicket();
                        break;
                    case 7:
                        reporte();
                        break;
                    case 8:
                        cartelera();
                        break;
                    case 9:
                        desactiveMovie();
                        break;
                    case 10:
                        taquilla();
                        break;
                    case 11:
                        limpiarSala();
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
            
        }while(op!=12);
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

    private static void asignar()throws IOException {
        System.out.print("Codigo Pelicula: ");
        int cp = lea.nextInt();
        System.out.print("Numero de sala: ");
        int n = lea.nextInt();
        
        if(cine.assignMovieToSala(cp, n))
            System.out.println("Pelicula Asignada con Exito");
        else
            System.out.println("No se puede asignar");
    }
    
    private static void ventaTicket() throws IOException{
        System.out.print("Numero de Sala: ");
        int s = lea.nextInt();
        System.out.println("Numero de Asiento: ");
        int a = lea.nextInt();
        if (cine.venderTicket(s, a)) {
            System.out.println("Ticket Vendido");
        }else
            System.out.println("No se pudo Vender Ticket");
    }
    
    private static void reporte()throws IOException{
        System.out.println("Numero de Sala: ");
        int n = lea.nextInt();
        cine.ticketsSoldInSala(n, null);
    }
    
    private static void cartelera()throws IOException{
        System.out.println("Ingrese Direccion: ");
        String s = lea.next();
        cine.cartelera(s);
    }
    
    private static void desactiveMovie()throws IOException{
        System.out.println("Cod de Pelicula: ");
        int c = lea.nextInt();
        if (cine.disableMovie(c)) {
            System.out.println("Movie Desactivada");
        }else
            System.out.println("No se pudo Desactivar");
    }
    
    private static void limpiarSala()throws IOException{
        System.out.println("Cod de Sala");
        int c = lea.nextInt();
        cine.cleanSala(c);
    }
    
    private static void taquilla()throws IOException{
        System.out.println("Cantidad de Tickets Vendidos: ");
        int cant = lea.nextInt();
        cine.taquilleras(cant);
    }
}
