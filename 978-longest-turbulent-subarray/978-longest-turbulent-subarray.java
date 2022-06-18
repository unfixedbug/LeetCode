class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        if(arr.length<2)return 1;
        int start=0;
        int end=0;
        int mx=1;
        while(start+1 < arr.length){
            
            if(arr[start]==arr[start+1]){
                start++; //cant take this index
                continue;
            }
            end = start+1;
            while(end+1< arr.length && isTurbulent(arr,end)){
                end++;
            }
            mx = Math.max(mx,end-start+1);
            start=end;
        }
        return mx;
    }
    
    private boolean isTurbulent(int arr[], int i){
        // peak, dp, not includes the edge cases
        return (arr[i-1]<arr[i] && arr[i]>arr[i+1]) ||  (arr[i-1]>arr[i] && arr[i]<arr[i+1]);
    }
}