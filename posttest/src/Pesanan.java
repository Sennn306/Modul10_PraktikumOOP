public class Pesanan {
    String namaPemesan;
    String judulFilm;
    String nomorKursi;
    int harga;

    public Pesanan(String namaPemesan, String judulFilm, String nomorKursi, int harga) {
        this.namaPemesan = namaPemesan;
        this.judulFilm = judulFilm;
        this.nomorKursi = nomorKursi;
        this.harga = harga;
    }

    public void cetakDetail() {
        System.out.println(
                "Nama: " + namaPemesan + " | Film: " + judulFilm + " | Kursi: " + nomorKursi + " | Harga: Rp " + harga);
    }
}