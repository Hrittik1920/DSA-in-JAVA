public class _2_Rod_Cutting_Problem {
    // *** EXACT COPY OF UNBOUNDED KNAPSAK ***
    // totalLength(maxCapacity), length array is equal to weight(wt) array, profit array is equal to value(val) array of unbounded knapsak
    public static int topDownApproach(int[] length, int[] profit, int totalLength, int n) {
        if(n == 0  ||  totalLength == 0) 
            return 0;
        int[][] dp = new int[n+1][totalLength+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=totalLength;j++) {
                if(length[i-1] <= j) {
                    dp[i][j] = Math.max(profit[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totalLength];
    }   
    public static void main(String[] args) {
        int totalLength = 8;
        int[] length = {1, 2, 3, 4,  5,  6,  7,  8};  // *** If length array is not given then profit[i] will become profit for i+1 length
        int[] profit = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(topDownApproach(length, profit, totalLength, length.length));
        // OUTPUT: (2, 6) -> 5 + 17 = 22
    }
}
