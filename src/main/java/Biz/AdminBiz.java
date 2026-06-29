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
    
    
    
    @Override    
    public List<Admin> getAllAdmin() {
        return daftarAdmin;
    }
}
