/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examenlab2;

import java.util.Date;

/**
 *
 * @author Andres
 */
public class CuentaBancaria {
    public int codigo;
    public String nombre;
    public double saldo;
    public Date lastDate;
    public CuentaBancaria siguiente;

    public CuentaBancaria(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.saldo = 500;
        this.lastDate = new Date();
        this.siguiente = null;
    }
    
    public void depositar(double monto){
        if(monto > 0){
            saldo += monto;
            lastDate = new Date();
        }
    }
    
    public boolean retirar(double monto){
        if(saldo >= monto && monto > 0){
           saldo -= monto;
           lastDate = new Date();
           return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " - Lps. " + saldo;
    }
}
