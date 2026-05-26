import java.util.Objects;

public class Anggota {
    public String idAnggota;
    public String nama;
    public String mahasiswa;

    public Anggota(String idAnggota, String nama, String mahasiswa) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.mahasiswa = mahasiswa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Anggota agt = (Anggota) o;
        return Objects.equals(idAnggota, agt.idAnggota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnggota);
    }
}
