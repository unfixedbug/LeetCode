class Solution {
        int a = 0, e = 1, i = 2, o = 3, u = 4, MOD = (int) (1e9 + 7);
        public int countVowelPermutation(int n) {
            long[] dp = new long[5], prevDP = new long[5];
            Arrays.fill(prevDP, 1L);
            while (n-- > 1) {
                dp[a] = (prevDP[e] + prevDP[i] + prevDP[u]) % MOD;
                dp[e] = (prevDP[a] + prevDP[i]) % MOD;
                dp[i] = (prevDP[e] + prevDP[o]) % MOD;
                dp[o] = prevDP[i];
                dp[u] = (prevDP[i] + prevDP[o]) % MOD;
                long[] tmp = dp; dp = prevDP; prevDP = tmp;
            }
            return (int) ((prevDP[a] + prevDP[e] + prevDP[i] + prevDP[o] + prevDP[u]) % MOD);
        }
}