/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asrama;

/**
 *
 * @author IVAN
 */
import java.util.ArrayList;
import java.util.List;
import Asrama.Kamar;

public class Asrama {

    private String namaGedung;
    private List<Kamar> daftarKamar;

    public Asrama(String namaGedung) {
        this.namaGedung = namaGedung;
        this.daftarKamar = new ArrayList<>();
    }

    public String getNamaGedung() {
        return namaGedung;
    }

    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }

    public List<Kamar> getDaftarKamar() {
        return daftarKamar;
    }

    public void tampilkanSemuaKamar() {

        System.out.println("\n=== " + namaGedung + " ===");

        for(Kamar kamar : daftarKamar){
            kamar.tampilkanInfo();
            System.out.println();
        }
    }
    
    public boolean hapusKamar(String nomorKamar){
        for(Kamar k : daftarKamar){
            if(k.getNomorKamar().equalsIgnoreCase(nomorKamar)){
                daftarKamar.remove(k);
                return true;
            }
        }
        return false;
    }
    
    public Kamar cariKamar(String nomorKamar){
        for(Kamar k : daftarKamar){
            if(k.getNomorKamar().equalsIgnoreCase(nomorKamar)){
                return k;
            }
        }
        return null;
    }
}