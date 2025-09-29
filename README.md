# Post_Test_4
<h1> 2409116078_Ravina Eka Adiya </h1>

<img width="676" height="426" alt="image" src="https://github.com/user-attachments/assets/6c51f5e4-5ed7-4238-a8c4-b0ef539134c4" />

## Penjelasan Singkat Program
Tujuan dari tema "Sistem Manajemen Daftar Destinasi Wisata Kota Jogja" adalah untuk menyediakan sarana pengelolaan informasi destinasi wisata di kota Jogja agar data lebih terorganisir, memudahkan pencarian informasi serta membantu pengguna dalam mengetahui daftar tempat wisata beserta detail harga tiketnya.

#
<h2> 1. destinasi.java</h2>

```java
package model;

public abstract class destinasi {
```
menandakan kelas ini ada di package model, kelas bisa di akses dari mana saja.

```java
protected String nama;
protected int hargaDewasa;
protected int hargaAnak;
```
- protected String namaDestinasi → nama tempat wisata, bisa diakses di class, subclass, dan package yang sama.
- protected int tiketDewasa → harga tiket dewasa, akses sama seperti di atas.
- protected int tiketAnak → harga tiket anak-anak, akses sama seperti di atas.

```java
public destinasi(String nama, int hargaDewasa, int hargaAnak) {
  this.nama = nama;
  this.hargaDewasa = hargaDewasa;
  this.hargaAnak = hargaAnak;
}
```
contructor dipanggil saat membuat objek baru di class destinasi : 
- this.namaDestinasi = namaDestinasi : menyimpan nilai yang dikirim ke parameter ke dalam atribut kelas.
- this.tiketDewasa = tiketDewasa : menyimpan harga tiket dewasa.
- this.tiketAnak = tiketAnak : menyimpan harga tiket anak.

```java
public String getNama() {
        return nama;
    }

    public int getHargaDewasa() {
        return hargaDewasa;
    }

    public int getHargaAnak() {
        return hargaAnak;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHargaDewasa(int hargaDewasa) {
        this.hargaDewasa = hargaDewasa;
    }

    public void setHargaAnak(int hargaAnak) {
        this.hargaAnak = hargaAnak;
    }
```
- getNama = digunakan untuk membaca data.
- getHargaDewasa = digunakan untuk membaca data.
- getHargaAnak = digunakan untuk membaca data.
- setNama = digunakan untuk mengubah data.
- setHargaDewasa = digunakan untuk mengubah data.
- setHargaAnak = digunakan untuk mengubah data.

```java
public abstract String getKategori();
}
```
setiap class turunan dari Destinasi harus punya cara sendiri untuk mengembalikan kategori destinasi.

#
<h2> 2. service.java</h2>
```java
package service;

import java.util.*;
import model.*;

public class service {
```
membuat class service di package service.

- import java.util.* : digunakan untuk mengimpor semua class di dalam package java.util.
- import model.* : digunakan untuk mengimpor semua class yang ada di package model buatanmu sendiri.

```java
private List<destinasi> daftarDestinasi = new ArrayList<>();
```
kode ini membuat sebuah atribut daftarDestinasi yang digunakan untuk menyimpan banyak objek destinasi.

```java
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
```
constructor digunakan untuk mengisi data awal daftar destinasi wisata jogja. jadi saat program dijalankan, suda ada 8 data bawaan yang tersimpan di daftarDestinasi.

```java
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
```
kode diatas untuk menampilkan semua data destinasi dalam bentuk tabel. 

```java
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
```
kode diatas, pengguna bisa menambah data destinasi baru dengan menginput nama destinasi, harga tiket dewasa dan anak. setelah itu data dimasukkan ke ArrayList daftarDestinasi.

```java
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
```
kode diatas untuk mengubah data destinasi yang suda ada. langkah pertama data akan ditampilkan daftar destinasi, lalu pengguna memilih nomor destinasi yang mau di ubah. setelah itu pengguna bisa mengganti nama destinasi dan harga tiket.

