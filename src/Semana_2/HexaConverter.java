/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana_2;

/**
 *
 * @author Andres
 */
public class HexaConverter {
    public static void main(String[] args) {
        decToHexa(16);
    }
    
    //Convertidor de numeros a hexadecimales
    private static void decToHexa(int n) {
        if(n >= 16){
            decToHexa(n/16);
        }
        
        int mod = n % 16;
        if(mod >= 0 && mod <= 9)
            System.out.print(mod);
        else if(mod == 10)
            System.out.print("A");
        else if(mod == 11)
            System.out.print("B");
        else if(mod == 12)
            System.out.print("C");
        else if(mod == 13)
            System.out.print("D");
        else if(mod == 14)
            System.out.print("E");
        else if(mod == 15)
            System.out.print("F");
    }
}
