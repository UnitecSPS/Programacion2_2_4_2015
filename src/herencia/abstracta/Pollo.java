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
public class Pollo extends Animal {

    public Pollo(String raza) {
        super(2, raza);
    }

    @Override
    public void makeSound() {
        System.out.println("Pio Pio Pio Pio");
    }
    
    
    
}
