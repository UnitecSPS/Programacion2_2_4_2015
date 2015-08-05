/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocial;

import java.util.ArrayList;

/**
 *
 * @author LEFF
 */
public class Redsocial {
    protected String nombre, password, email;
    protected ArrayList<Post> posts;
    
    
    public Redsocial(String nombre, String password, String email) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        
        posts = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
    
    public boolean isMyPassword(String pass){
        return pass.equals(password);
    }
    
    public void addPost(String msg){
        posts.add(new Post(msg));
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", email=" + email;
    }
    
    void quienSoy(){
        System.out.println("SOY RED SOCIAL");
    }
}
