class Solution {
    public boolean validMountainArray(int[] arr) {
       int l  = arr.length;
        int now= 0;
        while(now+1<l && arr[now] < arr[now+1]){
            now++;
        }
//         if peak is first or last
        if(now==0 || now==l-1) return false;
        
        while(now+1<l && arr[now]>arr[now+1]){
            now++;
        }
//         did we reach the last elment
        return now==l-1;
    }
    
}