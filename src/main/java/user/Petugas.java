/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author IVAN
 */

import java.util.ArrayList;
import java.util.List;

public class Petugas extends User {
    private String shift;
    private List<String> tugasHarian; 

    public Petugas( String id, String name, String email, String password, String shift) {
        super(id, name, email, password, "PETUGAS");
        this.shift = shift;
        this.tugasHarian = new ArrayList<>();
    }
    
    @Override
    public void tampilkanMenu() {
        System.out.println("\n=============================");
        System.out.println("  MENU PETUGAS - " + getName());
        System.out.println("  Shift: " + shift);
        System.out.println("=============================");
        System.out.println("1. Lihat Keluhan Mahasiswa");        
        System.out.println("2. Proses Keluhan");
        System.out.println("0. Logout");
        System.out.println("=============================");
    }
}
