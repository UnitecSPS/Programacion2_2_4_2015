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
public class NumeroInvertido {
    //------------------------------------------------------------------------
    public static int pow(int base, int exp) {
        if (exp > 0) {
            return pow(base, exp - 1) * base;
        }
        return 1;
    }
    
    private static int numLength(int n, int cont){
        if (n > 0)
            return numLength(n/10, cont + 1);
        return cont;
    }
    
    //Auxiliar
    public static int numLength(int n){
        return numLength(n, 0);
    }
    
    //Numeric method
    public static int reverseNumber(int n, int length) {
        if (length > 0)
            return reverseNumber(n/10, length - 1) + (n%10)*pow(10, length - 1);
        return 0;
    }
    
    //Auxiliar
    public static int reverseNumber(int n){
        return reverseNumber(n, numLength(n));
    }

    //Print method
    public static void reverseNumberPrint(int n) {
        if (n > 0) {
            System.out.print(n % 10);
            reverseNumber(n / 10);
        }
    }

    public static void main(String[] args) {
        int n = 72054;
        reverseNumberPrint(n);
        System.out.println("");
        System.out.println("Numero: " + n + "   Al reves: " + reverseNumber(n));
    }
}
