/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengaduan;

/**
 *
 * @author IVAN
 */
import java.util.Date;

public class Tanggapan {
    private String namaPetugas;
    private String isiTanggapan;
    private String statusUpdate;
    private Date tanggal;

    public Tanggapan(String namaPetugas, String statusUpdate , String isiTanggapan) {
        this.namaPetugas = namaPetugas;
        this.statusUpdate = statusUpdate;
        this.isiTanggapan = isiTanggapan;
        this.tanggal = new Date();
    }

    public String getNamaPetugas() {
        return namaPetugas;
    }
    
    public String getStatusUpdate() {
        return statusUpdate;
    }

    public String getIsiTanggapan() {
        return isiTanggapan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    @Override
    public String toString() {

        return "[" + tanggal + "] "
                + namaPetugas
                + " | Status : "
                + statusUpdate
                + " | Catatan : "
                + isiTanggapan;
    }
}
