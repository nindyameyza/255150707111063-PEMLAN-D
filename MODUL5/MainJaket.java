package MODUL5;
import java.util.Scanner;

public class MainJaket {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== PROGRAM PENJUALAN JAKET =====");
        System.out.println("Harga Normal:");
        System.out.println("Jaket A : Rp 100.000");
        System.out.println("Jaket B : Rp 125.000");
        System.out.println("Jaket C : Rp 175.000");
        System.out.println("-----------------------------------");

        System.out.print("Masukkan jumlah Jaket A : ");
        int jumlahA = input.nextInt();

        System.out.print("Masukkan jumlah Jaket B : ");
        int jumlahB = input.nextInt();

        System.out.print("Masukkan jumlah Jaket C : ");
        int jumlahC = input.nextInt();

        int totalA = Jaket.hitungA(jumlahA);
        int totalB = Jaket.hitungB(jumlahB);
        int totalC = Jaket.hitungC(jumlahC);

        int totalSemua = totalA + totalB + totalC;

        System.out.println("\n===== RINCIAN PEMBELIAN =====");
        System.out.println("Jaket A : Rp " + totalA);
        System.out.println("Jaket B : Rp " + totalB);
        System.out.println("Jaket C : Rp " + totalC);
        System.out.println("-----------------------------------");
        System.out.println("TOTAL BAYAR : Rp " + totalSemua);
        System.out.println("===================================");
    }
}