import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class animationFrame extends JFrame {
    private JTable alphabetTable;
    private JButton okAndExitButton;
    private  JTextField cypheredText;

    private animationFrame(VigenereCipher cipher){
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(515,630);
        //setLayout(new GridLayout(3, 1));
        setLayout(null);

        String[] columnNames = new String[32];
        char sign = 'A';
        for(int i = 0;i<32;i++){
            columnNames[i] = Character.toString(sign);
            sign++;
        }
        alphabetTable = new JTable(cipher.getAlphabetTable(),columnNames);
        alphabetTable.setTableHeader(null);
        okAndExitButton = new JButton("OK");
        okAndExitButton.setBounds(200,600,100,20);


        JScrollPane sp = new JScrollPane(alphabetTable);
        sp.setBounds(0,0,500,515);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        cypheredText = new JTextField();
        cypheredText.setBounds(50,550,400,40);
        cypheredText.setOpaque(true);

        add(sp);
        add(cypheredText);
        add(okAndExitButton);

        String polishSigns = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŻŹ";

        char[][]alphabet = new char[32][32];

        for(int i = 0;i<32;i++){
            for(int j = 0;j<32;j++){
                alphabet[i][j] = polishSigns.charAt(j);
            }
            char firsChar = polishSigns.charAt(0);
            polishSigns = polishSigns.substring(1);
            polishSigns=polishSigns+firsChar;
        }

        for(int i = 0;i<32;i++){
            for(int j = 0;j<32;j++){
                System.out.print(alphabet[i][j]);
            }
            System.out.println();
        }

        setVisible(true);
    }

    private void animation(String input, String inputWithPassword,VigenereCipher cypher){
        JTextField textBox = new JTextField();


                if (input.charAt(0) == 'W') {
                    TableColumn soprtColumn = alphabetTable.getColumnModel().getColumn(5);
                    soprtColumn.setCellRenderer(new myTableCellRenderer(1,5,Color.BLUE));
                }



    }

    public static void main(String[] args) {
        animationFrame animationFrame = new animationFrame(new VigenereCipher());
        VigenereCipher vigenereCipher = new VigenereCipher();

        vigenereCipher.setPassword("HELP");
        vigenereCipher.setInputText("WITAJ PIEKNY SWIECIE");
        vigenereCipher.enctyption();

        animationFrame.animation(vigenereCipher.getInputText(),vigenereCipher.getTextWitchPassword(),vigenereCipher);

    }

    class myTableCellRenderer implements TableCellRenderer {
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        int row, column;
        Color c;
        private myTableCellRenderer(int row, int column, Color c) {
            this.row = row;
            this.column = column;
            this.c = c;
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = dtcr.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);
            if (row == this.row && column == this.column) {
                renderer.setBackground(c);
            }
            return renderer;
        }
    }
}
