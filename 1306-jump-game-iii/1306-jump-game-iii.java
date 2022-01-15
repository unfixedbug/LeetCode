class Solution {
    public boolean canReach(int[] arr, int start) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            if(arr[curr]<0)continue;
            if(arr[curr]==0)return true;
            
            if(curr+arr[curr] <arr.length){  //validate next index
                // add new index to be searched with
                q.add(curr+arr[curr]);
            }
            if(curr-arr[curr]>=0){
                q.add(curr-arr[curr]);
            }
            arr[curr]= -arr[curr];
        }
        return false;
    }
}