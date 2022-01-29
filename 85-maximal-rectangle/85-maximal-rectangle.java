class Solution {
    public int maximalRectangle(char[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                // condition for first row
                if(matrix[i][j]=='1'){
                    if(i==0){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j] +1;
                    }
                }else{
                    dp[i][j]=0;
                }
            }
            int res = maxhist(dp[i]);
            ans = Math.max(ans,res);
        }
        return ans;
    }
    
    
//     supplementry function
    public int maxhist(int[] heights){
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