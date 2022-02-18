class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n<=2)return 0; // no water between two slabs
        int water=0;
        
        int left[] =new int[n], right[] = new int[n];
        left[0] = Integer.MIN_VALUE;
        
        for(int i=1;i<n-1;i++){
            left[i] = Math.max(left[i-1],height[i-1]); // largest bar to the left
        }
        right[n-1]  = Integer.MIN_VALUE;
        for(int i=n-2;i >=0;i--){
            right[i] = Math.max(right[i+1], height[i+1]); // dont take its own height
        }
        for(int i=0;i<n;i++){
            if(Integer.min(left[i], right[i]) > height[i]){
                water += Integer.min(left[i],right[i])- height[i];
            }
        }
        return water;
    }
}