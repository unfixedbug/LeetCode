class Solution {
    public int jump(int[] nums) {
        int currfarthest=0, currend=0,jumps=0; // farthest jump we can make, farthest end we can have
        for(int i=0 ; i< nums.length -1;i++){
            
            currfarthest = Math.max(currfarthest, i+nums[i]); // farthest we can react;
            if(i==currend){
                jumps++;
                currend = currfarthest;
            }
        }
        return jumps;
    }
}

// remember we need all longest paths