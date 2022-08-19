class Solution {
    public boolean isPossible(int[] A) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        
        for (int a: A) left.put(a, left.getOrDefault(a, 0) + 1);
        for (int a: A) {
            if (left.get(a) <= 0) continue;
            
            left.put(a, left.get(a) - 1);
            
            // place a in an existing subsequence if possible
            if (end.containsKey(a-1) && end.get(a-1) > 0) {
                end.put(a-1, end.get(a-1) - 1);
                end.put(a, end.getOrDefault(a, 0) + 1);
                continue;
            }
            
            // place a in a new subsequence
            if (left.containsKey(a+1) && left.get(a+1) > 0 && 
                left.containsKey(a+2) && left.get(a+2) > 0) {
                left.put(a+1, left.get(a+1) - 1);
                left.put(a+2, left.get(a+2) - 1);
                end.put(a+2, end.getOrDefault(a+2, 0) + 1);
                continue;
            }
            
            // don't know where to place a? ---> false
            return false;
        }
        
        return true;              
    }
}