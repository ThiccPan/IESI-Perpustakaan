package perpustakaan;

import java.util.ArrayList;

public class PeminjamanManager {
    public static boolean save(ArrayList<BukuDipinjam> bukuDipinjamCollection) {
        Peminjaman daftarPeminjaman = new Peminjaman();
        try {
            for (BukuDipinjam bukuDipinjam:bukuDipinjamCollection) {
                daftarPeminjaman.daftarBuku.add(bukuDipinjam);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
