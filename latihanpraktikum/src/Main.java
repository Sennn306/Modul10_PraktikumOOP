import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        Map<String, Buku> katalogBuku = new HashMap<>(); // Nomor 1
        katalogBuku.put("789", new Buku("789", "Buku 1"));
        katalogBuku.put("123", new Buku("123", "Buku 2"));
        katalogBuku.put("456", new Buku("456", "Buku 3"));

        Set<Anggota> setIdAnggota = new HashSet<>(); // Nomor 2
        setIdAnggota.add(new Anggota("A001", "Andi", "mahasiswa"));
        setIdAnggota.add(new Anggota("A002", "Budi", "mahasiswa"));
        setIdAnggota.add(new Anggota("A003", "Siti", "mahasiswa"));

        LinkedList<String> antrePinjaman = new LinkedList<>(); // Nomor 3

        // Nomor 3
        for (int i = 1; i < 5; i++) {
            System.out.print("Masukkan ID anggota: ");
            String idAgt = input.nextLine();
            System.out.print("Masukkan tipe anggota: ");
            String tipeAnggota = input.nextLine();
            System.out.print("Masukkan ISBN buku yang dipinjam: ");
            String isbn = input.nextLine();

            String dataAntrean = idAgt + "#" + isbn;

            if (tipeAnggota.equalsIgnoreCase("mahasiswa")) {
                antrePinjaman.addLast(dataAntrean);
            } else if (tipeAnggota.equalsIgnoreCase("dosen")) {
                antrePinjaman.addFirst(dataAntrean);
            }
        }

        System.out.println("Antrean Peminjaman: " + antrePinjaman); // Output untuk nomor 3

        Map<String, String> bukuSedangDipinjam = new HashMap<>();

        while (!antrePinjaman.isEmpty()) {
            String dataAntrean = antrePinjaman.removeFirst(); // Ambil lalu simpan di dataAntrean dan mengurangi list
                                                              // sebelumnya
            String[] data = dataAntrean.split("#");
            String dataId = data[0];
            String dataIsbn = data[1];

            Anggota anggotaDitemukan = null;
            for (Anggota agt : setIdAnggota) {
                if (agt.idAnggota.equals(dataId)) {
                    anggotaDitemukan = agt;
                    break;
                }
            }

            Buku bukuDitemukan = katalogBuku.get(dataIsbn);

            if (anggotaDitemukan == null) {
                System.out.println("Peminjaman Gagal [" + dataAntrean + "]: ID Anggota tidak terdaftar.");
            } else if (bukuDitemukan == null) {
                System.out.println("Peminjaman Gagal [" + dataAntrean + "]: ISBN tidak terdaftar di katalog");
            } else if (bukuSedangDipinjam.containsKey(bukuDitemukan.judul)) {
                // Pengecekan Kondisi 3: Apakah buku tersebut sedang dipinjam orang lain?
                System.out.println("Peminjaman Gagal [" + dataAntrean + "]: Buku " + bukuDitemukan.judul
                        + "sedang dipinjam orang lain.");
            } else {
                // Jika sukses, catat ke dalam Collections khusus
                bukuSedangDipinjam.put(bukuDitemukan.judul, anggotaDitemukan.nama);
                System.out
                        .println("Peminjaman Berhasil: " + anggotaDitemukan.nama + " meminjam " + bukuDitemukan.judul);
            }
        }
    }
}
