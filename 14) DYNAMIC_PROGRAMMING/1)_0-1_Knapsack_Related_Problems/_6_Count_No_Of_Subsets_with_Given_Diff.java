public class _6_Count_No_Of_Subsets_with_Given_Diff {
    public static int countSubsetsOfGivenSum(int[] arr,int sum, int n) {
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
    // *** APPROACH TO SOLVE THE PROBLEM ***
    // ** subset(s1) - subset(s2) = Diff(given);
    // ** subset(s1) + subset(s2) = range(sum of array);
    //  + ______________________________________________
    //    2 * s1 = range(sum) + Diff(given);
    //    s1 = (range + Diff) / 2;
    public static int countNoOfSubsetsWithGivenDiff(int[] arr, int diff) {
        int sum = 0;
        for(int a : arr) sum += a;
        int total = sum + diff;
        if(total % 2 != 0) {
            return 0;
        } else {
            return countSubsetsOfGivenSum(arr, total/2, arr.length);
        }
    }
    public static void main(String[] args) {
        int diff = 1;
        int[] arr = {1, 1, 2, 3};
        System.out.println(countNoOfSubsetsWithGivenDiff(arr, diff));
        // OUTPUTS:
        // 1) S1 {1, 1, 2} - S2 {3} = 1
        // 2) S1 {1, 3} - S2 {1, 2} = 1
        // 3) S1 {1, 3} - S2 {1, 2} = 1
    }
}
