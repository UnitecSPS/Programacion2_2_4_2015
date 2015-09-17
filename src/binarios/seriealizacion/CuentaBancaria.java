/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios.seriealizacion;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class CuentaBancaria implements Serializable {
    public int codigo;
    public String nombre;
    public double saldo;
    public transient Date fecha;

    public CuentaBancaria(int codigo, String nombre, double saldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.saldo = saldo;
        fecha = new Date();
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "codigo=" + codigo + ", nombre=" + nombre + ", saldo=" + saldo + ", fecha=" + fecha + '}';
    }
    
    
}
