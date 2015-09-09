/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.prueba2;

/**
 *
 * @author Aula
 */
public class Prestamo {
    protected int codigo;
    protected double montoTotal, balance;
    
    public Prestamo(int c, double mt){
        codigo = c;
        montoTotal = mt;
        balance = mt;
    }
    
    public void pagar(double m){
        if( m > balance )
            m = balance;
        balance -= m;
    }
}
