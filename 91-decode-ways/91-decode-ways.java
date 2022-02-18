class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        int ans = s.length()==0?0:decode(0,s,dp);
        return ans;    
    }
    
    private int decode(int i, String s, Integer dp[]){
        int n=s.length();
        if(i==n)return 1;
        if(s.charAt(i)=='0')return 0;
        if(dp[i]!=null)return dp[i];
        int res = decode(i+1,s,dp);
        if(i<n-1 && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<'7')){
            res+=decode(i+2,s,dp);
        }
        return dp[i]=res;
    }
}