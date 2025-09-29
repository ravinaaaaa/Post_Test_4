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
