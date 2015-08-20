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
public class RawDiaSemana {
    private int ordinal;
    private String name;
    
    public static final RawDiaSemana DOMINGO = new RawDiaSemana(0,"DOMINGO");
    public static final RawDiaSemana LUNES = new RawDiaSemana(1,"LUNES");
    public static final RawDiaSemana MARTES = new RawDiaSemana(2,"MARTES");
    public static final RawDiaSemana MIERCOLES = new RawDiaSemana(3,"MIERCOLES");
    public static final RawDiaSemana JUEVES = new RawDiaSemana(4,"JUEVES");
    public static final RawDiaSemana VIERNES = new RawDiaSemana(5,"VIERNES");
    public static final RawDiaSemana SABADO = new RawDiaSemana(6,"SABADO");

    public static RawDiaSemana[] values(){
        RawDiaSemana vals[] = { DOMINGO, LUNES, MARTES, MIERCOLES, JUEVES,
            VIERNES, SABADO };
                
        return vals;
    }
    
    public static RawDiaSemana valueOf(String name){
        switch(name){
            case "DOMINGO":
                return DOMINGO;
            case "LUNES":
                return LUNES;
            case "MARTES":
                return MARTES;
            case "MIERCOLES":
                return MIERCOLES;
            case "JUEVES":
                return JUEVES;
            default:
                throw new IllegalArgumentException(name + " no es valido");
        }
    }
    
    private RawDiaSemana(int o, String n){
        ordinal = o;
        name = n;
    }

    public int ordinal() {
        return ordinal;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
