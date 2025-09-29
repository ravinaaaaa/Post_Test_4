
public abstract class destinasi {
    protected String nama;
    protected int hargaDewasa;
    protected int hargaAnak;

    public destinasi(String nama, int hargaDewasa, int hargaAnak) {
        this.nama = nama;
        this.hargaDewasa = hargaDewasa;
        this.hargaAnak = hargaAnak;
    }

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

    // Abstract method → dioverride oleh subclass
    public abstract String getKategori();
}
