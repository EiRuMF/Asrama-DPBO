/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biz;

/**
 *
 * @author IVAN
 */
import user.Petugas;
import java.util.ArrayList;
import java.util.List;
import pengaduan.Keluhan;
import pengaduan.Tanggapan;


public class PetugasBiz implements IPetugasBiz {
     private List<Petugas> daftarPetugas;
     private MahasiswaBiz mahasiswaBiz;

    public PetugasBiz(MahasiswaBiz mahasiswaBiz) {
        this.mahasiswaBiz = mahasiswaBiz;
        
        daftarPetugas = new ArrayList<>();
        inisialisasiDummy();
    }
    
    private void inisialisasiDummy() {
        Petugas ptg1 = new Petugas(
            "P001", "kakang", "kakang@petugas.ac.id", "ptg123", "Pagi"
        );      
        daftarPetugas.add(ptg1);

        Petugas ptg2 = new Petugas(
            "P002", "Darrel", "jamil@petugas.ac.id", "ptg456", "Malam"
        );
        daftarPetugas.add(ptg2);
    }
     
     
    public List<Petugas> getAllPetugas() {
        return daftarPetugas;
    }


    
    @Override
    public void lihatSemuaKeluhan() {

        List<Keluhan> list = mahasiswaBiz.getDaftarKeluhan();

        if (list.isEmpty()) {
            System.out.println("Belum ada keluhan.");
            return;
        }

        System.out.println("\n===== DAFTAR KELUHAN =====");

        for (Keluhan k : list) {

            System.out.println("----------------------");
            System.out.println("ID       : " + k.getIdKeluhan());
            System.out.println("Judul    : " + k.getJudul());
            System.out.println("Kategori : " + k.getKategori());
            System.out.println("Status   : " + k.getStatus());

        }
    }
    
    @Override
    public void prosesKeluhan(String idKeluhan, String namaPetugas,String statusUpdate, String isiTanggapan) {

        for (Keluhan k : mahasiswaBiz.getDaftarKeluhan()) {

            if (k.getIdKeluhan().equalsIgnoreCase(idKeluhan)) {
        
                
                Tanggapan t = new Tanggapan(namaPetugas, statusUpdate ,isiTanggapan);
                
                k.tambahTanggapan(t);

                System.out.println("Keluhan berhasil diproses.");

                return;
            }

        }

        System.out.println("ID Keluhan tidak ditemukan.");

    }
    
}