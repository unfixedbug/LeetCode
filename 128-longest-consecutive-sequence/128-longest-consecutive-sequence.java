class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums)set.add(num);
        
        
        int longest=0;
        for(int num:nums){
            // if set contains num-1, the case is already covered SI
            if(!set.contains(num-1)){
                int curnum=num;
                int currstreak=1;
                while(set.contains(curnum+1)){
                    curnum++;
                    currstreak++;
                }
                longest = Math.max(longest,currstreak);
            }
        }
        
        return longest;
    }
}