/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biz;

/**
 *
 * @author IVAN
 */

import user.Mahasiswa;
import exception.KamarPenuhException;
import java.util.ArrayList;
import java.util.List;
import pengaduan.Keluhan;

public class MahasiswaBiz implements IMahasiswaBiz{
    private List<Mahasiswa> daftarMahasiswa;
    private List<Keluhan> daftarKeluhan = new ArrayList<>();
    
    private static final int KAPASITAS_KAMAR = 4;
    
    public MahasiswaBiz() {
        this.daftarMahasiswa = new ArrayList<>();
        inisialisasiDummy();
    }
    
    private void inisialisasiDummy() {
        Mahasiswa mhs1 = new Mahasiswa(
            "M001", "Andi Mahasiswa", "andi@student.ac.id", "mhs123", "1234567890"
        );
        mhs1.assignKamar("K-101");
        daftarMahasiswa.add(mhs1);

        Mahasiswa mhs2 = new Mahasiswa(
            "M002", "Siti Mahasiswa", "siti@student.ac.id", "mhs456", "0987654321"
        );
        daftarMahasiswa.add(mhs2);
    }
    
    @Override    
    public List<Mahasiswa> getAllMahasiswa() {
        return daftarMahasiswa;
    }   

    @Override
    public Mahasiswa cariByNim(String nim) {
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.getNim().equals(nim)) {
                return m;
            }
        }
        return null; // tidak ketemu
    }
    
    @Override
    public void lihatInfoKamar(String nim) {

        Mahasiswa mhs = cariByNim(nim);

        if (mhs == null) {
            return;
        }

        System.out.println("\n=== INFO KAMAR ===");

        System.out.println("Nama : "
            + mhs.getName());

        System.out.println("NIM : "
            + mhs.getNim());

        if (mhs.getKamarId() == null) {

        System.out.println(
                "Belum memiliki kamar");

        } else {

        System.out.println(
                "Kamar : "
                + mhs.getKamarId());
        }
    }
    
    
    @Override    
    public void assignKamar(String nim, String kamarId) throws KamarPenuhException {
        // Hitung berapa mahasiswa yang sudah di kamar ini
        int jumlahPenghuni = 0;
        for (Mahasiswa m : daftarMahasiswa) {
            if (kamarId.equals(m.getKamarId())) {
                jumlahPenghuni++;
            }
        }

        // Validasi - kalau sudah penuh, lempar exception
        if (jumlahPenghuni >= KAPASITAS_KAMAR) {
            throw new KamarPenuhException(kamarId);
        }

        // Kalau masih muat, baru di-assign
        Mahasiswa mhs = cariByNim(nim);
        if (mhs != null) {
            mhs.assignKamar(kamarId);
        }
    }

    @Override
    public void ajukanKeluhan(String nim, Keluhan keluhan) {

        Mahasiswa mhs = cariByNim(nim);

        if (mhs == null) {
            return;
        }

        daftarKeluhan.add(keluhan);

        System.out.println("Keluhan berhasil diajukan");
    }
    
    @Override
    public void tampilkanKeluhan(String nim) {

        if (daftarKeluhan.isEmpty()) {

            System.out.println("Belum ada keluhan");
             return;
        }

        for (Keluhan k : daftarKeluhan) {

            System.out.println("ID : " + k.getIdKeluhan());

            System.out.println("Judul : " + k.getJudul());

            System.out.println("Status : " + k.getStatus());

            System.out.println("----------------");
        }
    }
    
    @Override
    public void bayarSewa(String nim, int bulan) {

        Mahasiswa mhs = cariByNim(nim);

        if (mhs == null) {
            return;
        }

        if (!mhs.isStatusPenghuni()) {

            System.out.println("Belum memiliki kamar");
            return;
        }

        double total = bulan * 500000;

            System.out.println("Pembayaran berhasil");
            System.out.println("Total : Rp " + total);
    }

    @Override
    public boolean sudahPunyaKamar(String nim) {
        Mahasiswa mhs = cariByNim(nim);
        return mhs != null && mhs.isStatusPenghuni();
    }

    // Method tambahan khusus di class ini (boleh ada method di luar interface) 
    public void tambahMahasiswa(Mahasiswa mhs) {
        daftarMahasiswa.add(mhs);
    }
}
