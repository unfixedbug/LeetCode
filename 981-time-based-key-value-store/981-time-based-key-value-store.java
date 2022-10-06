class TimeMap {
    
    HashMap<String, HashMap<Integer,String>> map;
    
    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<Integer,String> mapt = new HashMap<>();
        if(!map.containsKey(key)){
            mapt.put(timestamp,value);
            map.put(key,mapt);
        }
        else{
            map.get(key).put(timestamp,value);
        }
        
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key))return "";
        
        
        for(int now=timestamp;now>=1;now--){
            if(map.get(key).containsKey(now)){
                return map.get(key).get(now);
            }    
        }
        
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */