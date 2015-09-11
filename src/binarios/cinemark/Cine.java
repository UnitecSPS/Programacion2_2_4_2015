/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios.cinemark;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
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
            System.out.println("7- Imprimir Ventas En Sala");
            System.out.println("8- Imprimir Cartelera");
            System.out.println("9- Deshabilitar Una Pelicula");
            System.out.println("10- Vaciar Asientos En Una Sala");
            System.out.println("11- Taquillera");
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
                        vender();
                        break;
                    case 7:
                        printVentas();
                        break;
                    case 8:
                        printCartelera();
                        break;
                    case 9:
                        disableMovie();
                        break;
                    case 10:
                        vaciarAsientos();
                        break;
                    case 11:
                        ticketsVendidos();
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
        System.out.print("Nombre: ");
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
        
        System.out.print("Duracion en horas:");
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
        System.out.print("Numero de sala: ");
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
    
    private static void vender() throws IOException{
        lea.useDelimiter("\n");
        System.out.print("Numero de sala: ");
        int sala = lea.nextInt();
        
        System.out.print("Numero de asiento: ");
        int asiento = lea.nextInt();
        
        cine.venderTicket(sala, asiento);
    }
    
    private static void printVentas() throws IOException{
        System.out.print("Numero de sala: ");
        int sala = lea.nextInt();
        
        System.out.println("Ingrese la fecha de inicio");
        System.out.print("Año: ");
        int year = lea.nextInt();
        System.out.print("Mes: ");
        int month = lea.nextInt() + 1;
        System.out.print("Dia: ");
        int dia = lea.nextInt();
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dia);
        
        cine.ticketsSoldInSala(sala, calendar.getTime());
        
    }
    
    private static void printCartelera() throws IOException{
        System.out.print("Nombre de archivo a exportar(Deje este campo vacio si no desea exportarlo): ");
        String fileName = lea.next();
        
        cine.cartelera(fileName);
    }
    
    private static void disableMovie() throws IOException{
        System.out.print("Codigo de pelicula");
        cine.disableMovie(lea.nextInt());
    }
    
    private static void vaciarAsientos() throws IOException{
        System.out.print("Numero de sala: ");
        cine.cleanSala(lea.nextInt());
    }
    
    private static void ticketsVendidos() throws IOException{
        System.out.print("Cantidad de tickets: ");
        cine.taquilleras(lea.nextInt());
    }
    
}
