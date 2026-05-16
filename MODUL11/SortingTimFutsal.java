package MODUL11;
import java.util.ArrayList;
import java.util.Collections;

public class SortingTimFutsal {

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

        // Sorting Tinggi Badan
        System.out.println("=== SORTING TINGGI BADAN ===");

        Collections.sort(tinggiA);
        System.out.println("Tinggi Tim A Ascending : " + tinggiA);

        Collections.sort(tinggiA, Collections.reverseOrder());
        System.out.println("Tinggi Tim A Descending : " + tinggiA);

        Collections.sort(tinggiB);
        System.out.println("Tinggi Tim B Ascending : " + tinggiB);

        Collections.sort(tinggiB, Collections.reverseOrder());
        System.out.println("Tinggi Tim B Descending : " + tinggiB);

        // Sorting Berat Badan
        System.out.println("\n=== SORTING BERAT BADAN ===");

        Collections.sort(beratA);
        System.out.println("Berat Tim A Ascending : " + beratA);

        Collections.sort(beratA, Collections.reverseOrder());
        System.out.println("Berat Tim A Descending : " + beratA);

        Collections.sort(beratB);
        System.out.println("Berat Tim B Ascending : " + beratB);

        Collections.sort(beratB, Collections.reverseOrder());
        System.out.println("Berat Tim B Descending : " + beratB);

        // Nilai Maksimum dan Minimum
        System.out.println("\n=== MAXIMUM DAN MINIMUM ===");

        System.out.println("Tinggi maksimum Tim A : " + Collections.max(tinggiA));
        System.out.println("Tinggi minimum Tim A : " + Collections.min(tinggiA));

        System.out.println("Berat maksimum Tim A : " + Collections.max(beratA));
        System.out.println("Berat minimum Tim A : " + Collections.min(beratA));

        System.out.println("Tinggi maksimum Tim B : " + Collections.max(tinggiB));
        System.out.println("Tinggi minimum Tim B : " + Collections.min(tinggiB));

        System.out.println("Berat maksimum Tim B : " + Collections.max(beratB));
        System.out.println("Berat minimum Tim B : " + Collections.min(beratB));

        // Copy Tim B ke Tim C
        ArrayList<Integer> timC = new ArrayList<>(tinggiB);

        System.out.println("\n=== COPY TIM B KE TIM C ===");
        System.out.println("Data Tim C : " + timC);
    }
}