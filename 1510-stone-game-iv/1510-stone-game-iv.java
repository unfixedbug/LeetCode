class Solution {
    public boolean winnerSquareGame(int n) {
        HashMap<Integer, Boolean> cache = new HashMap<>();
        cache.put(0, false);
        return dfs(cache,n);
    }
    public static boolean dfs(HashMap<Integer, Boolean> cache, int remain){
        if(cache.containsKey(remain)){
            return cache.get(remain);
        }
        int sqroot = (int)Math.sqrt(remain);
        for(int i=1; i<= sqroot;i++){
            if(!dfs(cache, remain -i*i)){
                cache.put(remain, true);
                return true;
            }
        }
        cache.put(remain, false);
        return false;
    }
}