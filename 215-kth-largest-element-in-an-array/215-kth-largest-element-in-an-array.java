class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int e:nums){
            pq.add(e);
        }
        while(k-->1){
            pq.poll();
        }
        return pq.poll();
    }
}