class Solution {
    final int mod= 1_000_000_007;
    public int numFactoredBinaryTrees(int[] a) {
        Arrays.sort(a);
        int n=a.length;
        long dp[] = new long[n];
        Arrays.fill(dp,1);
        
        Map<Integer,Integer> index = new HashMap<>();// stores index of a number
        for(int i=0;i<n;i++)index.put(a[i],i);
        
        for(int i=0;i<n;i++){
            // if a[i] is the required number, find its factors
            for(int j=0;j<i;j++){
                // factors of a[i] are,  a[i]/a[j] and a[j], if divisible
                if(a[i]%a[j]==0){//
                    int right = a[i]/a[j];
                    // int left = a[j];
                    if(index.containsKey(right)){// then only we have factors for i
                        // combinatiosns of left, and right tree;
                        int indexOfRight = index.get(right);
                        long combinations = dp[j]*dp[indexOfRight]; 
                        dp[i] +=  (combinations)%mod;
                    }
                }
            }
        }
        long ans=0l;
        for(long e:dp)ans+=e;
        
        return (int)(ans%mod);
        
    }
    
}