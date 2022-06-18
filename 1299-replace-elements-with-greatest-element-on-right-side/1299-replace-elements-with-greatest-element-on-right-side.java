class Solution {
    public int[] replaceElements(int[] arr) {
        Stack<Integer>st = new Stack<>();
        if(arr.length <2)return new int[]{-1};
        
        int ans[] = new int[arr.length];
        ans[arr.length-1]=-1;
        int mx=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<mx)ans[i]=mx;
            else{
                ans[i]=mx;
                mx = arr[i];
            }
        }
        return ans;
    }
}