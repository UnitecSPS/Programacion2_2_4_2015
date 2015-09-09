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
public class IngresoInvalidoException extends RuntimeException {
    public IngresoInvalidoException(){
        super("Valor Ingresado No es Correcto");
    }
}
