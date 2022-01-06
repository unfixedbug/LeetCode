class LRUCache {
    
//     this adds the node to the first, make it recently used
    private void addNode(Node node){
        //neighbour node next to the head, ie { head -> node -> neighbour}
        Node neighbour = head.next;
        
        node.next = neighbour;
        node.prev = head;
        
        neighbour.prev = node;
        head.next = node;
    }
    
    // easy to remove a node on a doubly linked list
    private void removeNode(Node node){
        // { --  previous  -> node -> NextToNode}
        Node previous = node.prev;
        Node NextToNode = node.next;
        
        previous.next = NextToNode;
        NextToNode.prev = previous;
        
        //mark as null
        node.prev = node.next = null;
    }
    
//     move the node to first, make it recent
    private void movetoFront(Node node){
        removeNode(node);
        addNode(node);
    }
    
//     helper stuff
    class Node{
        int key, value;
        Node prev, next;
    }
    HashMap<Integer, Node> cache;
    int cap;
    Node head, tail; // dumy nodes to fight null pointer exception
    
    
    public LRUCache(int capacity) {
        cache  = new HashMap<>();
        cap = capacity;
        
        
        //initiate a doubly linked list
        head= new Node();
        tail = new Node();
        head.next = tail;
        tail.prev= head;
    }
    
    public int get(int key) {
        Node node =  cache.get(key);
        
        if(node==null){// does not exist
            return -1;
        }else{
            int vl = node.value;
            movetoFront(node);
            return vl;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        
        
        //if the node doesnt exist in the list, ie FIRST TIME
        if(node ==null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            
            // if capacity(cache) is full, remove the least used node
            if(cache.size()==cap){ 
                Node LRU_Node = tail.prev;
                cache.remove(LRU_Node.key);
                
                removeNode(LRU_Node);
            }
            
            //hashmape cache, not ds
            cache.put(key, newNode);
            addNode(newNode);
        
        }else{ // already present
            // change the value
            node.value = value;
            
            // make it recentlu used
            movetoFront(node); 
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */