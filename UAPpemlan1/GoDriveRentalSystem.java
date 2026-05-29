package UAPpemlan1;
import java.util.ArrayList;
import java.util.Scanner;

public class GoDriveRentalSystem {

    private ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    // =========================
    // FORMAT RUPIAH
    // =========================
    private String formatRupiah(double nominal) {

        return String.format("Rp %,.0f", nominal);
    }

    // =========================
    // TAMBAH KENDARAAN
    // =========================
    public void tambahKendaraan(Kendaraan kendaraan) {

        daftarKendaraan.add(kendaraan);
    }

    // =========================
    // TAMPILKAN KENDARAAN
    // =========================
    public void tampilkanDaftarKendaraan() {

        System.out.println(
                "\n=============================================================="
        );

        System.out.println(
                "                    DAFTAR ARMADA GODRIVE"
        );

        System.out.println(
                "=============================================================="
        );

        if (daftarKendaraan.isEmpty()) {

            System.out.println("Belum ada kendaraan.");
            return;
        }

        for (Kendaraan k : daftarKendaraan) {
            k.tampilInfo();
        }

        System.out.println(
                "=============================================================="
        );
    }

    // =========================
    // SEWA KENDARAAN
    // =========================
    public void sewaKendaraan(String kode, int lamaSewa, boolean memberVIP)
            throws KendaraanTidakTersediaException {

        for (Kendaraan k : daftarKendaraan) {

            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {

                // Kendaraan sedang disewa
                if (!k.isTersedia()) {

                    throw new KendaraanTidakTersediaException(
                            "Kendaraan dengan kode "
                                    + kode
                                    + " gagal disewa.\n"
                                    + "Alasan: Kendaraan sedang disewa atau tidak ditemukan!"
                    );
                }

                double biayaDasar =
                        lamaSewa * k.getHargaSewaPerHari();

                double biayaTambahan = 0;

                // =========================
                // MOBIL
                // =========================
                if (k instanceof Mobil) {

                    Mobil mobil = (Mobil) k;

                    if (mobil.getJumlahKursi() > 5) {

                        biayaTambahan = 50000;
                    }
                }

                // =========================
                // MOTOR
                // =========================
                else if (k instanceof Motor) {

                    Motor motor = (Motor) k;

                    if (motor.getJenisTransmisi()
                            .equalsIgnoreCase("Matik")) {

                        biayaTambahan =
                                10000 * lamaSewa;
                    }
                }

                double totalBiaya =
                        biayaDasar + biayaTambahan;

                // Diskon VIP
                if (memberVIP) {

                    totalBiaya -= totalBiaya * 0.10;
                }

                // Diskon > 7 Hari
                if (lamaSewa > 7) {

                    totalBiaya -= totalBiaya * 0.05;
                }

                // Kendaraan disewa
                k.setTersedia(false);

                // =========================
                // OUTPUT TRANSAKSI
                // =========================
                System.out.println(
                        "\n================================================"
                );

                System.out.println(
                        "              TRANSAKSI SEWA GODRIVE"
                );

                System.out.println(
                        "================================================"
                );

                System.out.printf(
                        "%-20s : %s\n",
                        "Kode Kendaraan",
                        k.getKodeKendaraan()
                );

                System.out.printf(
                        "%-20s : %s\n",
                        "Nama Kendaraan",
                        k.getNamaKendaraan()
                );

                System.out.printf(
                        "%-20s : %d Hari\n",
                        "Durasi Sewa",
                        lamaSewa
                );

                System.out.printf(
                        "%-20s : %s\n",
                        "Member VIP",
                        (memberVIP ? "Ya" : "Tidak")
                );

                System.out.println(
                        "------------------------------------------------"
                );

                System.out.printf(
                        "%-20s : %s\n",
                        "Total Biaya",
                        formatRupiah(totalBiaya)
                );

                System.out.println(
                        "================================================"
                );

                return;
            }
        }

        throw new KendaraanTidakTersediaException(
                "Kendaraan dengan kode "
                        + kode
                        + " gagal disewa.\n"
                        + "Alasan: Kode kendaraan tidak ditemukan!"
        );
    }
    // KEMBALIKAN KENDARAAN
    public void kembalikanKendaraan(String kode) {

        for (Kendaraan k : daftarKendaraan) {

            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {

                if (!k.isTersedia()) {

                    k.setTersedia(true);

                    System.out.println(
                            "\n=============================================="
                    );

                    System.out.println(
                            "         PENGEMBALIAN KENDARAAN"
                    );

                    System.out.println(
                            "=============================================="
                    );

                    System.out.printf(
                            "%-18s : %s\n",
                            "Kode Kendaraan",
                            kode
                    );

                    System.out.printf(
                            "%-18s : %s\n",
                            "Nama Kendaraan",
                            k.getNamaKendaraan()
                    );

                    System.out.println(
                            "----------------------------------------------"
                    );

                    System.out.println(
                            "[INFO] Kendaraan berhasil dikembalikan."
                    );

                    System.out.println(
                            "=============================================="
                    );

                    return;

                } else {

                    System.out.println(
                            "[INFO] Kendaraan sedang tidak disewa."
                    );

                    return;
                }
            }
        }

        System.out.println(
                "[INFO] Kode kendaraan tidak ditemukan."
        );
    }
    // MENU UTAMA
    public void menu() {

        int pilihan;

        do {

            System.out.println(
                    "\n================================================"
            );

            System.out.println(
                    "             GO DRIVE RENTAL SYSTEM"
            );

            System.out.println(
                    "================================================"
            );

            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tampilkan Daftar Armada");
            System.out.println("3. Sewa Kendaraan");
            System.out.println("4. Kembalikan Kendaraan");
            System.out.println("5. Keluar");

            System.out.println(
                    "------------------------------------------------"
            );

            System.out.print("Pilih menu : ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                // TAMBAH KENDARAAN
                case 1:

                    System.out.println(
                            "\n============= TAMBAH KENDARAAN ============="
                    );

                    System.out.print(
                            "Jenis Kendaraan (mobil/motor) : "
                    );

                    String jenis = input.nextLine();

                    System.out.print(
                            "Kode Kendaraan                : "
                    );

                    String kode = input.nextLine();

                    System.out.print(
                            "Nama Kendaraan                : "
                    );

                    String nama = input.nextLine();

                    System.out.print(
                            "Harga Sewa / Hari             : "
                    );

                    double harga = input.nextDouble();

                    // MOBIL
                    if (jenis.equalsIgnoreCase("mobil")) {

                        System.out.print(
                                "Jumlah Kursi                  : "
                        );

                        int kursi = input.nextInt();

                        Mobil mobil = new Mobil(
                                kode,
                                nama,
                                harga,
                                kursi
                        );

                        tambahKendaraan(mobil);

                        System.out.println(
                                "\n[INFO] Kendaraan berhasil ditambahkan!"
                        );
                    }

                    // MOTOR
                    else if (jenis.equalsIgnoreCase("motor")) {

                        input.nextLine();

                        System.out.print(
                                "Jenis Transmisi               : "
                        );

                        String transmisi =
                                input.nextLine();

                        Motor motor = new Motor(
                                kode,
                                nama,
                                harga,
                                transmisi
                        );

                        tambahKendaraan(motor);

                        System.out.println(
                                "\n[INFO] Kendaraan berhasil ditambahkan!"
                        );
                    }

                    else {

                        System.out.println(
                                "[INFO] Jenis kendaraan tidak valid!"
                        );
                    }

                    break;

                // =========================
                // TAMPILKAN ARMADA
                // =========================
                case 2:

                    tampilkanDaftarKendaraan();

                    break;

                // =========================
                // SEWA KENDARAAN
                // =========================
                case 3:

                    try {

                        System.out.println(
                                "\n============= SEWA KENDARAAN ============="
                        );

                        System.out.print(
                                "Kode Kendaraan : "
                        );

                        String kodeSewa =
                                input.nextLine();

                        System.out.print(
                                "Durasi Sewa    : "
                        );

                        int lama =
                                input.nextInt();

                        input.nextLine();

                        System.out.print(
                                "Member VIP? (y/n) : "
                        );

                        String vip =
                                input.nextLine();

                        boolean memberVIP =
                                vip.equalsIgnoreCase("y");

                        sewaKendaraan(
                                kodeSewa,
                                lama,
                                memberVIP
                        );

                    } catch (KendaraanTidakTersediaException e) {

                        System.out.println(
                                "\nException in thread \"main\" "
                                        + e.getClass().getName()
                                        + ": "
                                        + e.getMessage()
                        );
                    }

                    break;

                // =========================
                // KEMBALIKAN KENDARAAN
                // =========================
                case 4:

                    System.out.println(
                            "\n========== KEMBALIKAN KENDARAAN =========="
                    );

                    System.out.print(
                            "Kode Kendaraan : "
                    );

                    String kodeKembali =
                            input.nextLine();

                    kembalikanKendaraan(
                            kodeKembali
                    );

                    break;

                // =========================
                // KELUAR
                // =========================
                case 5:

                    System.out.println(
                            "\nTerima kasih telah menggunakan GoDrive Rental System."
                    );

                    break;

                default:

                    System.out.println(
                            "\n[INFO] Menu tidak tersedia!"
                    );
            }

        } while (pilihan != 5);
    }
}