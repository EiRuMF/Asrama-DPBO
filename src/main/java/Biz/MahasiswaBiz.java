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
import exception.PembayaranGagalException;
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
        return null;
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
    
        
    public List<Keluhan> getDaftarKeluhan() {
        return daftarKeluhan;
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
    public void ajukanKeluhan(String nim, String judul, String deskripsi, String kategori) {

        Mahasiswa mhs = cariByNim(nim);

        if (mhs == null) {
            return;
        }

        Keluhan keluhan = new Keluhan(judul,deskripsi,kategori);
        
        mhs.tambahKeluhan(keluhan);
        
        daftarKeluhan.add(keluhan);


        System.out.println("Keluhan berhasil diajukan");
        System.out.println("ID Keluhan : " + keluhan.getIdKeluhan());
    }
    
    @Override
    public void tampilkanKeluhan(String nim) {
        
        Mahasiswa mhs = cariByNim(nim);

        if(mhs == null){
            return;
        }

        for (Keluhan k : mhs.getDaftarKeluhan()) {

            System.out.println("ID : " + k.getIdKeluhan());

            System.out.println("Judul : " + k.getJudul());

            System.out.println("Status : " + k.getStatus());

        }
    }


    @Override
    public boolean sudahPunyaKamar(String nim) {
        Mahasiswa mhs = cariByNim(nim);
        return mhs != null && mhs.isStatusPenghuni();
    }
 
    
    public void lihatTagihan(String nim) {

    Mahasiswa mhs = cariByNim(nim);

    if (mhs == null) {
        return;
    }

    System.out.println("\n=== TAGIHAN ASRAMA ===");

    System.out.println("Total Tagihan : Rp " + mhs.getTotalTagihan());

    System.out.println("Sudah Dibayar : Rp " + mhs.getTotalDibayar());

    System.out.println("Sisa Tagihan  : Rp "+ mhs.getSisaTagihan());
}
    
    @Override
    public void bayarSewa(String nim, double nominal) throws PembayaranGagalException{
        

        Mahasiswa mhs = cariByNim(nim);

        if(mhs == null)
            throw new PembayaranGagalException("Mahasiswa tidak ditemukan.");

        if(nominal <= 0)
            throw new PembayaranGagalException("Nominal harus lebih dari 0.");

        if(nominal > mhs.getSisaTagihan())
            throw new PembayaranGagalException("Nominal melebihi sisa tagihan.");
        

        mhs.tambahPembayaran(nominal);

        System.out.println("\n=== PEMBAYARAN BERHASIL ===");
        System.out.println("Dibayar : Rp " + nominal);
        System.out.println("Sisa    : Rp " + mhs.getSisaTagihan());

        if (mhs.getSisaTagihan() == 0) {
            System.out.println("Status : LUNAS");
        }
    }
    
    public void tambahMahasiswa(Mahasiswa mhs) {
        daftarMahasiswa.add(mhs);
    }
    
    public boolean hapusMahasiswa(String nim){
        Mahasiswa mhs = cariByNim(nim);
        if(mhs != null){
            daftarMahasiswa.remove(mhs);
            return true;
        }
        return false;
    }
    
    public void tampilkanSemuaMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {

            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        System.out.println("\n===== DAFTAR MAHASISWA =====");

        for (Mahasiswa m : daftarMahasiswa) {

            System.out.println("----------------------------");
            System.out.println("ID      : " + m.getId());
            System.out.println("Nama    : " + m.getName());
            System.out.println("NIM     : " + m.getNim());
            System.out.println("Email   : " + m.getEmail());

            if (m.getKamarId() == null) {
                System.out.println("Kamar   : Belum ada");
            } else {
                System.out.println("Kamar   : " + m.getKamarId());
            }
        }
    }
    
    public void tampilkanDetailMahasiswa(String nim) {
        Mahasiswa m = cariByNim(nim);

        if (m == null) {

            System.out.println("Mahasiswa tidak ditemukan.");
            return;
        }

        System.out.println("\n===== DETAIL MAHASISWA =====");
        System.out.println("ID      : " + m.getId());
        System.out.println("Nama    : " + m.getName());
        System.out.println("NIM     : " + m.getNim());
        System.out.println("Email   : " + m.getEmail());
        System.out.println("Kamar   : " + m.getKamarId());
    }
        
}
