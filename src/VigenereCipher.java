import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class VigenereCipher {
    private String password;
    private String inputText;
    private String textWitchPassword;
    private char[][] alphabetTable;
    private ArrayList<Character>signs;
    private String polishSigns = ("AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ");

    VigenereCipher(){
        char signStart = 'A';

        alphabetTable = new char[32][32];

        for(int i = 0;i<32;i++){
            for(int j = 0;j<32;j++){
                alphabetTable[i][j] = polishSigns.charAt(j);
            }
            char firsChar = polishSigns.charAt(0);
            polishSigns = polishSigns.substring(1);
            polishSigns+=firsChar;
        }

        char signEnd = 'A';
        signs = new ArrayList<>();
        for(int i = 0;i<65;i++){
            signEnd--;
            signs.add(signEnd);
        }

    }

    Character[][] getAlphabetTable(){
        Character[][] alphabet = new Character[32][32];
        for(int i = 0;i<32;i++){
            for(int j = 0;j<32;j++){
                alphabet[i][j] = alphabetTable[i][j];
            }
        }
        return alphabet;
    }

    public void printAlhpabet(){
        for (char[] chars : alphabetTable) {
            IntStream.range(0, alphabetTable.length).map(j -> chars[j]).forEachOrdered(System.out::print);
            System.out.println();
        }
    }

    private String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password.toUpperCase().replaceAll("\\s+","");
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText.toUpperCase();
    }

    private String setTextWitchPassword(){
        StringBuilder textWithPassword = new StringBuilder(inputText.toUpperCase());
        System.out.println(textWithPassword);
        int j = 0;
        for(int i = 0;i<inputText.length();i++){
            if(signs.contains(inputText.charAt(i))){
                char sign = inputText.charAt(i);
                textWithPassword.setCharAt(i,sign);
            }
            else{
                if(j==password.length()) j=0;
                textWithPassword.setCharAt(i,password.charAt(j));
                j++;
            }
        }

        return textWithPassword.toString();
    }

    public void readFromFile(String fileName) throws IOException {
        final String[] password = {new String()};
        setPassword(Files.lines(Paths.get(fileName)).findFirst().get());
        Files.lines(Paths.get(fileName)).forEach(x-> password[0] +=(x+"\n"));
        setInputText(password[0].substring(getPassword().length()+1));
        System.out.println(getPassword());
        System.out.println(getInputText());
    }

    public String getTextWitchPassword(){
        return this.textWitchPassword;
    }

    private String formatTextIntoSentance(String text){
        return text.substring(0,1).toUpperCase()+text.substring(1).toLowerCase();
    }

    public String enctyption(){
        textWitchPassword = setTextWitchPassword();

        StringBuilder encryptedText = new StringBuilder(textWitchPassword);
        for(int i = 0;i<textWitchPassword.length();i++){
            if(signs.contains(textWitchPassword.charAt(i))){
                char sign = inputText.charAt(i);
                encryptedText.setCharAt(i,sign);
            }
            else{
                int x = polishSigns.indexOf(inputText.charAt(i));
                int y = polishSigns.indexOf(textWitchPassword.charAt(i));
                encryptedText.setCharAt(i,alphabetTable[x][y]);
            }
        }
        return formatTextIntoSentance(encryptedText.toString());
    }

    public String decription(){
        textWitchPassword = setTextWitchPassword();

        StringBuilder decryptedText = new StringBuilder(textWitchPassword);

        for (int i = 0, j = 0; i < inputText.length(); i++) {
            int letter = polishSigns.indexOf(inputText.charAt(i));
            if(signs.contains(textWitchPassword.charAt(i))){
                char sign = inputText.charAt(i);
                decryptedText.setCharAt(i,sign);
            }
            else{
                int x = polishSigns.indexOf(textWitchPassword.charAt(i));
                decryptedText.setCharAt(i,alphabetTable[0][((letter - x + 32) % 32)]);
            }
        }
        return formatTextIntoSentance(decryptedText.toString());
    }

    private void encriptionAnimated(){

        for(int i = 0;i<32;i++){
            for(int j = 0;j<32;j++){
                System.out.print(alphabetTable[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        VigenereCipher vc = new VigenereCipher();
        vc.encriptionAnimated();
    }

}

