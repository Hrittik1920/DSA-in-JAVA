public class _3_Coin_Change_Maximum_Ways {
    public static int countSubsetsWithGivenSumCoinChangeMaximum(int[] coins, int sum, int n) {
        if(sum == 0)
            return 1;
        if(n == 0)
            return 0;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=sum;j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int sum = 5;
        int[] coins = {1, 2, 3};
        System.out.println(countSubsetsWithGivenSumCoinChangeMaximum(coins, sum, coins.length));
    }
}
