/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trycatches.prueba3;

/**
 *
 * @author Aula
 */
public class ElMain {
    public static void main(String[] args) {
        IngresoEntero ie = new IngresoEntero();
        
        int valor;
        do{
            try{
                valor = ie.leaEntero();
                break;
            }
            catch(IngresoInvalidoException e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }
}
