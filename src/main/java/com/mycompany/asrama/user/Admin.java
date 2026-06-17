/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asrama.user;

/**
 *
 * @author IVAN
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Admin extends User {
    private Map<String, Mahasiswa> daftarMahasiswa = new HashMap<>();
    private List<String> daftarLaporan = new ArrayList<>();

    public Admin(String name, String id, String email, String password, String role) {
        super(name, id, email, password, role);
    }
    public void tambahMahasiswa(Mahasiswa m){}
    public void hapusMahasiswa(String id){}
    public void approvePembayaran(String id){}
    
}
