//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] m)
    {
        // Code here 
        int now = Integer.MAX_VALUE;
        //
        
        int n=m.length;
        // for(int i=0;i<m.length;i++){
        //     for(int j=0;j<n;j++){
        //         if(m[i][j]==-1)m[i][j] = now;       
        //     }
        // }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    
                    if(i==k || j==k || m[i][k]==-1 || m[k][j]==-1)continue;
                    int p1 = m[i][j]==-1?now:m[i][j];
                    int p2 = m[i][k]+m[k][j];
                    m[i][j]=Math.min(p1,p2);
                    
                }
            }
        }
        
        // for(int i=0;i<m.length;i++){
        //     for(int j=0;j<n;j++){
        //         if(m[i][j]==now)m[i][j] = -1;       
        //     }
        // }
    }
}