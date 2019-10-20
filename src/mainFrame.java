import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class mainFrame extends JFrame implements ActionListener, CaretListener, MouseListener {
    private JLabel exit;
    private JPanel panel;
    private JLabel passwordText;
    private JScrollPane sp;
    private JScrollPane sp2;
    private JTextField haslo;
    private JButton passwordOKButton;
    private  JButton enterDataFromFileButton;
    private JTextArea tekst;
    private JButton cipherButton;
    private JButton encipherButton;
    private JButton clearFieldsButton;
    private JButton saveToFileButton;
    private JTextPane wynik;
    private VigenereCipher vigenereCipher;
    private PickAFile pickAFile;


    private mainFrame() throws IOException {
        vigenereCipher = new VigenereCipher();
        setSize(408,640);
        setTitle("Szyfromachina");
        setLayout(null);
        setUndecorated(true);
        pickAFile = new PickAFile();


        passwordText = new JLabel("HASŁO:");
        passwordText.setBounds(0,12,40,20);
        passwordText.setOpaque(true);
        passwordText.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        passwordText.setForeground(new Color(76,81,109));


        exit = new JLabel("X");
        exit.setBounds(396,0,10,10);
        exit.setOpaque(true);
        exit.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        exit.setForeground(new Color(76,81,109));


        panel = new MotionPanel(this);
        panel.setBounds(0, 2, 500, 50);


        haslo = new JTextField();
        haslo.setToolTipText("<html> <p style=\"font-size:7px;\">"+"podaj hasło"+"</p></html>");
        haslo.setBounds(40,12,200,20);
        haslo.setBorder(new MatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));
        haslo.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        haslo.setForeground(new Color(76,81,109));

        passwordOKButton = new JButton("OK");
        passwordOKButton.setBounds(253,12,50,20);
        passwordOKButton.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        passwordOKButton.setBackground(new Color(114,133,165));
        passwordOKButton.setForeground(Color.LIGHT_GRAY);

        enterDataFromFileButton = new JButton("WCZYTAJ");
        enterDataFromFileButton.setBounds(313,12,85,20);
        enterDataFromFileButton.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        enterDataFromFileButton.setBackground(new Color(114,133,165));
        enterDataFromFileButton.setForeground(Color.LIGHT_GRAY);


        tekst = new JTextArea();
        tekst.setBounds(0,40,398,270);
        tekst.setLineWrap(true);
        tekst.setFont(new Font(Font.DIALOG,Font.BOLD,10));


        cipherButton = new JButton("SZYFRUJ");
        encipherButton = new JButton("ODSZYFRUJ");
        cipherButton.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        cipherButton.setForeground(Color.LIGHT_GRAY);
        cipherButton.setBackground(new Color(114,133,165));
        cipherButton.setBounds(0,320,204,20);
        encipherButton.setBounds(204,320,204,20);
        encipherButton.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        encipherButton.setForeground(Color.LIGHT_GRAY);
        encipherButton.setBackground(new Color(76,81,109));

        wynik = new JTextPane();
        wynik.setBounds(0,340,408,360);
        wynik.setOpaque(true);
        wynik.setBackground(new Color(114,133,165));
        wynik.setEditable(false);
        wynik.setFont(new Font(Font.DIALOG,Font.BOLD,10));

        sp = new JScrollPane(tekst,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBounds(0,40,408,270);
        sp.setBorder(null);

        sp2 = new JScrollPane(wynik,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp2.setBounds(0,340,408,276);
        sp2.setBorder(null);
        sp2.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        sp2.getViewport().getView().setBackground(new Color(114,133,165));

        clearFieldsButton = new JButton("WYCZYŚĆ POLA");
        clearFieldsButton.setBounds(0,615,204,20);
        clearFieldsButton.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        clearFieldsButton.setBackground(new Color(76,81,109));
        clearFieldsButton.setForeground(Color.LIGHT_GRAY);

        saveToFileButton = new JButton("ZAPISZ");
        saveToFileButton.setBounds(204,615,204,20);
        saveToFileButton.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        saveToFileButton.setBackground(new Color(76,81,109));
        saveToFileButton.setForeground(Color.LIGHT_GRAY);



        add(exit);
        add(passwordText);



        add(haslo);
        add(passwordOKButton);
        add(enterDataFromFileButton);
        add(sp);
        add(sp2);
        add(cipherButton);
        add(encipherButton);
        add(clearFieldsButton);
        add(saveToFileButton);
        add(panel);



        exit.addMouseListener(this);

        haslo.addCaretListener(this);
        tekst.addCaretListener(this);
        passwordOKButton.addActionListener(this);
        enterDataFromFileButton.addActionListener(this);
        cipherButton.addActionListener(this);
        encipherButton.addActionListener(this);
        clearFieldsButton.addActionListener(this);
        saveToFileButton.addActionListener(this);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) throws IOException {
        mainFrame mainFrame = new mainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        wynik.setText("");
        Object o = e.getSource();
        try {
            if(o == passwordOKButton){
                vigenereCipher.setPassword(haslo.getText());
                System.out.println(haslo.getText());
                haslo.setText("");
            }
            else if(o == enterDataFromFileButton){
                pickAFile.selectFile(vigenereCipher);
                haslo.setText("");
                tekst.setText(vigenereCipher.getInputText());
                //tekst.setEditable(false);
            }
            else if (o == cipherButton) {
                wynik.setText(vigenereCipher.enctyption());
                cipherButton.setBackground(new Color(114,133,165));
                encipherButton.setBackground(new Color(76,81,109));
                tekst.setEditable(true);

            } else if (o == encipherButton) {
                wynik.setText(vigenereCipher.decription());
                encipherButton.setBackground(new Color(114,133,165));
                cipherButton.setBackground(new Color(76,81,109));
                tekst.setEditable(true);
            }
            else if(o == clearFieldsButton){
                haslo.setText("");
                tekst.setText("");
                wynik.setText("");
                vigenereCipher.setPassword("");
            }
            else if(o == saveToFileButton){
                vigenereCipher.saveToFile();
            }

        } catch (NoSuchFileException e2){
            new messageFrame("Nie ma takiego pliku.",getLocation().x+50,getLocation().y+100);
        } catch (Exception exception){
            new messageFrame("Podaj potrzebne dane!",getLocation().x+50,getLocation().y+100);
        }
    }


    @Override
    public void caretUpdate(CaretEvent e) {
        Object o = e.getSource();
        setEnabled(true);
       /* if(o == haslo){
            vigenereCipher.setPassword(haslo.getText());
            System.out.println(haslo.getText());
        }*/
        if(o==tekst){
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

