public class _7_Target_Sum {
    public static int countSubsetsOfGivenSum(int[] arr, int sum, int n) {
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
    // *** APPROACH FOR SOLVING THE PROBLEM ***
    // ** STATEMENT : What are the diffrent combination of sign I can use to get sum of each element with different combination of + 
    // & - sign before each element to get sum of array equal to sum.
    // e.g., OUTPUTS:
    //       1) +1 -1 -2 +3 
    //       2) -1 +1 -2 +3
    //       3) +1 +1 +2 -3
    // *** BUT THIS PROBLEM IS TOTALY SIMMILAR TO **COUNT_NO_OF_SUBSETS_WITH_GIVEN_DIFF** 
    // e.g,, OUTPUTS:
    //       1) s1(+1, +3) - s2(-1, -2) = 1(sum given) [ which is actually **DIFF** of that sum ]
    //       2) s1(+1, +3) - s2(-1, -2) = 1
    //       3) s1(+1, +1, +2) - S2(-3) = 1
    public static int tagetSum(int[] arr, int sum)  {//  **EXACT SIMILAR TO COUNT SUBSETS OF GIVEN DIFFERENCE**
        int range = 0;
        for(int i : arr) range += i;
        int total = range + sum;
        if(total % 2 != 0) {
            return 0;
        } else {
            return countSubsetsOfGivenSum(arr, total/2, arr.length);
        }
    }
    public static void main(String[] args) {
        int sum = 1;
        int[] arr = {1, 1, 2, 3};
        System.out.println(tagetSum(arr, sum));
    }
}
