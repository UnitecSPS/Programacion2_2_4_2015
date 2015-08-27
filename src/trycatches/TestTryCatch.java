/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trycatches;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestTryCatch {
    public static void main(String[] args) {
        System.out.println("---INICIANDO MAIN---");
        
        try{
            A();
            System.out.println("Finalizando Try de main");
        }
        catch(ArrayIndexOutOfBoundsException | ArithmeticException e){
            System.out.println("Ingrese una coordenada correcta");
            //int x = 5/0;
        }
        catch(InputMismatchException e){
            System.out.println("Por favor ingrese un valor correcto");
        }
        catch(Exception e){
            System.out.println("Error: "+e);
            //e.printStackTrace();
            System.out.println(e.getStackTrace()[0].getFileName());
            System.out.println(e.getStackTrace()[0].getLineNumber());
            System.out.println(e.getStackTrace()[0].getMethodName());
            System.out.println(e.getStackTrace()[0].toString());
        }
        finally{
            System.out.println("Aqui Se ejecuta siempre!!");
        }
        
        System.out.println("---FINALIZANDO MAIN---");
    }

    private static void A() {
        System.out.println("---INICIANDO A---");
        //try{
            B();
            
        /*}
        catch(Exception e){
            System.out.println("Error: "+e);
        }*/
        System.out.println("---FINALIZANDO A---");
    }

    private static void B() {
        System.out.println("---INICIANDO B---");
        Scanner lea = new Scanner(System.in);
        lea.close();
        int pos = lea.nextInt();
        int arr[] = {0,1,2,3};
        System.out.println(5/arr[pos]);
        System.out.println("---FINALIZANDO B---");
    }
}
