/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author IVAN
 */
import java.util.ArrayList;
import java.util.List;
import pengaduan.Keluhan;

public class Mahasiswa extends User {
    private String nim;
    private String kamarId;
    private boolean statusPenghuni;
    private double totalSewa;
    private double totalDibayar;
    
    private List<Keluhan> daftarKeluhan; 

    public Mahasiswa(String id, String name, String email, String password, String nim ) {
        super(id, name, email, password, "MAHASISWA");
        this.nim = nim;
        this.kamarId = null; 
        this.statusPenghuni =  false;
        this.daftarKeluhan = new ArrayList<>();
        
        this.totalSewa = 7000000;
        this.totalDibayar = 0;  
    }
    
    
    
    @Override
    public void tampilkanMenu() {
    }
    
    public void tambahKeluhan(Keluhan keluhan){
        daftarKeluhan.add(keluhan);
    }
    
    public List<Keluhan> getDaftarKeluhan(){
        return daftarKeluhan;
    }
    
    public String getNim(){ 
        return nim; 
    }
    public String getKamarId(){
        return kamarId; 
    }
    public boolean isStatusPenghuni() {
        return statusPenghuni;
    }
    
    public void assignKamar(String kamarId) {
        this.kamarId = kamarId;
        this.statusPenghuni = true;
    }

    public double getTotalTagihan() {
        return totalSewa;
    }

    public double getTotalDibayar() {
        return totalDibayar;
    }

    public double getSisaTagihan() {
        return totalSewa - totalDibayar;
    }

    public void tambahPembayaran(double nominal) {
        totalDibayar += nominal;
    }
}
