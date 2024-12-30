package testingbcp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class JadwalDanPembayaran {

    private static final String FILE_PATH = "jadwal_kursus.txt"; // File path to store data

    // Method to save schedule and fee to a text file
    public static void simpan(String pelajaran) {
        Scanner scanner = new Scanner(System.in);

        // 1. Select day
        System.out.println("Pilih hari (Senin/Jumat): ");
        String hari = scanner.nextLine();

        // 2. Select available time
        System.out.println("Pilih jam yang tersedia:");
        System.out.println("1. 08:00-10:00");
        System.out.println("2. 10:00-12:00");
        System.out.println("3. 13:00-15:00");
        System.out.println("4. 15:00-17:00");
        System.out.print("Masukkan nomor pilihan jam: ");
        int pilihanJam = scanner.nextInt();
        scanner.nextLine(); // Clear input buffer
        String jam = "";

        //nentuin jam
        switch (pilihanJam) {
            case 1:
                jam = "08:00-10:00";
                break;
            case 2:
                jam = "10:00-12:00";
                break;
            case 3:
                jam = "13:00-15:00";
                break;
            case 4:
                jam = "15:00-17:00";
                break;
            default:
                System.out.println("Pilihan jam tidak valid.");
                return;
        }

        // 3. Input class name and fee
        System.out.print("Silahkan masukkan nama kelas: ");
        String kelas = scanner.nextLine();

        System.out.print("Silahkan masukkan biaya: ");
        double biaya = scanner.nextDouble();
        scanner.nextLine(); // Clear input buffer

        // 4. Save the schedule and fee to the file
        simpanKeFile(kelas, pelajaran, hari, jam, biaya);

        // 5. Read and display the saved fee
        tampilkanBiayaTersimpan(pelajaran, hari, jam);
    }

    // Method to save schedule and fee to the text file
    public static void simpanKeFile(String kelas, String pelajaran, String hari, String jam, double biaya) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(kelas + "," + pelajaran + "," + hari + "," + jam + "," + biaya);
            writer.newLine();
            System.out.println("\nJadwal berhasil disimpan ke file!");
        } catch (IOException e) {
            System.out.println("Error: Gagal menyimpan jadwal ke file.");
            e.printStackTrace();
        }
    }

    // Method to retrieve and display the saved fee from the text file
    public static void tampilkanBiayaTersimpan(String pelajaran, String hari, String jam) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String currentLine;
            boolean found = false;

            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");

                if (data.length == 5 && data[1].equals(pelajaran) && data[2].equals(hari) && data[3].equals(jam)) {
                    double biaya = Double.parseDouble(data[4]);
                    System.out.println("Biaya yang disimpan: Rp " + biaya);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Jadwal tidak ditemukan untuk pilihan Anda.");
            }
        } catch (IOException e) {
            System.out.println("Error: Terjadi kesalahan saat membaca file.");
            e.printStackTrace();
        }
    }
}
