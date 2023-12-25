import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Toko {
    private Map<String, Integer> cart;
    private int totalPembelian;

    public Toko() {
        cart = new HashMap<>();
        totalPembelian = 0;
    }

    public void beliBarang(String namaBarang, int hargaBarang, int jumlah) {
        int totalHargaBarang = hargaBarang * jumlah;

        if (cart.containsKey(namaBarang)) {
            int existingJumlah = cart.get(namaBarang);
            cart.put(namaBarang, existingJumlah + jumlah);
        } else {
            cart.put(namaBarang, jumlah);
        }

        totalPembelian += totalHargaBarang;
        System.out.println(jumlah + " pcs " + namaBarang + " telah ditambahkan ke keranjang.");
    }

    public void tampilkanStruk() {
        System.out.println("===== Struk Pembelian =====");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String barang = entry.getKey();
            int jumlah = entry.getValue();
            System.out.println(barang + ": " + jumlah + " pcs x Rp" + cart.get(barang) + " = Rp" + (jumlah * cart.get(barang)));
        }
        System.out.println("===========================");
        System.out.println("Total Pembelian: Rp" + totalPembelian);
    }

    public static void main(String[] args) {
        Toko tokoSaya = new Toko();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Selamat Datang di Toko Warcok ===");
            System.out.println("1. Beli Barang");
            System.out.println("2. Tampilkan Struk");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu (1/2/3): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String namaBarang = scanner.next();
                    System.out.print("Masukkan harga barang per pcs: ");
                    int hargaBarang = scanner.nextInt();
                    System.out.print("Masukkan jumlah yang ingin dibeli: ");
                    int jumlah = scanner.nextInt();
                    tokoSaya.beliBarang(namaBarang, hargaBarang, jumlah);
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
