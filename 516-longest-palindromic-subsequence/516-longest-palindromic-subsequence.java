class Solution {
    
    public int longestPalindromeSubseq(String s) {
        return funcn(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    
    private int funcn(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j)      return 0;
        if (i == j)     return 1;
        
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = funcn(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(funcn(s, i + 1, j, memo), funcn(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
}