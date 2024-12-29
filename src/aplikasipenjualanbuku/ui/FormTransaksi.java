/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasipenjualanbuku.ui;


import aplikasipenjualanbuku.utils.TransactionPrinter;
import aplikasipenjualanbuku.dao.BukuDAO;
import aplikasipenjualanbuku.model.BukuModel;
import aplikasipenjualanbuku.dao.TransaksiDAO;
import aplikasipenjualanbuku.model.TransaksiModel;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.text.ParseException;
import java.awt.print.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class FormTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form FormTransaksi
     */
    public FormTransaksi() {
        initComponents();
        loadComboBoxBuku();
        setupListeners();
        loadTableTransaksi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblIdTransaksi = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        lblBuku = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        lblTotalHarga = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        txtIdTransaksi = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        cmbBuku = new javax.swing.JComboBox<>();
        jTanggal = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("FORM TRANSAKSI");
        getContentPane().add(lblTitle, java.awt.BorderLayout.PAGE_START);

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblIdTransaksi.setText("ID Transaksi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 6);
        jPanel1.add(lblIdTransaksi, gridBagConstraints);

        lblTanggal.setText("Tanggal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 6);
        jPanel1.add(lblTanggal, gridBagConstraints);

        lblBuku.setText("Buku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 6);
        jPanel1.add(lblBuku, gridBagConstraints);

        lblJumlah.setText("Jumlah");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 6);
        jPanel1.add(lblJumlah, gridBagConstraints);

        lblTotalHarga.setText("Total Harga");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 6);
        jPanel1.add(lblTotalHarga, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 200));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 400));

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "TANGGAL", "BUKU", "JUMLAH", "TOTAL HARGA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransaksi.setPreferredSize(new java.awt.Dimension(600, 64));
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransaksi);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel1.add(btnCetak, gridBagConstraints);

        txtIdTransaksi.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 47, 8, 19);
        jPanel1.add(txtIdTransaksi, gridBagConstraints);

        txtHarga.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 47, 8, 19);
        jPanel1.add(txtHarga, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 47, 8, 19);
        jPanel1.add(txtJumlah, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 13);
        jPanel2.add(btnTambah, gridBagConstraints);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 13);
        jPanel2.add(btnEdit, gridBagConstraints);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 13);
        jPanel2.add(btnHapus, gridBagConstraints);

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 13);
        jPanel2.add(btnBatal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 20;
        jPanel1.add(jPanel2, gridBagConstraints);

        cmbBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBukuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(9, 47, 9, 17);
        jPanel1.add(cmbBuku, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 46, 0, 18);
        jPanel1.add(jTanggal, gridBagConstraints);

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 0, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransaksiMouseClicked
     int row = tblTransaksi.getSelectedRow();
            if (row != -1) {
                // Ambil data dari baris yang dipilih
                int idTransaksi = (int) tblTransaksi.getValueAt(row, 0);
                String tanggal = (String) tblTransaksi.getValueAt(row, 1);
                int idBuku = (int) tblTransaksi.getValueAt(row, 2);
                int jumlah = (int) tblTransaksi.getValueAt(row, 3);
                double totalHarga = (double) tblTransaksi.getValueAt(row, 4);

                // Isi data ke textfield dan JDateChooser
                txtIdTransaksi.setText(String.valueOf(idTransaksi));
                txtJumlah.setText(String.valueOf(jumlah));
                txtHarga.setText(String.valueOf(totalHarga));

                // Mengonversi tanggal ke Date dan mengisi JDateChooser
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date date = sdf.parse(tanggal);
                    jTanggal.setDate(date);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Gagal mengonversi tanggal: " + ex.getMessage());
                }

                // Pilih item di ComboBox berdasarkan ID Buku
                for (int i = 0; i < cmbBuku.getItemCount(); i++) {
                    String item = (String) cmbBuku.getItemAt(i);
                    if (item.split(" - ")[0].equals(String.valueOf(idBuku))) {
                        cmbBuku.setSelectedIndex(i);
                        break;
                    }
                }
            }
    }//GEN-LAST:event_tblTransaksiMouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
    printTransaksi();                // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
     tambahTransaksi();  
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
     editTransaksi(); 
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
     hapusTransaksi();  
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
     batalTransaksi();   
    }//GEN-LAST:event_btnBatalActionPerformed
private void clearForm() {
    txtIdTransaksi.setText("");
    jTanggal.setDate(null);
    cmbBuku.setSelectedIndex(0);
    txtJumlah.setText("");
    txtHarga.setText("");
}

