class MyHashMap {

    static final int size = 19997;
    static final int mult = 12582917;
    
//     using linkedlists
    ListNode []map;
    
    public MyHashMap() {
        this.map = new ListNode[size]; // create a map
    }
    
    private int hash(int key){
        return (int)((long)key*mult%size);
    }
    
    public void put(int key, int value) {
        remove(key); // ?? why so
        int h = hash(key);
        ListNode node = new ListNode(key,value,map[h]);
        map[h] = node; // self pointer ??
    }
    
    public int get(int key) {
        int h = hash(key);
        ListNode node = map[h];
        for(; node!=null; node = node.next){
            if(node.key == key)return node.val;
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        ListNode node = map[h]; // data stored with hash h, hth location;
        if(node==null) return;
        if(node.key==key) map[h] = node.next;
        else for(;node.next!=null;node=node.next){
            if(node.next.key == key){
node.next = node.next.next;
            return;}
        }
    }
}

class ListNode{
    int key, val;
    ListNode next;
    public ListNode(int key, int val, ListNode next){
        this.key  = key;
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */