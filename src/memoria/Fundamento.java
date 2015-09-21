/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Aula
 */
public class Fundamento {
    public static void main(String[] args) {
        Nodo a = new Nodo("Andres", 100);
        Nodo b = a;
        b.nombre = "Waldo";
        System.out.println(a);
        System.out.println(b);
        
        if( a == b )
            System.out.println("Son el mismo espacio");
        
        int x = 10;
        int y = x;
        y = 5;
        System.out.println(x);
        System.out.println(y);
        
        String c1 = "hola";
        String c2 = "hola";
        
        if(c1 == c2)
            System.out.println("Son iguales!");
    }
}
