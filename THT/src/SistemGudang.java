import java.util.*;

public class SistemGudang {
    Map<String, Barang> databaseBarang = new HashMap<>();
    Set<String> kategoriUnik = new HashSet<>();
    List<String> riwayat = new ArrayList<>();

    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        Barang barang = new Barang(id, nama, kategori, stok);
        databaseBarang.put(id, barang);
        kategoriUnik.add(kategori);
        riwayat.add("Menambahkan Barang Baru: " + id + " - " + nama + " (" + kategori + ") stok awal " + stok);
    }

    public void tambahStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);
        if (barang != null) {
            barang.stok = barang.stok + jumlah;
            riwayat.add("Menambahkan Stok Barang: " + id + " ditambah " + jumlah + ", stok sekarang " + barang.stok);
        } else {
            riwayat.add("Gagal Menambah Stok: Barang dengan ID " + id + " tidak ditemukan");
        }
    }

    public void kurangiStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);
        if (barang != null) {
            if (barang.stok >= jumlah) {
                barang.stok = barang.stok - jumlah;
                riwayat.add("Barang Keluar: " + id + " keluar sebanyak " + jumlah + ", sisa stok " + barang.stok);
            } else {
                riwayat.add("Gagal Kurangi Stok: Barang dengan ID " + id + " stok tidak tercukupi, stok tersisa "
                        + barang.stok);
            }
        } else {
            riwayat.add("Gagal Kurangi Stok: Barang dengan ID " + id + " tidak ditemukan");
        }
    }

    public void cetakLaporan() {
        System.out.println("DAFTAR KATEGORI");
        for (String kategori : kategoriUnik) {
            System.out.println("- " + kategori);
        }

        System.out.println("--- SISA STOK BARANG ---");
        for (String id : databaseBarang.keySet()) {
            Barang b = databaseBarang.get(id);
            System.out.println("ID: " + b.idBarang + " | Nama: " + b.namaBarang + " | Kategori: " + b.kategori
                    + " | Stok: " + b.stok);
        }

        System.out.println("--- RIWAYAT TRANSAKSI ---");
        for (String log : riwayat) {
            System.out.println(log);
        }
    }

}
