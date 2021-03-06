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
        
        RedSocial.testVersion();
        
        //UPCASTING
        RedSocial rst = new Twitter("Pancho","Pepe","pancho@patito.com");
        RedSocial rsf = new Facebook("Pancho","Pepe","pancho@patito.com");
        RedSocial rs = new RedSocial("Pancho","Pepe","pancho@patito.com") {

            @Override
            boolean isMe(String u, String p) {
                return true;
            }
        };
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
        
        Commentable com = new Facebook(null, null, null);
        
        /*if(rsf instanceof Facebook)
            ((Facebook)rsf).addComment(null, null, 0);
        
        if(rsf instanceof Instagram)
            ((Instagram)rsf).addComment(null, null, 0);*/
        if(rsf instanceof Commentable)
            ((Commentable)rsf).addComment(null, null, 0);
        
        Commentable comme = new Commentable() {

            @Override
            public void addComment(String body, String autor, int idpost) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void deleteComment(int id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
