/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asrama;

/**
 *
 * @author IVAN
 */
import user.Mahasiswa;
import java.util.ArrayList;
import java.util.List;

public class Kamar {
    private int nomorKamar;
    private int kapasitas;
    private int lantai;
    private double hargaSemester;

    private List<Mahasiswa> penghuni;

    public Kamar(int nomorKamar,
                 int kapasitas,
                 int lantai,
                 double hargaSemester) {

        this.nomorKamar = nomorKamar;
        this.kapasitas = kapasitas;
        this.lantai = lantai;
        this.hargaSemester = hargaSemester;

        penghuni = new ArrayList<>();
    }
    
        public int getNomorKamar() {
        return nomorKamar;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public int getLantai() {
        return lantai;
    }

    public double getHargaSemester() {
        return hargaSemester;
    }

    public List<Mahasiswa> getPenghuni() {
        return penghuni;
    }

    
    



}
