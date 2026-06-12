import java.util.*;

public class MonoAlphabeticCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.print("Enter 26-letter Key: ");
        String key = sc.nextLine().toUpperCase();

        System.out.print("Enter Text: ");
        String text = sc.nextLine().toUpperCase();

        String enc = "", dec = "";

        // Encryption
        for (char c : text.toCharArray())
            enc += Character.isLetter(c) ? key.charAt(alpha.indexOf(c)) : c;

        System.out.println("Encrypted Text: " + enc);

        // Decryption
        for (char c : enc.toCharArray())
            dec += Character.isLetter(c) ? alpha.charAt(key.indexOf(c)) : c;

        System.out.println("Decrypted Text: " + dec);

        sc.close();
    }
}
