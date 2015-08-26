/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia_Abstracta;

/**
 *
 * @author LEFF
 */
public class Animal {
    protected int patas;
    protected String raza;

    public Animal(int patas, String raza) {
        this.patas = patas;
        this.raza = raza;
    }
    
    public void makeSound(){
        System.out.println("No definido..!");
    }
}
