import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String komputerBergerak = generateGerakanKomputer();
            String pemainBergerak = getGerakanPemain(scanner);

            String hasil = tentukanPemenang(pemainBergerak, komputerBergerak);
            System.out.println("Komputer bergerak: " + komputerBergerak);
            System.out.println(hasil);

            if (!bermainLagi(scanner)) {
                break;
            }
        }
    }
    /**
     * Menghasilkan gerakan acak untuk komputer dari pilihan yang tersedia.
     *
     * @return gerakan yang dipilih komputer (baik "kertas", "gunting", atau "batu").
     */

    public static String generateGerakanKomputer() {
        String[] kertasGuntingBatu = {"kertas", "gunting", "batu"};
        return kertasGuntingBatu[new Random().nextInt(kertasGuntingBatu.length)];
    }

    /**
     * Meminta pemain untuk memasukkan gerakan yang valid dan mengembalikannya.
     *
     * @param scanner Objek Scanner untuk menerima input dari pengguna.
     * @return gerakan yang dipilih pemain.
     * @throws IllegalArgumentException jika pemain memasukkan gerakan yang tidak valid.
     */
    public static String getGerakanPemain(Scanner scanner) {
        String pemainBergerak;
        while (true) {
            System.out.println("Masukkan pilihan anda (kertas, gunting, atau batu)");
            pemainBergerak = scanner.nextLine();
            if (pemainBergerak.equals("kertas") || pemainBergerak.equals("gunting") || pemainBergerak.equals("batu")) {
                return pemainBergerak;
            }
            System.out.println(pemainBergerak + " bukanlah gerakan yang benar.");
        }
    }

    /**
     * Menentukan hasil permainan berdasarkan gerakan pemain dan komputer.
     *
     * @param pemainBergerak gerakan yang dipilih oleh pemain.
     * @param komputerBergerak gerakan yang dipilih oleh komputer.
     * @return hasil permainan ("Kamu Menang!", "Kamu Kalah!", atau "Permainan seri!").
     */
    public static String tentukanPemenang(String pemainBergerak, String komputerBergerak) {
        if (pemainBergerak.equals(komputerBergerak)) {
            return "Permainan seri!";
        } else if (pemainBergerak.equals("batu")) {
            return komputerBergerak.equals("kertas") ? "Kamu Kalah!" : "Kamu Menang!";
        } else if (pemainBergerak.equals("gunting")) {
            return komputerBergerak.equals("batu") ? "Kamu Kalah!" : "Kamu Menang!";
        } else if (pemainBergerak.equals("kertas")) {
            return komputerBergerak.equals("gunting") ? "Kamu Kalah!" : "Kamu Menang!";
        }
        return "";
    }

    /**
     * Menanyakan kepada pemain apakah mereka ingin bermain lagi.
     *
     * @param scanner Objek Scanner untuk menerima input dari pengguna.
     * @return true jika pemain ingin bermain lagi; false jika tidak.
     */
    public static boolean bermainLagi(Scanner scanner) {
        System.out.println("Bermain lagi? (ya/tidak)");
        String bermainLagi = scanner.nextLine();
        return bermainLagi.equalsIgnoreCase("ya");
    }
}
