class Solution {
    public boolean find132pattern(int[] nums) {
        int mid = Integer.MIN_VALUE;
        Stack<Integer> s3 = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<mid)return true;
            else{
                while(!s3.isEmpty() && s3.peek()<nums[i]){
                        mid = s3.pop();
                }
            }
            s3.push(nums[i]);
        }
        return false;
    }
}