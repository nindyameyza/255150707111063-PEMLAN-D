package MODUL8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM KOPERASI KARYAWAN ===");

        // Input data karyawan
        System.out.print("Masukkan ID Karyawan : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Masukkan Nama        : ");
        String name = input.nextLine();

        System.out.print("Masukkan Gaji Bulanan: ");
        int salary = input.nextInt();

        // Input jumlah invoice
        System.out.print("\nMasukkan jumlah belanja: ");
        int jumlah = input.nextInt();
        input.nextLine();

        Invoice[] invoices = new Invoice[jumlah];

        // Input data invoice
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nBelanja ke-" + (i + 1));

            System.out.print("Nama Produk : ");
            String produk = input.nextLine();

            System.out.print("Jumlah      : ");
            int qty = input.nextInt();

            System.out.print("Harga/item  : ");
            int harga = input.nextInt();
            input.nextLine();

            invoices[i] = new Invoice(produk, qty, harga);
        }

        // Membuat object Employee
        Employee emp = new Employee(id, name, salary, invoices);

        // Polymorphism
        Payable payable = emp;

        // Output
        emp.displayEmployee();

        System.out.println("\n[Polymorphism]");
        System.out.println("Gaji akhir via Payable: " + payable.getPayableAmount());

        input.close();
    }
}