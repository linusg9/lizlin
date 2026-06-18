import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    BigInteger p,q,n,phi,e,d;

    RSA() {
        SecureRandom r = new SecureRandom();

        p = BigInteger.probablePrime(512, r);
        q = BigInteger.probablePrime(512, r);

        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.valueOf(65537);
        d = e.modInverse(phi);
    }

    BigInteger encrypt(BigInteger m) {
        return m.modPow(e, n);
    }

    BigInteger decrypt(BigInteger c) {
        return c.modPow(d, n);
    }

    public static void main(String[] args) {

        RSA r = new RSA();

        String msg = "HELLO";
        BigInteger m = new BigInteger(msg.getBytes());

        System.out.println("Original Message: " + msg);

        BigInteger enc = r.encrypt(m);
        System.out.println("Encrypted Message: " + enc);

        BigInteger dec = r.decrypt(enc);
        System.out.println("Decrypted Message: " +
                new String(dec.toByteArray()));
    }
}
