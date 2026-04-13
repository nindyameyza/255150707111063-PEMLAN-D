package MODUL7;
public abstract class Kue {
    protected String nama;
    public double harga;

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungHarga();

    @Override
    public String toString() {
        return "Nama Kue: " + nama + ", Harga: " + harga;
    }
}
