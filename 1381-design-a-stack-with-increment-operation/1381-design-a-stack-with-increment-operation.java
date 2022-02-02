class CustomStack {
    Stack <Integer> stack;
    int size;
    int inc[];
    public CustomStack(int maxSize) {
        size=maxSize;
        inc = new int[size];
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.size()<size){
            stack.push(x);
        }
    }
    
    public int pop() {
        int i = stack.size()-1;
        if(i<0)return -1;
        if(i>0) inc[i-1]+=inc[i]; /// cause size is decrewasing
        int res = stack.pop() + inc[i];
        inc[i]=0;
        return res;
    }
    
    public void increment(int k, int val) {
        int i= Math.min(k, stack.size())-1;
        if(i>=0)inc[i]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */