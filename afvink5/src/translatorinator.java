import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class translatorinator extends JFrame implements ActionListener {

    static JFrame jf = new JFrame();
    static JPanel jp;
    static JLabel jl;
    static JLabel jl2;
    static JTextArea jta;
    static JTextArea jta2;
    static JButton jb;
    private static final long serialVersionUID = 1L;
    static final String[] ONE = {"A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"};
    static final String[] THREE = {"ALA", "ARG", "ASN", "ASP", "CYS", "GLN", "GLU", "GLY",
            "HIS", "ILE", "LEU", "LYS", "MET", "PHE", "PRO", "SER",
            "THR", "TRP", "TYR", "VAL"};


    public static void main(String[] args) {
        translatorinator frame = new translatorinator();
        frame.setSize(1000, 1000);
        frame.CreateGUI();
        frame.setVisible(true);
    }

    public void CreateGUI() {
        Container window = getContentPane();
        jp = new JPanel();
        jp.setLayout(new FlowLayout());
        jta = new JTextArea(3, 20);
        jta.setText(" ");
        jl = new JLabel("Input 1-Lettercode");
        jl2 = new JLabel("Input 3-Lettercode");
        jb = new JButton("Translate");
        jb.addActionListener(this);
        jta2 = new JTextArea(3, 20);
        jp.add(jl);
        jp.add(jta);
        jp.add(jb);
        jp.add(jl2);
        jp.add(jta2);
        window.add(jp);
    }

    public void actionPerformed(ActionEvent event) {
        if (jta2.getText().length() == 0) {
            String seq = jta.getText();
            String final_seq = "";
            for (int i = 0; i < seq.length(); i++) {
                String temp_aa = "" + seq.charAt(i);
                String temp_aa1 = vertaal(temp_aa);
                final_seq += temp_aa1 + "-";
            }
            jta2.setText(final_seq);
        } else {
            String seq = jta2.getText();
            String final_seq = "";
            for (int i = 0; i < seq.length(); i += 3) {
                final_seq += vertaal(seq.substring(i, i + 3));
            }
            jta.setText(final_seq);
        }
    }

    public String vertaal(String aa) {
        String translatie = "";

        for (int i = 0; i < ONE.length; i++) {
            if (ONE[i].equals(aa.toUpperCase())) {
                translatie = THREE[i];
            } else if (THREE[i].equals(aa.toUpperCase())) {
                translatie = ONE[i];
            }
        }
        return translatie;
    }
}