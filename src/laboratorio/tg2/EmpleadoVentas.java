/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laboratorio.tg2;

import java.util.Calendar;

/**
 *
 * @author Docente 17082011
 */
public final class EmpleadoVentas extends Empleado implements Comisionable {
    private double ventas[]={0,0,0,0,0,0,0,0,0,0,0,0}; 
    private final double tasaXVenta = 0.05;
            
    public EmpleadoVentas(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
    }
    
    private int getMesActual(){
        return Calendar.getInstance().get(Calendar.MONTH);
    } 
    
    void actualizarVenta(double m){
        ventas[getMesActual()] += m;
    }
    
     @Override
    public double comision() {
        return ventas[getMesActual()] * tasa();
    }

    @Override
    public double pago() {
        return salario + comision();
    }

    @Override
    public double ventaAnual() {
        double v = 0;
        for(double ve : ventas)
            v+=ve;
        return v;
    }

    @Override
    public double tasa() {
        return tasaXVenta;
    }
    
}
