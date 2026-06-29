/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biz;

/**
 *
 * @author IVAN
 */
import user.Mahasiswa;
import exception.KamarPenuhException;
import java.util.List;
import pengaduan.Keluhan;

public interface IMahasiswaBiz {
    List<Mahasiswa> getAllMahasiswa();
    
    Mahasiswa cariByNim(String nim);
    
    void lihatInfoKamar(String nim);
    
    void assignKamar(String nim, String kamarId) throws KamarPenuhException;
    
    void ajukanKeluhan(String nim, String judul, String deskripsi,String kategori);
    
    void tampilkanKeluhan(String nim);
    
    void bayarSewa(String nim, double nominal);
    
    void lihatTagihan(String nim);
    
    boolean sudahPunyaKamar(String nim);
}
