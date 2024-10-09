/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pbo;
import java.util.Scanner;

/**
 *
 * @author kurohana
 */
public class Admin extends Kamar {
    Kamar kamar = new Kamar();
    
    public void add(Kamar kamar){
        if(kamar.jumlah == 100){
            System.out.println("Kamar penuh.");
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan nomor kamar baru.");
            String kamarBaru = input.nextLine();

            kamar.jumlah += 1;
            kamar.nomorKamar[kamar.jumlah-1] = kamarBaru;
        }
    }
    
    public void cekKamar(Kamar kamar){
        System.out.println("Jumlah kamar yang tersedia: " + kamar.jumlah);
        System.out.println("Nomor kamar yang tersedia: ");
        for(int i = 0; i < kamar.jumlah; i++){
            System.out.print(kamar.nomorKamar[i] + " ");
            if(i >= 20 && i%20 == 0){
                System.out.println("");
            }
        }
    }
    
    public void delete(Kamar kamar){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan nomor kamar yang ingin dihapus: ");     
        String nomorKamar = input.nextLine();
        
        for(int i = 0; i < kamar.jumlah; i++){
            if(nomorKamar.equals(kamar.nomorKamar[i])){
                for(int j = i; j < kamar.jumlah-1; j++){
                    kamar.nomorKamar[j] = kamar.nomorKamar[j+1];
                }
                kamar.jumlah-=1;
                System.out.println("Kamar dihapus.");
                i = kamar.jumlah;
            } else {
                System.out.println("Kamar tidak ada.");
            }
        }
    }
}
