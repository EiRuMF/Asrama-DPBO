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
public interface IAdminBiz {
    List<Admin> getAllAdmin();
    public void hapusMahasiswa();
    public void generateLaporan();
    public void approvePembayaran(String id);
}
