class Solution {
    public void sortColors(int[] nums) {
    int low=0,high=nums.length-1,mid=0;
        
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
            }else if(nums[mid]==2){
                swap(nums,mid,high);
                high--;
                mid--;
            }
            
            mid++;
        }
    }
    
    static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}