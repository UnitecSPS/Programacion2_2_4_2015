/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestMiLista {
    static Scanner lea = new Scanner(System.in);
    static Lista lista = new Lista();
    
    public static void main(String[] args) {        
        int op;

        do{
            System.out.println("1- Agregar");
            System.out.println("2- Imprimir");
            System.out.println("3- Borrar");
            System.out.println("4- Agregar En");
            System.out.println("5- Size");
            System.out.println("6- Salir");
            System.out.println("Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    agregar();
                    break;
                case 2:
                    lista.print();
                    break;
                case 3:
                    borrar();
                    break;
                case 4:
                    agregarEn();
                    break;
                case 5:
                    System.out.println("Size: " + lista.size());
                    break;
            }
        }while(op!=6);
    }

    private static void agregar() {
        System.out.println("Nombre: ");
        String n = lea.next();
        System.out.println("Puntos: ");
        int pts = lea.nextInt();
        lista.add(new Nodo(n, pts));
    }

    private static void borrar() {
        System.out.println("Nombre: ");
        String n = lea.next();
        lista.remove(n);
    }

    private static void agregarEn() {
      System.out.println("¨Posicion (>=0): ");
      int pos = lea.nextInt();
      System.out.println("Nombre: ");
      String n = lea.next();
      System.out.println("Puntos: ");
      int pts = lea.nextInt();
      lista.add(pos, new Nodo(n, pts));
    }
}
