import java.util.*;
public class KMP_algorithm
{
   void kmpSearch(String pat,String txt)
    {
        int M=pat.length();
        int N=txt.length();
        int lps[]=new int[M];
        int j=0,i=0;
        boolean flag=true;
        computeLPS(pat,M,lps);
        while(i<N)
        {    
            if(pat.charAt(j)==txt.charAt(i))
             {
                i++;
                j++;
             }
            if(j==M)
            {
                flag=false;
                System.out.println("Found at "+(i-j));
                j=lps[j-1];
            }        
            else if(i<N&&pat.charAt(j)!=txt.charAt(i))
            {
                if(j!=0)
                j=lps[j-1];
                else
                i++;
            }
        }
        if(flag)
        System.out.println("Pattern not found");
    }

    
    void computeLPS(String pat,int M,int lps[])
    {
        int len=0;
        int i=1;
        lps[0]=0;
        while(i<M)
        {
            if(pat.charAt(i)==pat.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len=lps[len-1];
                }
                else
                {
                    lps[i]=len;
                    i++;
                }
            }
        }
    }

    public static void main(String [ ]args)
    {
       Scanner sc=new Scanner(System.in);
        String txt=sc.next();
        String pat=sc.next();
        // String txt = "ABABDABACDABABCABAB"; 
        // String pat = "ABABCABAB"; 
       sc.close();
      new KMP_algorithm().kmpSearch(pat, txt);
    }
}