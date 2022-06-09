class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length==0)return new int[]{};
        for(int i=0;i<numbers.length;i++){
            int start = i+1,end = numbers.length-1,gap = target-numbers[i];
            while(start<=end){
                int m = start + (end-start)/2;
                if(numbers[m]==gap)return new int[]{i+1,m+1};
                else if(numbers[m]>gap)end=m-1;
                else start = m+1;
            }
        }
        return new int[]{};
    }
}