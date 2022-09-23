class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long sum = 0;
        int length = 0;
        
        for(int i = 1; i <= n; i++) {
            if((i & (i - 1)) == 0)
                length++;
            sum = ((sum << length) | i) % MOD;
        }
        
        return (int) sum;
    }
}