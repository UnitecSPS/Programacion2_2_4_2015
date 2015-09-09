/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import pautas.examen1.CuentaAhorro;

/**
 *
 * @author Aula
 */
public class TestTipoCuenta {
    public static void main(String[] args) {
        CuentaAhorro ahorro = new CuentaAhorro(1, "Carlos");
        System.out.println(ahorro.tipo.tasa());
    }
}
