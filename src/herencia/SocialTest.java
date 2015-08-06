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
public class SocialTest {
    public static void main(String[] args) {
        //UPCASTING
        RedSocial rst = new Twitter("Pancho","Pepe","pancho@patito.com");
        RedSocial rsf = new Facebook("Pancho","Pepe","pancho@patito.com");
        RedSocial rs = new RedSocial("Pancho","Pepe","pancho@patito.com");
        /*FORMATO instanceof:
            objeto instanceof Clase
        */
        if(rst instanceof Twitter){
            //dowcasting para asignarle el username
            
            //DOWNCASTING INDIRECTO
            Twitter tw = (Twitter)rst;
            tw.setUsername("@pancho");
            //DOWNCASTING DIRECTO
            System.out.println(((Twitter)rst).getUsername());
        }
        
        System.out.println("objeto: " + rst);
        
        rst.quienSoy();
        rsf.quienSoy();
        rs.quienSoy();
        
    }
}
