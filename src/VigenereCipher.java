import java.util.ArrayList;

public class VigenereCipher {
    private String password;
    private String inputText;
    private String textWitchPassword;
    private char[][] alphabetTable;
    private ArrayList<Character>signs;

    VigenereCipher(){
        alphabetTable = new char[26][26];
        char signStart = 'A';

        for(int i = 0;i<26;i++){
            char sign = signStart;
            for(int j = 0;j<26;j++){
                if(sign>90) {
                    sign='A';
                }
                alphabetTable[i][j] = sign;
                sign++;
            }
            signStart++;
        }

        signStart = 'A';
        signs = new ArrayList<>();
        for(int i = 0;i<34;i++){
            signStart--;
            signs.add(signStart);
        }

    }

    public void printAlhpabet(){
        for(int i = 0;i<alphabetTable.length;i++){
            for(int j = 0;j<alphabetTable.length;j++){
                System.out.print(alphabetTable[i][j]);
            }
            System.out.println();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.toUpperCase().replaceAll("\\s+","");
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText.toUpperCase();
    }

    private void setTextWitchPassword(){
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

        this.textWitchPassword = textWithPassword.toString();
    }

    public String getTextWitchPassword(){
        return this.textWitchPassword;
    }

    private boolean betwene(char a, char b, char c){
        Character A = a;
        Character B = b;
        Character C = c;
        if(A.compareTo(B)==0&&A.compareTo(C)==1) return true;
        return false;
    }

    private String formatTextIntoSentance(String text){
        String newText = text.substring(0,1).toUpperCase()+text.substring(1).toLowerCase();
        return newText;
    }

    public String enctyption(){
        textWitchPassword = new String();
        setTextWitchPassword();

        StringBuilder encryptedText = new StringBuilder(textWitchPassword);
        for(int i = 0;i<textWitchPassword.length();i++){
            if(signs.contains(textWitchPassword.charAt(i))){
                char sign = inputText.charAt(i);
                encryptedText.setCharAt(i,sign);
            }
            else{
                encryptedText.setCharAt(i,alphabetTable[(inputText.charAt(i)-65)][textWitchPassword.charAt(i)-65]);
            }
        }
        return formatTextIntoSentance(encryptedText.toString());
    }

    public String decription(){
        StringBuilder decriptedText = new StringBuilder(textWitchPassword);
        System.out.println(decriptedText);
        for(int i = 0;i<textWitchPassword.length();i++){
            if(signs.contains(textWitchPassword.charAt(i))){
                char sign = inputText.charAt(i);
                decriptedText.setCharAt(i,sign);
            }
            else{
                decriptedText.setCharAt(i,alphabetTable[textWitchPassword.charAt(i)-65][0]);
            }
        }
        String edite;
        return decriptedText.toString();
    }


}

