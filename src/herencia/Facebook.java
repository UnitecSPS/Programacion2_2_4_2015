/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.io.Serializable;

/**
 *
 * @author Aula
 */
public final class Facebook extends RedSocial implements Commentable, Serializable{
    
    
    public Facebook(String nombre, String password, String email) {
        super(nombre, password, email);
    }
    
    @Override
    public void quienSoy(){
        System.out.println("SOY FACEBOOK");
    }

    @Override
    boolean isMe(String u, String p) {
        return u.equals(email) && isMyPassword(p);
    }

    @Override
    public void addComment(String body, String autor, int idpost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
