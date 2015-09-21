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
public class Nodo {
    public String nombre;
    public int points;
    public Nodo siguiente;

    public Nodo(String nombre, int points) {
        this.nombre = nombre;
        this.points = points;
        siguiente = null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "nombre=" + nombre + ", points=" + points + '}';
    }
    
    
}
