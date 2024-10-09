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
public class Customer extends Admin{
    private final String[] kamarTerpesan;
    private int jumlahPesanan;
    Kamar kamar = new Kamar();

    public Customer() {
        this.kamarTerpesan = new String[100];
    }
    
    @Override
    public void add(Kamar kamar){ 
        this.jumlahPesanan = 0;
        if (kamar.jumlah == 0){
            System.out.println("Semua kamar sudah terpesan.");
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Jumlah kamar yang ingin dipesan: ");
            this.jumlahPesanan = input.nextInt();
            
            int i = 0;
            while(i < this.jumlahPesanan){
                this.kamarTerpesan[i] = kamar.nomorKamar[kamar.jumlah-1];
                i++;
                kamar.jumlah--;
            }
            System.out.println("Sukses memesan. Terimakasih ^-^");
        }
    }

    @Override
    public void cekKamar(Kamar kamar){
        System.out.println("Kamar tersedia: ");
        for(int i = 0; i < kamar.jumlah; i++){
            System.out.print(kamar.nomorKamar[i] + " ");
            if(i >= 20 && i%20 == 0){
                System.out.println("");
            }
        }
        System.out.println("");
    }
    
    public void cekDetailPesanan(){
        if(this.jumlahPesanan == 0){
            System.out.println("Anda belum memesan kamar. Silahkan pesan terlebih dahulu.");
        } else {
            System.out.println("Anda memesan: " + this.jumlahPesanan + " kamar.");
            System.out.println("Nomor kamar anda:");
            int i = 0;
            while(i < this.jumlahPesanan){
                System.out.print(this.kamarTerpesan[i] + " ");
                i++;
            }
        }
        System.out.println("");
    }
    
    @Override
    public void delete(Kamar kamar){
        if(this.jumlahPesanan != 0){
            Scanner input = new Scanner(System.in);

            System.out.print("Masukkan nomor kamar yang ingin anda batalkan: ");
            String nomorKamar = input.nextLine();
            
            kamar.jumlah++;
            
            for(int i = 0; i < this.jumlahPesanan; i++){
                if(nomorKamar.equals(this.kamarTerpesan[i])){
                    kamar.nomorKamar[kamar.jumlah-1] = nomorKamar;
                    
                    // update reservation list
                    for(int a = i; a < this.jumlahPesanan; a++){
                        this.kamarTerpesan[a] = this.kamarTerpesan[a+1];
                    }
                    this.jumlahPesanan--;
                    System.out.println("Pemesanan dibatalkan.");
                    i = this.jumlahPesanan;
                } else {
                    System.out.println("Anda tidak memesan kamar ini.");
                    i = this.jumlahPesanan;
                }
            }
        } else {
            System.out.println("Anda belum memesan kamar.");
        }
    }
}
