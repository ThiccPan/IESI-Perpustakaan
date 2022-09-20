package perpustakaan;

public class BukuDipinjam extends Buku{
    int lama;

    public BukuDipinjam(String judul, int lama) {
        super(judul);
        this.lama = lama;
    }
}
