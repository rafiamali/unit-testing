package testingbcp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestingBcp {
    public static String FILE_PATH = "data_pendaftaran.txt";
    public static Scanner scanner = new Scanner(System.in);  // Static scanner, tidak perlu di-passing
    static int counter = 0;
    
    public static String inputNama() {  // Tidak perlu parameter scanner lagi
        System.out.print("Silahkan masukkan nama Anda : ");
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            return input.equals("0") ? null : input;
        }
        return null;
    }

    public static String inputJenjangSekolah() {
        String jenjang;
        while (true) {
            System.out.print("Silahkan masukkan jenjang sekolah Anda (SD/SMP/SMA): ");
            if (scanner.hasNextLine()) {
                jenjang = scanner.nextLine();
                if (jenjang.equalsIgnoreCase("SD") ||
                    jenjang.equalsIgnoreCase("SMP") ||
                    jenjang.equalsIgnoreCase("SMA")) {
                    return jenjang; 
                } else {
                    System.out.println("Error: Jenjang sekolah harus SD, SMP, atau SMA.");
                }
            }
            counter++;  
            if (counter > 3) {  
                System.out.println("Loop dihentikan karena terlalu banyak iterasi.");
                return null; 
            }
        }
        
    }

    public static String inputNoHp() {
        String noHp;
        int counter = 0;  

        while (counter < 3) {  
            System.out.print("Silahkan masukkan nomor handphone Anda (harus diawali dengan 62): ");
            if (scanner.hasNextLine()) {
                noHp = scanner.nextLine();

                if (noHp.equals("0")) {
                    return null; 
                }

                if (noHp.startsWith("62") && noHp.matches("\\d+")) {
                    return noHp;
                } else {
                    System.out.println("Error: Nomor handphone harus diawali dengan 62 dan berupa angka.");
                }
            }
        }
        return null;
    }

    public static String inputAlamat() {
        System.out.print("Silahkan masukkan alamat Anda (atau ketik 0 untuk keluar): ");
        if (scanner.hasNextLine()) {
            String alamat = scanner.nextLine();
            return alamat.equals("0") ? null : alamat;
        }
        return null;
    }

    public static String inputEmail() {
        String email;
        while (true) {
            System.out.print("Silahkan masukkan email Anda (harus menggunakan domain @gmail.com): ");
            if (scanner.hasNextLine()) {
                email = scanner.nextLine();
                if (email.equals("0")) return null;

                if (email.endsWith("@gmail.com")) {
                    return email;
                } else {
                    System.out.println("Error: Email harus menggunakan domain @gmail.com.");
                }
            }
            counter++;  
            if (counter > 3) {  
                System.out.println("Loop dihentikan karena terlalu banyak iterasi.");
                return null; 
            }
        }
    }

    public static String inputTempatTanggalLahir() {
        System.out.print("Silahkan masukkan tempat dan tanggal lahir Anda (format: Kota, DD-MM-YYYY): ");
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            return input.equals("0") ? null : input;
        }
        return null;
    }

    public static String inputNik() {
        String nik;
        while (true) {
            System.out.print("Silahkan masukkan NIK Anda (16 digit): ");
            if (scanner.hasNextLine()) {
                nik = scanner.nextLine();

                if (nik.equals("0")) return null;

                if (nik.length() == 16 && nik.matches("\\d+")) {
                    return nik;
                } else {
                    System.out.println("Error: NIK harus 16 digit dan berupa angka.");
                }
            }

            counter++;
            if (counter > 3) {
                System.out.println("Loop dihentikan karena terlalu banyak iterasi.");
                break;
            }
        }
        return null;
    }

    public static String inputMataPelajaran() {
        String mataPelajaran;
        while (true) {
            System.out.print("Silahkan masukkan mata pelajaran (Matematika/Sains/Bahasa Inggris): ");
            if (scanner.hasNextLine()) {
                mataPelajaran = scanner.nextLine();
                if (mataPelajaran.equals("0")) return null;

                if (mataPelajaran.equalsIgnoreCase("Matematika") || 
                    mataPelajaran.equalsIgnoreCase("Sains") || 
                    mataPelajaran.equalsIgnoreCase("Bahasa Inggris")) {
                    return mataPelajaran;
                } else {
                    System.out.println("Error: Mata pelajaran harus Matematika, Sains, atau Bahasa Inggris.");
                }
            }
            counter++;  
            if (counter > 3) {  
                System.out.println("Loop dihentikan karena terlalu banyak iterasi.");
                return null; 
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Program Pendaftaran Kursus (tekan 0 untuk keluar)");
        System.out.println("-------------------------------------------");
        System.out.println("Identitas Siswa");

        String nama = inputNama();
        if (nama == null) return;

        String jenjang = inputJenjangSekolah();
        if (jenjang == null) return;

        String nomorHp = inputNoHp();
        if (nomorHp == null) return;

        String alamat = inputAlamat();
        if (alamat == null) return;

        String email = inputEmail();
        if (email == null) return;

        String ttl = inputTempatTanggalLahir();
        if (ttl == null) return;

        String nik = inputNik();
        if (nik == null) return;

        String pelajaran = inputMataPelajaran();
        if (pelajaran == null) return;

        simpanKeFile(nama, jenjang, nomorHp, alamat, email, ttl, nik, pelajaran);

        // JadwalDanPembayaran.simpan(pelajaran);  // Pastikan kelas ini diimplementasikan atau hapus jika tidak ada
        JadwalDanPembayaran.simpan(pelajaran);
    }

    public static void simpanKeFile(String nama, String jenjang, String nomorHp, String alamat, String email, String ttl, String nik, String pelajaran) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(nama + "," + jenjang + "," + nomorHp + "," + alamat + "," + email + "," + ttl + "," + nik + "," + pelajaran);
            writer.newLine();
            System.out.println("Data berhasil disimpan ke file!");
        } catch (IOException e) {
            System.out.println("Error: Gagal menyimpan data ke file.");
            e.printStackTrace();
        }
    }
}