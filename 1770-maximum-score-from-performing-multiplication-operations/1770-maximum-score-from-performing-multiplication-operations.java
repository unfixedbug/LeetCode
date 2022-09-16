class Solution {
    int dp[][];
    
    public int maximumScore(int[] nums, int[] mul) {
        int n=nums.length;
        int m=mul.length;
        
        int dp[][] = new int[m+1][m+1];
        
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],0);
        }
        
        for(int op=m-1;op>=0;op--){
            for(int left=op;left>=0;left--){
                int l=  mul[op]*nums[left] + dp[op+1][left+1];
                int r = mul[op]*nums[n-1-(op-left)] + dp[op+1][left];
                dp[op][left]  = Math.max(l,r);
            }
        }
        return dp[0][0];
    }
    
    // TLE
     public int maximumScore1(int[] nums, int[] mul) {
        dp = new int[nums.length][mul.length];
        return dynamicP(0,nums.length-1,0,nums,mul);  
     }
    
    private int dynamicP(int l,int r,int cur,int nums[],int mul[]){
        
        if(cur==mul.length)return 0;
        
        // if already calC
        if(dp[cur][l]!=0)return dp[cur][l];
        //pickup from left
        int left = nums[l]*mul[cur] + dynamicP(l+1,r,cur+1,nums,mul);
        // pickup from right
        int right = nums[r]*mul[cur] + dynamicP(l,r-1,cur+1,nums,mul);
        return dp[cur][l] = Math.max(left,right);
    }
    
    
    //maximumScore2 gives TLE
    public int not_for_use(int[] nums, int[] mul) {
        // dp = new int[mul.length];
        return dfs(0,nums.length-1,0,nums,mul);
       
    }
    
    // i is the current index,and cur be the current ans
    private int dfs(int l,int r,int cur,int[]nums, int mul[]){
        if(cur==mul.length)return 0;
        //pickup from left
        int left = nums[l]*mul[cur] + dfs(l+1,r,cur+1,nums,mul);
        // pickup from right
        int right = nums[r]*mul[cur] + dfs(l,r-1,cur+1,nums,mul);
        
        return Math.max(left,right);
    }
}