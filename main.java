
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        service s = new service();

        while (true) {
            System.out.println("\n=== MENU DESTINASI ===");
            System.out.println("1. Tampilkan daftar destinasi");
            System.out.println("2. Tambah destinasi");
            System.out.println("3. Ubah destinasi");
            System.out.println("4. Cari destinasi");
            System.out.println("5. Hapus destinasi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka menu!");
                continue;
            }

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
