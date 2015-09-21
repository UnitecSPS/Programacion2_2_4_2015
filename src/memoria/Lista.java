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
        if(!isEmpty()){
            if(inicio.nombre.equals(n))
                inicio = inicio.siguiente;
            else{
                Nodo tmp = inicio;
                
                while(tmp.siguiente != null){
                    if(tmp.siguiente.nombre.equals(n))
                        tmp.siguiente = tmp.siguiente.siguiente;
                    else
                        tmp = tmp.siguiente;
                }
            }
        }
    }
    
    public void add(int index, Nodo obj){
        if(index == 0){
            obj.siguiente = inicio;
            inicio = obj;
        }
        else{
            Nodo tmp = inicio;
            int contador=0;
            
            while(tmp.siguiente != null){
                if(contador != index-1){
                    tmp = tmp.siguiente;
                    contador++;
                }
                else
                    break;
            }
            
            //conectar
            obj.siguiente = tmp.siguiente;
            tmp.siguiente = obj;
        }
    }
    
    public int size(){
        int size=0;
        Nodo tmp = inicio;
        
        while(tmp != null){
            size++;
            tmp = tmp.siguiente;
        }
        
        return size;
    }
    
    public void clear(){
        inicio = null;
    }
    
    public Nodo[] toArray(){
        return null;
    }
    
    public void set(int index, Nodo obj){
        
    }
}
