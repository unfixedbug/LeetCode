class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)-> a[1]-b[1]);
        var heap = new PriorityQueue<Integer>((a,b) -> b - a);
        int total=0;
        for(int[]course:courses){
            total+=course[0];
            heap.add(course[0]);
            if(total>course[1]){
                total-=heap.poll();
            }
        }
        
        return heap.size();
    }
}