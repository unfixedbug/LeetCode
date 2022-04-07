class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int e:stones)pq.add(e);
        if(stones.length>1){
            int ans=0;
            while(pq.size()>=2){
                ans = pq.poll()-pq.poll();
                pq.add(ans);
            }
            
            }
        return pq.poll();
    }
}