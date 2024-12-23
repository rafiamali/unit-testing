package testingbcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Test class for Project functionalities.
 * 
 * @author Developer
 */
public class TestingBcpTest {
    private static final String FILE_PATH = "test_data_pendaftaran.txt"; // Temporary test file path

    @Before
    public void setUp() throws IOException {
        // Pastikan file dalam keadaan kosong sebelum setiap pengujian
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("");
        }
    }

    @After
    public void tearDown() {
        // Hapus file setelah pengujian selesai
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    // Test method for inputNama()
    @Test
    public void testInputNama() {
        System.out.println("-----Testing Input Nama-----");
        String input = "John Doe";
        // Simulate user input
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputNama();
        assertThat(result, is("John Doe"));
        assertThat(result, is(not(nullValue())));
    }
    
     @Test
    public void testInputNamaExitWithZero() {
        System.out.println("-----Testing Input Tempat dan Tanggal Lahir Exit with 0-----");
        
        // Simulate user input for exiting
        String input = "0";  // User presses 0 to exit
        TestingBcp.scanner = new java.util.Scanner(input);
        
        String result = TestingBcp.inputNama();  // Call inputTempatTanggalLahir without parameters
        
        // Assert that the result is null or an expected exit value (modify as per your logic)
        assertThat(result, is(nullValue())); // Assuming your method returns null when exiting
    }

    @Test
    // Test method for inputJenjangSekolah()
    public void testInputJenjangSekolahValidSD() {
        System.out.println("-----Testing Input Jenjang Sekolah SMP(Valid)-----");
        String input = "SD";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputJenjangSekolah();
        assertThat(result, is("SD"));
    }
    
    @Test
    public void testInputJenjangSekolahValidSMP() {
        System.out.println("-----Testing Input Jenjang Sekolah SMP(Valid)-----");
        String input = "SMP";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputJenjangSekolah();
        assertThat(result, is("SMP"));
    }
    
    @Test
    public void testInputJenjangSekolahValidSMA() {
        System.out.println("-----Testing Input Jenjang Sekolah SMA(Valid)-----");
        String input = "SMA";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputJenjangSekolah();
        assertThat(result, is("SMA"));
    }

    @Test
    public void testInputJenjangSekolahInvalid() {
        System.out.println("-----Testing Input Jenjang Sekolah (Invalid)-----");
        String input = "SMP\nSMA\n123\nSMP";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputJenjangSekolah();
        assertThat(result, is("SMP"));
    }
    
    @Test
    public void testInputJenjangSekolahExitWithZero() {
        System.out.println("-----Testing Input Tempat dan Tanggal Lahir Exit with 0-----");
        
        // Simulate user input for exiting
        String input = "0";  // User presses 0 to exit
        TestingBcp.scanner = new java.util.Scanner(input);
        
        String result = TestingBcp.inputJenjangSekolah();  // Call inputTempatTanggalLahir without parameters
        
        // Assert that the result is null or an expected exit value (modify as per your logic)
        assertThat(result, is(nullValue())); // Assuming your method returns null when exiting
    }

    // Test method for inputNoHp()
    @Test
    public void testInputNoHpValid() {
        System.out.println("-----Testing Input No Hp (Valid)-----");
        String input = "6281234567890";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputNoHp();
        assertThat(result, startsWith("62"));
        assertThat(result, is("6281234567890"));
    }

    @Test
    public void testInputNoHpInvalid() {
        System.out.println("-----Testing Input No Hp (Invalid)-----");
        String input = "081234567890\n6281234567890";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputNoHp();
        assertThat(result, startsWith("62"));
    }
    
    @Test
    public void testInputNoHpWithZero() {
        System.out.println("-----Testing Input Tempat dan Tanggal Lahir Exit with 0-----");
        
        // Simulate user input for exiting
        String input = "0";  // User presses 0 to exit
        TestingBcp.scanner = new java.util.Scanner(input);
        
        String result = TestingBcp.inputNoHp();  // Call inputTempatTanggalLahir without parameters
        
        // Assert that the result is null or an expected exit value (modify as per your logic)
        assertThat(result, is(nullValue())); // Assuming your method returns null when exiting
    }
    
    @Test
    public void testInputAlamat() {
        System.out.println("-----Testing Input Alamat-----");
        String alamat = "123 Main St";  // Replace with your desired test address
        TestingBcp.scanner = new java.util.Scanner(alamat);    
        String result = TestingBcp.inputAlamat();  // Call inputAlamat with the simulated scanner
        assertThat(result, is("123 Main St"));
        assertThat(result, is(not(nullValue())));
    }
    
    @Test
    public void testInputAlamatExitWithZero() {
        System.out.println("-----Testing Input Alamat Exit with 0-----");
        String input = "0";  // User presses 0 to exit
        TestingBcp.scanner = new java.util.Scanner(input);        
        String result = TestingBcp.inputAlamat();  // Call inputAlamat without parameters
        assertThat(result, is(nullValue())); // Assuming your method returns null when exiting
    }


    // Test method for inputEmail()
    @Test
    public void testInputEmailValid() {
        System.out.println("-----Testing Input Email (Valid)-----");
        String input = "test@gmail.com";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputEmail();
        assertThat(result, is("test@gmail.com"));
    }

    @Test
    public void testInputEmailInvalid() {
        System.out.println("-----Testing Input Email (Invalid)-----");
        String input = "test@yahoo.com\ntest@gmail.com";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputEmail();
        assertThat(result, is("test@gmail.com"));
    }
    
    @Test
    public void testInputEmailExitWithZero() {
        System.out.println("-----Testing Input Tempat dan Tanggal Lahir Exit with 0-----");
        String input = "0";  // User presses 0 to exit
        TestingBcp.scanner = new java.util.Scanner(input);        
        String result = TestingBcp.inputEmail();  // Call inputTempatTanggalLahir without parameters       
        assertThat(result, is(nullValue())); // Assuming your method returns null when exiting
    }
    
    @Test
    public void testTempatTanggalLahir() {
        System.out.println("-----Testing Input Tempat Tanggal Lahir-----");
        String ttl = "Jakarta, 01-01-2000";  // Replace with your desired test address
        TestingBcp.scanner = new java.util.Scanner(ttl);   
        String result = TestingBcp.inputTempatTanggalLahir();  // Call inputAlamat with the simulated scanner
        assertThat(result, is("Jakarta, 01-01-2000"));
        assertThat(result, is(not(nullValue())));
    }
     @Test
    public void testInputTempatTanggalLahirExitWithZero() {
        System.out.println("-----Testing Input Tempat dan Tanggal Lahir Exit with 0-----");
        String input = "0";  // User presses 0 to exit
        TestingBcp.scanner = new java.util.Scanner(input);        
        String result = TestingBcp.inputTempatTanggalLahir();  // Call inputTempatTanggalLahir without parameters
        assertThat(result, is(nullValue())); // Assuming your method returns null when exiting
    }

    // Test method for inputNik()
    @Test
    public void testInputNikValid() {
        System.out.println("-----Testing Input NIK (Valid)-----");
        String input = "1234567890123456";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputNik();
        assertThat(result.length(), is(16));
        assertThat(result, is("1234567890123456"));
    }

    @Test
    public void testInputNikInvalid() {
        System.out.println("-----Testing Input NIK (Invalid)-----");
        String input = "123456\n1234567890123456";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputNik();
        assertThat(result, is("1234567890123456"));
    }
    
    @Test
    public void testInputNikExitWithZero() {
        System.out.println("-----Testing Input Tempat dan Tanggal Lahir Exit with 0-----");
        String input = "0";  // User presses 0 to exit
        TestingBcp.scanner = new java.util.Scanner(input);        
        String result = TestingBcp.inputNik();  // Call inputTempatTanggalLahir without parameters
        assertThat(result, is(nullValue())); // Assuming your method returns null when exiting
    }

    // Test method for inputMataPelajaran()
    @Test
    public void testInputMataPelajaranValidMatematika() {
        System.out.println("-----Testing Input Mata Pelajaran Matematika(Valid)-----");
        String input = "Matematika";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputMataPelajaran();
        assertThat(result, is("Matematika"));
    }
    
    @Test
    public void testInputMataPelajaranValidSains() {
        System.out.println("-----Testing Input Mata Pelajaran Sains(Valid)-----");
        String input = "Sains";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputMataPelajaran();
        assertThat(result, is("Sains"));
    }
    
    @Test
    public void testInputMataPelajaranValidBahasaInggris() {
        System.out.println("-----Testing Input Mata Pelajaran Bahasa Inggris(Valid)-----");
        String input = "Bahasa Inggris";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputMataPelajaran();
        assertThat(result, is("Bahasa Inggris"));
    }

    @Test
    public void testInputMataPelajaranInvalid() {
        System.out.println("-----Testing Input Mata Pelajaran (Invalid)-----");
        String input = "Sejarah\nMatematika";
        TestingBcp.scanner = new java.util.Scanner(input);
        String result = TestingBcp.inputMataPelajaran();
        assertThat(result, is("Matematika"));
    }
    
    @Test
    public void testInputMataPelajarnExitWithZero() {
        System.out.println("-----Testing Input Tempat dan Tanggal Lahir Exit with 0-----");
        String input = "0";  // User presses 0 to exit
        TestingBcp.scanner = new java.util.Scanner(input);        
        String result = TestingBcp.inputMataPelajaran();  // Call inputTempatTanggalLahir without parameters
        assertThat(result, is(nullValue())); // Assuming your method returns null when exiting
    }
    
    // Test for simpanKeFile() method
    @Test
    public void testSimpanKeFile() {
        System.out.println("-----Testing simpanKeFile-----");

        // Test data
        String nama = "John Doe";
        String jenjang = "SMA";
        String nomorHp = "6281234567890";
        String alamat = "123 Main St";
        String email = "johndoe@gmail.com";
        String ttl = "Jakarta, 01-01-2000";
        String nik = "1234567890123456";
        String pelajaran = "Matematika";

        // Call the method with the test data
        TestingBcp.simpanKeFile(nama, jenjang, nomorHp, alamat, email, ttl, nik, pelajaran);

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            String expected = nama + "," + jenjang + "," + nomorHp + "," + alamat + "," + email + "," + ttl + "," + nik + "," + pelajaran;
            assertEquals(expected, line);  // Bandingkan hasil di file dengan yang diharapkan
        } catch (IOException e) {
            fail("Gagal membaca file untuk pengujian");
        }
    }
    
    // Test for the main() method
    @Test
    public void testMain() {
        System.out.println("-----Testing Main Program Flow-----");

        // Simulate the full input sequence for the main method
        String inputSequence = "John Doe\nSMA\n6281234567890\n123 Main St\njohndoe@gmail.com\nJakarta, 01-01-2000\n1234567890123456\nMatematika\n";
        TestingBcp.scanner = new java.util.Scanner(inputSequence);

        // Run the main method
        TestingBcp.main(new String[0]);

        // Verify that the file contains the correct data
        File file = new File(FILE_PATH);
        assertTrue("File should be created", file.exists());

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            assertNotNull("File should contain data", line);
            assertEquals("Data in the file should match the input", 
                "John Doe,SMA,6281234567890,123 Main St,johndoe@gmail.com,Jakarta, 01-01-2000,1234567890123456,Matematika", line);
        } catch (IOException e) {
            fail("Error reading the test file: " + e.getMessage());
        }
    }
    
}

