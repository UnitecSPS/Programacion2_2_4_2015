/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Aula
 */
public class Facebook extends RedSocial {

    public Facebook(String nombre, String password, String email) {
        super(nombre, password, email);
    }
    
    @Override
    public void quienSoy(){
        System.out.println("SOY FACEBOOK");
    }
    
}
