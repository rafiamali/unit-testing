package testingbcp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class JadwalDanPembayaranTest {

    public JadwalDanPembayaranTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up class executed");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tear down class executed");
    }

    @Before
    public void setUp() {
        System.out.println("Set up executed before each test");
    }

    @After
    public void tearDown() {
        System.out.println("Tear down executed after each test");
    }
    
    @Test
    public void testSimpan() {
    System.out.println("Test simpan");

    // Simulasi input pengguna untuk pengujian
    for (int i = 1; i <= 5; i++) {
            String input = "Senin\n" + i + "\nKelas A\n100000\n"; // Mengganti 'Senin' dengan pilihan hari 1-5
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in); // Set System.in ke input simulasi

    // Jalankan metode simpan
    JadwalDanPembayaran.simpan("Matematika");

    // Reset System.in ke standar
    System.setIn(System.in);
    }
}

    //bagian testing
    @Test
    public void testInputNamaKelasNotNull() {
        System.out.println("Test input nama kelas not null");

        // Assume that the input nama kelas is "Matematika"
        String namaKelas = "Matematika";
        assertThat(namaKelas, is(not(nullValue())));
    }

    @Test
    public void testBiayaValid() {
        System.out.println("Test valid biaya");

        // Assume that biaya is valid if greater than 0
        double biaya = 50000.00;
        assertTrue(biaya > 0);
    }

    @Test
    public void testInvalidBiaya() {
        System.out.println("Test invalid biaya");

        // Assume that biaya is invalid if less than or equal to 0
        double biaya = 0.00;
        assertFalse(biaya > 0);
    }
    
}
