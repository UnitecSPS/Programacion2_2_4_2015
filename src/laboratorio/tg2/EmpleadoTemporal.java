/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.tg2;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public final class EmpleadoTemporal extends Empleado {
    private Calendar fechaFin;
            
    public EmpleadoTemporal(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
        fechaFin = Calendar.getInstance();
    }

    public void setFechaFin(int y,int m, int d) {
        this.fechaFin.set(y, m, d);
    }
    
    @Override
    public double pago() {
        Calendar now = Calendar.getInstance();
        if(now.before(fechaFin))
            return salario;
        return 0;
    }

    @Override
    public String toString() {
        return super.toString()+", Fecha Fin="+fechaFin.getTime();
    }
    
    
}
