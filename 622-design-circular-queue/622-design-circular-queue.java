class MyCircularQueue {

    
    final int []q;
    int front=0,rear=-1,len=0;
    int k;
    public MyCircularQueue(int k) {
        //initialise the q, of length k
        this.k=k;
        q = new int[k];
    }
    
    public boolean enQueue(int value) {
        // add to the last
        if(isFull())return false;
        //push rear forward
        rear = (rear+1)%k;
        q[rear]=value;
        len++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())return false;
        // remove element from the first
        front=(front+1)%k;
        len--;
        return true;
    }
    
    public int Front() {
        return isEmpty()?-1:q[front];
    }
    
    public int Rear() {
        
        return isEmpty()?-1:q[rear];
    }
    
    public boolean isEmpty() {
        return len==0;
    }
    
    public boolean isFull() {
        return len==k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */