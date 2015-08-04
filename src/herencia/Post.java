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
    String body;
    Date fecha;

    public Post(String body) {
        this.body = body;
        fecha = new Date();
    }
    
    
}
