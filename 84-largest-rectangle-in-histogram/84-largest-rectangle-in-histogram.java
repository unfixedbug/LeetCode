class Solution {
    public int largestRectangleArea(int[] heights) {
        int n =heights.length;
        int rb[] = new int[n]; // next smaller index right;
        int lb[] = new int[n]; // next samller index on left;
        
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        rb[n-1] = n; // if no smaller element in the right, declare rightboundary as the smaller element
        
        for(int i=n-2; i>=0 ; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.size()==0){
                rb[i] = n;
                
            }else{
                rb[i]=st.peek();
            }
            st.push(i);
        
        }
        st = new Stack<>();
        st.push(0);
        lb[0]=-1;
        for(int i=1; i <n ; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.size()==0){
                lb[i] = -1;
                
            }else{
                lb[i]=st.peek();
            }
            st.push(i);
        
        }
        
        
         int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
        maxArea = Math.max(maxArea, heights[i] * (rb[i] - lb[i] - 1));
    }

    return maxArea;
    }
}