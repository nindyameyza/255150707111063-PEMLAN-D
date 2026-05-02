package MODUL9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormMahasiswa extends JFrame implements ActionListener {

    JTextField tNama, tTanggal, tNoDaftar, tTelp, tEmail;
    JTextArea tAlamat;
    JButton btnSubmit;

    public FormMahasiswa() {
        setTitle("Form Daftar Ulang Mahasiswa");
        setSize(450, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Nama Lengkap"));
        tNama = new JTextField();
        panel.add(tNama);

        panel.add(new JLabel("Tanggal Lahir"));
        tTanggal = new JTextField();
        panel.add(tTanggal);

        panel.add(new JLabel("Nomor Pendaftaran"));
        tNoDaftar = new JTextField();
        panel.add(tNoDaftar);

        panel.add(new JLabel("No. Telp"));
        tTelp = new JTextField();
        panel.add(tTelp);

        panel.add(new JLabel("Alamat"));
        tAlamat = new JTextArea(3, 20);
        panel.add(new JScrollPane(tAlamat));

        panel.add(new JLabel("E-mail"));
        tEmail = new JTextField();
        panel.add(tEmail);

        panel.add(new JLabel(""));
        btnSubmit = new JButton("Submit");
        panel.add(btnSubmit);

        add(panel);

        btnSubmit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        String nama = tNama.getText();
        String tanggal = tTanggal.getText();
        String noDaftar = tNoDaftar.getText();
        String telp = tTelp.getText();
        String alamat = tAlamat.getText();
        String email = tEmail.getText();

        // VALIDASI
        if (nama.isEmpty() || tanggal.isEmpty() || noDaftar.isEmpty()
                || telp.isEmpty() || alamat.isEmpty() || email.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!");
            return;
        }

        // KONFIRMASI
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah anda yakin data yang Anda isi sudah benar?",
                "Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (confirm == JOptionPane.OK_OPTION) {

            // ===== WINDOW HASIL =====
            JFrame hasil = new JFrame("Data Mahasiswa");
            hasil.setSize(400, 350);
            hasil.setLocationRelativeTo(null);
            hasil.setLayout(new BorderLayout());

            // ===== JUDUL =====
            JLabel judul = new JLabel("DATA MAHASISWA", JLabel.CENTER);
            judul.setFont(new Font("Arial", Font.BOLD, 18));
            judul.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            hasil.add(judul, BorderLayout.NORTH);

            // ===== ISI DATA =====
            JPanel panelData = new JPanel(new GridLayout(6, 2, 10, 10));
            panelData.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

            panelData.add(new JLabel("Nama Lengkap"));
            panelData.add(new JLabel(": " + nama));

            panelData.add(new JLabel("Tanggal Lahir"));
            panelData.add(new JLabel(": " + tanggal));

            panelData.add(new JLabel("No. Pendaftaran"));
            panelData.add(new JLabel(": " + noDaftar));

            panelData.add(new JLabel("No. Telp"));
            panelData.add(new JLabel(": " + telp));

            panelData.add(new JLabel("Alamat"));
            panelData.add(new JLabel(": " + alamat));

            panelData.add(new JLabel("E-mail"));
            panelData.add(new JLabel(": " + email));

            hasil.add(panelData, BorderLayout.CENTER);

            hasil.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new FormMahasiswa().setVisible(true);
    }
}