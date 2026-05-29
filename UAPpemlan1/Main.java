package UAPpemlan1;
public class Main {

    public static void main(String[] args) {

        GoDriveRentalSystem goDrive = new GoDriveRentalSystem();

        // Data awal kendaraan
        goDrive.tambahKendaraan(
                new Mobil("MBL01", "Toyota Avanza", 350000, 7)
        );

        goDrive.tambahKendaraan(
                new Mobil("MBL02", "Daihatsu Sigra", 300000, 7)
        );

        goDrive.tambahKendaraan(
                new Mobil("MBL03", "Honda Brio", 280000, 5)
        );

        goDrive.tambahKendaraan(
                new Motor("MTR01", "Honda Vario", 80000, "Matik")
        );

        goDrive.tambahKendaraan(
                new Motor("MTR02", "Yamaha NMAX", 100000, "Matik")
        );

        goDrive.tambahKendaraan(
                new Motor("MTR03", "Kawasaki KLX", 90000, "Manual")
        );

        // Jalankan menu
        goDrive.menu();
    }
}