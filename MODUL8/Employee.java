package MODUL8;

class Employee implements Payable {
    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    public double getTotalInvoice() {
        double total = 0;
        for (Invoice inv : invoices) {
            total += inv.getPayableAmount();
        }
        return total;
    }

    @Override
    public double getPayableAmount() {
        return salaryPerMonth - getTotalInvoice();
    }

    public void displayEmployee() {
        System.out.println("\n====================================");
        System.out.println("         DATA KARYAWAN");
        System.out.println("====================================");
        System.out.println("ID Karyawan   : " + registrationNumber);
        System.out.println("Nama          : " + name);
        System.out.println("Gaji Bulanan  : " + salaryPerMonth);

        System.out.println("\n----- DETAIL BELANJA -----");
        System.out.printf("%-15s %-10s %-15s %-15s\n",
                "Produk", "Jumlah", "Harga/Item", "Total");

        for (Invoice inv : invoices) {
            inv.display();
        }

        System.out.println("------------------------------------");
        System.out.println("Total Hutang  : " + getTotalInvoice());
        System.out.println("Gaji Bersih   : " + getPayableAmount());
        System.out.println("====================================");
    }
}