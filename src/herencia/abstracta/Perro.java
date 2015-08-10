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
public class Perro extends Animal {
    public Perro(String raza){
        super(4,raza);
    }
    
    @Override
    public void makeSound(){
       // super.makeSound();
        System.out.println("Guau Guau Guau Guau");
    }
}
