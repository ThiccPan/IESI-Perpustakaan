/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;


public class Perpustakaan {

    public static HalamanUtamaUI halamanUtamaUI;
    public static PencarianController controllerPencarian;
    public static PeminjamanController controllerPeminjaman;
    public static FormPencarian formPencarian;
    public static FormPeminjaman formPeminjaman;
    public static DialogUI dialogUI;
    public static BukuProvider bukuProvider;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create new Home
        Perpustakaan.halamanUtamaUI = new HalamanUtamaUI();
        
        // center screen
        Perpustakaan.halamanUtamaUI.pack();
        Perpustakaan.halamanUtamaUI.setLocationRelativeTo(null);
        Perpustakaan.halamanUtamaUI.setVisible(true);
        
        
        // TODO code application logic here
    }
    
}
