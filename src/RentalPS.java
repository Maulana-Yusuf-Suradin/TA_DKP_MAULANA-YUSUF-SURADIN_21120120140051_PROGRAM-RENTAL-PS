import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Secara otomatis terinput ketika membuat form dan begiannya
public class RentalPS {
    private JTextField textNamaPenyewa;
    private JTextField textEmailPenyewa;
    private JTextField textPilihanPlaystation;
    private JTextField textLamaPenyewaan;
    private JButton prosesButton;
    private JButton hapusDataButton;
    private JTextField textNama;
    private JTextField textHargaSewa;
    private JTextField textTotalBayar;
    private JComboBox<String> comboTanggal;
    private JComboBox<String> comboBulan;
    private JTextField textTerimaKasih;
    private JLabel LabelNamaPenyewa;
    private JLabel LabelEmailPenyewa;
    private JLabel LabelPilihanPlaystation;
    private JLabel LabelLamaPenyewaan;
    private JLabel LabelNama;
    private JLabel LabelHargaSewa;
    private JLabel LabelTotalBayar;
    private JLabel LabelWaktuPemesanan;
    private JPanel panel;
    private JTextField textJamPemesanan;
    private JLabel LabelJamPemesanan;
    private JButton keluarButton;
    private JLabel RentalPS;
    private JTextField textAlamat;
    private JFrame frame;
    private JTextArea textArea1;
    private JButton submitButton;

//Syntax untuk memanggil Form RentalPS agar bisa bekerja
    public static void main(String[] args) {
        JFrame frame = new JFrame("RentalPS");
        frame.setContentPane(new RentalPS().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

//Syntax untuk tombol Proses
    public RentalPS() {
        prosesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = String.valueOf(textNamaPenyewa.getText());
                int tarif;
                String email = String.valueOf(textEmailPenyewa.getText());
                Float PilihanPlaystation = Float.parseFloat(textPilihanPlaystation.getText());
                Float LamaPenyewaan = Float.parseFloat(textLamaPenyewaan.getText());
                textNama.setText("" + nama);

//Syntax untuk memilih jenis Playstation
                if (PilihanPlaystation == 1) {
                    textPilihanPlaystation.setText("Playstation 3");
                    textHargaSewa.setText("Rp 4000/jam");
                    tarif = (int) (4000 * LamaPenyewaan);
                    textTotalBayar.setText("Rp " + tarif);
                } else if (PilihanPlaystation == 2) {
                    textPilihanPlaystation.setText("Playstation 4");
                    textHargaSewa.setText("Rp 6000/jam");
                    tarif = (int) (6000 * LamaPenyewaan);
                    textTotalBayar.setText("Rp " + tarif);
                } else if (PilihanPlaystation == 3) {
                    textPilihanPlaystation.setText("Playstation 5");
                    textHargaSewa.setText("Rp 9000/jam");
                    tarif = (int) (9000 * LamaPenyewaan);
                    textTotalBayar.setText("Rp " + tarif);
                }

//Syntax untuk combobox pilihan tanggal dan bulan
                for (int i = 1; i <= 31; i++) {
                    comboTanggal.addItem("" + i);
                }
                for (int i = 1; i <= 12; i++) {
                    comboBulan.addItem("" + i);
                }
            }
        });

//Syntax untuk tombol hapus seluruh data
        hapusDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNama.setText("");
                textNamaPenyewa.setText("");
                textEmailPenyewa.setText("");
                textPilihanPlaystation.setText("");
                textJamPemesanan.setText("");
                textLamaPenyewaan.setText("");
                comboTanggal.setSelectedIndex(0);
                comboBulan.setSelectedIndex(0);
                textHargaSewa.setText("");
                textTotalBayar.setText("");
                textAlamat.setText("");
                textTerimaKasih.setText("");
                textArea1.setText("");
            }
        });

//Syntax untuk tombol Keluar
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Syntax untuk tombol Submit
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(
                        "\nNama Penyewa \t= "+textNamaPenyewa.getText()+
                        "\n Alamat Rumah \t= "+textAlamat.getText()+
                        "\n Email Penyewa \t= "+textEmailPenyewa.getText()+
                        "\n Pilihan Playstation \t= "+textPilihanPlaystation.getText()+
                        "\n Lama Penyewaan \t= "+textLamaPenyewaan.getText()+
                        "\n Tanggal \t                             ="+comboTanggal.getSelectedItem()+
                        "\n Bulan \t                             = "+comboBulan.getSelectedItem()+
                        "\n Jam Pemesanan \t= "+textJamPemesanan.getText()+
                        "\n Harga Sewa \t                             = "+textHargaSewa.getText()+
                        "\n Total Bayar \t                             = "+textTotalBayar.getText()
                );
                textTerimaKasih.setText("Terimakasih telah memesan, untuk informasi lebih lanjut akan kami hubungi melalui "+textEmailPenyewa.getText());
            }
        });
    }
}