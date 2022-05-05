class MedianFinder {
    
    private PriorityQueue<Integer> small;  //.. max heap
    
    private PriorityQueue<Integer> large; // min heap
    
    private boolean even =true;
    
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {
        if(even){
            large.offer(num);
            small.offer(large.poll());
        }else{
            small.offer(num);
            large.offer(small.poll());
        }
        even=!even;
    }
    
    public double findMedian() {
        if(even)return (small.peek()+large.peek())/2.0;
        else return small.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */