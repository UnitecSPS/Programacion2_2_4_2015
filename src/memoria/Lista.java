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
public class Lista {
    private Nodo inicio = null;
    
    public boolean isEmpty(){
        return inicio == null;
    }
    
    public void add(Nodo obj){
        if(isEmpty())
            inicio = obj;
        else{
            Nodo tmp = inicio;
            while(tmp.siguiente != null){
                tmp = tmp.siguiente;
            }
            tmp.siguiente = obj;
        }
    }
    
    public void print(){
        Nodo viajero = inicio;
        while(viajero != null){
            System.out.println(viajero);
            viajero = viajero.siguiente;
        }
    }
    
    public void remove(String n){
        
    }
}
