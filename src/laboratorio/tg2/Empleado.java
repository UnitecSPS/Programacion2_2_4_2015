/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.tg2;

import java.util.Date;

/**
 *
 * @author Aula
 */
public abstract class Empleado {
    protected int codigo;
    protected String nombre;
    protected Date contratacion;
    protected double salario;

    public Empleado(int codigo, String nombre, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        contratacion = new Date();
    }

    public int getCodigo() {
        return codigo;
    }
    
    public abstract double pago();

    @Override
    public String toString() {
        return "codigo=" + codigo + ", nombre=" + nombre;
    }
    
    
}
