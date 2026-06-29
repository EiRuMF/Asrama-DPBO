/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengaduan;

/**
 *
 * @author IVAN
 */
import Biz.Reportable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Keluhan implements Reportable{
    
    private static int counter = 1;

    private String idKeluhan;
    private String judul;
    private String deskripsi;
    private Date tanggalKeluhan;
    private String status;
    private String kategori;
    private List<Tanggapan> daftarTanggapan;

    public Keluhan(String judul,String deskripsi,String kategori) {   
        this.idKeluhan = "KL" + String.format("%03d", counter++);
        
        
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.kategori = kategori;

        this.tanggalKeluhan = new Date();
        this.status = "Menunggu";
        this.daftarTanggapan = new ArrayList<>();
    }
    

    public void tambahTanggapan(Tanggapan tanggapan) {
        daftarTanggapan.add(tanggapan);
        
        this.status = tanggapan.getStatusUpdate();
    }

    public List<Tanggapan> getDaftarTanggapan() {
        return daftarTanggapan;
    }

    public String getIdKeluhan() {
        return idKeluhan;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public Date getTanggalKeluhan() {
        return tanggalKeluhan;
    }

    public String getKategori() {
        return kategori;
    }
    
    @Override
    public void buatLaporan() {
        System.out.println(this);
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void updateStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Keluhan{" +
                "idKeluhan='" + idKeluhan + '\'' +
                ", judul='" + judul + '\'' +
                ", kategori='" + kategori + '\'' +
                ", status='" + status + '\'' +
                ", tanggalKeluhan=" + tanggalKeluhan +
                '}';
    }
}
