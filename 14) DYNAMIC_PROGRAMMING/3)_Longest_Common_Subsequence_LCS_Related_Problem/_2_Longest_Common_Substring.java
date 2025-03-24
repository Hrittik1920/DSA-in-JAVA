public class _2_Longest_Common_Substring {
    public static int topDownApproach(String x, String y, int n, int m) {
        if(n == 0  ||  m == 0) 
            return 0;
        int[][] dp = new int[n+1][m+1];
        int maxLength = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String x = "abcdef";
        String y = "abedcf";
        System.out.println(topDownApproach(x, y, x.length(), y.length()));
    }
}