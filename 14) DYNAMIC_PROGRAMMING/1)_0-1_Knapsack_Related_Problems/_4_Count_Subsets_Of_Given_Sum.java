public class _4_Count_Subsets_Of_Given_Sum {
    public static int topDownApproach(int[] arr, int sum, int n) {
        if(sum == 0) return 1;
        if(n == 0) return 0;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=sum;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int sum = 10;
        int[] arr = {2, 3, 5, 6, 8, 3, 10};
        System.out.println(topDownApproach(arr, sum, arr.length));
    }
}
