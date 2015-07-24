/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.util.Date;

/**
 *
 * @author Andres
 */
public class TestDate {
    public static void main(String[] args) {
        Date fecha1 = new Date();
        Date fecha2 = new Date(3270021);
        
        System.out.println("Fecha 1: " + fecha1 + "Ms desde el 69: " + fecha1.getTime());
        System.out.println("Fecha 2: " + fecha2);
        
        //Comparar fechas
        if(fecha1.getTime() > fecha2.getTime())
            System.out.println("Fecha 1 paso despues de fecha 2");
        
        if(fecha1.after(fecha2))
            System.out.println("Fecha 1 paso despues de fecha 2");
        
        if(fecha2.before(fecha1))
            System.out.println("Fecha 2 paso antes de fecha 2");
        
        System.out.println(fecha1.compareTo(fecha2) >= 0);
        
        long diff = fecha1.getTime() - fecha2.getTime();
        long years = diff/31556900000L;
        System.out.println("Years: " + years);
    }
}
