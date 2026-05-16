package MODUL11;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTim {

    public static void main(String[] args) {

        // Data Tim A
        ArrayList<Integer> tinggiA = new ArrayList<>();
        Collections.addAll(tinggiA, 168,170,165,168,172,170,169,165,171,166);

        ArrayList<Integer> beratA = new ArrayList<>();
        Collections.addAll(beratA, 50,60,56,55,60,70,66,56,72,56);

        // Data Tim B
        ArrayList<Integer> tinggiB = new ArrayList<>();
        Collections.addAll(tinggiB, 170,167,165,166,168,175,172,171,168,169);

        ArrayList<Integer> beratB = new ArrayList<>();
        Collections.addAll(beratB, 66,60,59,58,58,71,68,68,65,60);

        // Sorting sebelum binary search
        Collections.sort(tinggiB);
        Collections.sort(beratA);

        System.out.println("=== BINARY SEARCH ===");

        // Cari tinggi 168 cm dan 160 cm pada Tim B
        int cari168 = Collections.binarySearch(tinggiB, 168);
        int cari160 = Collections.binarySearch(tinggiB, 160);

        if(cari168 >= 0)
            System.out.println("Tinggi 168 cm ditemukan pada index : " + cari168);
        else
            System.out.println("Tinggi 168 cm tidak ditemukan");

        if(cari160 >= 0)
            System.out.println("Tinggi 160 cm ditemukan pada index : " + cari160);
        else
            System.out.println("Tinggi 160 cm tidak ditemukan");

        // Cari berat 56 kg dan 53 kg pada Tim A
        int cari56 = Collections.binarySearch(beratA, 56);
        int cari53 = Collections.binarySearch(beratA, 53);

        if(cari56 >= 0)
            System.out.println("Berat 56 kg ditemukan pada index : " + cari56);
        else
            System.out.println("Berat 56 kg tidak ditemukan");

        if(cari53 >= 0)
            System.out.println("Berat 53 kg ditemukan pada index : " + cari53);
        else
            System.out.println("Berat 53 kg tidak ditemukan");

        // Mengecek data yang sama
        boolean samaTinggi = false;
        boolean samaBerat = false;

        for(Integer t : tinggiA){
            if(tinggiB.contains(t)){
                samaTinggi = true;
                break;
            }
        }

        for(Integer b : beratA){
            if(beratB.contains(b)){
                samaBerat = true;
                break;
            }
        }

        System.out.println("\n=== CEK DATA SAMA ===");

        if(samaTinggi)
            System.out.println("Ada tinggi badan yang sama antara Tim A dan Tim B");
        else
            System.out.println("Tidak ada tinggi badan yang sama");

        if(samaBerat)
            System.out.println("Ada berat badan yang sama antara Tim A dan Tim B");
        else
            System.out.println("Tidak ada berat badan yang sama");
    }
}
