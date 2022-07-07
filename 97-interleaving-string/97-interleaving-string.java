class Solution {
    int dp[][];
    int s1l,s2l,s3l;
    public boolean isInterleave(String s1, String s2, String s3) {
        s1l = s1.length();
        s2l = s2.length();
        s3l = s3.length();
        dp = new int[s1l][s2l];
        
        if(s1l+s2l!=s3l)return false;
        for(int []a:dp){
            Arrays.fill(a,-1); // fill the array with false
        }
        
        return recur(s1,0,s2,0,s3,0);
    }
    
    private boolean recur(String s1, int i, String s2,int j, String s3, int k){
        if(i==s1l){
            // reached s1 end
            // s2 susbtring equals remaining s3
            return s2.substring(j).equals(s3.substring(k));
        }
        if(j==s2l){
            return s1.substring(i).equals(s3.substring(k));
        }
        // if already computed
        if(dp[i][j] >=0){// 3 states for -1 -> uncomputed 0-> not substring 1-> can be made
            return dp[i][j]==1?true:false;
        }
      
        dp[i][j] = ((s3.charAt(k)==s1.charAt(i) && recur(s1,i+1,s2,j,s3,k+1)) || (recur(s1,i,s2,j+1,s3,k+1)&&s3.charAt(k)==s2.charAt(j)))?1:0;
        // if true 1, else false
        
        return dp[i][j]==1?true:false;
        
    }
}