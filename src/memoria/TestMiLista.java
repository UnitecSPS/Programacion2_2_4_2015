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
            System.out.println("3- Salir");
            System.out.println("Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    agregar();
                    break;
                case 2:
                    lista.print();
                    break;
            }
        }while(op!=3);
    }

    private static void agregar() {
        System.out.println("Nombre: ");
        String n = lea.next();
        System.out.println("Puntos: ");
        int pts = lea.nextInt();
        lista.add(new Nodo(n, pts));
    }
}
