/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asrama;
import Asrama.Fasilitas;
/**
 *
 * @author IVAN
 */
import java.util.ArrayList;
import java.util.List;

public class Kamar {

    private String nomorKamar;
    private int lantai;
    private final int kapasitas;
    private List<String> daftarPenghuni;
    private Fasilitas fasilitas;

    public Kamar(String nomorKamar, int lantai) {
        this.nomorKamar = nomorKamar;
        this.lantai = lantai;
        this.kapasitas = 4;
        this.daftarPenghuni = new ArrayList<>();
        this.fasilitas = new Fasilitas();
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public int getLantai() {
        return lantai;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public List<String> getDaftarPenghuni() {
        return daftarPenghuni;
    }

    public Fasilitas getFasilitas() {
        return fasilitas;
    }

    public boolean isKamarPenuh() {
        return daftarPenghuni.size() >= kapasitas;
    }
    
    public void tambahPenghuni(String namaMahasiswa){
        if(isKamarPenuh()){
            System.out.println("Kamar sudah penuh.");
            return;
        }
        daftarPenghuni.add(
                namaMahasiswa);
    }
    
    public void hapusPenghuni(String namaMahasiswa){
        daftarPenghuni.remove(namaMahasiswa);
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Kamar : " + nomorKamar);
        System.out.println("Lantai      : " + lantai);
        System.out.println("Penghuni    : " + daftarPenghuni.size() + "/" + kapasitas);

        if (daftarPenghuni.isEmpty()) {
            System.out.println("Daftar Penghuni : -");
        } else {
            System.out.println("Daftar Penghuni : " + String.join(", ", daftarPenghuni));
        }

        System.out.println(fasilitas);
    }
}
