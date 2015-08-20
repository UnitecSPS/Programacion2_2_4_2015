/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Aula
 */
public enum TipoCuenta {
    PLANILLA(0), PLAZOFIJO(0.2), AHORRO(0.05);
    private double tasa;
    
    private TipoCuenta(double t){
        tasa = t;
    }
    
    public double tasa(){
        return tasa;
    }
}
