class Solution {
    
    //https://www.geeksforgeeks.org/count-palindrome-sub-strings-string/ reference
    
    public int countSubstrings(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int ans=0;
        for(int gap=0; gap < s.length(); gap++){
            for(int i=0 , j=gap ; j<s.length(); i++,j++){
                if(gap==0){
                    dp[i][j]=true;
                }else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }else{

                        dp[i][j]=false;
                    }
                }else{//gap==2,3
//                     if last characters are equal and, middle from dp
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }
                if(dp[i][j]==true)ans++;
            }
        }
        return ans;
    }
}