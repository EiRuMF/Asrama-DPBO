/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maintenance;

/**
 *
 * @author IVAN
 */
public class RiwayatPerbaikan {
    private String idRiwayat;
    private String tanggalPerbaikan;
    private String deskripsiPerbaikan;
    private double biayaPerbaikan;
    private String statusPerbaikan;

    public RiwayatPerbaikan(String idRiwayat, String tanggalPerbaikan, String deskripsiPerbaikan, double biayaPerbaikan, String statusPerbaikan) {
        this.idRiwayat = idRiwayat;
        this.tanggalPerbaikan = tanggalPerbaikan;
        this.deskripsiPerbaikan = deskripsiPerbaikan;
        this.biayaPerbaikan = biayaPerbaikan;
        this.statusPerbaikan = statusPerbaikan;
    }
    
    public void updateStatus(){
        
    }
    
    public void tampilkanRiwayat(){
    
    }
}
