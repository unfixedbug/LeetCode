class Solution {
    
//     recursive solution BFS
    public boolean canReach(int []arr, int start){
        if(start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        } 
        if (arr[start] == 0) {
            return true;
        }
        arr[start] = -arr[start];
        
        return canReach(arr, start - arr[start]) || canReach(arr, start + arr[start]);
    }
    
    
    
    public boolean canReachIterative(int[] arr, int start) {
        
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