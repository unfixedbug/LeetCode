class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans=0, prefix=0,c,t;
        Map<Integer, Integer> count = new HashMap<>(), total = new HashMap<>();
        count.put(0,1);
        for(int i=0;i<n;i++){
            prefix ^=arr[i];
            c = count.getOrDefault(prefix,0);
            t = total.getOrDefault(prefix,0);
            ans += c*i -t;
            count.put(prefix,c+1); /// increase the frequency
            total.put(prefix, t+i+1);
        }
        return ans;
    }
}