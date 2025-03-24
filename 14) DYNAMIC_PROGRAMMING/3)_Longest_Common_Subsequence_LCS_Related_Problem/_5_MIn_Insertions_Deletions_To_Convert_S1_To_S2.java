public class _5_MIn_Insertions_Deletions_To_Convert_S1_To_S2 {
    // *** No. of Insertions = s2.length() - lcs(s1, s2);
    // *** No. of Deletions = s1.length() - lcs(s1, s2);
    // lcs("heap", "pea") = 2 ("ea");
    // No. of insertions = length("pea") - leagth("ea");
    // No. of Deletions = length("heap") - length("ea");
    public static int longestCommonSubsequence(String s1, String s2, int n, int m) {
        if(n == 0  ||  m == 0)
            return 0;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1)  == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int[] minInsertionDelectionToConvertS1ToS2(String s1, String s2, int n, int m) {
        int lcs = longestCommonSubsequence(s1, s2, n, m);
        return new int[]{m-lcs, n-lcs};
    }
    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        int[] ans = minInsertionDelectionToConvertS1ToS2(s1, s2, s1.length(), s2.length());
        System.out.println("Insertions: " + ans[0] + ",   Deletions: " + ans[1]);
    }
}
