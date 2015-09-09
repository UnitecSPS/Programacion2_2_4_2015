package pautas.examenlab1;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andres
 */
public class Store {
    private static ArrayList<RentItem> items = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");
        RentItem item;
        int codigo, dias;
        String nombre, tipo;
        double precio;
        
        while(true){
            System.out.println("----ITEMS MENU----");
            System.out.println("1. Agregar Item\n2. Rentar\n3. Ejecutar Sub Menu\n4. Imprimir todo");
            System.out.print("Escoja opcion: ");
            
            switch(lea.nextInt()){
                case 1:
                    System.out.println("----NUEVO ITEM----");
                    System.out.print("Tipo de item: ");
                    tipo = lea.next().toUpperCase();
                    if(tipo.equals("MOVIE") || tipo.equals("GAME")){
                        System.out.print("Codigo: ");
                        codigo = lea.nextInt();
                        
                        if(searchItem(codigo) != null){
                            System.out.println("Este item ya existe.");
                            break;
                        }
                        
                        System.out.print("Nombre: ");
                        nombre = lea.next();
                        
                        if(tipo.equals("GAME")){
                            items.add(new Game(codigo, nombre));
                            break;
                        }

                        System.out.print("Precio: ");
                        precio = lea.nextDouble();
                        items.add(new Movie(codigo, nombre, precio));
                    }else
                        System.out.println("TIPO INCORRECTO");
                    break;
                case 2:
                    System.out.println("----RENTAR UN ITEM----");
                    System.out.print("Codigo: ");
                    codigo = lea.nextInt();
                    item = searchItem(codigo);
                    if(item != null){
                        System.out.println(item);
                        System.out.print("Dias a rentar: ");
                        dias = lea.nextInt();
                        System.out.println("Monto a pagar: L. " + item.pagoRenta(dias));
                    }else
                        System.out.println("Item no existe.");
                    break;
                case 3:
                    System.out.println("----EJECUTAR SUB MENU----");
                    System.out.print("Codigo: ");
                    codigo = lea.nextInt();
                    item = searchItem(codigo);
                    
                    if(item != null && item instanceof MenuActions){
                        ((MenuActions)item).submenu();
                        System.out.print("Escoja opcion: ");
                        ((MenuActions)item).ejecutarOpcion(lea.nextInt());
                    }
                    break;
                case 4:
                    System.out.println("----LISTA DE ITEMS----");
                    for(RentItem it : items)
                        System.out.println(it + "\n");
                    break;
            }
        }
    }
    
    public static RentItem searchItem(int codigo){
        for(RentItem item : items){
            if(item.getCodigo() == codigo)
                return item;
        }
        return null;
    }
}
