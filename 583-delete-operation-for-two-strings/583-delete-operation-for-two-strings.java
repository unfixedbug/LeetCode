class Solution {
    public int minDistance(String word1, String word2) {
//         starting from1
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        return word1.length() + word2.length() - 2*lcs(word1,word2,word1.length(),word2.length(),dp);
    }
    
    public int lcs(String s1, String s2, int n, int m, int[][]dp){
        if(m==0||n==0)return 0;
        if(dp[n][m]>0)return dp[n][m]; // if already computed, then return
        // if equal characters present, then decreased length
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            dp[n][m] = 1 + lcs(s1,s2,n-1,m-1,dp);
        }
        
        
        // else maximum
        else{
            dp[n][m] = Math.max(lcs(s1,s2,n-1,m,dp),lcs(s1,s2,n,m-1,dp));
        }
        return dp[n][m];
    }
}