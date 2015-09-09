/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.examenlab1;

public abstract class RentItem {
    protected int codigo;
    protected String nombre;
    protected double precio;

    public RentItem(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
         return "CODIGO: " + codigo + " | NOMBRE: " + nombre.toUpperCase() + " | PRECIO: " + precio; 
    }
    
    public abstract double pagoRenta(int dias);

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
