/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestRawEnum {
    public static void main(String[] args) {
        RawDiaSemana dia;
        //los valores disponibles
        for(RawDiaSemana ds : RawDiaSemana.values())
            System.out.print(ds+" ");
        //asignarle un valor directamente
        dia = RawDiaSemana.JUEVES;
        System.out.println("\n"+dia);
        System.out.println("ordinal: " + dia.ordinal());
        
        if( dia == RawDiaSemana.JUEVES )
            System.out.println("Si es Jueves!");
        
         //ASIGNARLO SEGUN UN VALOR INGRESADO DEL TECLADO
        Scanner lea = new Scanner(System.in);
        dia = RawDiaSemana.valueOf(lea.next().toUpperCase());
        System.out.println("Dia Ingresado: " + dia+" con ordinal: "+
                dia.ordinal());
    }
}
