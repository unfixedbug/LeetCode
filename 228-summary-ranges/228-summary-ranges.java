class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length==1){
            ans.add(nums[0]+"");
        }
        else{
            for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            while(i+1 < nums.length && nums[i+1]-nums[i]==1){
                i++;
            }
            if(curr!=nums[i]){
                ans.add(curr+"->"+nums[i]);
            }
            else{
                ans.add(curr+"");
            }
        }}
        return ans;
    }
}