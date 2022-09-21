package perpustakaan;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class FormPeminjaman extends javax.swing.JFrame{
    private JTextField judulBuku;
    private JButton cariButton;
    private JButton batalButton;
    private JButton pinjamButton;
    private JTable daftarBuku;
    private JTable daftarPinjaman;
    private JPanel PeminjamanPanel;
    private JButton konfirmasiButton;
    private JSpinner lama;
    ArrayList<BukuDipinjam> bukuDipinjamCollection;
    ArrayList<Buku> bukuTersediaCollection;

    public FormPeminjaman() {
        bukuDipinjamCollection = new ArrayList<>();

        daftarBuku.setCellSelectionEnabled(true);
        ListSelectionModel modelBukuTerpilih = daftarBuku.getSelectionModel();
        modelBukuTerpilih.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judulBukuPinjam = judulBuku.getText();
                Perpustakaan.controllerPeminjaman.cariBuku(judulBukuPinjam);
            }
        });

        modelBukuTerpilih.addListSelectionListener(new ListSelectionListener() {
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

        // TODO: 21/09/2022 finish this method
        pinjamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ambil value lama pinjam
                int lamaPinjam = (int) lama.getValue();

                //ambil value buku terpilih
                int rowBukuTerpilih = daftarBuku.getSelectedRow();
                int colBukuTerpilih = daftarBuku.getSelectedColumn();
                String judulBukuTerpilih = (String) daftarBuku.getValueAt(rowBukuTerpilih,colBukuTerpilih);
                Buku bukuTerpilih = null;
                for (Buku bukuTersedia : bukuTersediaCollection) {
                    if (Objects.equals(bukuTersedia.judul, judulBukuTerpilih)) {
                        bukuTerpilih = bukuTersedia;
                    }
                }

                //cek value lama pinjam dan tambah jika sesuai
                try {
                    tambahBuku(bukuTerpilih,lamaPinjam);
                } catch (NullPointerException np) {
                    DialogUI dialogUI = new DialogUI("Buku tidak terdaftar");
                    dialogUI.pack();
                    dialogUI.setLocationRelativeTo(null);
                    dialogUI.setVisible(true);
                }

                //tambahkan ke daftarBukuTerpinjam
                tampilPinjaman();
            }
        });
    }

    public void tampilkan() {
        setContentPane(PeminjamanPanel);
        setTitle("Form Peminjaman");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        this.pack();
    }

    public static void main(String[] args) {
        FormPeminjaman peminjamanform = new FormPeminjaman();
        peminjamanform.tampilkan();
    }


    public void display(ArrayList<Buku> bukuList) {
        bukuTersediaCollection = bukuList;
        Object[] kolom = { "Judul" };
        DefaultTableModel model = new DefaultTableModel(kolom, 0);

        for(Buku buku : bukuList) {
            Object[] baris = { buku.judul };
            model.addRow(baris);
        }

        daftarBuku.setModel(model);
    }

    public void tambahBuku(Buku buku, int lama) {
        if (lama > 3) {
            DialogUI dialogUI = new DialogUI("Lama peminjaman melebihi batas maksimal (3 hari)");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        } else {
            BukuDipinjam bukuDipinjam;
            bukuDipinjam = new BukuDipinjam(buku.judul,lama);
            bukuDipinjamCollection.add(bukuDipinjam);
        }
    }

    public void tampilPinjaman() {
        Object[] kolom = {"Judul", "Lama Peminjaman"};
        DefaultTableModel tableModel = new DefaultTableModel(kolom, 0);

        for (BukuDipinjam buku : bukuDipinjamCollection) {
            Object[] baris = { buku.judul, buku.lama };
            tableModel.addRow(baris);
        }
        daftarPinjaman.setModel(tableModel);
    }

    // TODO: 21/09/2022 finish this method
    public void hapusBuku(Buku buku) {

    }
}
