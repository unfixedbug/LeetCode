class LRUCache2 {
	LinkedHashMap<Integer,Integer> lookup;
    
	public LRUCache(int capacity) {

		lookup = new LinkedHashMap<>(capacity, 0.5f, true){
			protected boolean removeEldestEntry(Map.Entry<Integer,Integer> entry){
				return size() > capacity;      
			}
		};

	}
    
    public int get(int key) {
        return lookup.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        lookup.put(key, value);

    }
}
