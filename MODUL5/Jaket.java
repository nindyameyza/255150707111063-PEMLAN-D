package MODUL5;
public class Jaket {

    public static final int HARGA_A = 100000;
    public static final int HARGA_B = 125000;
    public static final int HARGA_C = 175000;

    public static int hitungA(int jumlah){
        if(jumlah > 100){
            return jumlah * 95000;
        } else {
            return jumlah * HARGA_A;
        }
    }

    public static int hitungB(int jumlah){
        if(jumlah > 100){
            return jumlah * 120000;
        } else {
            return jumlah * HARGA_B;
        }
    }

    public static int hitungC(int jumlah){
        if(jumlah > 100){
            return jumlah * 160000;
        } else {
            return jumlah * HARGA_C;
        }
    }
}