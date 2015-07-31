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
public class Ejercicios {
    //SERIE DE FIBONACCI CON FUNCIONES RECURSIVAS
    //FORMULA MATEMATICA: F(n) = F(n - 1) + F(n - 2)
    
    //Metodo UP
    public static int fibonacciUp(int n) {
        if (n > 1) {
            return fibonacciUp(n - 1) + fibonacciUp(n - 2);
        }
        return n;
    }

    //Metodo DOWN
    private static int fibonacciDown(int n, int cont, int n1, int n2) {
        if (cont <= n) {
            return fibonacciDown(n, cont + 1, n2, n1 + n2);
        }
        return n1;
    }

    //Funcion auxiliar para fibonacci con Metodo DOWN
    public static int fibonacciDown(int n) {
        return fibonacciDown(n, 1, 0, 1);
    }
    
    //------------------------------------------------------------------------
    //CALCULAR NUMEROS CON POTENCIA
    //Metodo UP
    public static double ExponenteUp(int base, int exp){
        if(exp >= 1)
            return ExponenteUp(base, exp - 1)*base;
        return 1;
    }
    
    //Metodo DOWN
    //VALOR INICIAL NECESARIO: producto = 1;
    private static double ExponenteDown(int base, int exp, int producto){
        if(exp >= 1)
            return ExponenteDown(base, exp - 1, base*producto);
        return producto;
    }
    
    //Funcion auxiliar para el metodo DOWN
    public static double ExponenteDown(int base, int exp){
        if(exp < 0){
            return (1.00/ExponenteDown(base, exp*-1, 1));
        }
        return ExponenteDown(base, exp, 1);
    }
    //------------------------------------------------------------------------
    
    public static void main(String[] args) {
        System.out.println(ExponenteUp(2,3));
        System.out.println(ExponenteUp(2,-2));
        System.out.println(ExponenteUp(2,0));
        System.out.println(ExponenteUp(2,2));
        System.out.println(ExponenteUp(2,16));
        System.out.println("--------------------------");
        System.out.println(ExponenteDown(2,3));
        System.out.println(ExponenteDown(2,0));
        System.out.println(ExponenteDown(2,2));
        System.out.println(ExponenteDown(2,16));
    }
    
}
