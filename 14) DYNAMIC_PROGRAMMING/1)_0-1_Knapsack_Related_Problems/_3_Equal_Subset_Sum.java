public class _3_Equal_Subset_Sum {
    public static boolean subsetSumTopDown(int[] arr, int sum, int n) {
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
    public static boolean isEqualSubsetSum(int[] arr) {
        int sum = 0;
        for(int i : arr) sum += i;
        if(sum % 2 != 0) {
            return false;
        } 
        return subsetSumTopDown(arr, sum, arr.length);
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 11, 7};
        System.out.println(isEqualSubsetSum(arr));
    }
}
