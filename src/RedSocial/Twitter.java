/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocial;

/**
 *
 * @author LEFF
 */
public class Twitter extends Redsocial{
    private String username;
    
    public Twitter(String n, String p, String e){
        super(n, p, e);
    }
    
    public Twitter(){
        super("","","");
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        nombre = "luis";
        return username;
    }

    @Override
    public String toString() {
        return "Twitter{" + super.toString()+"username=" + username + '}';
    }
    
    @Override
    public void quienSoy(){
        System.out.println("SOY TWITTER");
    }
}
