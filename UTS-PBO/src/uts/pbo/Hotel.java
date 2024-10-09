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
public class Hotel implements Menu{
    Scanner input = new Scanner(System.in);
    Kamar kamar = new Kamar();
    Admin admin = new Admin();
    Customer customer = new Customer();
    String pilihan;

    @Override
    public void mainMenu(){
        do {
            System.out.println("===== Selamat Datang di Hotel Zell =====");
            System.out.print("1. Login\n2. Keluar\nMasukkan pilihan : ");
            pilihan = input.nextLine();
            switch(pilihan){
                case "1":
                    menuLogin();
                    break;
                case "2":
                    System.out.println("Sampai jumpa lagi.");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        } while (!"2".equals(pilihan));      
    }
    @Override
    public void menuLogin(){
        System.out.println("\n===== Login =====");
        System.out.print("Masukkan Username Anda: ");
        String username = input.nextLine();
        System.out.print("Masukkan Password Anda: ");
        String password = input.nextLine();
        Login login = new Login(username, password);
        String isAdmin = login.cekUser();

        switch (isAdmin) {
            case "admin":
                menuAdmin();
                break;
            case "customer":
                menuCustomer();
                break;
            default:
                System.out.println("Invalid User.\n");
        }
    }
    @Override
    public void menuAdmin(){
        do {
            System.out.println("\n===== Menu Admin =====\n");
            System.out.print("1. Tambah Kamar\n2. Cek Kamar\n3. Hapus Kamar\n4. Keluar\n");
            System.out.print("Masukkan pilihan: ");
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    admin.add(kamar);
                    break;
                case "2":
                    admin.cekKamar(kamar);
                    break;
                case "3":
                    admin.delete(kamar);
                    break;
                case "4":
                    System.out.println("Keluar.\n");
                    break;
                default:
                    System.out.println("Invalid input.\n");
            }
        } while (!"4".equals(pilihan));
    }
    @Override
    public void menuCustomer(){
        do {
            System.out.println("\n===== Menu Customer =====\n");
            System.out.print("1. Pesan Kamar\n2. Cek Kamar \n3. Check Detail Pesanan\n4. Batalkan Pesanan\n5. Keluar\n");
            System.out.print("Masukkan pilihan: ");
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    customer.add(kamar);
                    break;
                case "2":
                    customer.cekKamar(kamar);
                    break;
                case "3":
                    customer.cekDetailPesanan();
                    break;
                case "4":
                    customer.delete(kamar);
                    break;
                case "5":
                    System.out.println("Keluar.\n");
                    break;
                default:
                    System.out.println("Invalid input.\n");
            }
        } while (!"5".equals(pilihan));
    }
}
