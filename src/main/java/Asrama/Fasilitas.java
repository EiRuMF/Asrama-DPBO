/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asrama;

/**
 *
 * @author IVAN
 */
public class Fasilitas {
    private String statusKondisi;
    private String catatanLaporan;

    public Fasilitas() {
        statusKondisi = "Baik";
        catatanLaporan = "-";
    }

    public String getStatusKondisi() {
        return statusKondisi;
    }

    public String getCatatanLaporan() {
        return catatanLaporan;
    }

    public void laporkanRusak(String catatan) {
        statusKondisi = "Rusak";
        catatanLaporan = catatan;

        System.out.println("  [LAPORAN MASUK]");
        System.out.println("  Catatan : " + catatan);
        System.out.println("  Status  : " + statusKondisi);
    }

    public void tandaiSudahDiperbaiki() {
        statusKondisi = "Baik (Sudah Diperbaiki)";
        catatanLaporan = "-";

        System.out.println("  [PERBAIKAN SELESAI]");
        System.out.println("  Status : " + statusKondisi);
    }

    @Override
    public String toString() {
        return "Fasilitas [Status: " + statusKondisi
                + " | Catatan: " + catatanLaporan + "]";
    }
}