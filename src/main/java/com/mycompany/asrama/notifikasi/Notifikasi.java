/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asrama.notifikasi;

import java.util.Date;

/**
 *
 * @author IVAN
 */
public class Notifikasi {
    private String idNotifikasi;
    private String pesan;
    private Date tanggal;
    private boolean status;

    public Notifikasi(String idNotifikasi, String pesan, Date tanggal, boolean status) {
        this.idNotifikasi = idNotifikasi;
        this.pesan = pesan;
        this.tanggal = tanggal;
        this.status = status;
    }
    
    public void kirimNotifikasi() {
        
    }
    
    public void tandaiDibaca() {
        
    }
    
    public String getPesan() {
        
        return null;
        
    }
}
