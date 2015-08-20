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
public class TestEnum {
    public static void main(String[] args) {
        DiaSemana dia;
        //los valores disponibles
        for(DiaSemana ds : DiaSemana.values())
            System.out.print(ds+" ");
        //asignarle un valor directamente
        dia = DiaSemana.JUEVES;
        System.out.println("\n"+dia);
        System.out.println("ordinal: " + dia.ordinal());
        //comparar
        if( dia == DiaSemana.JUEVES )
            System.out.println("SI ES JUEVES!");
        switch(dia){
            case JUEVES:
                System.out.println("SI YA TE DIJE QUE ES JUEVES!");
        }
        if( dia.equals(DiaSemana.JUEVES))
            System.out.println("SII OMBE! ES JUEVES!");
        if( dia.name().equals("JUEVES"))
            System.out.println("QUE MOLESTAS! QUE TE QUEDE CLARO QUE ES JUEVES!");
        if( dia.ordinal() == 4 )
            System.out.println("LA ULTIMA VEZ QUE TE DIGO QUE ES JUEVES!");
        //ASIGNARLO SEGUN UN VALOR INGRESADO DEL TECLADO
        Scanner lea = new Scanner(System.in);
        dia = DiaSemana.valueOf(lea.next().toUpperCase());
        System.out.println("Dia Ingresado: " + dia+" con ordinal: "+
                dia.ordinal());
    }
}
