/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notifikasi;

import java.util.Date;

public class Notifikasi {

    private String idNotifikasi;
    private String pesan;
    private Date tanggal;
    private boolean sudahDibaca;
    private String penerimaId;
    private String tipe;

    public Notifikasi(String idNotifikasi, String pesan, String penerimaId, String tipe) {
        this.idNotifikasi = idNotifikasi;
        this.pesan = pesan;
        this.penerimaId = penerimaId;
        this.tipe = tipe;
        this.tanggal = new Date();
        this.sudahDibaca = false;
    }

    public String getIdNotifikasi() {
        return idNotifikasi;
    }

    public String getPesan() {
        return pesan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public boolean isSudahDibaca() {
        return sudahDibaca;
    }

    public String getPenerimaId() {
        return penerimaId;
    }

    public String getTipe() {
        return tipe;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public void setPenerimaId(String penerimaId) {
        this.penerimaId = penerimaId;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void kirimNotifikasi() {

        System.out.println("\n===== NOTIFIKASI =====");
        System.out.println("Kepada : " + penerimaId);
        System.out.println("Pesan  : " + pesan);
        System.out.println("Tipe   : " + tipe);
        System.out.println("======================");
    }

    public void tandaiDibaca() {
        this.sudahDibaca = true;
    }

    @Override
    public String toString() {

        String status =
                sudahDibaca ? "Sudah Dibaca" : "Belum Dibaca";

        return "Notifikasi{" +
                "idNotifikasi='" + idNotifikasi + '\'' +
                ", pesan='" + pesan + '\'' +
                ", tanggal=" + tanggal +
                ", penerimaId='" + penerimaId + '\'' +
                ", tipe='" + tipe + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}