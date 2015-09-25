/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examenlab2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Banco {
    private static ListaBancaria lista = new ListaBancaria();
    private static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        fillList();
        int opcion;
        do{
            System.out.println("\n1- Buscar cuenta");
            System.out.println("2- Agregar cuenta");
            System.out.println("3- Depositar");
            System.out.println("4- Retirar");
            System.out.println("5- Generar backup");
            System.out.println("6- Cargar backup");
            System.out.println("7- Crear reporte de cuentas");
            System.out.println("8- Eliminar cuentas");
            System.out.println("9- Salir");
            
            System.out.print("Ingrese una opcion: ");
            opcion = lea.nextInt();
            switch(opcion){
                case 1:
                    search();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    retirar();
                    break;
                case 5:
                    backup();
                    break;
                case 6:
                    loadBackup();
                    break;
                case 7:
                    report();
                    break;
                case 8:
                    lista.eliminarCuentas();
                    break;
            }
        }while(opcion != 9);
    }
    
    public static void fillList(){
        lista.addCuenta(1, "Test1");
        lista.addCuenta(7, "Test2");
        lista.addCuenta(10, "Test3");
        lista.addCuenta(5, "Test4");
        lista.addCuenta(2, "Test5");
    }
    
    public static void search(){
        System.out.print("Codigo: ");
        int codigo = lea.nextInt();
        CuentaBancaria c = lista.contains(codigo);
        
        if(c != null)
            System.out.println(c);
        else
            System.out.println("Esta cuenta no existe.");
    }
    
    public static void add(){
        System.out.print("Codigo: ");
        int codigo = lea.nextInt();
        System.out.print("Nombre: ");
        String nombre = lea.next();
        
        if(lista.addCuenta(codigo, nombre))
            System.out.println("Cuenta agreada exitosamente.");
        else
            System.out.println("La cuenta no se pudo agregar.");
    }
    
    public static void depositar(){
        System.out.print("Codigo: ");
        int codigo = lea.nextInt();
        System.out.print("Monto a depositar: ");
        double monto = lea.nextDouble();
        
        lista.depositar(codigo, monto);
    }
    
    public static void retirar(){
        System.out.print("Codigo: ");
        int codigo = lea.nextInt();
        System.out.print("Monto a retirar: ");
        double monto = lea.nextDouble();
        
        lista.retiro(codigo, monto);
    }
    
    public static void backup(){
        try{
            lista.generarBackup();
        } catch (IOException ex) {
            System.out.println("ERROR: El backup no pudo ser creado.");
        }
    }
    
    public static void loadBackup(){
        try{
            System.out.print("Path de backup: ");
            String filepath = lea.next();
            lista.loadFromBackup(filepath);
        } catch (IOException ex) {
            System.out.println("ERROR: El backup no pudo ser cargado.");
        }
    }
    
    public static void report(){
        System.out.print("Path a guardar: ");
        String txtfilepath = lea.next();
        
        try{
            lista.listado(txtfilepath);
        } catch (IOException ex) {
            System.out.println("ERROR: El reporte no pudo ser generado.");
        }
    }
}
