/*
Time Complexity: O(n^3)
Auxiliary Space: O(n^2)
*/

import java.util.*;
public class Matrix_Chain_Multiplication_parenthesize
{
    static char name;
    static void printParenthesis(int i,int j,int n,int[][] dp)
    {
        if(i==j)
        {
            System.out.print(name++);
            return;
        }
        System.out.print('(');
        printParenthesis(i, dp[j][i], n, dp);
        printParenthesis(dp[j][i]+1, j, n, dp);
        System.out.print(')');
    }

    static int Matrix(int arr[],int n)
    {
        int dp[][]=new int [n][n];
        for(int i=1;i<n;i++)
        dp[i][i]=0;
        //l is used for chain length
        for(int l=2;l<=(n-1);l++)
        {
            for(int i=1;i<=n-l;i++)
            {
                int j=i+l-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++)
                {
                    dp[i][j]=Math.min(dp[i][j],(dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j]));
                    dp[j][i]=k;
                }
            }
        }
        name='A';
        System.out.print("Optimal Parenthesization is: "); 
        printParenthesis(1, n - 1, n, dp); 
        return dp[1][n-1];
    }
    public static void main(String [ ] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int [n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("\nOptimal Cost is :" +Matrix(arr,arr.length));
    }
}