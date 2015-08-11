/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.abstracta;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class Granja {
    public static void main(String[] args) {
        ArrayList<Animal> animalitos = new ArrayList<>();
        
        animalitos.add(new Perro("Pitbull"));
        animalitos.add(new Gato("Siames"));
        animalitos.add(new Pollo("Salvaje")); 
        animalitos.add(new Vaca("Suiza"));
        
        //Funciones On-Demand
        Animal animal = new Animal(1,"Monstruo"){
            int x = 4;
            public void sound(){
                System.out.print("Grr Grrr Grrr");
            }
            
            @Override
            public void makeSound(){
                sound();
                System.out.println(" "+x);
            }
        };
        animalitos.add(animal);
        
        for(Animal ani : animalitos){
            ani.makeSound();
            if(ani instanceof Gato)
                ((Gato)ani).limpiarme();
        }
    }
}
