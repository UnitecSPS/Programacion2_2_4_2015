/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios.cinemark;

/**
 *
 * @author Aula
 */
public enum TypeSala{
    S2D(80), S3D(150), XD3D(180), XD2D(120), IMAX(200), PREMIER(500);
    double precio;
    TypeSala(double p){
        precio=p;
    }
}
