class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<heights.length-1;i++){
            if(heights[i]>heights[i+1])continue;
            int diff= heights[i+1]-heights[i]; 
            bricks-= diff;
            pq.add(diff);
            
            if(bricks<0){
                bricks+=pq.poll();// exchange ladder instead of bricks for bigger ones
                if(ladders>0)ladders--;
                else return i;
            }
        }
        // return last index
        return heights.length-1;
    }
}