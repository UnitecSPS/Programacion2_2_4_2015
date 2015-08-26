/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trycatches;

/**
 *
 * @author Aula
 */
public class CuentaBancaria {
    private double saldo=500;
    
    public void depositar(double m){
        if(m < 0)
            //FORMATO PARA LANZARLO: throw objeto instanciado throwable
            throw new InvalidAmountException(m);
        saldo += m;
    }
}
