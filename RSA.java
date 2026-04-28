import java.math.BigInteger;
import java.security.SecureRandom;
public class RSA
{
private BigInteger p,q,n,phi,e,d;
private int bitLength=1024;
private SecureRandom random=new SecureRandom();
public RSA()
{
p=BigInteger.probablePrime(bitLength,random);
q=BigInteger.probablePrime(bitLength,random);
n=p.multiply(q);
phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
e=BigInteger.valueOf(65537);
while(!phi.gcd(e).equals(BigInteger.ONE))
{
e=e.add(BigInteger.TWO);
}
d=e.modInverse(phi);
}
public BigInteger encrypt(BigInteger message)
{
return message.modPow(e,n);
}
public BigInteger decrypt(BigInteger ciphertext)
{
return ciphertext.modPow(d,n);
}
public BigInteger getPublicKeyE()
{
return e;
}
public BigInteger getModulusN()
{
return n;
}
public static void main(String[]args)
{
RSA rsa=new RSA();
String text="HELLO";
BigInteger message=new BigInteger(text.getBytes());
System.out.println("Original Message: "+text);
BigInteger encrypted=rsa.encrypt(message);
System.out.println("Encrypted Message: "+encrypted);
BigInteger decrypted=rsa.decrypt(encrypted);
String decryptedText=new String(decrypted.toByteArray());
System.out.println("Decrypted Message: "+decryptedText);
}
}
