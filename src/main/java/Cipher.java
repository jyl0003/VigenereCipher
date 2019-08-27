import java.util.Scanner;
public class Cipher {
    public String key;
    public int option;
    public String output;

    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        String input = "MEMORY";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter input");
        System.out.print("Input = ");
        input = scan.nextLine();
        System.out.println("\nEnter encrypt key");
        System.out.print("Key = ");
        cipher.key = scan.nextLine();
        input = input.toUpperCase();
        cipher.key = cipher.key.toUpperCase();
        System.out.print("\nDo you want to encrpyt or decrypt your input?\nEnter 1 for Encrypt or 2 for Decrypt (DEFAULT IS ENCRYPT if neither 1 or 2 are chosen):  " );
        cipher.option = scan.nextInt();
        String copy = cipher.key;
        int copy_length = copy.length();
        int i = copy_length;
        while (copy.length() < input.length()) {
            if (!Character.isLetter(copy.charAt(i-copy_length))) {

            }
            else {
                cipher.key = copy + copy.charAt(i - copy_length);
                copy = cipher.key;
            }
            i++;
        }
        if (cipher.option == 2) {
            cipher.output = cipher.decrypt(input, cipher.key);
            System.out.println("\nHere is you decrypted input: " + cipher.output);
        }
        else {
            cipher.output = cipher.encrypt(input, cipher.key);
            System.out.println("\nHere is you encrypted input: " + cipher.output);
        }


    }
    public String encrypt(String input, String key) {
        StringBuilder keys = new StringBuilder(input);
        for (int j = 0; j < input.length(); j++) {
            if (keys.charAt(j) == ' ') {
                //keys.setCharAt(j, ' ');
            }
            else {
                char c = key.charAt(j);
                char m = input.charAt(j);
                char newLetter;
                if (c+m-65 > 90) {
                    newLetter = (char) (m+c-91);
                }
                else {
                    newLetter = (char) (m+c-65);//key.charAt(c+(c-65));
                }
                //key.charAt(k) = newLetter;
                keys.setCharAt(j,newLetter);
                //k++;
            }
        }
        String in = keys.toString();
        return in;
    }
    public String decrypt(String keys, String key) {
        StringBuilder newInput = new StringBuilder(key);
        for (int j = 0; j < keys.length(); j++) {
            if (newInput.charAt(j) == ' ') {
                //newInput.setCharAt(j, ' ');
            }
            else {
                char c = key.charAt(j);
                char m = keys.charAt(j);
                char newLetter;
                if (m+65-c < 65) {
                    newLetter = (char) (m-c+91);
                }
                else {
                    newLetter = (char) (m-c+65);//key.charAt(c+(c-65));
                }
                //key.charAt(k) = newLetter;
                newInput.setCharAt(j,newLetter);
                //k++;
            }
        }
        String in = newInput.toString();
        return in;
    }
}