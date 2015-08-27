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
public class Banco {
    public static void main(String[] args) {
        try {
            depositar();
        } catch (Exception ex) {
        }
    }

    private static void depositar()throws Exception {
        CuentaBancaria cb = new CuentaBancaria();
        cb.depositar(-5000);
    }
}
