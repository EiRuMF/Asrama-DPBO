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
        System.out.println("\n=============================");
        System.out.println("  MENU MAHASISWA - " + getName());
        System.out.println("=============================");
        System.out.println("1. Lihat Info Kamar");        
        System.out.println("2. Ajukan Keluhan");
        System.out.println("3. Lihat Status Keluhan");
        System.out.println("4. Bayar Sewa");
        System.out.println("0. Logout");
        System.out.println("=============================");
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
    
    public boolean isLunas(){
        return getSisaTagihan() == 0;
    }
}
