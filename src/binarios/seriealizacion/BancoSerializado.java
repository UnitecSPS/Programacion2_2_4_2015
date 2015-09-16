/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios.seriealizacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Aula
 */
public class BancoSerializado {
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("cuentas.bak");
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        
        ous.writeObject(new CuentaBancaria(1, "Messi", 5000));
        
        FileInputStream fis = new FileInputStream("cuentas.bak");
        ObjectInputStream ois = new ObjectInputStream(fis);
        CuentaBancaria cb = (CuentaBancaria)ois.readObject();
        System.out.println(cb);
    }
}
