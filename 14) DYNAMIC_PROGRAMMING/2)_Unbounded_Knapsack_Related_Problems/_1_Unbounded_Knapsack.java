public class _1_Unbounded_Knapsack {
    // *** dp[i-1] we call for dp[i] to again take the same elemnent in the array ***
    public static int topDownApproach(int[] wt, int[] val, int maxCapacity, int n) {
        if(n == 0 || maxCapacity == 0) 
            return 0;
        int[][] dp = new int[n+1][maxCapacity+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=maxCapacity;j++) {
                if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + /* ***in Place of dp[i-1], dp[i]*** */dp[i][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][maxCapacity];
    }
    public static void main(String[] args) {
        int[] wt = { 2, 3, 4, 5, 3, 1}; // weight
        int[] val = { 45, 56, 67, 23, 34, 24}; // profit
        int maxCapacity = 7;
        System.out.println(topDownApproach(wt, val, maxCapacity, wt.length));
    }
}
