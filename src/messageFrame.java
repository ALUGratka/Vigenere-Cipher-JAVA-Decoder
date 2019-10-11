import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class messageFrame extends JFrame implements ActionListener {
    private JLabel messageText;
    private JButton okAndExitButton;

    messageFrame(String message){
        setSize(210, 130);
        setLocation(50,50);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        messageText = new JLabel(message,JLabel.CENTER);
        messageText.setBounds(0,20,200,20);
        messageText.setOpaque(true);

        okAndExitButton = new JButton("OK");
        okAndExitButton.setBounds(50,50,100,20);
        okAndExitButton.setToolTipText("<html> <p style=\"font-size:7px;\">"+"potrzebne dane:"+"<br>"+ "-hasło"+"<br>"+"-tekst do zaszyfrowania"+"</p></html>");

        add(messageText);
        add(okAndExitButton);

        okAndExitButton.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        messageFrame messageFrame = new messageFrame("Podaj potrzebne dane");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o==okAndExitButton){
            this.dispose();
        }
    }
}
