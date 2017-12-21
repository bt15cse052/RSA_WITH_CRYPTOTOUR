
package javaapplication5;
import java.util.*;
import java.math.BigInteger;
public class JavaApplication5 {

    public static void main(String[] args) {
    knighttour kn=new knighttour();
    BigInteger []text=new BigInteger[64];
    rsa rs=new rsa(); 
    int []text_p=new int[]{ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311};
    int []text_q=new int[]{313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719};
    BigInteger []p=new BigInteger[64];
    BigInteger []q=new BigInteger[64];
    BigInteger []phin=new BigInteger[64];//private key
    BigInteger []e=new BigInteger[64];//public key
    BigInteger []d=new BigInteger[64];//private key
    BigInteger []n=new BigInteger[64];
    BigInteger [][]t_n=new BigInteger[64][64];//public key
    BigInteger []m=new BigInteger[64];
    String str;
    Scanner sc=new Scanner(System.in);
    System.out.println("enter your text max 64 characters");
    str=sc.nextLine();
    for(int i=0;i<64;i++)
    {
        p[i]=BigInteger.valueOf(text_p[i]);
    }
    for(int i=0;i<64;i++)
    {
        q[i]=BigInteger.valueOf(text_q[i]);
    }
    for(int i=0;i<64;i++)
    {
        n[i]=p[i].multiply(q[i]);//n=p*q
    }
    for(int i=0;i<64;i++)
    {
        for(int j=0;j<64;j++)
        {
            t_n[i][j]=p[i].multiply(q[j]);//total space of n(modular value)
        }
    }
   
     for(int i=0;i<64;i++)
    {
        phin[i]=q[i].subtract(BigInteger.ONE).multiply(p[i].subtract(BigInteger.ONE));//calculatin phi of n
    }
    for(int i=0;i<64;i++)
    {
      for(int j=2;j<phin[i].intValue();j++)//choosing e (encryption key value)
      {
        if(rs.gcd(j, phin[i].intValue())==1)
          e[i]=BigInteger.valueOf(j);
      }
    }
     for(int i=0;i<64;i++)
    {
       d[i]=rs.inverese(e[i],phin[i]);//calculation decryption key values
    }
    BigInteger []message=new BigInteger[64];
    BigInteger [][]cipher=new BigInteger[64][64];
    int []msg=new int[64];
    for(int i=0;i<str.length();i++)
    {
        msg[i]=0;
    }
    for(int i=0;i<str.length();i++)
    {
        msg[i]=(int)str.charAt(i);
    }
    for(int i=0;i<64;i++)
    {
     message[i]=BigInteger.valueOf(msg[i]);
    }
 
   for(int i=0;i<64;i++)
   {
   t_n[i]=kn.k_scrambler(t_n[i], 1);//Knight's tour scrambler using private key of reciever
   } 
   for(int i=0;i<64;i++)
    {
        for(int j=0;j<64;j++)
        {
        cipher[i][j]=rs.encryption(e[i], message[i],t_n[i][j] );//encrypting using rsa
     
    }
   }
  
    BigInteger [][]copy=new BigInteger[64][64];
    copy=cipher;
    cipher=kn.B_scrambler(cipher, 0);// Knight's tour scrambler using sender's key
     
   System.out.println();
   System.out.println("encrypted text: ");
   System.out.println();
   for(int i=0;i<64;i++)
    {
      for(int j=0;j<64;j++)
      {
        System.out.print((char)cipher[i][j].intValue()+" ");
      }
      System.out.println();
    }
    
          cipher=kn.B_scrambler(cipher, 1);// Knight's tour scrambler using sender's key
    for(int i=0;i<64;i++)
   {
   cipher[i]=kn.k_scrambler(cipher[i], 3);//Knight's tour scrambler using private key of reciever
   }
          System.out.println();
    System.out.print("message :");

          for(int i=0;i<64;i++)
    {
        m[i]=rs.decryption(d[i],cipher[i][i],n[i] );//decrypting using rsa
        System.out.print((char)m[i].intValue()+" ");
    }
    
  
    }
}
