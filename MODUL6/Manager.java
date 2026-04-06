package MODUL6;
public class Manager extends Pekerja {
    private String departemen;

    public Manager(String departemen, double gaji, int tahun, int bulan, int hari, int jumlahAnak,
                   String nama, boolean jenisKelamin, String nik, boolean menikah) {
        super(gaji, tahun, bulan, hari, jumlahAnak, nama, jenisKelamin, nik, menikah);
        this.departemen = departemen;
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + (0.1 * getGaji());
    }

    @Override
    public String toString() {
        return super.toString() +
               "\ndepartemen : " + departemen;
    }
}