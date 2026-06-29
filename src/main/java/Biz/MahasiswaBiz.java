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
    
    
    @Override    
    public void assignKamar(String nim, String kamarId) throws KamarPenuhException {
        
        int jumlahPenghuni = 0;
        for (Mahasiswa m : daftarMahasiswa) {
            if (kamarId.equals(m.getKamarId())) {
                jumlahPenghuni++;
            }
        }

        
        if (jumlahPenghuni >= KAPASITAS_KAMAR) {
            throw new KamarPenuhException(kamarId);
        }

        
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
    public void bayarSewa(String nim, double nominal) {

    Mahasiswa mhs = cariByNim(nim);

    if (mhs == null) {
        System.out.println("Mahasiswa tidak ditemukan");
        return;
    }

    if (nominal <= 0) {
        System.out.println("Nominal harus lebih dari 0");
        return;
    }

    if (nominal > mhs.getSisaTagihan()) {
        System.out.println("Nominal melebihi sisa tagihan");
        return;
        }

        mhs.tambahPembayaran(nominal);

        System.out.println("\n=== PEMBAYARAN BERHASIL ===");
        System.out.println("Dibayar : Rp " + nominal);
        System.out.println("Sisa    : Rp " + mhs.getSisaTagihan());

        if (mhs.getSisaTagihan() == 0) {
            System.out.println("Status : LUNAS");
        }
    }
}
