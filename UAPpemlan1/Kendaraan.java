package UAPpemlan1;
public abstract class Kendaraan {

    private String kodeKendaraan;
    private String namaKendaraan;
    private double hargaSewaPerHari;
    private boolean isTersedia;

    public Kendaraan(String kode, String nama, double hargaSewa) {

        this.kodeKendaraan = kode;
        this.namaKendaraan = nama;
        this.hargaSewaPerHari = hargaSewa;
        this.isTersedia = true;
    }

    // =========================
    // GETTER SETTER
    // =========================

    public String getKodeKendaraan() {
        return kodeKendaraan;
    }

    public void setKodeKendaraan(String kodeKendaraan) {
        this.kodeKendaraan = kodeKendaraan;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public boolean isTersedia() {
        return isTersedia;
    }

    public void setTersedia(boolean tersedia) {
        isTersedia = tersedia;
    }

    // =========================
    // FORMAT RUPIAH
    // =========================
    protected String formatRupiah(double nominal) {

        return String.format("Rp %,.0f", nominal);
    }

    // =========================
    // ABSTRACT METHOD
    // =========================
    public abstract double hitungBiayaDasar(int lamaSewa);

    public abstract void tampilInfo();
}