package RedSocial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LEFF
 */
public class SocialTest{
    public static void main(String[] args) {
        //UPCASTING
        Redsocial rst = new Twitter("Pancho","pancho@patito.com","@Pancho");
        Redsocial rsf = new Facebook("Pancho","pancho@patito.com","@Pancho");
        Redsocial rsf1 = new Redsocial("Pancho","pancho@patito.com","@Pancho"){
            
            @Override
            boolean isMe(String u, String p){
                return true;
            }
        };
        
        if(rst instanceof Twitter)
            System.out.println("Es Twitter!");
        //DOWNCASTING indirecto
        Twitter tw = (Twitter)rst;
        tw.setUsername("@Pancho");
        //DONWCASTING directo
        ((Twitter)rst).getUsername();
        
        
        System.out.println("Objeto: "+rst);
        
        rst.quienSoy();
        rsf.quienSoy();
        rsf1.quienSoy();
    }
}
