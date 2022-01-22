class Solution {
    
    public boolean stoneGame(int[] piles) {
        return true;
    }
    public boolean stoneGame2(int[] piles) {
        int n = piles.length;
        int dp[][] = new int[n+2][n+2];
//         dp[i+1][j+1] = value of the game
        for(int size = 1;size<=n;size++){
            for(int i=0; i + size <=n;i++){
                int j= i+ size-1;
                int p = (j+i+n)%2;
                
                if(p==1){
                    dp[i+1][j+1] = Math.max(piles[i]+ dp[i+2][j+1], piles[j]+dp[i+1][j]);
                    
                }
                else{
                    dp[i+1][j+1] = Math.min(-piles[i]+ dp[i+2][j+1], -piles[j] + dp[i+1][j]);
                }
            }
        }
        return dp[1][n]>0;
    
    }
}