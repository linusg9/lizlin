import java.util.*;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Shift: ");
        int shift = sc.nextInt();

        String enc = "", dec = "";

        // Encryption
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                enc += (char) ((c - base + shift) % 26 + base);
            } else
                enc += c;
        }

        System.out.println("Encrypted Text: " + enc);

        // Decryption
        for (char c : enc.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                dec += (char) ((c - base - shift + 26) % 26 + base);
            } else
                dec += c;
        }

        System.out.println("Decrypted Text: " + dec);
        sc.close();
    }
}
