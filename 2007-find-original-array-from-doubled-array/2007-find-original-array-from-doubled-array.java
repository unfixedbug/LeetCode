class Solution {
   public int[] findOriginalArray(int[] A) {
        int n = A.length, i = 0;
        if (n % 2 == 1) return new int[0];
        int[] res = new int[n / 2];
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : A)
            count.put(a, count.getOrDefault(a, 0) + 1);
        for (int x : count.keySet()) {
            if (count.get(x) > count.getOrDefault(x + x, 0))
                return new int[0];
            for (int j = 0; j < count.get(x); ++j) {
                res[i++] = x;
                count.put(x + x, count.get(x + x) - 1);
            }
        }
        return res;
    }
    public int[] findOriginalArray2(int[] changed) {
        Arrays.sort(changed);
        int n=changed.length;
        if(n%2==1)return new int[]{};
        int ans[] = new int[n/2];
        Map<Integer,Integer> map = new TreeMap<>();
        // has frequency
        for(int e:changed){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        int ind=0;
        int count=0;
        // or we can iterate over array also
        for(int e:changed){
            if(map.get(e)>=1 && map.containsKey(e*2)){
                // remvoe occurances of the same
                ans[ind++]=e;
                if(map.get(e)==1){
                    map.remove(e);
                }else{
                    map.put(e,map.get(e)-1);
                }
                if(map.get(e*2)==1){
                    map.remove(e*2);
                }else{
                    map.put(e*2,map.get(e*2)-1);
                }
                // map.put(e,map.put())
            }    
        }
        // on map, sorted queries
        // for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        //     int key = entry.getKey();
        //     int freq = entry.getValue();
        //     if(map.containsKey(key*2)){
        //         ans[ind++]=key;
        //         if(freq==1){
        //             map.remove(key);
        //         }
        //         else map.put(key,freq-1);
        //         count++;
        //     }
        // }
        // if(count!=)
        return ans;
        // return new int[]{};

    }
}