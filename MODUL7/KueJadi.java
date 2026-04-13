package MODUL7;
public class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    @Override
    public double hitungHarga() {
        return harga * jumlah * 2;
    }

    public double getJumlah() {
        return jumlah;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jenis: KueJadi" + ", Jumlah: " + jumlah + ", Harga Akhir: " + hitungHarga();
    }
}
