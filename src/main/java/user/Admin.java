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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin extends User {

    public Admin(String id, String name, String email, String password, String role) {
        super(id, name, email, password, "ADMIN");
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("\n=============================");
        System.out.println("  MENU ADMIN - " + getName());
        System.out.println("=============================");
        System.out.println("[1] Kelola Data Mahasiswa");
        System.out.println("[2] Kelola Data Kamar");
        System.out.println("[3] Lihat Pembayaran");
        System.out.println("[0] Logout");
        System.out.println("=============================");
    }
}
