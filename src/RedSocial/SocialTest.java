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
        Redsocial rst = new Twitter("","","");
        Redsocial rsf = new Facebook("","","");
        Redsocial rsf1 = new Redsocial("","","");
        
        if(rst instanceof Redsocial)
            System.out.println("Es Twitter!");
        //UPCASTING
        
        System.out.println("Objeto: "+rst);
        
        rst.quienSoy();
        rsf.quienSoy();
        rsf1.quienSoy();
    }
}
