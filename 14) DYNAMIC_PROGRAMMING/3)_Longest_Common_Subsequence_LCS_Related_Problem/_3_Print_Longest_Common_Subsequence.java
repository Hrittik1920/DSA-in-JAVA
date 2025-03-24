public class _3_Print_Longest_Common_Subsequence {
    public static String printLongestCommonSequence(String x, String y, int n, int m) {
        if(n == 0 || m == 0)
            return "";
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
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while(i > 0  &&  j > 0) {
            if(x.charAt(i-1) == y.charAt(j-1)) {
                sb.append(x.charAt(i-1));
                i--;j--;
            } else {
                if(dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String x = "abcdfgh";
        String y = "abedfhr";
        System.out.println(printLongestCommonSequence(x, y, x.length(), y.length()));
    }
}
