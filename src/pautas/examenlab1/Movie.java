package pautas.examenlab1;

import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Movie extends RentItem{
    private Calendar fecha;

    public Movie(int codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        fecha = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return super.toString() + " | ESTADO: " + getEstado() + " | - MOVIE";
    }
    
    public String getEstado(){
        Calendar limite = Calendar.getInstance();
        limite.add(Calendar.MONTH, -3);
        return limite.compareTo(fecha) <= 0 ? "ESTRENO" : "NORMAL";
    }

    @Override
    public double pagoRenta(int dias) {
        if(getEstado().equals("ESTRENO") && dias > 2)
            return precio + 50*(dias - 2);
        else if(getEstado().equals("NORMAL") && dias > 5)
            return precio + 30*(dias - 5);
        return precio;
    }
}
