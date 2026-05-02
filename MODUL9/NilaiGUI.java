package MODUL9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ===== ABSTRACT CLASS =====
abstract class MataKuliah {
    double tugas, kuis, uts, uas;

    public MataKuliah(double t, double k, double u, double ua) {
        tugas = t;
        kuis = k;
        uts = u;
        uas = ua;
    }

    abstract double hitungNilai();
}

// ===== RUMUS BERBEDA =====
class Pemlan extends MataKuliah {
    public Pemlan(double t, double k, double u, double ua) {
        super(t, k, u, ua);
    }

    double hitungNilai() {
        return (tugas + kuis + uts + uas) / 4; // 80
    }
}

class ASD extends MataKuliah {
    public ASD(double t, double k, double u, double ua) {
        super(t, k, u, ua);
    }

    double hitungNilai() {
        return (tugas * 0.1 + kuis * 0.2 + uts * 0.3 + uas * 0.4); // 82.5
    }
}

class Matkomlan extends MataKuliah {
    public Matkomlan(double t, double k, double u, double ua) {
        super(t, k, u, ua);
    }

    double hitungNilai() {
        return (tugas + kuis + uts + uas) / 4; // 80
    }
}

class Probstat extends MataKuliah {
    public Probstat(double t, double k, double u, double ua) {
        super(t, k, u, ua);
    }

    double hitungNilai() {
        return (tugas * 0.1 + kuis * 0.1 + uts * 0.4 + uas * 0.4); // 90
    }
}

// ===== GUI =====
public class NilaiGUI extends JFrame implements ActionListener {

    JRadioButton rbPemlan, rbASD, rbMatkomlan, rbProbstat;
    JTextField tTugas, tKuis, tUTS, tUAS, tHasil;
    JTextArea area;
    JButton btnHitung, btnTampil;

    Double nilaiPemlan, nilaiASD, nilaiMatkomlan, nilaiProbstat;

    public NilaiGUI() {
        setTitle("Hitung Nilai Akhir");
        setSize(500, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Hitung Nilai Akhir", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(title);

        JPanel panelRadio = new JPanel();
        rbPemlan = new JRadioButton("Pemlan", true);
        rbASD = new JRadioButton("ASD");
        rbMatkomlan = new JRadioButton("Matkomlan");
        rbProbstat = new JRadioButton("Probstat");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbPemlan);
        bg.add(rbASD);
        bg.add(rbMatkomlan);
        bg.add(rbProbstat);

        panelRadio.add(rbASD);
        panelRadio.add(rbPemlan);
        panelRadio.add(rbMatkomlan);
        panelRadio.add(rbProbstat);

        panel.add(panelRadio);

        JPanel panelInput = new JPanel(new GridLayout(5, 2, 5, 5));

        panelInput.add(new JLabel("Tugas :"));
        tTugas = new JTextField("70");
        panelInput.add(tTugas);

        panelInput.add(new JLabel("Kuis :"));
        tKuis = new JTextField("80");
        panelInput.add(tKuis);

        panelInput.add(new JLabel("UTS :"));
        tUTS = new JTextField("90");
        panelInput.add(tUTS);

        panelInput.add(new JLabel("UAS :"));
        tUAS = new JTextField("80");
        panelInput.add(tUAS);

        panelInput.add(new JLabel("Hasil :"));
        tHasil = new JTextField();
        tHasil.setEditable(false);
        panelInput.add(tHasil);

        panel.add(panelInput);

        JPanel panelButton = new JPanel();
        btnHitung = new JButton("Hitung");
        btnTampil = new JButton("Tampilkan nilai semua matkul");

        panelButton.add(btnHitung);
        panelButton.add(btnTampil);

        panel.add(panelButton);

        area = new JTextArea(8, 40);
        area.setBorder(BorderFactory.createTitledBorder("HASIL NILAI SEMUA MATA KULIAH"));
        panel.add(new JScrollPane(area));

        add(panel);

        btnHitung.addActionListener(this);
        btnTampil.addActionListener(this);

        // Clear field saat ganti matkul
        ActionListener clear = e -> {
            tTugas.setText("");
            tKuis.setText("");
            tUTS.setText("");
            tUAS.setText("");
            tHasil.setText("");
        };

        rbPemlan.addActionListener(clear);
        rbASD.addActionListener(clear);
        rbMatkomlan.addActionListener(clear);
        rbProbstat.addActionListener(clear);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double t = Double.parseDouble(tTugas.getText());
            double k = Double.parseDouble(tKuis.getText());
            double u = Double.parseDouble(tUTS.getText());
            double ua = Double.parseDouble(tUAS.getText());

            MataKuliah mk = null;

            if (rbPemlan.isSelected()) mk = new Pemlan(t,k,u,ua);
            else if (rbASD.isSelected()) mk = new ASD(t,k,u,ua);
            else if (rbMatkomlan.isSelected()) mk = new Matkomlan(t,k,u,ua);
            else if (rbProbstat.isSelected()) mk = new Probstat(t,k,u,ua);

            if (e.getSource() == btnHitung) {
                double hasil = mk.hitungNilai();
                tHasil.setText(String.format("%.1f", hasil));

                if (rbPemlan.isSelected()) nilaiPemlan = hasil;
                else if (rbASD.isSelected()) nilaiASD = hasil;
                else if (rbMatkomlan.isSelected()) nilaiMatkomlan = hasil;
                else if (rbProbstat.isSelected()) nilaiProbstat = hasil;
            }

            if (e.getSource() == btnTampil) {
                String text = "";

                if (nilaiPemlan != null)
                    text += String.format("Pemlan      : %.1f\n", nilaiPemlan);
                if (nilaiASD != null)
                    text += String.format("ASD         : %.1f\n", nilaiASD);
                if (nilaiMatkomlan != null)
                    text += String.format("Matkomlan   : %.1f\n", nilaiMatkomlan);
                if (nilaiProbstat != null)
                    text += String.format("Probstat    : %.1f\n", nilaiProbstat);

                area.setText(text);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Input harus angka!");
        }
    }

    public static void main(String[] args) {
        new NilaiGUI().setVisible(true);
    }
}