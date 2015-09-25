/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examenlab2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Andres
 */
public class ListaBancaria {
    private CuentaBancaria primera;

    public ListaBancaria() {
        primera = null;
    }
    
    public CuentaBancaria contains(int code){
        CuentaBancaria tmp = primera;
        while(tmp != null){
            if(tmp.codigo == code)
                return tmp;
            tmp = tmp.siguiente;
        }
        return null;
    }
    
    public boolean addCuenta(int code, String nombre){
        CuentaBancaria tmp = primera;
        CuentaBancaria obj = new CuentaBancaria(code, nombre);
        
        if(contains(code) == null){
            if(primera == null){
                primera = obj;
                return true;
            }
            while(tmp.siguiente != null && code > tmp.siguiente.codigo){
                tmp = tmp.siguiente;
            }
            obj.siguiente = tmp.siguiente;
            tmp.siguiente = obj;
            return true;
        }
        return false;
    }
    
    public void depositar(int code, double monto){
        CuentaBancaria tmp = contains(code);
        if(tmp != null)
            tmp.depositar(monto);
    }
    
    public boolean retiro(int code, double monto){
        CuentaBancaria tmp = contains(code);
        if(tmp != null){
            return tmp.retirar(monto);
        }
        return false;
    }
    
    public void generarBackup() throws IOException{
        CuentaBancaria tmp = primera;
        try(RandomAccessFile backup = new RandomAccessFile("backup_"+(new Date().getTime())+".bak", "rw")){
            while(tmp != null){
                int codigo = tmp.codigo;
                String nombre = tmp.nombre;
                double saldo = tmp.saldo;
                long date = tmp.lastDate.getTime();
                
                backup.writeInt(codigo);
                backup.writeUTF(nombre);
                backup.writeDouble(saldo);
                backup.writeLong(date);
                
                tmp = tmp.siguiente;
            }
        }
    }
    
    public void loadFromBackup(String filepath) throws IOException{
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        
        try(RandomAccessFile backup = new RandomAccessFile(filepath, "r")){
            while(backup.getFilePointer() < backup.length()){
                int codigo = backup.readInt();
                String nombre = backup.readUTF();
                double saldo = backup.readDouble();
                
                CuentaBancaria obj = new CuentaBancaria(codigo , nombre);
                obj.saldo = saldo;
                obj.lastDate = new Date(backup.readLong());
                
                cuentas.add(obj);
            }
        }
        
        primera = null;
        for(CuentaBancaria cb : cuentas){
            addCuenta(cb.codigo, cb.nombre);
        }
    }
    
    public void listado(String txtfilepath) throws IOException{
        try(FileWriter f = new FileWriter(txtfilepath)){
            CuentaBancaria tmp = primera;
            while(tmp != null){
                String text = tmp + " - " + tmp.lastDate;
                f.write(text+"\r\n");
                tmp = tmp.siguiente;
            }
        }
    }
    
    
    public void eliminarCuentas(){
        if( primera != null ){
            Calendar seis = Calendar.getInstance();
            seis.add(Calendar.MONTH, -6);

            //movamos primera
            while(primera != null && primera.lastDate.before(seis.getTime())){
                primera = primera.siguiente;
            }
            //miremos el resto solo si no quedo vacia la lista
            if(primera != null){
                CuentaBancaria tmp = primera;

                while(tmp.siguiente != null){
                    if(tmp.siguiente.lastDate.before(seis.getTime())){
                        tmp.siguiente = tmp.siguiente.siguiente;
                    }
                    tmp = tmp.siguiente;
                }
            }
        }
    }
}
