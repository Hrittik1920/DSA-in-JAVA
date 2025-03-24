public class _8_Print_Shortest_Common_SuperSequence {
    public static String printSCS(String x, String y, int n, int m) {
        if(n == 0)
            return y;
        if(m == 0)
            return x;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
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
                    sb.append(x.charAt(i-1));
                    i--;
                } else {
                    sb.append(y.charAt(j-1));
                    j--;
                }
            }
        }
        while(i > 0) {
            sb.append(x.charAt(i-1));
            i--;
        }
        while(j > 0) {
            sb.append(y.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        System.out.println(printSCS(x, y, x.length(), y.length()));
    }
}
