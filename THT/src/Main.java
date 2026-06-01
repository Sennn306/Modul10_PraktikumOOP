public class Main {
    public static void main(String[] args) {
        SistemGudang gudang = new SistemGudang();

        // Mendaftarkan barang
        gudang.tambahBarangBaru("B01", "Kulkas", "Elektronik", 10);
        gudang.tambahBarangBaru("B02", "Meja Belajar", "Furniture", 5);
        gudang.tambahBarangBaru("B03", "Kertas A4", "ATK", 100);

        gudang.tambahStok("B01", 5); // Simulasi tambah stok berhasil
        gudang.kurangiStok("B02", 2); // Simulasi kurangi stok berhasil
        gudang.kurangiStok("B03", 150); // Simulasi kurangi stok gagal

        gudang.cetakLaporan();
    }
}