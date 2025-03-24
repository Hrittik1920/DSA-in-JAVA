public class _7_Min_Deletions_To_Make_Palindromic_String {
    // *** s1.lenght - lcs(s, s.reverse) (ans);
    public static int longestCommonSubsequence(String x, String y, int n) {
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
    public static int minDeletionsToMakePalindromicString(String s) {
        return s.length() - longestCommonSubsequence(s, new StringBuilder(s).reverse().toString(), s.length());
    }
    public static void main(String[] args) {
        String s = "agbcba";
        System.out.println(minDeletionsToMakePalindromicString(s));
    }
}
