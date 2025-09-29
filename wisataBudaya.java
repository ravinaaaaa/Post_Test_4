
public class wisataBudaya extends destinasi {

    public wisataBudaya(String nama, int hargaDewasa, int hargaAnak) {
        super(nama, hargaDewasa, hargaAnak);
    }

    @Override
    public String getKategori() {
        return "Budaya";
    }
}
