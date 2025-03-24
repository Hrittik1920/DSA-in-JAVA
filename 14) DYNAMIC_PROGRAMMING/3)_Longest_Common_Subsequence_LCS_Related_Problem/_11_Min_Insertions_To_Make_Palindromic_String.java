public class _11_Min_Insertions_To_Make_Palindromic_String {
    // *** Minimum No. of Deletion to Make Palindromic == Minimum No. of insertion to make it Palindromic ***
    public static int minInsertionsToMakePalindromicString(String s, int n) {
        if(n == 0)
            return 0;
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return s.length()-dp[n][n];
    }
    public static void main(String[] args) {
        String s = "aebcbda";
        System.out.println(minInsertionsToMakePalindromicString(s, s.length()));
    }
}
