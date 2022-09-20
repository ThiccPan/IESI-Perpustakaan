package perpustakaan;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
                Perpustakaan.controllerPeminjaman.cariBuku(judulBukuPinjam);
            }
        });
        daftarBuku.setCellSelectionEnabled(true);
        ListSelectionModel bukuTerpilih = daftarBuku.getSelectionModel();
        bukuTerpilih.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        bukuTerpilih.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ArrayList<String> judulBukuAkanDitambah = new ArrayList<>();
                int[] rows = daftarBuku.getSelectedRows();
                int[] columns = daftarBuku.getSelectedColumns();
                for (int row : rows) {
                    for (int column : columns) {
                        String judulBukuTerpilih = (String) daftarBuku.getValueAt(row, column);
                        if (judulBukuTerpilih != null) {
                            judulBukuAkanDitambah.add(judulBukuTerpilih);
                        }
                    }
                }
                System.out.println("Judul buku yang dipilih" + judulBukuAkanDitambah);
            }
        });
    }

    public void tampilkan() {
        setContentPane(PeminjamanPanel);
        setTitle("Form Peminjaman");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        this.pack();
    }

    public static void main(String[] args) {
        FormPeminjaman peminjamanform = new FormPeminjaman();
    }


    public void display(ArrayList<Buku> bukuList) {
        Object[] kolom = { "Judul" };
        DefaultTableModel model = new DefaultTableModel(kolom, 0);

        for(Buku buku : bukuList) {
            Object[] baris = { buku.judul };
            model.addRow(baris);
        }

        daftarBuku.setModel(model);
    }
}
