package UAPpemlan1;
public class Motor extends Kendaraan {

    private String jenisTransmisi;

    public Motor(String kode, String nama, double harga, String jenisTransmisi) {
        super(kode, nama, harga);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi() {
        return jenisTransmisi;
    }

    public void setJenisTransmisi(String jenisTransmisi) {
        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {

        double total = lamaSewa * getHargaSewaPerHari();

        // Tambahan asuransi motor matik
        if (jenisTransmisi.equalsIgnoreCase("Matik")) {
            total += (10000 * lamaSewa);
        }

        return total;
    }

    @Override
    public void tampilInfo() {

        System.out.printf(
                "[MOTOR] Kode: %-6s | Nama: %-20s | Transmisi: %-6s | Tarif: %-20s | Status: %s\n",
                getKodeKendaraan(),
                getNamaKendaraan(),
                jenisTransmisi,
                formatRupiah(getHargaSewaPerHari()) + "/hari",
                (isTersedia() ? "Tersedia" : "Tidak Tersedia")
        );
    }
}