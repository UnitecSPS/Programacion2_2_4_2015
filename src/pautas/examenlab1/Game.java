package pautas.examenlab1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Game extends RentItem implements MenuActions{
    private Calendar fecha;
    private ArrayList<String> especificaciones;
    

    public Game(int codigo, String nombre) {
        super(codigo, nombre, 20);
        especificaciones = new ArrayList<>();
        fecha = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return super.toString() + " | FECHA DE PUBLICACION: " + fecha.getTime() + " | - PS3 GAME";
    }
    
    public void setFechaPublicacion(int year, int mes, int dia){
        fecha.set(year, mes, dia);
    }
    
    private void listEspecificaciones(int i){
        if(i < especificaciones.size()){
            System.out.println((i + 1) + ". " + especificaciones.get(i));
            listEspecificaciones(i + 1);
        }
    }
    
    public void listEspecificaciones(){
        listEspecificaciones(0);
    }
    
    @Override
    public double pagoRenta(int dias) {
        return precio*dias;
    }

    @Override
    public void submenu() {
        System.out.println("1. Actualizar Fecha de Publicacion\n2. Agregar Especificacion\n3. Ver Especificaciones");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");
        switch(opcion){
            case 1:
                System.out.println("----ACTUALIZAR FECHA DE PUBLICACION----");
                System.out.print("Año: ");
                int year = lea.nextInt();
                System.out.print("Mes: ");
                int mes = lea.nextInt()-1;
                System.out.print("Dia: ");
                int dia = lea.nextInt();      
                setFechaPublicacion(year, mes, dia);
                break;
            case 2:
                System.out.println("----AGREGAR ESPECIFICACION----");
                System.out.print("Ingrese una especificacion: ");
                especificaciones.add(lea.next());
                break;
            case 3:
                System.out.println("----LISTA DE ESPECIFICACIONES----");
                listEspecificaciones();
                break;
        }
    }
}
