import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Buat map untuk simpan jadwal film dengan Kode Film sebagai key
        Map<String, Film> jadwalFilm = new HashMap<>();
        jadwalFilm.put("F01", new Film("Avengers", 45000));
        jadwalFilm.put("F02", new Film("Inception", 40000));
        jadwalFilm.put("F03", new Film("Interstellar", 50000));

        // Set untuk cegah kursi ganda
        Set<String> kursiDipesan = new HashSet<>();

        // Buat list untuk simpan riwayat transaksi
        List<Pesanan> riwayatTransaksi = new ArrayList<>();

        // Buat list untuk simpan data awal
        List<String> daftarInput = new ArrayList<>();
        daftarInput.add("Ujang#F01#A1"); // Sukses
        daftarInput.add("Asep#F02#B4"); // Sukses
        daftarInput.add("Udin#F01#C2"); // Sukses
        daftarInput.add("Natan#F03#A1"); // Gagal (Kursi ganda)

        System.out.println("PROSES PEMESANAN");

        for (String dataMentah : daftarInput) {
            // Memecah teks berdasarkan tanda # (Sesuai logika Soal 4)
            String[] data = dataMentah.split("#"); // Split berdasarkan #
            String nama = data[0]; // Ambil potongan pertama di index 0 array
            String kodeFilm = data[1]; // Ambil potongan kedua di index 1 array
            String kursi = data[2]; // Ambil potongan ketiga di index 2 array

            // Cek kode film ada di map jadwal film
            if (!jadwalFilm.containsKey(kodeFilm)) {
                System.out.println("Pemesanan Gagal: Kode film " + kodeFilm + " tidak valid");
            }
            // Cek kursi ada di set kursi dipesan
            else if (!kursiDipesan.add(kursi)) {
                System.out.println("Pemesanan Gagal: Kursi " + kursi + " sudah dipesan");
            }
            // Kalau semua syarat terpenuhi masuk ke sukses
            else {
                Film f = jadwalFilm.get(kodeFilm);
                riwayatTransaksi.add(new Pesanan(nama, f.judul, kursi, f.harga));
                System.out.println("Pemesanan Sukses: " + nama + " memesan kursi " + kursi);
            }
        }

        // Mencetak seluruh riwayat transaksi dari List
        System.out.println("\nRIWAYAT TRANSAKSI");
        for (Pesanan p : riwayatTransaksi) {
            p.cetakDetail();
        }
    }
}