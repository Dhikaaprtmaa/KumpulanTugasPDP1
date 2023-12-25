import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Toko {
    private Map<String, Integer> daftarHarga;
    private Map<String, Integer> keranjangBelanja;
    private int totalPembelian;

    public Toko() {
        daftarHarga = new HashMap<>();
        keranjangBelanja = new HashMap<>();
        totalPembelian = 0;

        // Inisialisasi harga barang
        daftarHarga.put("sayur", 15000);
        daftarHarga.put("beras", 20000);
        daftarHarga.put("telur", 7000);
        daftarHarga.put("roti", 10000);
    }

    public void beliBarang(String namaBarang, int jumlah) {
        if (daftarHarga.containsKey(namaBarang)) {
            int hargaPerPcs = daftarHarga.get(namaBarang);
            int totalHargaBarang = hargaPerPcs * jumlah;

            if (keranjangBelanja.containsKey(namaBarang)) {
                int existingJumlah = keranjangBelanja.get(namaBarang);
                keranjangBelanja.put(namaBarang, existingJumlah + jumlah);
            } else {
                keranjangBelanja.put(namaBarang, jumlah);
            }

            totalPembelian += totalHargaBarang;
            System.out.println(jumlah + " pcs " + namaBarang + " telah ditambahkan ke keranjang.");
        } else {
            System.out.println("Barang tidak valid. Silakan pilih barang yang benar.");
        }
    }

    public void tampilkanStruk() {
        System.out.println("===== Struk Pembelian =====");
        for (Map.Entry<String, Integer> entry : keranjangBelanja.entrySet()) {
            String barang = entry.getKey();
            int jumlah = entry.getValue();
            int hargaPerPcs = daftarHarga.get(barang);
            System.out.println(barang + ": " + jumlah + " pcs x Rp" + hargaPerPcs + " = Rp" + (jumlah * hargaPerPcs));
        }
        System.out.println("===========================");
        System.out.println("Total Pembelian: Rp" + totalPembelian);
    }

    public static void main(String[] args) {
        Toko tokoSaya = new Toko();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Selamat Datang di Warcok (Warung Ucok) ===");
            System.out.println("1. Beli Barang");
            System.out.println("2. Tampilkan Struk");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu (1/2/3): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Pilih barang yang ingin dibeli:");
                    System.out.println("1. Sayur");
                    System.out.println("2. Beras");
                    System.out.println("3. Telur");
                    System.out.println("4. Roti");
                    int pilihanBarang = scanner.nextInt();
                    System.out.print("Masukkan jumlah yang ingin dibeli: ");
                    int jumlah = scanner.nextInt();
                    switch (pilihanBarang) {
                        case 1:
                            tokoSaya.beliBarang("sayur", jumlah);
                            break;
                        case 2:
                            tokoSaya.beliBarang("beras", jumlah);
                            break;
                        case 3:
                            tokoSaya.beliBarang("telur", jumlah);
                            break;
                        case 4:
                            tokoSaya.beliBarang("roti", jumlah);
                            break;
                        default:
                            System.out.println("Pilihan barang tidak valid.");
                    }
                    break;
                case 2:
                    tokoSaya.tampilkanStruk();
                    break;
                case 3:
                    System.out.println("Terima kasih telah berbelanja di toko kami!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
}
