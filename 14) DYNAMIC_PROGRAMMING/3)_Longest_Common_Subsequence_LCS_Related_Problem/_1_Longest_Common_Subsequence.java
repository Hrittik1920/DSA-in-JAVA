import java.util.Arrays;

public class _1_Longest_Common_Subsequence {
    // ##################-> RECURSIVE CODE <-####################
    public static int lcsRecursion(String x, String y, int n, int m) {
        if(n == 0  ||  m == 0)
            return 0;
        if(x.charAt(n-1) == y.charAt(m-1)) {
            return 1 + lcsRecursion(x, y, n-1, m-1);
        } else {
            return Math.max(lcsRecursion(x, y, n-1, m), lcsRecursion(x, y, n, m-1));
        }
    }

    // ###########-> MEMOIZATION (BOTOM-UP APPROACH) <-############
    public static int lcsMemoizedRecursion(String x, String y, int n, int m, int[][] mem) {
        if(n == 0  ||  m == 0)
            return 0;
        if(mem[n][m] != -1) {
            return mem[n][m];
        }
        if(x.charAt(n-1) == y.charAt(m-1)) {
            return mem[n][m] = lcsMemoizedRecursion(x, y, n-1, m-1, mem) + 1;
        } else {
            return mem[n][m] = Math.max(lcsMemoizedRecursion(x, y, n-1, m, mem), lcsMemoizedRecursion(x, y, n, m-1, mem));
        }
    }
    public static int lcsMemoized(String x, String y, int n, int m) {
        if(n == 0 || m == 0)
            return 0;
        int[][] mem = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(mem[i], -1);
        }
        for(int i=0;i<=n;i++) {
            mem[i][0] = 0;
        }
        for(int j=0;j<=m;j++) {
            mem[0][j] = 0;
        }
        return lcsMemoizedRecursion(x, y, n, m, mem);
    }

    // #####################-> TOP-DOWN-APPROACH <-###################
    public static int lcsTopDownApproach(String x, String y, int n, int m) {
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
    public static void main(String[] args) {
        String x = "abcdfgh";
        String y = "abedhr";
        // OUTPUT: x(a, b, d, h) is common in y (a, b, d, h) -> 4 (output);
        System.out.println(lcsRecursion(x, y, x.length(), y.length()));
        System.out.println(lcsMemoized(x, y, x.length(), y.length()));
        System.out.println(lcsTopDownApproach(x, y, x.length(), y.length()));
    }
}
