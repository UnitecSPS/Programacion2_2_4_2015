/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Date;

/**
 *
 * @author Aula
 */
public class Post {
    String body, autor;
    Date fecha;
    
    public Post(String autor, String body) {
        this.body = body;
        this.autor = autor;
        fecha = new Date();
    }
    
    public void print(){
        System.out.println(autor + " - " + fecha+ ":");
        System.out.println(body);
    }
}
