/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Aula
 */
public class TestCloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        Facebook fb = new Facebook("Carlos", "Pepe", "email");
        Facebook fb2 = fb.clone();
        fb2.nombre = "Armando";
        System.out.println(fb);
    }
}
