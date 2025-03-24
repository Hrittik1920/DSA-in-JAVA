public class _5_Minimum_Subset_Sum_Diff {
    // ***APPROACH TO SOLVE THE PROBLEM***
    // * As we hae to find min(s1 - s2), range = s1 + s2, s2 = range - s1
    // * min(abs(s1 - s2)) = min(range - s1 - s1) = **min(range - 2 * s1)**;
    // * so we have to check for which values of sum subset1(s1) is possible, so we will calculate it by using subsetSumEqualToRange
    // method and get the last row of the matrix[n] where we will get for which value of range(sum) subset(s1) is True, then we will 
    // calculate the minimum of them by using **min = Math.min(min, range - 2*i);**
    public static boolean[] subsetSumEqualToRange(int[] arr, int range, int n) {
        boolean[][] dp = new boolean[n+1][range+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=range;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        } 
        return dp[n];
    }
    public static int minimumSubsetSumDiff(int[] arr) {
        int range = 0;
        for(int a : arr) range += a;
        boolean[] valid = subsetSumEqualToRange(arr, range, arr.length);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<(valid.length+1)/2;i++) {
            if(valid[i]) {
                min = Math.min(min, range - 2*i);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 6};
        System.out.println(minimumSubsetSumDiff(arr));
    }
}
