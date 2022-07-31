class NumArray {
    
    static int bit[];
    int nums[];
    int n;
    
    public NumArray(int[] nums) {
        n=nums.length;
        bit = new int[n+1];
        
        this.nums=nums;
        // construct btree
        // tree starts from index 1
        for(int i=1;i<=n;i++){
            bit[i]=0;
        }
        
        for(int i=0;i<n;i++){
            init(i,nums[i]);
        }
    }
    
    private void init(int index, int val){
        // index starts from 1
        index+=1;
        while(index<=n){
            bit[index] +=val;
            int raisedBy= index&(-index); // add the lsb , 
            /*
            index = 1010 -> raised by 0010
            */
            index += raisedBy;
        }// ignore 
    }
    
    public void update(int index, int val) {
        int diff = val-nums[index];// we need to add this diff only
        nums[index]=val;
        init(index,diff);
    }
    
    public int sumRange(int left, int right) {
        return pointSum(right)-pointSum(left-1);
    }
    
    private int pointSum(int index){
        int sum=0;
        index++;
        while(index>0){
            sum+=bit[index];
            index-=index&(-index);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */