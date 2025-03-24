public class _6_Longest_Palindromic_Subsequence {
    // *** Exact similar to calculating **longest common subsequence** by passing two paramente as lcs(s, s.reverse());
    public static int longestPaindromicSubsequence(String x, String y, int n) {
        if(n == 0)
            return 0;
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    public static void main(String[] args) {
        String s = "agbcba";
        System.out.println(longestPaindromicSubsequence(s, new StringBuilder(s).reverse().toString(), s.length()));
    }
}
