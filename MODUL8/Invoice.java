package MODUL8;

class Invoice implements Payable {
    private String productName;
    private int quantity;
    private int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPayableAmount() {
        return quantity * pricePerItem;
    }

    public void display() {
        System.out.printf("%-15s %-10d %-15d %-15.2f\n",
                productName, quantity, pricePerItem, getPayableAmount());
    }
}