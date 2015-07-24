/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        
        //num[pos] = 4;
        nombres.add("Carlos");
        nombres.add("Armando");
        nombres.add(0, "Ingeniero");
        
        //Imprimir
        for(int p = 0; p < nombres.size(); p++){
            System.out.println("-" + nombres.get(p));
        }
        
        System.out.println("--------------------");
        //Remover
        nombres.remove(0);
        for(String cad : nombres){
            System.out.println("-" + cad);
        }
        
        //Busqueda
        if(nombres.contains("Carlos"))
            System.out.println("Si lo tiene!");
        
        nombres.clear();
        System.out.println("Size: " + nombres.size());
    }
}
