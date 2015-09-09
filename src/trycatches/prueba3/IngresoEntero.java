/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trycatches.prueba3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class IngresoEntero {
    private Scanner lea = new Scanner(System.in);
    
    public int leaEntero(){
        try{
            return lea.nextInt();
        }
        catch(InputMismatchException e){
            lea.next();
            throw new IngresoInvalidoException();
        }
        catch(Exception e){
            return -1;
        }
    }
}
