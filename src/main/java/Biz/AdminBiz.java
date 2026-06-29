/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biz;

/**
 *
 * @author IVAN
 */
import user.Admin;
import java.util.List;
import java.util.ArrayList;
import user.Mahasiswa;
public class AdminBiz implements IAdminBiz{
    private List<Admin> daftarAdmin;

    public AdminBiz() {
        this.daftarAdmin = new ArrayList<>();
        inisialisasiDummy();
    }
    
    private void inisialisasiDummy() {
    Admin adn1 = new Admin(
        "A001", "Iurie", "iurie@admin.ac.id", "adn123", "1234567890"
    );      
        daftarAdmin.add(adn1);

        Admin adn2 = new Admin(
            "A002", "Jamil", "jamil@admin.ac.id", "adn456", "0987654321"
        );
        daftarAdmin.add(adn2);
    }
    
    public void lihatPembayaranMahasiswa(MahasiswaBiz mahasiswaBiz){

    System.out.println("\n===== LIST PEMBAYARAN MAHASISWA =====");

    for(Mahasiswa m : mahasiswaBiz.getAllMahasiswa()){

        System.out.println("--------------------------------");

        System.out.println("Nama          : " + m.getName());

        System.out.println("Tagihan       : Rp " + m.getTotalTagihan());

        System.out.println("Sudah Dibayar : Rp " + m.getTotalDibayar());

        System.out.println("Sisa          : Rp " + m.getSisaTagihan());

        if(m.isLunas()){

            System.out.println("Status        : LUNAS");

        }else{

            System.out.println("Status        : BELUM LUNAS");

        }

    }

}
    
    
    
    @Override    
    public List<Admin> getAllAdmin() {
        return daftarAdmin;
    }
    

    

    @Override
    public void hapusMahasiswa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public void approvePembayaran(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
