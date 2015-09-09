/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios.cinemark;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class Cinemark {
    private RandomAccessFile rp, rt;
    public static final String ROOT = "cinemark";
    public static final int PELICULA_OFFSET = 0, SALA_OFFSET=4, TICKET_OFFSET=8;
    public static final int PRINT_ALL=0, PRINT_ACTIVE=1, PRINT_INACTIVE=2;
    
    public Cinemark(){
        try{
            new File(ROOT).mkdir();
            rp = new RandomAccessFile(ROOT+"/peliculas.cnk", "rw");
            rt = new RandomAccessFile(ROOT+"/tickets.cnk", "rw");
            initCodes();
        }
        catch(IOException e){}
    }

    private void initCodes() throws IOException{
        try(RandomAccessFile rc = new RandomAccessFile(ROOT+"/codigos.cnk", "rw")){
            if(rc.length() == 0){
                rc.writeInt(1);
                rc.writeInt(1);
                rc.writeInt(1);
            }
        }
    }
    
    private int nextCode(long offset)throws IOException{
        int code;
        try(RandomAccessFile rc = new RandomAccessFile(ROOT+"/codigos.cnk", "rw")){
            rc.seek(offset);
            code = rc.readInt();
            rc.seek(offset);
            rc.writeInt(code+1);
        }
        return code;
    }
    
    public void addMovie(String n,Rating r, TypeMovie tm, double d)throws IOException{
        rp.seek(rp.length());
        //codigo
        rp.writeInt(nextCode(PELICULA_OFFSET));
        //nombre
        rp.writeUTF(n);
        //fecha
        rp.writeLong(new Date().getTime());
        //rating
        rp.writeUTF(r.name());
        //tipo
        rp.writeUTF(tm.name());
        //duracion
        rp.writeDouble(d);
        //activo
        rp.writeBoolean(true);
    }
    
    public void printMovies(int all)throws IOException{
        rp.seek(0);
        while(rp.getFilePointer() < rp.length()){
            int cod = rp.readInt();
            String no = rp.readUTF();
            Date f = new Date(rp.readLong());
            String r = rp.readUTF();
            String t = rp.readUTF();
            double d = rp.readDouble();
            boolean a = rp.readBoolean();
            
            if(all==PRINT_ACTIVE && !a)
                continue;
            else if(all==PRINT_INACTIVE && a)
                continue;
            
            System.out.println(cod+"-"+no+" Fecha: "+f+" Rating: "+r+
                    " Tipo: "+t+"-"+d+" horas.");
        }
       
    }
    
    private RandomAccessFile getSalaFile(int n)throws IOException{
        return new RandomAccessFile(ROOT+"/sala"+n+".cnk", "rw");
    }
    
    private boolean existsSala(int n){
        String path = ROOT+"/sala"+n+".cnk";
        return new File(path).exists();
    } 
    
    public void addSala(TypeSala tipo, String horario, int cant)throws IOException{
        int numero = nextCode(SALA_OFFSET);
        try(RandomAccessFile rs = getSalaFile(numero)){
            rs.writeInt(0);
            rs.writeUTF(tipo.name());
            rs.writeDouble(tipo.precio);
            rs.writeUTF(horario);
            rs.writeInt(cant);
            for(int x=1; x <= cant; x++){
                rs.writeBoolean(false);
            }
            
        }
    }
    
    public void printSalaInfo(int n)throws IOException{
        if( existsSala(n) ){
            try(RandomAccessFile rs = getSalaFile(n)){
                //TODO: Una funcion de busqueda movie seria bueno
                
            }
        }
        else
            System.out.println("Dicha Sala no Existe");
    }
    
    public boolean assignMovieToSala(int cp, int ns)throws IOException{
        return false;
    }

}