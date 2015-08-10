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
public class Twitter extends RedSocial {
    private String username;
    
    public Twitter(String n, String p, String e){
        super(n,p,e);
    }
    
    public Twitter(){
        super("","","");
        username = "";
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        nombre = "carlos"; 
        return username;
    }

    @Override
    /*
    lo mismo:
     super.email
     this.email
     email
    */
    public String toString() {
        return "Twitter{" + super.toString()+", username=" + username + '}';
    }
    
    @Override
    public void quienSoy(){
        System.out.println("SOY TWITTER");
    }
    
}
