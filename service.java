package service;

import java.util.*;
import model.*;

public class service {
    private List<destinasi> daftarDestinasi = new ArrayList<>();

    public service() {
        daftarDestinasi.add(new wisataBudaya("Candi Prambanan", 50000, 25000));
        daftarDestinasi.add(new wisataBudaya("Keraton Yogyakarta", 15000, 7000));
        daftarDestinasi.add(new wisataBudaya("Museum Sonobudoyo", 10000, 5000));
        daftarDestinasi.add(new wisataBudaya("Benteng Vredeburg", 3000, 2000));
        daftarDestinasi.add(new wisataAlam("Pantai Parangtritis", 10000, 5000));
        daftarDestinasi.add(new wisataAlam("Gunung Merapi (Lava Tour)", 150000, 100000));
        daftarDestinasi.add(new wisataAlam("Goa Pindul", 40000, 30000));
        daftarDestinasi.add(new wisataAlam("Kaliurang", 10000, 5000));
    }

    public void tampilkanDestinasi() {
        System.out.println("=== DAFTAR DESTINASI ===");
        System.out.printf("%-3s | %-25s | %-11s | %-12s |\n",
                "No", "Nama Destinasi", "Harga Anak", "Harga Dewasa");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < daftarDestinasi.size(); i++) {
            destinasi d = daftarDestinasi.get(i);
            System.out.printf("%-3d | %-25s | %-11d | %-12d |\n",
                    (i + 1), d.getNama(), d.getHargaAnak(), d.getHargaDewasa());
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void tambahDestinasi(Scanner sc) {
        System.out.print("Masukkan kategori (Budaya/Alam): ");
        String kategori = sc.nextLine();

        System.out.print("Masukkan nama destinasi: ");
        String nama = sc.nextLine();

        int hargaDewasa = 0, hargaAnak = 0;
        try {
            System.out.print("Masukkan harga tiket dewasa: ");
            hargaDewasa = Integer.parseInt(sc.nextLine());
            System.out.print("Masukkan harga tiket anak: ");
            hargaAnak = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harga harus berupa angka!");
            return;
        }

        destinasi d;
        if (kategori.equalsIgnoreCase("Budaya")) {
            d = new wisataBudaya(nama, hargaDewasa, hargaAnak);
        } else if (kategori.equalsIgnoreCase("Alam")) {
            d = new wisataAlam(nama, hargaDewasa, hargaAnak);
        } else {
            System.out.println("Kategori tidak dikenal. Gunakan Budaya/Alam.");
            return;
        }

        daftarDestinasi.add(d);
        System.out.println("Destinasi berhasil ditambahkan!");
    }

    public void ubahDestinasi(Scanner sc) {
        tampilkanDestinasi();
        System.out.print("Pilih nomor destinasi yang ingin diubah: ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;

        if (idx < 0 || idx >= daftarDestinasi.size()) {
            System.out.println("Nomor tidak valid!");
            return;
        }

        destinasi d = daftarDestinasi.get(idx);
        System.out.print("Masukkan nama baru: ");
        d.setNama(sc.nextLine());

        try {
            System.out.print("Masukkan harga tiket dewasa baru: ");
            d.setHargaDewasa(Integer.parseInt(sc.nextLine()));
            System.out.print("Masukkan harga tiket anak baru: ");
            d.setHargaAnak(Integer.parseInt(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Input harga harus berupa angka!");
        }

        System.out.println("Destinasi berhasil diperbarui!");
    }

    public void hapusDestinasi(Scanner sc) {
        tampilkanDestinasi();
        if (daftarDestinasi.isEmpty()) {
            System.out.println("Daftar kosong, tidak ada yang bisa dihapus.");
            return;
        }

        int idx;
        while (true) {
            try {
                System.out.print("Pilih nomor destinasi yang ingin dihapus: ");
                idx = Integer.parseInt(sc.nextLine()) - 1;

                if (idx < 0 || idx >= daftarDestinasi.size()) {
                    System.out.println("Nomor tidak valid, coba lagi.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka, coba lagi.");
            }
        }

        destinasi removed = daftarDestinasi.remove(idx);
        System.out.println("Destinasi \"" + removed.getNama() + "\" berhasil dihapus!");
    }

    public void cariDestinasi(Scanner sc) {
        System.out.print("Masukkan kategori destinasi (Budaya/Alam): ");
        String kategori = sc.nextLine();

        boolean found = false;
        for (destinasi d : daftarDestinasi) {
            if (d.getKategori().equalsIgnoreCase(kategori)) {
                if (!found) {
                    System.out.println("=== Destinasi dalam kategori " + kategori + " ===");
                }
                System.out.printf("- %s (Dewasa: %d, Anak: %d)\n",
                        d.getNama(), d.getHargaDewasa(), d.getHargaAnak());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada destinasi dalam kategori tersebut.");
        }
    }
}
