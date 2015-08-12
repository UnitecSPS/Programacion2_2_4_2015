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
public class Recursion {
    public static void patito(int x){
        int y = 0;
        if(x < 8)
            patito(x + 1);
        y++;
        System.out.print(x);
    }
    
    public static void print(int n){
        if(n > 1)
            print(n - 1);
        
        System.out.print(n);
    }
    
    //Metodo UP
    //Agrupar en dos terminos hasta encontrar el caso base.
    public static int sumaUp(int n){
        if(n > 1)
            return sumaUp(n-1) + n;
        return n;
    }
    
    //Metodo DOWN
    //Siempre retornan el valor acumulado
    private static int suma(int n, int suma){
        if(n >= 1)
            return suma(n - 1, suma + n);
        return suma;
    }
    
    public static int sumaDown(int n){
        return suma(n, 0);
    }
    
    public static void main(String[] args) {
        print(5);
        System.out.println();
        System.out.println(sumaUp(5));
        System.out.println(sumaDown(5));
    }
}