```java
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
```
kode diatas ini menampilkan daftar destinasi, lalu pengguna bisa menghapus daftar destinasi yang ingin dihapus dengan memilih nomor data destinasi nya. setelah itu data akan dihapus dari ArrayList.

```java
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
```
kode diatas untuk mencari destinasi. program akan menampilkan daftar destinasi, lalu pengguna ketik nama destinasi yang ingin dicari, jikda tidak ada hasil maka akan ditampilkan "Tidak ada destinasi dalam kategori tersebut."

#
<h2>3. main.java</h2>

```java
package main;

import java.util.Scanner;
import service.service;

public class main {
```
membuat class main di package main.

- import scanner : digunakan untuk membaca input dari user.
- import service.service : digunakan untuk memanggil class service dari package service.

```java
public static void main(String[] args) {
```
kode diatas adalah method utama untuk titik awal program berjalan.

```java
Scanner sc = new Scanner(System.in);
service s = new service();
```
- scanner digunakan untuk membaca input user.
- service adalah objek dari class service, digunakan untuk menjalankan semua fitur CRUD dan pencarian.

```java
while (true) {
while (true) {
  System.out.println("\n=== MENU DESTINASI ===");                       System.out.println("1. Tampilkan daftar destinasi");
  System.out.println("2. Tambah destinasi");                            System.out.println("3. Ubah destinasi");
  System.out.println("4. Cari destinasi");                              System.out.println("5. Hapus destinasi");
  System.out.println("6. Keluar");
  System.out.print("Pilih menu: ");
```
- kode while digunakan untuk menampilkan menu berulang selama pengguna tidak memilih menu keluar.
- kode diatas juga untuk menampilkan pilihan menu utama untuk pengguna, disini pengguna diminta untuk memasukan atau meng input angka sesuai yang tersedia di menu.

```java
int pilihan;
            try {
                pilihan = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka menu!");
                continue;
            }
```
kode diatas digunakan untuk mencegah error saat user salah input.

```java
switch (pilihan) {
                case 1 -> s.tampilkanDestinasi();
                case 2 -> s.tambahDestinasi(sc);
                case 3 -> s.ubahDestinasi(sc);
                case 4 -> s.cariDestinasi(sc);
                case 5 -> s.hapusDestinasi(sc);
                case 6 -> {
                    System.out.println("Terima kasih <3");
                    return;
                }
                default -> System.out.println("Menu tidak tersedia!");
            }
        }
    }
}
```
- case 1 untuk menampilkan daftar destinasi.
- case 2 untuk menambah destinasi baru.
- case 3 untuk mengubah data destinasi.
- case 4 untuk menghapus destinasi.
- case 5 untuk menghapus destinasi berdasarkan nama.
- case 6 keluar dari program.
- default jika user salah pilih menu.

#
<h2>4. wisataAlam.java</h2>

```java
package model;

public class wisataAlam extends destinasi {
```
membuat class wisataAlam sebagai subclass dari class destinasi di package model.

```java
public wisataAlam(String nama, int hargaDewasa, int hargaAnak) {
        super(nama, hargaDewasa, hargaAnak);
    }
```
constuctor digunakan untuk membuat objek wisataAlam baru

```java
@Override
    public String getKategori() {
        return "Alam";
    }
}
```
method ini diapaki untuk menandai kategori destinasi yaitu wisata alam.

#
<h2>5. wisataBudaya.java</h2>

```java
package model;

public class wisataBudaya extends destinasi {
```
membuat class wisataBudaya sebagai subclass dari class destinasi di package model.

```java
public wisataBudaya(String nama, int hargaDewasa, int hargaAnak) {
        super(nama, hargaDewasa, hargaAnak);
    }
```
constuctor digunakan untuk membuat objek wisataBudaya baru.

```java
@Override
    public String getKategori() {
        return "Budaya";
    }
}
```
method ini diapaki untuk menandai kategori destinasi yaitu wisata budaya.
