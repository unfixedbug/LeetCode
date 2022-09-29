class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int integer : arr) {
            if (k > 0) {
                minHeap.offer(integer);
                k--;
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.offer(integer);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
        
    }
}
 
/*
    private List<Integer> helper(int arr[], int k, int x, int ind){
         //if lower than min,
        List<Integer> ans = new ArrayList<>();
        if(x<arr[0]){
            for(int i=0;i<k;i++)ans.add(arr[i]);
            return ans;
        }
        int n=arr.length;
        // if greater than max
        if(x>arr[n-1]){
            for(int i=n-1;i>n-k;i++)ans.add(arr[i]);
            return ans;
        }
        //else the two pointer approach
        // int ind = bs(arr,x);
        if(arr[ind]==x){//element int the array
            return helper(arr,k,x,ind);    
        }else{
            
        }
    }
    
    
    private int bs(int arr[], int x){
        int ind=-1;
        int n=arr.length;
        
        int h=n;
        int l=0;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid]==x)return mid;
            if(arr[mid]<x){
                ind = mid;
                l=mid+1;
            }else{
                // ind=mid;w
                h=mid-1;
            }
        }
        return ind;
    }
}
*/