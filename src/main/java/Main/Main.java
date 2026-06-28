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
import Asrama.Asrama;
import Asrama.Kamar;

import exception.LoginGagalException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pengaduan.Keluhan;

public class Main {
    private static MahasiswaBiz mahasiswaBiz = new MahasiswaBiz();
    private static AdminBiz adminBiz = new AdminBiz();
    private static PetugasBiz petugasBiz     = new PetugasBiz();
    private static Scanner scanner = new Scanner(System.in);
    private static Asrama asrama = new Asrama("Asrama Putra");

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
                    
                    Keluhan keluhan = new Keluhan("KL", judul, deskripsi, "Fasilitas");
                    
                    mahasiswaBiz.ajukanKeluhan(mhs.getNim(),keluhan);
                    break;

                case "3":
                    mahasiswaBiz.tampilkanKeluhan(mhs.getNim());
                    break;
                
                case "4":
                    System.out.println("Jumlah Bulan : ");
                    int bulan = Integer.parseInt(scanner.nextLine());
                    
                    mahasiswaBiz.bayarSewa(mhs.getNim(), bulan);
                    break;
                    
                case "0":
                    aktif = false;
                    break;
            }

        }
    }

    private static void menuAdmin(Admin adn){

    boolean aktif = true;

    while(aktif){

        adn.tampilkanMenu();

        System.out.print("Pilih menu : ");
        String pilihan = scanner.nextLine();

        switch(pilihan){

            case "1":
                adn.tampilkanDaftarMahasiswa();
                break;

            case "2":
                boolean kelolaKamar = true;
                while(kelolaKamar){
                    System.out.println("\n=== KELOLA DATA KAMAR ===");
                    System.out.println("1. Tambah Kamar");
                    System.out.println("2. Hapus Kamar");
                    System.out.println("3. Lihat Semua Kamar");
                    System.out.println("4. Tambah Penghuni");
                    System.out.println("5. Lapor Kerusakan");
                    System.out.println("6. Perbaiki Fasilitas");
                    System.out.println("0. Kembali");

                    System.out.print("Pilih : ");
                    String pilihKamar = scanner.nextLine();

                    switch(pilihKamar){

                        case "1":

                            System.out.print("Nomor Kamar : ");
                            String nomor = scanner.nextLine();

                            System.out.print("Lantai : ");
                            int lantai = Integer.parseInt(scanner.nextLine());

                            Kamar kamarBaru = new Kamar(nomor, lantai);

                            asrama.tambahKamar(kamarBaru);
                            System.out.println("Kamar berhasil ditambahkan.");
                            break;
                            
                        case "2":
                            System.out.print("Nomor Kamar : ");
                            String nomorHapus = scanner.nextLine();

                            if(asrama.hapusKamar(nomorHapus)){
                                System.out.println("Kamar berhasil dihapus.");
                            }else{
                                System.out.println("Kamar tidak ditemukan.");
                            }
                            break;
                            
                        case "3":
                            asrama.tampilkanSemuaKamar();
                            break;
                            
                        case "4":
                            System.out.print("Nomor Kamar : ");
                            String nomorCari = scanner.nextLine();

                            Kamar kamar =
                                    asrama.cariKamar(nomorCari);

                            if(kamar != null){

                                System.out.print("Nama Penghuni : ");
                                String nama = scanner.nextLine();

                                kamar.tambahPenghuni(nama);

                            }else{

                                System.out.println("Kamar tidak ditemukan.");
                            }
                            break;
                            
                            case "5":
                                System.out.print("Nomor Kamar : ");
                                String nomorRusak = scanner.nextLine();

                                Kamar kRusak = asrama.cariKamar(nomorRusak);

                                if(kRusak != null){
                                    System.out.print("Catatan : ");
                                    String catatan = scanner.nextLine();
                                    kRusak.laporkanFasilitasRusak(catatan);
                                }else{

                                    System.out.println("Kamar tidak ditemukan.");
                                }
                                break;
                                
                            case "6":
                                System.out.print("Nomor Kamar : ");
                                String nomorPerbaiki = scanner.nextLine();

                                Kamar kPerbaiki = asrama.cariKamar(nomorPerbaiki);

                                if(kPerbaiki != null){
                                    kPerbaiki.perbaikiFasilitas();
                                }else{
                                    System.out.println("Kamar tidak ditemukan.");
                                }
                                break;
                                
                            case "0":
                                kelolaKamar = false;
                                break;
                    }
                }
                break;

            case "3":
                System.out.print("Masukkan ID Pembayaran : ");
                String id = scanner.nextLine();

                adn.approvePembayaran(id);
                break;

            case "4":
                adn.generateLaporan();
                break;

            case "0":
                aktif = false;
                break;

            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}
    private static void menuPetugas(Petugas ptg){}

}
