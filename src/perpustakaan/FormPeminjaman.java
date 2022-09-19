package perpustakaan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPeminjaman extends javax.swing.JFrame{
    private JTextField judulBuku;
    private JButton cariButton;
    private JButton batalButton;
    private JButton pinjamButton;
    private JTable daftarBuku;
    private JTable daftarPinjaman;
    private JPanel PeminjamanPanel;
    private JButton konfirmasiButton;

    public FormPeminjaman() {
        cariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judulBukuPinjam = judulBuku.getText();
                System.out.println(judulBukuPinjam);
            }
        });
    }

    public void tampilkan() {
        setContentPane(PeminjamanPanel);
        setTitle("Form Peminjaman");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(400, 500);
    }

    public static void main(String[] args) {
        FormPeminjaman peminjamanform = new FormPeminjaman();
    }


}
