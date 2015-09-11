/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios.cinemark;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
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
    
    public long searchMovie(int cp)throws IOException{
        rp.seek(0);
        while(rp.getFilePointer() < rp.length()){
            int cod = rp.readInt();
            if(cod == cp)
                return rp.getFilePointer();
            rp.readUTF();
            rp.readLong();
            rp.readUTF();
            rp.readUTF();
            rp.skipBytes(9);
        }
        return -1;
    }
    
    public void printSalaInfo(int n)throws IOException{
        if( existsSala(n) ){
            try(RandomAccessFile rs = getSalaFile(n)){
                //TODO: Una funcion de busqueda movie seria bueno
                int cp = rs.readInt();
                //busco esa pelicula
                long pos = searchMovie(cp);
                if(pos!=-1){
                    //saco su nombre
                    System.out.println("Movie: "+ rp.readUTF());
                }
                else{
                    System.out.println("-No tiene pelicula asignada.");
                }
                //tipo
                System.out.println("Tipo: "+rs.readUTF());
                //precio
                System.out.println("Precio: Lps."+rs.readDouble());
                //horario
                System.out.println("Horario: "+rs.readUTF());
                //asientos
                int asientos = rs.readInt();
                System.out.println("Asientos: "+asientos);
                //ocupados
                for(int x=1; x<= asientos; x++){
                    System.out.println("A["+x+"]: "+ 
                            (rs.readBoolean() ? "X" : "_"));
                }
            }
        }
        else
            System.out.println("Dicha Sala no Existe");
    }

    
    public boolean assignMovieToSala(int cp, int ns)throws IOException{
        if(existsSala(ns)){
            long pos = searchMovie(cp);
            
            if(pos != -1){
                String np = rp.readUTF();
                rp.readLong();
                rp.readUTF();
                rp.readUTF();
                rp.readDouble();
                
                if(rp.readBoolean()){
                    try(RandomAccessFile rs = getSalaFile(ns)){
                        rs.writeInt(cp);
                        System.out.println(np+" Asignada a Sala#"+ns);
                        return true;
                    }
                }
                else
                    System.out.println(np+ " No esta disponible");
            }
            else
                System.out.println("No existe");
        }
        else
            System.out.println("No existe Sala");
        
        return false;
    }
    
    public boolean venderTicket(int sala, int asiento)throws IOException{
        if(existsSala(sala)){
            try(RandomAccessFile rs = getSalaFile(sala)){
                int cp = rs.readInt();
                rs.readUTF();
                double p = rs.readDouble();
                //crear ticket
                rt.seek(rt.length());
                //codigo t
                rt.writeInt(nextCode(TICKET_OFFSET));
                //sala
                rt.writeInt(sala);
                //pelicula
                rt.writeInt(cp);
                //precio
                rt.writeDouble(p);
                //fecha
                rt.writeLong(new Date().getTime()); 
            }
            return true;
        }
        return false;
    }
     /*
    TRABAJO EN GRUPO 3:
    -------------------------------------
    1- (10%)En vender ticket, validar que la sala tenga una pelicula asignada, que
      el numero de asiento sea correcto segun el tamaño de la sala y que este
      esté desocupado, si se cumple todo esto, se escribe true en dicho booleano
      que representa ese asiento.
    */
    
    /**
     * 2- (20%)Esta función imprime todo el detalle de los tickets vendidos para una
     * sala especifica. Se imprime el nombre de la pelicula junto con su código.
     * El precio pagado y la fecha de cuando se pago. Se toman en cuenta TODOS
     * los tickets guardados desde la fecha beginning hasta la actualidad.
     * AL FINAL se imprime el MONTO TOTAL SUMADO entre el precio de todos los 
     * tickets vendidos.
     * Si la sala NO existe, se imprime dicha información.
     * @param sala Numero de la sala
     * @param beginning Fecha de inicio del reporte
     * @throws java.io.IOException
     */
    public void ticketsSoldInSala(int sala, Date beginning)throws IOException{
        RandomAccessFile rs = getSalaFile(sala);
        System.out.println("Codigo Pelicula: "+rs.readInt());
        System.out.println("Nombre Pelicula: "+rs.readUTF());
        
    }
    
    /**
     * 3- (25%)Funcion que imprime la cartelera del cine en pantalla. Se toman en
     * cuenta TODAS las salas que tengan una pelicula asignada. Se imprime:
     * - Sala #X Exhibe la pelicula: ####-[RATING]=[TIPO] en horario de: ####
     *    Lps. PRECIO - Tickets vendidos: CANTIDAD VENDIDOS/TOTAL ASIENTOS.
     * SI txtfile viene != "" se agarra ese valor como la direccion para expotar
     * TODO este detalle a un archivo de texto donde al principio se escribe:
     *  "CARTELERA DEL CINE PARA LA [FECHA]"
     * NOTA: Para no duplicar codigos analicen como pueden usar el mismo texto
     * que imprimen para tambien escribirlo en el archivo de texto si es
     * necasario. Ademas si dicho archivo ya existia, se limipia todo cuando
     * se comienza a escribir
     * @param txtfile Dirección del archivo de texto a exportar. 
     */
    public void cartelera(String txtfile){
        
    }
    
    /**
     * 4- (10%)Funcion que hace que una pelicula se vuelva inactiva. Una pelicula
     * asi ya no se puede asignar a una sala. Validar que la pelicula exista.
     * @param cp Codigo de la pelicula
     * @return Retornar true si se pudo inhabilitar o no.
     */
    public boolean existPelicula(int cp)throws IOException{ 
        rp.seek(0);
        while(rp.getFilePointer() < rp.length()){
            if(cp == rp.readInt()){                
                return true;
            }
            rp.readUTF();
            rp.readLong();
            rp.readUTF();
            rp.readUTF();
            rp.readDouble();
            rp.readBoolean();
            
        }
        return false;
        
    }    
    
    public boolean disableMovie(int cp)throws IOException{
        if(existPelicula(cp)){
            rp.seek(0);
            while(rp.getFilePointer() < rp.length()){         
                int c = rp.readInt();
                rp.readUTF();
                rp.readLong();
                rp.readUTF();
                rp.readUTF();
                rp.readDouble();
                if(c == cp){
                    rp.writeBoolean(false);
                    return true;
                }else{
                    rp.readBoolean();
                }
            }   
        }
        return false;
    }    
    
    /**
     * 5- (15%)Funcion que vuelve a escribir false TODOS los asientos de una Sala
     * EXISTENTE en el cine. Pero tiene una validación que SOLO lo hace si la
     * hora actual es > 11 PM, si no lo es, se informa que aun no se puede 
     * limpiar la sala.
     * @param sala Numero de la sala
     */
    public void cleanSala(int sala)throws IOException{
        Calendar hour = Calendar.getInstance();
        if(23 == hour.get(Calendar.HOUR_OF_DAY)){
            if(existsSala(sala)){
                RandomAccessFile rs = getSalaFile(sala);
                rs.readInt();
                rs.readUTF();
                rs.readDouble();
                rs.readUTF();
                int c = rs.readInt();
                for(int x=1; x <= c; x++){
                    rs.writeBoolean(false);
                }
            }
        }
    }
    
    /**
     * 6- (20%)Imprime todas las peliculas [codigo-nombre] que han vendido en toda
     * su historia minimo la cantidad de tickets que se pide de parametro.
     * @param minimo Cantidad minima de tickets vendidos necesarios
     */
    public void taquilleras(int minimo){
        
    }
    
    /**
     * 7- (5%)Agregar dichas funciones al main de Cine.
     */
    
    

}
