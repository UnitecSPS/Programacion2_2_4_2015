/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examen1;

import enums.TipoCuenta;

/**
 *
 * @author Aula
 */
public abstract class CuentaBancaria {
    protected int codigo;
    protected String cliente;
    protected double saldo;
    public TipoCuenta tipo;
    
    public CuentaBancaria(int c, String cli){
        codigo = c;
        cliente = cli;
        saldo = 500;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void deposito(double m){
        saldo += m;
    }
    
    public abstract boolean retiro(double m);
    
    @Override
    public String toString(){
        return codigo+cliente+saldo;
    }
}
