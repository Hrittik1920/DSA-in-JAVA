public class _2_Subset_Sum_Problem {
    public static boolean topDownApproach(int[] arr, int sum, int n) {
        if(sum == 0) return true;
        if(n == 0) return false;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = true;
        } 
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=sum;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int sum = 11;   // maxCapacity according to 0-1 KnapSack
        int[] arr = {2, 3, 5, 83, 10};  // weight array according to 0-1 KnapSack
        System.out.println(topDownApproach(arr, sum, arr.length));
    }
}
