/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class UbserSocial {
    ArrayList<RedSocial> redes;
    
    public UbserSocial(){
        redes = new ArrayList<>();
    }
    
    public void add(String n, String p, String e, String tipo){
        /*
        Agregan una nueva red social al arreglo.
        Si el t
        ipo es FACEBOOK crean un nuevo facebook
        Si es TWITTER crean un nuevo twitter.
        
        VALIDAR que el email sea unico en FACEBOOK y que el 
        username sea unico en twitter
        */
    }
    
    public RedSocial search(String dato, String tipo){
        /*
        Buscan dicho dato segun su tipo
        Retornan una cuenta facebook si el dato coincide con el 
            email de una cuenta fb agregada
        Retornan una cuenta twitter si el dato coincide con el
            username de una cuenta tw agregada
        Retornan null si no encuentran nada
        */
        return null;
    }
}
