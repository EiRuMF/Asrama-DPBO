/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asrama.maintenance;

import java.util.Date;

/**
 *
 * @author IVAN
 */
public class InvoiceMaintenance {
    private String idInvoice;
    private Date tanggalInvoice;
    private double totalBiaya;
    private String statusPembayaran;
    private String keterangan;

    public InvoiceMaintenance(String idInvoice, Date tanggalInvoice, double totalBiaya, String statusPembayaran, String keterangan) {
        this.idInvoice = idInvoice;
        this.tanggalInvoice = tanggalInvoice;
        this.totalBiaya = totalBiaya;
        this.statusPembayaran = statusPembayaran;
        this.keterangan = keterangan;
    }
    
    public double hitungTotalBiaya() {
        System.out.println("Menghitung total biaya...");
        return this.totalBiaya;
    }
    
    public void cetakInvoice() {
        System.out.println("===== INVOICE MAINTENANCE =====");
        System.out.println("ID Invoice       : " + idInvoice);
        System.out.println("Tanggal Invoice  : " + tanggalInvoice);
        System.out.println("Total Biaya      : " + totalBiaya);
        System.out.println("Status Pembayaran: " + statusPembayaran);
        System.out.println("Keterangan       : " + keterangan);
    }
       
}