private void loadTableTransaksi() {
    // Muat ulang data transaksi ke tabel
    try {
        TransaksiDAO transaksiDAO = new TransaksiDAO();
        List<TransaksiModel> listTransaksi = transaksiDAO.getAllTransaksi();

        DefaultTableModel model = (DefaultTableModel) tblTransaksi.getModel();
        model.setRowCount(0);

        for (TransaksiModel transaksi : listTransaksi) {
            model.addRow(new Object[]{
                transaksi.getIdTransaksi(),
                transaksi.getTanggal(),
                transaksi.getIdBuku(),
                transaksi.getJumlah(),
                transaksi.getTotalHarga()
            });
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Gagal memuat tabel transaksi: " + ex.getMessage());
    }
}
// Menggunakan JDateChooser untuk mengambil tanggal
private boolean validateForm() {
    if (jTanggal.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Tanggal harus diisi.");
        return false;
    }

    if (cmbBuku.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Pilih buku terlebih dahulu.");
        return false;
    }

    if (txtJumlah.getText().isEmpty() || !txtJumlah.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Jumlah harus diisi dengan angka.");
        return false;
    }

    if (txtHarga.getText().isEmpty() || !txtHarga.getText().matches("\\d+(\\.\\d+)?")) {
        JOptionPane.showMessageDialog(this, "Harga total tidak valid.");
        return false;
    }

    return true;
}

private void tambahTransaksi() {
    try {
        if (validateForm()) {
            TransaksiDAO transaksiDAO = new TransaksiDAO();

            TransaksiModel transaksi = new TransaksiModel();
            
            // Format tanggal menjadi string
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = sdf.format(jTanggal.getDate());
            transaksi.setTanggal(tanggal);

            transaksi.setIdBuku(Integer.parseInt(cmbBuku.getSelectedItem().toString().split(" - ")[0]));
            transaksi.setJumlah(Integer.parseInt(txtJumlah.getText()));
            transaksi.setTotalHarga(Double.parseDouble(txtHarga.getText()));

            transaksiDAO.insertTransaksi(transaksi);

            JOptionPane.showMessageDialog(this, "Transaksi berhasil ditambahkan.");
            clearForm();
            loadTableTransaksi();
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Gagal menambahkan transaksi: " + ex.getMessage());
    }
}

private void editTransaksi() {
    try {
        if (validateForm()) {
            TransaksiDAO transaksiDAO = new TransaksiDAO();

            TransaksiModel transaksi = new TransaksiModel();
            transaksi.setIdTransaksi(Integer.parseInt(txtIdTransaksi.getText())); // Pastikan ID tidak kosong

            // Format tanggal menjadi string
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = sdf.format(jTanggal.getDate());
            transaksi.setTanggal(tanggal);

            transaksi.setIdBuku(Integer.parseInt(cmbBuku.getSelectedItem().toString().split(" - ")[0]));
            transaksi.setJumlah(Integer.parseInt(txtJumlah.getText()));
            transaksi.setTotalHarga(Double.parseDouble(txtHarga.getText()));

            transaksiDAO.updateTransaksi(transaksi);

            JOptionPane.showMessageDialog(this, "Transaksi berhasil diperbarui.");
            clearForm();
            loadTableTransaksi();
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Gagal mengedit transaksi: " + ex.getMessage());
    }
}

private void hapusTransaksi() {
    try {
        if (txtIdTransaksi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih transaksi yang akan dihapus.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus transaksi ini?");
        if (confirm == JOptionPane.YES_OPTION) {
            TransaksiDAO transaksiDAO = new TransaksiDAO();
            int idTransaksi = Integer.parseInt(txtIdTransaksi.getText());
            transaksiDAO.deleteTransaksi(idTransaksi);

            JOptionPane.showMessageDialog(this, "Transaksi berhasil dihapus.");
            clearForm();
            loadTableTransaksi();
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Gagal menghapus transaksi: " + ex.getMessage());
    }
}

private void batalTransaksi() {
    clearForm();
}

   private void setupListeners() {
    cmbBuku.addItemListener(e -> updateTotalHarga());
    txtJumlah.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateTotalHarga();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateTotalHarga();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateTotalHarga();
        }
    });
}

private void updateTotalHarga() {
    try {
        BukuDAO bukuDAO = new BukuDAO();
        String selectedItem = (String) cmbBuku.getSelectedItem(); // Mengambil pilihan dari combobox
        if (selectedItem != null && !txtJumlah.getText().isEmpty()) {
            int idBuku = Integer.parseInt(selectedItem.split(" - ")[0]); // Mengambil ID buku dari combobox
            double harga = bukuDAO.getHargaBukuById(idBuku); // Mendapatkan harga buku dari DAO
            int jumlah = Integer.parseInt(txtJumlah.getText()); // Jumlah buku dari input pengguna
            double totalHarga = harga * jumlah; // Menghitung total harga

            txtHarga.setText(String.valueOf(totalHarga)); // Mengonversi totalHarga ke String dan menampilkannya

        }
    } catch (NumberFormatException ex) {
        txtHarga.setText("0");
        JOptionPane.showMessageDialog(this, "Input jumlah harus berupa angka valid.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal menghitung total harga: " + ex.getMessage());
    }
}

private void loadComboBoxBuku() {
    try {
        BukuDAO bukuDAO = new BukuDAO();
        List<BukuModel> listBuku = bukuDAO.cmbBuku(); // Mengambil data buku dari DAO
        for (BukuModel buku : listBuku) {
            cmbBuku.addItem(buku.getIdBuku() + " - " + buku.getJudul()); // Format: "ID - Judul"
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data buku: " + ex.getMessage());
    }
}

// Add this method to your FormTransaksi class:
private void printTransaksi() {
    try {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new TransactionPrinter(tblTransaksi));
        
        if (job.printDialog()) {
            job.print();
            JOptionPane.showMessageDialog(this,
                "Printing complete.",
                "Print Result",
                JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (PrinterException pe) {
        JOptionPane.showMessageDialog(this,
            "Printing failed: " + pe.getMessage(),
            "Print Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

    
    private void cmbBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBukuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbBuku;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jTanggal;
    private javax.swing.JLabel lblBuku;
    private javax.swing.JLabel lblIdTransaksi;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalHarga;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdTransaksi;
    private javax.swing.JTextField txtJumlah;
    // End of variables declaration//GEN-END:variables
}
