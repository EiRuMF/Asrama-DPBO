/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengaduan;

import java.util.Date;

/**
 *
 * @author IVAN
 */
public class Tanggapan {
    private String idTanggapan;
    private String isi;
    private Date tanggal;

    public Tanggapan(String idTanggapan, String isi, Date tanggal) {
        this.idTanggapan = idTanggapan;
        this.isi = isi;
        this.tanggal = tanggal;
    }

    public String getIdTanggapan() {
        return idTanggapan;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    @Override
    public String toString() {
        return "[" + tanggal + "] " + isi;
    }
}