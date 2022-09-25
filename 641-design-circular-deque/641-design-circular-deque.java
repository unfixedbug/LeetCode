class MyCircularDeque {
    
    int deq[];
    int front=0,rear=1,len=0;
    int k;
    public MyCircularDeque(int k) {
        this.k=k;
        deq=  new int[k];
    }
    
    public boolean insertFront(int value) {
        if(isFull())return false;
        front = (front+1)%k;
        deq[front]=value;
        len++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull())return false;
        rear = (rear-1+k)%k;
        deq[rear]=value;
        len++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty())return false;
        front = (front-1+k)%k;
        len--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty())return false;
        rear = (rear+1)%k;
        len--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty())return -1;
        // front = (front+1)%k;
        return deq[front];
    }
    
    public int getRear() {
        if(isEmpty())return -1;
        // rear = (rear-1+k)%k;
        return deq[rear];
    }
    
    public boolean isEmpty() {
        return len==0;   
    }
    
    public boolean isFull() {
        return len==k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */