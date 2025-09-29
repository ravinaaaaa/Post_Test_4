
public class wisataAlam extends destinasi {

    public wisataAlam(String nama, int hargaDewasa, int hargaAnak) {
        super(nama, hargaDewasa, hargaAnak);
    }

    @Override
    public String getKategori() {
        return "Alam";
    }
}
