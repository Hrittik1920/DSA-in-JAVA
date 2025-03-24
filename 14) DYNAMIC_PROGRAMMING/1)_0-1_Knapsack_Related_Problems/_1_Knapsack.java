import java.util.Arrays;

public class _1_Knapsack {
    // ******************************************-> O / 1 KNAPSACK PROBLEM <-************************************************
    // **CHOICE DIAGRAM**
    //                 n 
    //               /   \
    //              /     \
    //             /       \
    // (wt[n-1] <= maxC)  (wt[n-1] > maxC)
    //       / \                  |
    //      /   \                 |
    //     T     F                F
    
    // For **BASE CASE**    
    // **- Try to make all inputs smallest one-one and try to find what value it will return, THAT WILL BECOME THE BASE CASE
    
    // ########################-> RECURSIVE SOLUTION <-############################
    public static int recursive(int[] wt, int[] val, int maxCapacity, int n) {
        if(n == 0 || maxCapacity == 0) 
            return 0;
        if(wt[n-1] <= maxCapacity) {
            return Math.max(val[n-1] + recursive(wt, val, maxCapacity-wt[n-1], n-1), recursive(wt, val, maxCapacity, n-1));
        } else {
            return recursive(wt, val, maxCapacity, n-1);
        }
    }

    // ##########################-> MEMOIZATION (DP) <-#############################
    // ** We have to create a array it dimension will depends on **PARAMETERS IN RECURSIVE FUNCTION WHICH GET CHANGED**
    // ** Like in our case maxCapacity and n changes with wt, val remains same, to we have to make a 2D MATRIX to save the
    // state of the recursion in different stages  
    public static int memoization(int[] wt, int[] val, int maxCapacity, int n) {
        int[][] dp = new int[n+1][maxCapacity+1];
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return recMemoizition(wt, val, maxCapacity, n, dp);
    }
    public static int recMemoizition(int[] wt, int[] val, int maxCapacity, int n, int[][] dp) {
        if(n == 0 || maxCapacity == 0) 
            return 0;
        if(dp[n][maxCapacity] != -1) 
            return dp[n][maxCapacity];
        if(wt[n-1] <= maxCapacity) {
            return dp[n][maxCapacity] = Math.max(val[n-1] + recMemoizition(wt, val, maxCapacity-wt[n-1], n-1, dp), recMemoizition(wt, val, maxCapacity, n-1, dp));
        } else {
            return dp[n][maxCapacity] = recMemoizition(wt, val, maxCapacity, n-1, dp);
        }
    }

    // #######################-> TOP-DOWN APPROACH (DP) <-###########################
    // **Initialization is done on the basis of **BASE CASE** as n == 0 || w == 0 is the base case so dp[0][] & dp[][0] will be initializzed 
    // with 0, if base case return -1 & 1 if should be initialized by -1 & 1 respectively.
    // **And loop will be run for 2D matrix (n, maxCapacity) time, and we will build logic from our recursion function
    public static int topDownApproach(int[] wt, int[] val, int maxCapacity, int n) {
        if(n == 0 || maxCapacity == 0) 
            return 0;
        int[][] dp = new int[n+1][maxCapacity+1];
        for(int i=1;i<=n;i++) {  // nth weight = i;
            for(int j=1;j<=maxCapacity;j++) {  // current subProblem maxCapacity = j;
                if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][maxCapacity];
    }
    public static void main(String[] args) {
        int[] wt = { 2, 3, 4, 5, 3, 1}; // weight
        int[] val = { 45, 56, 67, 23, 34, 2}; // profit
        int maxCapacity = 7;
        // System.out.println(recursive(wt, val, maxCapacity, wt.length));
        System.out.println(memoization(wt, val, maxCapacity, wt.length));
        // System.out.println(topDownApproach(wt, val, maxCapacity, wt.length));
    }
}
