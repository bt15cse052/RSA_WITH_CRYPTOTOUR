package javaapplication5;
import java.math.BigInteger;
public class knighttour {
    private int []keys=new int[]{1,30,47,52,5,28,43,54,48,51,2,29,44,53,6,27,31,46,49,4,25,8,55,42,50,3,32,45,56,41,26,7,33,62,15,20,9,24,39,58,16,19,34,61,40,57,10,23,63,14,17,36,21,12,59,38,18,35,64,13,60,37,22,11};
    private int []keyr=new int[]{1,24,39,36,11,22,49,34,40,37,12,23,50,35,10,21,13,2,25,38,57,64,33,48,26,41,60,63,54,51,20,9,3,14,53,56,61,58,47,32,42,27,62,59,52,55,8,19,15,4,29,44,17,6,31,46,28,43,16,5,30,45,18,7};
    public BigInteger[] k_scrambler(BigInteger []text,int f)
    {
        int [] keyr_inv=new int[64];
        int [] keys_inv=new int[64];
    BigInteger [] temp_p=new BigInteger[64];
        for(int i=0;i<64;i++)
        {
          keys_inv[keys[i]-1]=i+1;  
        }
        for(int i=0;i<64;i++)
        {
          keyr_inv[keyr[i]-1]=i+1;  
        }
        if(f==0)
        for(int i=0;i<64;i++)  
        {
            temp_p[i]=text[keys[i]-1];
        }
       else if(f==1) 
        for(int i=0;i<64;i++)  
        {
            temp_p[i]=text[keyr[i]-1];
        }
       else if(f==2)
        for(int i=0;i<64;i++)  
        {
            temp_p[i]=text[keys_inv[i]-1];
        }
       else if(f==3)
        for(int i=0;i<64;i++)  
        {
            temp_p[i]=text[keyr_inv[i]-1];
        }   
    return temp_p;
      
    }
    
    public BigInteger [][] B_scrambler(BigInteger [][]text,int f)
    {
       BigInteger [][]temp_n=new BigInteger[64][64];
       int [] keyr_inv=new int[64];
       int [] keys_inv=new int[64];
        for(int i=0;i<64;i++)
        {
          keys_inv[keys[i]-1]=i+1;  
        }
        for(int i=0;i<64;i++)
        {
          keyr_inv[keyr[i]-1]=i+1;  
        }
        if(f==0)
        for(int i=0;i<64;i++)
        {
            for(int j=0;j<64;j++)
            {
                temp_n[i][j]=text[keys[i]-1][j];
            }
        }
        else if(f==1)
            for(int i=0;i<64;i++)
        {
            for(int j=0;j<64;j++)
            {
                temp_n[i][j]=text[keys_inv[i]-1][j];
            }
        }
         else if(f==2)
            for(int i=0;i<64;i++)
        {
            for(int j=0;j<64;j++)
            {
                temp_n[i][j]=text[keyr[i]-1][j];
            }
        } 
         else if(f==3)
            for(int i=0;i<64;i++)
        {
            for(int j=0;j<64;j++)
            {
                temp_n[i][j]=text[keyr_inv[i]-1][j];
            }
        }
        return temp_n;
    }
    
}
