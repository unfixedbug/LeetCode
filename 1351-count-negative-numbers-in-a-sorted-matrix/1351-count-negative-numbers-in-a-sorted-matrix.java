class Solution {
    public int countNegatives(int[][] grid) {
        int s=0;
        int m = grid[0].length;
        for(int a[]:grid){
            s += (m-index(a,m));
        }
        return s;
    }
    
    private int index(int arr[], int n){
        int l = 0;
        int r = n-1;
        
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]<0){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
}