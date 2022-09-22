package perpustakaan;

import java.util.ArrayList;

public class Peminjaman {
    public ArrayList<BukuDipinjam> daftarBuku;

    public Peminjaman(ArrayList<BukuDipinjam> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }

    public Peminjaman() {
        this.daftarBuku = new ArrayList<>();
    }
}
