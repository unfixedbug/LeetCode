class MyHashSet {

    static final int size = 131071;
    private Node[] hashset;
    static final int mult = 191919;
    
    public MyHashSet() {
        this.hashset = new Node[size]; 
    }
    
    private int hash(int key){
        return (int)((long)key*mult%size);
    }
    
    public void add(int key) {
        int h = hash(key);
        if(this.contains(key))return;
        hashset[h] = new Node(key, hashset[h]); // self looping
    }
    
    public void remove(int key) {
        int h = hash(key);
        if(!this.contains(key))return;
        // if head is the key -> remove head;
        if(hashset[h].key == key)hashset[h] = hashset[h].next;
        else{
            while(hashset[h].next.key!=key)hashset[h] = hashset[h].next;
            hashset[h] = hashset[h].next;}
    }
    
    public boolean contains(int key) {
        int h = hash(key);
        for(Node node = hashset[h]; node!=null; node = node.next){
            if(node.key == key)return true;
        }
        return false;
    }
}

class Node{// rather than listNode
    int key;
    Node next;
    Node(int key){
        this.key = key;
    }
    
    Node(int key, Node next){
        this.key = key;
        this.next = next;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */