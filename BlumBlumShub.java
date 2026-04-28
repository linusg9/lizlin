import java.math.BigInteger;
import java.security.SecureRandom;
public class BlumBlumShub
{
private BigInteger p,q,M,seed;
public BlumBlumShub(int bitLength)
{
SecureRandom random=new SecureRandom();
do
{
p=BigInteger.probablePrime(bitLength,random);
}
while(!p.mod(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3)));
do
{
q=BigInteger.probablePrime(bitLength,random);
}
while(!q.mod(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3)));
M=p.multiply(q);
do
{
seed=new BigInteger(bitLength*2,random);
}
while(!seed.gcd(M).equals(BigInteger.ONE));
}
public int nextBit()
{
seed=seed.modPow(BigInteger.valueOf(2),M);
return seed.mod(BigInteger.valueOf(2)).intValue();
}
public BigInteger nextNumber(int bits)
{
BigInteger result=BigInteger.ZERO;
for(int i=0;i<bits;i++)
{
result=result.shiftLeft(1);
result=result.or(BigInteger.valueOf(nextBit()));
}
return result;
}
public static void main(String[]args)
{
BlumBlumShub bbs=new BlumBlumShub(64);
System.out.println("Generated Random Bits:");
for(int i=0;i<20;i++)
{
System.out.print(bbs.nextBit()+" ");
}
System.out.println("\n\nGenerated Random Number (16 bits):");
System.out.println(bbs.nextNumber(16));
}
}
