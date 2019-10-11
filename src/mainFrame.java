import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame implements ActionListener, CaretListener{
    private JTextField haslo;
    private JTextField tekst;
    private JComboBox wyborAkcji;
    private JButton cipherButton;
    private JButton encipherButton;
    private JTextPane wynik;
    VigenereCipher vigenereCipher;

    public mainFrame() {
        vigenereCipher = new VigenereCipher();
        setSize(320,450);
        setTitle("Szyfromachina");
        setLayout(null);

        haslo = new JTextField();
        haslo.setBounds(100,10,100,20);

        tekst = new JTextField();
        tekst.setBounds(50,40,200,200);


        cipherButton = new JButton("SZYFRUJ");
        encipherButton = new JButton("ODSZYFRUJ");
        cipherButton.setBounds(50,250,100,20);
        encipherButton.setBounds(150,250,100,20);



        /*wyborAkcji = new JComboBox();
        wyborAkcji.addItem("szyfruj");
        wyborAkcji.addItem("odszyfruj");
        wyborAkcji.setBounds(100,250,100,20);
        wyborAkcji.setSelectedIndex(0);*/

        wynik = new JTextPane();
        wynik.setBounds(50,280,200,100);
        wynik.setOpaque(true);
        wynik.setBackground(Color.WHITE);
        wynik.setEditable(false);


        add(haslo);
        add(tekst);
        add(cipherButton);
        add(encipherButton);
        add(wynik);

        haslo.addCaretListener(this);
        tekst.addCaretListener(this);
        cipherButton.addActionListener(this);
        encipherButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        mainFrame mainFrame = new mainFrame();
        System.out.println(mainFrame.vigenereCipher.getPassword());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        try {
            if (o == cipherButton) {
                wynik.setText(vigenereCipher.enctyption());
            } else if (o == encipherButton) {
                wynik.setText("odszyfrowujemy");
            }

        }catch (Exception exception){
            System.out.println("Podaj dana");
        }

    }


    @Override
    public void caretUpdate(CaretEvent e) {
        Object o = e.getSource();
        if(o == haslo){
            vigenereCipher.setPassword(haslo.getText());
            System.out.println(haslo.getText());
        }
        else if(o==tekst){
            vigenereCipher.setInputText(tekst.getText());
            System.out.println(tekst.getText());
        }
    }

}
