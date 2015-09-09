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
public class Banco {
    ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    
    public CuentaBancaria search(int c){
        return search(c,0);
    }

    private CuentaBancaria search(int c, int pos) {
        if(pos < cuentas.size()){
            if(cuentas.get(pos).getCodigo() == c)
                return cuentas.get(pos);
            return search(c,pos+1);
        }
        return null;
    }
    
    public void addCuenta(int c, String n, String t){
        if(search(c) == null){
            switch(t){
                case "AHORRO":
                    cuentas.add(new CuentaAhorro(c,n));
                    break;
                case "CHEQUE":
                    cuentas.add(new CuentaCheque(c,n));
            }
        }
    }
    
    public boolean transferir(int nc1,int nc2,double m){
        CuentaBancaria c1 = search(nc1);
        CuentaBancaria c2 = search(nc2);
        
        if(c1 != null && c2 != null){
            if(c1.retiro(m)){
                c2.deposito(m);
                return true;
            }
        }
        return false;
    }
    
    public void printInfo(int nc){
        CuentaBancaria c = search(nc);
        if( c != null ){
            System.out.println(c);
            if( c instanceof CuentaCheque )
                ((CuentaCheque)c).listarCheques(0);
        }
    }
    
    public void inactivas(){
        for(CuentaBancaria cb : cuentas){
            if(cb instanceof CuentaAhorro){
                if(!((CuentaAhorro)cb).isActiva())
                    System.out.println(cb);
            }
        }
    }
}
