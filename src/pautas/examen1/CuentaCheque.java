/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examen1;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public final class CuentaCheque extends CuentaBancaria {
    private ArrayList<Cheque> cheques;
    
    public CuentaCheque(int c, String cli){
        super(c,cli);
        cheques = new ArrayList<>();
    }
    
    @Override
    public boolean retiro(double m){
        boolean rebote = saldo > m;
        if(!rebote)
            saldo -= m;
        cheques.add(new Cheque("Al Portador", m, rebote));
        return !rebote;
    }
    
    public void listarCheques(int pos){
        if(pos < cheques.size()){
            Cheque ch = cheques.get(pos);
            System.out.println(pos+ch.beneficiario+ch.monto+ch.rebotado);
            listarCheques(pos+1);
        }
    }
    
    @Override
    public String toString(){
        return super.toString()+"CHEQUES";
    }
}
