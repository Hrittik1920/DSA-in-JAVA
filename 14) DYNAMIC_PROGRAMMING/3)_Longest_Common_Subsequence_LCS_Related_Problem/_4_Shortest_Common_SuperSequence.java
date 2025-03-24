public class _4_Shortest_Common_SuperSequence {
    // *** APPROACH TO SOLVE THE PROBLEM ***
    // ** Shortest Common SuperSequence = x.length() + y.length() - Common(G, T, A, B)[***equal to Longest Common Subsequence]
    // ** OUTPUT:  9 (AGGXTXAYB)
    // **       x.length() + y.length() - LCS(x, y)  =>  6 + 7 - 4 = 13 - 4 = 9(ans); 
    public static int lcsubsequenceTopDownApproach(String x, String y, int n, int m) {
        if(n == 0 || m == 0)
            return 0;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int shortestCommonSuperSequenceLength(String x, String y) {
        return x.length() + y.length() - lcsubsequenceTopDownApproach(x, y, x.length(), y.length());
    }
    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        System.out.println(shortestCommonSuperSequenceLength(x, y));
    }
}
