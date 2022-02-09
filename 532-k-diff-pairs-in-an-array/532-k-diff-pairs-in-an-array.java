class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;
        for(int x:nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(int x:map.keySet()){
            if((k>0 && map.containsKey(k+x)) || (k==0 && map.get(x)>1)){count++;}
        }
        return count;
    }
}