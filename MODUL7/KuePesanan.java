package MODUL7;

public class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    @Override
    public double hitungHarga() {
        return getHarga() * berat; 
    }

    @Override
    public String toString() {
        return super.toString() + ", Jenis: KuePesanan, Berat: " + berat +
                ", Harga Akhir: " + hitungHarga();
    }
}