
class Solution {
    
    double mod = 1e9+7;
    public int maxPerformance(int n, int[] speed, int[] efi, int k) {
        int [][]arr = new int[n][2];
        //arr decreasingly sorted WRT efficiency
        for(int i=0;i<n;i++){
            arr[i] = new int[]{efi[i],speed[i]};   
        }
        
        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(a,b)->a-b);
        
        
        long ans=0,sum=0;
        
        for(int []es:arr){
            //add speed, with max efficiency
            pq.add(es[1]);
            sum +=es[1];
            
            if(pq.size()>k){
                // remove the sum which contributes the least
                sum-=pq.poll();
                
            }
            
            // es[0], is the min efficiency as we are traversing from increasing side
            long curval = sum*es[0];
            ans = Math.max(ans,curval);
            
        }
        
        return (int)(ans%(long)(mod));
        
    }
    
    /*
    
        IDEA 01:
        // sort wrt gecreasing efficiency
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getKey()-b.getKey());        
        
        //search engineer with max product ?
        int ind=0;
        int mx=0;
        for(int i=1;i<n;i++){
            
        }
    */
}