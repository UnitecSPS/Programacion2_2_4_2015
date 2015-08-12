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
public class Prueba1 {
    public static boolean palindromo(String cad, int i){
        int longi = cad.length();
        
        if(i < longi){
            if(cad.charAt(i) == cad.charAt(longi - i - 1))
                return palindromo(cad, i + 1);
            return false;
        }
        return true;
    }
    
    public static boolean palindromo(String txt, int inicio, int fin){
        if(inicio < fin){
            if(txt.charAt(inicio) != txt.charAt(fin))
                return false;
            return palindromo(txt, inicio + 1, fin - 1);
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(palindromo("AnitalavalatinA", 0));
    }
}
