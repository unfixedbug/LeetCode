class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[k];
        for(int i:nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(), a.getValue())); // sort based on value(frequency) of element
        
        pq.addAll(map.entrySet());
        
        
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
        
        
    }
    
}
