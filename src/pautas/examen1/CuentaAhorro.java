/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examen1;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public final class CuentaAhorro extends CuentaBancaria {
    private Calendar ultimaModi;
    public static final double TASA_INTERES=0.2;
    
    public CuentaAhorro(int c, String cli){
        super(c,cli);
        ultimaModi = Calendar.getInstance();
    }
    
    public final boolean isActiva(){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, -6);
        return now.before(ultimaModi);
    }
    
    @Override
    public void deposito(double m){
        if(!isActiva())
            m *= 0.9;
        saldo += m;
        ultimaModi = Calendar.getInstance();
    }
    
    @Override
    public boolean retiro(double m){
        if(isActiva() && saldo > m){
            saldo -= m;
            ultimaModi = Calendar.getInstance();
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return super.toString()+"AHORRO"+(isActiva() ? "-ACTIVADA" : "-DESACTIVADA");
    }
}
