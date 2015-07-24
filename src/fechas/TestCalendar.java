/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Andres
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar cal1 = Calendar.getInstance();
        System.out.println(cal1.getTime());
        
        //Yo configuro una fecha especifica
        cal1.set(1996, Calendar.MARCH, 19);
        System.out.println(cal1.getTime());
        
        //Extraer valores epecificos
        System.out.println("Milis: " + cal1.getTimeInMillis());
        System.out.println("ERA: " + cal1.get(Calendar.ERA));
        System.out.println("Año: " + cal1.get(Calendar.YEAR));
        System.out.println("Dia: " + cal1.get(Calendar.DATE));
        System.out.println("Dia en el año: " + cal1.get(Calendar.DAY_OF_YEAR));
        System.out.println("Dia en la semana: " + cal1.get(Calendar.DAY_OF_WEEK));
        
        //Comparar
        Calendar now = Calendar.getInstance();
        
        if(now.after(cal1))
            System.out.println("Now paso despues de call");
        if(cal1.before(now))
            System.out.println("Cal1 paso antes de now");
        
        //Adicionar o restar valores
        cal1.add(Calendar.YEAR, 2);
        System.out.println(cal1.getTime());
        
        cal1.add(Calendar.MONTH, 15);
        System.out.println(cal1.getTime());
        
        cal1.add(Calendar.DATE, -20);
        System.out.println(cal1.getTime());
        
        String name = cal1.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.forLanguageTag("es"));
        System.out.println(name);
        
        
    }
}
