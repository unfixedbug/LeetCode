class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        
        int min = Integer.MAX_VALUE;
        for(int e:nums){
            if(e%2==1) e*=2;// if odd multiply by 2
            min = Math.min(min,e);
            pq.add(e);
        }
        
        int diff = Integer.MAX_VALUE;
        while(pq.peek()%2==0){
            int max = pq.remove();
            diff=  Math.min(diff,max-min);
            min = Math.min(max/2,min);
            pq.add(max/2);
        }
        return Math.min(diff,pq.peek()-min);
    }
    
}