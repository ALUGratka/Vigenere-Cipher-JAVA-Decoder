import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.undo.StateEditable;
import java.awt.*;
import java.awt.event.*;

public class mainFrame extends JFrame implements ActionListener, CaretListener, MouseListener {
    private JLabel exit;
    private JPanel panel;
    private JLabel passwordText;
    private JTextField haslo;
    private JTextArea tekst;
    private JButton cipherButton;
    private JButton encipherButton;
    private JTextPane wynik;
    private VigenereCipher vigenereCipher;


    private mainFrame() {
        vigenereCipher = new VigenereCipher();
        setSize(304,370);
        setTitle("Szyfromachina");
        setLayout(null);
        setUndecorated(true);


        passwordText = new JLabel("HASŁO:");
        passwordText.setBounds(0,12,40,20);
        passwordText.setOpaque(true);
        passwordText.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        passwordText.setForeground(new Color(76,81,109));


        exit = new JLabel("X");
        exit.setBounds(296,0,10,10);
        exit.setOpaque(true);
        exit.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        exit.setForeground(new Color(76,81,109));


        panel = new MotionPanel(this);
        panel.setBounds(0, 2, 500, 50);


        haslo = new JTextField();
        haslo.setToolTipText("<html> <p style=\"font-size:7px;\">"+"podaj hasło"+"</p></html>");
        haslo.setBounds(40,12,264,20);
        haslo.setBorder(new MatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));
        haslo.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        haslo.setForeground(new Color(76,81,109));

        tekst = new JTextArea();
        tekst.setBounds(0,40,304,200);
        tekst.setLineWrap(true);
        tekst.setFont(new Font(Font.DIALOG,Font.BOLD,10));


        cipherButton = new JButton("SZYFRUJ");
        encipherButton = new JButton("ODSZYFRUJ");
        cipherButton.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        cipherButton.setForeground(Color.LIGHT_GRAY);
        cipherButton.setBackground(new Color(114,133,165));
        cipherButton.setBounds(0,250,150,20);
        encipherButton.setBounds(150,250,155,20);
        encipherButton.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        encipherButton.setForeground(Color.LIGHT_GRAY);
        encipherButton.setBackground(new Color(76,81,109));

        wynik = new JTextPane();
        wynik.setBounds(0,270,304,100);
        wynik.setOpaque(true);
        wynik.setBackground(new Color(114,133,165));
        wynik.setEditable(false);
        wynik.setFont(new Font(Font.DIALOG,Font.BOLD,10));

        add(exit);
        add(passwordText);


        add(haslo);
        add(tekst);
        add(cipherButton);
        add(encipherButton);
        add(wynik);
        add(panel);

        exit.addMouseListener(this);

        haslo.addCaretListener(this);
        tekst.addCaretListener(this);
        cipherButton.addActionListener(this);
        encipherButton.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        mainFrame mainFrame = new mainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        wynik.setText("");
        Object o = e.getSource();
        try {
            if (o == cipherButton) {
                wynik.setText(vigenereCipher.enctyption());
                cipherButton.setBackground(new Color(114,133,165));
                encipherButton.setBackground(new Color(76,81,109));
            } else if (o == encipherButton) {
                wynik.setText(vigenereCipher.decription());
                encipherButton.setBackground(new Color(114,133,165));
                cipherButton.setBackground(new Color(76,81,109));
            }

        }catch (Exception exception){
            new messageFrame("Podaj potrzebne dane!",getLocation().x+50,getLocation().y+100);
        }
    }


    @Override
    public void caretUpdate(CaretEvent e) {
        Object o = e.getSource();
        setEnabled(true);
        if(o == haslo){
            vigenereCipher.setPassword(haslo.getText());
            System.out.println(haslo.getText());
        }
        else if(o==tekst){
            vigenereCipher.setInputText(tekst.getText());
            System.out.println(tekst.getText());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

