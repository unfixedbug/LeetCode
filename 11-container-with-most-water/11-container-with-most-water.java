class Solution {
    public int maxArea(int[] height) {
//         similar to rainwater trapping
        int left=0,right = height.length -1;
        int mx=0;
        while(left<right){
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            mx = Math.max(mx, w*h);
            if(height[left]<height[right])left++;
            else if(height[left] > height[right])right--;
            else{
                left++;
                right--;
            }
        }
        return mx;
    }
}