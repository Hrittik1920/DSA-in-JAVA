public class _10_Sequence_Pattern_Method {
    // STATEMENT : Check if string(s1) is subsequence of string(s2);
    public static boolean isSequenceS1inS2(String s1, String s2, int n, int m) {
        if(n == 0)
            return true;
        if(m == 0) 
            return false;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m] == s1.length();
    }
    public static void main(String[] args) {
        String s1 = "AXY";
        String s2 = "ADXCPY";
        System.out.println(isSequenceS1inS2(s1, s2, s1.length(), s2.length()));
    }
}
