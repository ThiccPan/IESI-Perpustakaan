package perpustakaan;

import java.util.ArrayList;

public class PeminjamanController {
    public void showFormPeminjaman() {
        Perpustakaan.formPeminjaman = new FormPeminjaman();
        Perpustakaan.formPeminjaman.tampilkan();
    }

    public void cariBuku(String judul) {
        BukuProvider bukuProvider = new BukuProvider();
        try {
            ArrayList<Buku> listBuku = bukuProvider.selectBuku(judul);
            if(listBuku.isEmpty())
            {
                DialogUI dialogUI = new DialogUI("Buku tidak terdaftar");
                dialogUI.pack();
                dialogUI.setLocationRelativeTo(null);
                dialogUI.setVisible(true);
            }
            else Perpustakaan.formPeminjaman.display(listBuku);
        } catch(Exception ex) {
            DialogUI dialogUI = new DialogUI("Connection Error");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
    }

    public void pinjam(ArrayList<BukuDipinjam> bukuDipinjam) {
        boolean statusPinjam = PeminjamanManager.save(bukuDipinjam);
        DialogUI dialogUI = new DialogUI("Peminjaman gagal dikonfirmasi, silahkan hubungi admin");
        if (statusPinjam) {
            dialogUI.setMessage("Peminjaman telah dikonfirmasi!");
        }
        dialogUI.pack();
        dialogUI.setLocationRelativeTo(null);
        dialogUI.setVisible(true);
    }
}
