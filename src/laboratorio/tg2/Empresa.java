/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.tg2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class Empresa {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    static Scanner lea = new Scanner(System.in);
    
    public Empleado search(int c){
        for(Empleado e : empleados){
            if(e.getCodigo() == c)
                return e;
        }
        return null;
    }
    
    public void AgregarEmpleado(int co, String no, String ti){
        if(search(co) == null){
            double sal = lea.nextDouble();
            
            switch(ti.toUpperCase()){
                case "NORMAL":
                    empleados.add(new Empleado(co,no,sal) {

                        @Override
                        public double pago() {
                            return salario - salario*0.035;
                        }
                    });
                    break;
                case "TEMPORAL":
                    empleados.add(new EmpleadoTemporal(co, no, sal));
                    break;
                case "VENTA":
                    empleados.add(new EmpleadoVentas(co, no, sal));
                    break;
            }
        }
    } 
    
    public double pagarEmpleado(int codigo){
        Empleado em = search(codigo);
        if(em != null)
            return em.pago();
        return 0;
    }
    
    public void registrarVenta(int codigo, double m){
        Empleado em = search(codigo);
        if(em instanceof EmpleadoVentas)
            ((EmpleadoVentas)em).actualizarVenta(m);
    }
    
    public void setFechaFin(int codigo, int year, int dia, int mes){
        Empleado em = search(codigo);
        if(em instanceof EmpleadoTemporal){
            ((EmpleadoTemporal)em).setFechaFin(year, mes, dia);
        }
    }
    
    public void imprimir(){
        int empleado=0, ventas=0, temps=0;
        
        for(Empleado em : empleados){
            System.out.println("-" + em);
            if( em instanceof EmpleadoVentas)
                ventas++;
            else if(em instanceof EmpleadoTemporal)
                temps++;
            else
                empleado++;
        }
        System.out.println(empleado+"-"+ventas+"-"+temps);
    }
    
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
    }
}   
