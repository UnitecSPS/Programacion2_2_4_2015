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
public abstract class Redsocial {
    protected String nombre, password, email;
    protected ArrayList<Post> posts;
    protected ArrayList<String>friends;
    
    public static final int version = 1;
    
    public Redsocial(String nombre, String password, String email) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        posts = new ArrayList();
        friends = new ArrayList();
    }
    
    public void addFriend(String msg){
        friends.add(new Post(nombre, msg));
    }
    
    abstract void timeline(){
        for()
    }
    
    public static void testVersion(){
        int x = 1;
        switch(x){
            case version:
                System.out.println("Version 1");
                break;
            default:
                System.out.println("Otra Version...");
        }
    }

    public final String getNombre() {
        return nombre;
    }

    public final String getEmail() {
        return email;
    }
    
    public final boolean isMyPassword(String pass){
        return pass.equals(password);
    }
    
    public final void addPost(String msg){
        posts.add(new Post(msg));
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", email=" + email;
    }
    
    void quienSoy(){
        System.out.println("SOY RED SOCIAL");
    }
    
    abstract boolean isMe(String u, String p);
}
