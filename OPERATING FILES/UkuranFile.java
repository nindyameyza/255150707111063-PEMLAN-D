import java.io.File;

public class UkuranFile {
    public static void main(String[] args) {
        File file = new File("test.txt");

        if (file.exists()) {
            double ukuran = file.length();

            if (ukuran < 1024 * 1024) {
                System.out.printf("Ukuran file: %.2f KB\n", ukuran / 1024);
            } else {
                System.out.printf("Ukuran file: %.2f MB\n", ukuran / (1024 * 1024));
            }
        } else {
            System.out.println("File tidak ditemukan");
        }
    }
}