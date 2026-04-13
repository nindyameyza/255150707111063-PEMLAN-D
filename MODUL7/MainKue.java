package MODUL7;
import java.text.NumberFormat;
import java.util.Locale;

public class MainKue {
    public static void main(String[] args) {

        Kue[] kueArray = new Kue[20];

        kueArray[0] = new KuePesanan("Brownies", 20000, 1.5);
        kueArray[1] = new KueJadi("Donat", 5000, 10);
        kueArray[2] = new KuePesanan("Lapis", 25000, 2);
        kueArray[3] = new KueJadi("Klepon", 4000, 15);
        kueArray[4] = new KuePesanan("Cheesecake", 50000, 1);
        kueArray[5] = new KueJadi("Onde-onde", 3000, 20);
        kueArray[6] = new KuePesanan("Tiramisu", 45000, 1.2);
        kueArray[7] = new KueJadi("Bakpia", 3500, 25);
        kueArray[8] = new KuePesanan("Blackforest", 60000, 2);
        kueArray[9] = new KueJadi("Risoles", 4000, 12);
        kueArray[10] = new KuePesanan("Red Velvet", 55000, 1.5);
        kueArray[11] = new KueJadi("Lemper", 4500, 18);
        kueArray[12] = new KuePesanan("Opera Cake", 70000, 1);
        kueArray[13] = new KueJadi("Pastel", 3000, 22);
        kueArray[14] = new KuePesanan("Pandan Cake", 30000, 2.5);
        kueArray[15] = new KueJadi("Serabi", 2500, 30);
        kueArray[16] = new KuePesanan("Strawberry Cake", 65000, 1.3);
        kueArray[17] = new KueJadi("Martabak Mini", 5000, 14);
        kueArray[18] = new KuePesanan("Chocolate Cake", 60000, 2);
        kueArray[19] = new KueJadi("Pukis", 3000, 28);

        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        double totalHargaSemua = 0;
        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;

        Kue kueTermahal = kueArray[0];

        System.out.println("========================================================================================================");
        System.out.printf("%-3s %-20s %-15s %-15s %-12s %-15s\n",
                "No", "Nama Kue", "Jenis", "Harga", "Qty/Berat", "Harga Akhir");
        System.out.println("========================================================================================================");

        int no = 1;

        for (Kue k : kueArray) {

            String jenis = "";
            double qty = 0;

            if (k instanceof KuePesanan) {
                jenis = "Pesanan";
                qty = ((KuePesanan) k).getBerat();
            } else if (k instanceof KueJadi) {
                jenis = "Jadi";
                qty = ((KueJadi) k).getJumlah();
            }

            double hargaAkhir = k.hitungHarga();

            System.out.printf("%-3d %-20s %-15s %-15s %-12.2f %-15s\n",
                    no++,
                    k.nama,
                    jenis,
                    rupiah.format(k.harga),
                    qty,
                    rupiah.format(hargaAkhir));

            totalHargaSemua += hargaAkhir;

            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalHargaPesanan += hargaAkhir;
                totalBeratPesanan += kp.getBerat();
            } else if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                totalHargaJadi += hargaAkhir;
                totalJumlahJadi += kj.getJumlah();
            }

            if (hargaAkhir > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }

        System.out.println("========================================================================================================");

        System.out.println("\n===================== RINGKASAN =====================");
        System.out.println("Total Harga Semua Kue     : " + rupiah.format(totalHargaSemua));
        System.out.println("Total Harga KuePesanan    : " + rupiah.format(totalHargaPesanan));
        System.out.printf("Total Berat KuePesanan    : %.2f\n", totalBeratPesanan);
        System.out.println("Total Harga KueJadi       : " + rupiah.format(totalHargaJadi));
        System.out.printf("Total Jumlah KueJadi      : %.0f\n", totalJumlahJadi);

        System.out.println("\nKue dengan harga terbesar:");
        System.out.println(kueTermahal);
    }
}