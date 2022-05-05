class MyStack {
    private LinkedList<Integer> q = new LinkedList<>();
    
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
//         keep adding first element to the last
        q.add(x);
        int sz = q.size();
        while(sz>1){
            // just take elements from front and add to the back
            q.add(q.remove());
            sz--;
        }
    }
    
    public int pop() {
        return q.remove();// removes first element which is by far added last
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */