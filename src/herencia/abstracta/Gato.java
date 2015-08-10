/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.abstracta;

/**
 *
 * @author Aula
 */
public class Gato extends Animal {

    public Gato(String raza) {
        super(4, raza);
    }

    @Override
    public void makeSound() {
        System.out.println("Miau Miau Miau");
    }
    
    public void limpiarme(){
        System.out.println("Me paso la lengua para bañarme");
    }
    
}
