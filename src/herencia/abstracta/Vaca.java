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
public class Vaca extends Animal {
    public Vaca(String r){
        super(4,r);
    }

    @Override
    public void makeSound() {
        System.out.println("Muuu Muuuu Muuuuu");
    }
}
