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
public class Piramide {
    private static void printStar(int n){
        if(n > 0){
            System.out.print("*");
            printStar(n - 1);
        }
    }
    
    private static void piramide(int n, int cont){
        if(cont <= n){
            System.out.println("");
            printStar(cont);
            piramide(n, cont + 1);
        }
    }
    
    public static void piramide(int n){
        piramide(n, 0);
    }
    
    public static void main(String[] args) {
        piramide(10);
    }
}
