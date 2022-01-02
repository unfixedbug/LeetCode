class KthLargest {
    private static int k;
    private PriorityQueue<Integer> pq;
    
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq = new PriorityQueue<>();
        for(int i:nums){
            add(i);
        }
    }
    
    public int add(int val) {
        if(pq.size()<k){
            pq.add(val);
        }
        
        else if(pq.peek()<val){
            pq.poll();
            pq.add(val);
        }
        if(pq.size()==k){
            return pq.peek();
        }
        else return -1;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */