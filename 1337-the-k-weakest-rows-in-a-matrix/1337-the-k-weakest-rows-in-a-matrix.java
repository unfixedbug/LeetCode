class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->  a[0]!=b[0] ? b[0]-a[0]:b[1]-a[1]);
        int ans[]= new int[k];
        
        for(int i=0;i<mat.length;i++){
            q.offer(new int[]{ nums1(mat[i]) ,i }); //priority queue of number of ones and index
            if(q.size()>k){
                q.poll();
            }
        }
        while(k>0){
            ans[--k] = q.poll()[1]; //get the index
        }
        return ans;
        
    }
    
    
    static int nums1(int[] ar){
        int l=0,h = ar.length;
        while(l<h){
            int mid = l + (h-l)/2;
            if(ar[mid]==1){
                l = mid+1;
            }
            else{
                h = mid;
            }
        }
        return l;
    }
}