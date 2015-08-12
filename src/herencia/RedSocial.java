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
public abstract class RedSocial {
    protected String nombre, password, email;
    protected ArrayList<Post> posts;
    protected ArrayList<String> friends;
    
    public static final int version = 1;
    
    public RedSocial(String nombre, String password, String email) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        posts = new ArrayList<>();
        friends = new ArrayList<>();
    }
    
    public static void testVersion(){
        final int x = 1;
        switch(x){
            case version:
                System.out.println("Version 1");
                break;
            default:
               // x = 2;
                System.out.println("Otra version");
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
    
    public void addPost(String msg){
        posts.add( new Post(nombre,msg) );
    }
    
    public void addFriend(String f){
        friends.add(f);
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", email=" + email ;
    }
    
    public void quienSoy(){
        System.out.println("SOY REDSOCIAL");
    }
    
    abstract boolean isMe(String u, String p);
    
    public void timeline(){
        for(Post p : posts)
            p.print();
    }   
}
