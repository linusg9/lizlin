import java.util.*;

public class PolyalphabeticCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine().toUpperCase();

        System.out.print("Enter Key: ");
        String key = sc.nextLine().toUpperCase();

        String enc = "", dec = "";
        int k = 0;

        // Encryption
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                enc += (char) ((c - 'A' + key.charAt(k++ % key.length()) - 'A') % 26 + 'A');
            } else
                enc += c;
        }

        System.out.println("Encrypted Text: " + enc);

        k = 0;

        // Decryption
        for (char c : enc.toCharArray()) {
            if (Character.isLetter(c)) {
                dec += (char) ((c - 'A' - (key.charAt(k++ % key.length()) - 'A') + 26) % 26 + 'A');
            } else
                dec += c;
        }

        System.out.println("Decrypted Text: " + dec);
        sc.close();
    
}
