package UAPpemlan1;
public class Mobil extends Kendaraan {

    private int jumlahKursi;

    public Mobil(String kode, String nama, double harga, int jumlahKursi) {
        super(kode, nama, harga);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {

        double total = lamaSewa * getHargaSewaPerHari();

        // Tambahan biaya perawatan
        if (jumlahKursi > 5) {
            total += 50000;
        }

        return total;
    }

    @Override
    public void tampilInfo() {

        System.out.printf(
                "[MOBIL] Kode: %-6s | Nama: %-20s | Kursi: %-2d | Tarif: %-20s | Status: %s\n",
                getKodeKendaraan(),
                getNamaKendaraan(),
                jumlahKursi,
                formatRupiah(getHargaSewaPerHari()) + "/hari",
                (isTersedia() ? "Tersedia" : "Tidak Tersedia")
        );
    }
}