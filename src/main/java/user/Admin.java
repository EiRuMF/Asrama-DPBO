package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin extends User {

    private Map<String, Mahasiswa> daftarMahasiswa = new HashMap<>();
    private List<String> daftarLaporan = new ArrayList<>();

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
        System.out.println("[3] Approve Pembayaran");
        System.out.println("[4] Generate Laporan");
        System.out.println("[0] Logout");
        System.out.println("=============================");
    }

    public void tambahMahasiswa(Mahasiswa m) {

        if (m == null) {
            System.out.println("[Admin] Data mahasiswa tidak valid.");
            return;
        }

        daftarMahasiswa.put(m.getId(), m);

        System.out.println("[Admin] Mahasiswa berhasil ditambahkan.");
        System.out.println("Nama : " + m.getName());
        System.out.println("ID   : " + m.getId());
    }

    public void hapusMahasiswa(String id) {

        if (daftarMahasiswa.containsKey(id)) {

            Mahasiswa m = daftarMahasiswa.remove(id);

            System.out.println("[Admin] Mahasiswa berhasil dihapus.");
            System.out.println("Nama : " + m.getName());

        } else {

            System.out.println("[Admin] Mahasiswa dengan ID "
                    + id + " tidak ditemukan.");
        }
    }

    public void tampilkanDaftarMahasiswa() {

        if (daftarMahasiswa.isEmpty()) {
            System.out.println("[Admin] Belum ada data mahasiswa.");
            return;
        }

        System.out.println("\n===== DAFTAR MAHASISWA =====");

        for (Mahasiswa m : daftarMahasiswa.values()) {

            System.out.println("----------------------------");
            System.out.println("ID    : " + m.getId());
            System.out.println("Nama  : " + m.getName());
            System.out.println("Email : " + m.getEmail());
        }
    }

    public Mahasiswa cariMahasiswa(String id) {
        return daftarMahasiswa.get(id);
    }

    public void tambahLaporan(String laporan) {

        daftarLaporan.add(laporan);

        System.out.println("[Admin] Laporan ditambahkan:");
        System.out.println(laporan);
    }

    public void approvePembayaran(String idPembayaran) {

        System.out.println("[Admin] Pembayaran ID "
                + idPembayaran
                + " telah di-approve.");

        tambahLaporan("Approve pembayaran: " + idPembayaran);
    }

    public void generateLaporan() {

        System.out.println("\n===== LAPORAN ADMIN =====");

        if (daftarLaporan.isEmpty()) {

            System.out.println("Belum ada laporan.");

        } else {

            for (String laporan : daftarLaporan) {
                System.out.println("- " + laporan);
            }
        }
    }

    public int getJumlahMahasiswa() {
        return daftarMahasiswa.size();
    }

    public Map<String, Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public List<String> getDaftarLaporan() {
        return daftarLaporan;
    }
}