/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biz;

/**
 *
 * @author IVAN
 */
import user.Petugas;
import java.util.ArrayList;
import java.util.List;


public class PetugasBiz implements IPetugasBiz {
     private List<Petugas> daftarPetugas;

    public PetugasBiz() {
        this.daftarPetugas = new ArrayList<>();
        inisialisasiDummy();
    }
    
        private void inisialisasiDummy() {
        Petugas ptg1 = new Petugas(
            "P001", "kakang", "kakang@petugas.ac.id", "ptg123", "Pagi"
        );      
        daftarPetugas.add(ptg1);

        Petugas ptg2 = new Petugas(
            "P002", "Darrel", "jamil@petugas.ac.id", "ptg456", "Malam"
        );
        daftarPetugas.add(ptg2);
    }
     
     
    public List<Petugas> getAllPetugas() {
        return daftarPetugas;
    }


    
    public void cekKeluhan() {
        System.out.println("blm ada");
    }
    
}