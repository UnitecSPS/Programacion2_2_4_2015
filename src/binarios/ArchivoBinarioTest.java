/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class ArchivoBinarioTest {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        try(RandomAccessFile raf = new RandomAccessFile("misplayers.mpl", "rw")){
            //agreguemos uno nuevo
            raf.seek(raf.length());
            raf.writeInt(lea.nextInt());
            raf.writeUTF(lea.next());
            raf.writeDouble(lea.nextDouble());
            raf.writeBoolean(true);
            
            //imprimir todos los que tengo
            raf.seek(0);
            while(raf.getFilePointer() < raf.length()){
                System.out.print("["+raf.getFilePointer()+"]: "+
                        raf.readInt());
                System.out.print("-["+raf.getFilePointer()+"]: "+
                        raf.readUTF());
                System.out.print("["+raf.getFilePointer()+"]: "+
                        raf.readDouble());
                System.out.println("["+raf.getFilePointer()+"]: "+
                        raf.readBoolean());
            }
            //actualizar puntos de, sumandole:
            int cod = lea.nextInt();
            double points = lea.nextDouble();
        }
        catch(IOException e){
            
        }
    }
}
