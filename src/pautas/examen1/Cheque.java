/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examen1;

/**
 *
 * @author Aula
 */
public class Cheque {
    String beneficiario;
    double monto;
    boolean rebotado;

    public Cheque(String beneficiario, double monto, boolean rebotado) {
        this.beneficiario = beneficiario;
        this.monto = monto;
        this.rebotado = rebotado;
    }
    
    
}
