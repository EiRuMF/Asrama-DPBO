/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

/**
 *
 * @author IVAN
 */
import Biz.AdminBiz;
import Biz.MahasiswaBiz;
import Biz.PetugasBiz;
import user.User;
import user.Mahasiswa;
import user.Petugas;
import user.Admin;

import exception.LoginGagalException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pengaduan.Keluhan;

public class Main {
    private static MahasiswaBiz mahasiswaBiz = new MahasiswaBiz();
    private static AdminBiz adminBiz = new AdminBiz();
    private static PetugasBiz petugasBiz = new PetugasBiz(mahasiswaBiz);
    private static Scanner scanner = new Scanner(System.in);

    private static User prosesLogin(String email, String password)
            throws LoginGagalException {

        for (User u : mahasiswaBiz.getAllMahasiswa()) {
            if (u.login(email, password)) {
                return u;
            }
        }

        for (User u : adminBiz.getAllAdmin()) {
            if (u.login(email, password)) {
                return u;
            }
        }

        for (User u : petugasBiz.getAllPetugas()) {
            if (u.login(email, password)) {
                return u;
            }
        }

        throw new LoginGagalException(email, 1);
    }




    public static void main(String[] args) {



        System.out.println("=====================================");
        System.out.println("  SELAMAT DATANG DI ASRAMA!  ");
        System.out.println("=====================================");

        boolean running = true;
        while (running) {
            System.out.println("\nSilakan Login");
            System.out.print("Email    : ");
            String email = scanner.nextLine();

            System.out.print("Password : ");
            String password = scanner.nextLine();

            try {

                User userLogin = prosesLogin(email, password);

                System.out.println("\nLogin berhasil! Selamat datang, " + userLogin.getName() + ".");
                System.out.println("Role: " + userLogin.getRole());


                if (userLogin instanceof Mahasiswa) {
                    menuMahasiswa((Mahasiswa) userLogin);
                } else if (userLogin instanceof Admin) {
                    menuAdmin((Admin) userLogin);
                } else if (userLogin instanceof Petugas) {
                    menuPetugas((Petugas) userLogin);
                }

                System.out.print("\nTekan Enter untuk kembali ke login...");
                scanner.nextLine();

            } catch (LoginGagalException e) {
                System.out.println("\n[ERROR] " + e.getMessage());
                System.out.println("Pastikan email dan password benar.");
            }

            System.out.print("\nKeluar dari program? (y/n): ");
            String pilihan = scanner.nextLine();
            if (pilihan.equalsIgnoreCase("y")) {
                running = false;
            }
        }

    }

    private static void menuMahasiswa(Mahasiswa mhs){
        boolean aktif = true;

        while(aktif){
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Lihat Info Kamar");        
            System.out.println("2. Ajukan Keluhan");
            System.out.println("3. Lihat Status Keluhan");
            System.out.println("4. Bayar Sewa");
            System.out.println("0. Logout");

            System.out.println("Pilih menu : ");
            String pilihan = scanner.nextLine();

            switch (pilihan){
                case "1":
                mahasiswaBiz.lihatInfoKamar(mhs.getNim());
                break;

                case "2":
                    System.out.println("Judul : ");
                    String judul = scanner.nextLine();
                    
                    System.out.println("Deskripsi : ");
                    String deskripsi = scanner.nextLine();
                    
                    System.out.print("Kategori : ");
                    String kategori = scanner.nextLine();
                                 
                    mahasiswaBiz.ajukanKeluhan(mhs.getNim(),judul, deskripsi, kategori);
                    break;
                
                case "3":
                    mahasiswaBiz.tampilkanKeluhan(mhs.getNim());
                    break;
                    
                case "4":
                    mahasiswaBiz.lihatTagihan(mhs.getNim());
                    
                    System.out.println("Masukkan nominal pembayaran : ");
                    double nominal = Double.parseDouble(scanner.nextLine());
                    
                    mahasiswaBiz.bayarSewa(mhs.getNim(), nominal);
                    break;
                    
                case "0":
                    aktif = false;
                    break;
            }

        }
    }

    private static void menuAdmin(Admin adn){}
    private static void menuPetugas(Petugas ptg){
        boolean aktif = true;

        while(aktif){
            System.out.println("\n=== MENU PETUGAS ===");
            System.out.println("1. Lihat Keluhan Mahasiswa");        
            System.out.println("2. Proses Keluhan");
            System.out.println("0. Logout");

            System.out.println("Pilih menu : ");
            String pilihan = scanner.nextLine();

            switch (pilihan){
                case "1":
                    petugasBiz.lihatSemuaKeluhan();
                break;

                case "2":
                    System.out.print("ID Keluhan : ");
                    String id = scanner.nextLine();
                    
                    System.out.print("Status : ");
                    String status = scanner.nextLine();

                    System.out.print("Catatan : ");
                    String catatan = scanner.nextLine();

                    petugasBiz.prosesKeluhan(id,ptg.getName(),status, catatan);
                    break;
                       
                case "0":
                    aktif = false;
                    break;
            }

        }

    }

}
