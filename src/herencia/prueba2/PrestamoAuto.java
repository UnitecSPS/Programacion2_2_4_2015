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
public class PrestamoAuto extends Prestamo {
    private double montoSeguro;
    
    public PrestamoAuto(int c,double mt){
        super(c,mt);
        montoSeguro = mt * 0.3;
    }
    
    @Override
    public void pagar(double m){
        super.pagar(m);
        if(balance==0)
            balance = montoSeguro;
    }
}
