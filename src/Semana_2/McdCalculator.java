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
public class McdCalculator {
    //mcd con metodo UP
    private static int mcd(int n1, int n2, int divisor){
        if(n1 >= divisor && n2 >= divisor){
            if(n1%divisor == 0 && n2%divisor == 0)
                return mcd(n1/divisor, n2/divisor, divisor)*divisor;
             return mcd(n1, n2, divisor + 1);
        }
        return 1;
    }
    
    //mcd con metodo DOWN
    private static int mcd(int n1, int n2, int divisor, int producto){
        if(n1 >= divisor && n2 >= divisor){
            if(n1%divisor == 0 && n2%divisor == 0)
                return mcd(n1/divisor, n2/divisor, divisor, producto*divisor);
            return mcd(n1, n2, divisor + 1, producto);
        }
        return producto;
    }
    
    //Funcion auxiliar de mcd UP
    public static int mcdUp(int n1, int n2){
        return mcd(n1, n2, 2);
    }
    
    //Funcion auxiliar de mcd DOWN
    public static int mcdDown(int n1, int n2){
        return mcd(n1, n2, 2, 1);
    }
    
    public static void main(String[] args) {
        int n1 = 32, n2 = 24;
        
        System.out.println("N1: " + n1);
        System.out.println("N2: " + n2);
        System.out.println("MCD: " + mcdUp(n1,n2));
        System.out.println("==============================");
        System.out.println("MCD: " + mcdDown(n1,n2));
        System.out.println(65029%16);
    }
}
