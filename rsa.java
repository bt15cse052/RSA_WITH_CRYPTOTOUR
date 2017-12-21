
package javaapplication5;
import java.math.BigInteger;
public class rsa {
 BigInteger[][] matA=new BigInteger[8][8];   
public BigInteger encryption(BigInteger e,BigInteger m,BigInteger n)
{
    return m.modPow(e, n);
}
public BigInteger inverese(BigInteger e,BigInteger n)
{
   return e.modInverse(n);
}
public BigInteger decryption(BigInteger d,BigInteger c,BigInteger n){
    return c.modPow(d,n);
}
public int gcd(int a,int b){
    if(b==0)
        return a;
    int r=a%b;
    return gcd(b,r);
}
}