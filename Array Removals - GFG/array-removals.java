//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int k;
    int dp[][];
    int removals(int[] arr, int n, int k) {
        // code 
        Arrays.sort(arr);
        dp = new int[n][n];
        this.k=k;
        // int score=0;
        
        return dp[0][n-1]= helper(arr,0,n-1);
        
    }
    
    private int helper(int arr[], int st, int end){
        if(arr[end]-arr[st]<=k || st>end)return 0;
        if(dp[st][end]!=0)return dp[st][end];
        
        return dp[st][end] = 1 +  Math.min(helper(arr,st+1,end),helper(arr,st,end-1));
    }
}