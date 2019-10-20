import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class messageFrame extends JDialog implements ActionListener {
    private JLabel messageText;
    private JButton okAndExitButton;
    private JPanel panel;

    messageFrame(String message,int x, int y){
        setSize(210, 50);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(x,y);
        setLayout(null);
        setUndecorated(true);
        setAlwaysOnTop(true);

        setModalityType(ModalityType.APPLICATION_MODAL);

        messageText = new JLabel(message,JLabel.CENTER);
        messageText.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        messageText.setBounds(0,10,200,20);
        messageText.setOpaque(true);

        okAndExitButton = new JButton();
        okAndExitButton.setText("OK");
        okAndExitButton.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        okAndExitButton.setBounds(0,30,210,20);
        okAndExitButton.setForeground(Color.LIGHT_GRAY);
        okAndExitButton.setBackground(new Color(114,133,165));
        okAndExitButton.setToolTipText("<html> <p style=\"font-size:7px;\">"+"potrzebne dane:"+"<br>"+ "-hasło"+"<br>"+"-tekst do zaszyfrowania"+"</p></html>");

        add(messageText);
        add(okAndExitButton);
        //add(panel);

        okAndExitButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o==okAndExitButton){
            this.dispose();
        }
    }
}
