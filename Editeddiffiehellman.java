import java.math.BigInteger;
import java.util.*;

public class DiffieHellman {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter prime number p: ");
        BigInteger p = sc.nextBigInteger();

        System.out.print("Enter primitive root g: ");
        BigInteger g = sc.nextBigInteger();

        System.out.print("Enter Alice private key a: ");
        BigInteger a = sc.nextBigInteger();

        System.out.print("Enter Bob private key b: ");
        BigInteger b = sc.nextBigInteger();

        BigInteger A = g.modPow(a, p);
        BigInteger B = g.modPow(b, p);

        System.out.println("\nAlice Public Key: " + A);
        System.out.println("Bob Public Key: " + B);

        BigInteger k1 = B.modPow(a, p);
        BigInteger k2 = A.modPow(b, p);

        System.out.println("\nShared Key by Alice: " + k1);
        System.out.println("Shared Key by Bob: " + k2);

        if (k1.equals(k2))
            System.out.println("\nKey Exchange Successful");
        else
            System.out.println("\nKey Exchange Failed");

        sc.close();
    }
}
