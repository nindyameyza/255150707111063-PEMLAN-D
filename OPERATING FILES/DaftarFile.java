import java.io.File;

public class DaftarFile {
    public static void main(String[] args) {
        File folder = new File("OPERATING FILES");

        if (folder.exists() && folder.isDirectory()) {
            String[] daftarFile = folder.list();

            System.out.println("Daftar file dalam direktori:");

            for (String namaFile : daftarFile) {
                System.out.println(namaFile);
            }
        } else {
            System.out.println("Direktori tidak ditemukan");
        }
    }
}