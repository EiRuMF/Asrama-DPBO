/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asrama.pengaduan;

import java.util.Date;

/**
 *
 * @author IVAN
 */
public class Pelanggaran {
    private String idPelanggaran;
    private String judul;
    private String deskripsi;
    private Date tanggalPelanggaran;
    private String status;

    public Pelanggaran(String idPelanggaran, String judul, String deskripsi, Date tanggalPelanggaran, String status) {
        this.idPelanggaran = idPelanggaran;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalPelanggaran = tanggalPelanggaran;
        this.status = status;
    }

    public String getIdPelanggaran() {
        return idPelanggaran;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public Date getTanggalPelanggaran() {
        return tanggalPelanggaran;
    }

    public String getStatus() {
        return status;
    }
    
    public void laporanPelanggaran() {
        
    }
    
    public void selesaikanPelanggaran() {
        
    }
}
