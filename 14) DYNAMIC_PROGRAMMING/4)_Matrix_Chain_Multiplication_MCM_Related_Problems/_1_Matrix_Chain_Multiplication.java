import java.util.Arrays;

public class _1_Matrix_Chain_Multiplication {
    // ##################-> RECURSIVE APPROACH <-#####################
    public static int mcmRecursive(int[] arr, int i, int j) {
        if(i >= j) 
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int temp = mcmRecursive(arr, i, k) + mcmRecursive(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            // let k = 2 (arr[2] = 30), As matrix get divided in (1, 2) and (2+1, 4), or we can explain it as
            // for Matrix(1, 2) -> Matrix(arr[1-1]*arr[1]) + Matrix(arr[2-1][2]) -> 40 * 20 X 20 * 30 -> new matrix -> 40 * 30;
            // for Matrix(3, 4) -> Matrix(arr[3-1]*arr[3]) + Matrix(arr[4-1][4]) -> 30 * 10 X 10 * 30 -> new matrix -> 30 * 30;
            //                   *** TOTAL COST of Multiplication in this state wil be ** 40 * 30 * 30 == arr[i-1]*arr[k]*arr[j] *****
            min = Math.min(min, temp);
        }
        return min;
    }
    // ############-> MEMOIZATION(BUTTOM-UP APPROACH) <-##############
    public static int mcmRecMemoize(int[] arr, int i, int j, int[][] mem) {
        if(i >= j)
            return 0;
        if(mem[i][j] != -1) {
            return mem[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int temp = mcmRecMemoize(arr, i, k, mem) + mcmRecMemoize(arr, k+1, j, mem) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min, temp);
        }
        return mem[i][j] = min;
    }
    public static int mcmBottomUpMemoization(int[] arr, int n) {
        int[][] mem = new int[n+1][n+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(mem[i], -1);
        }
        return mcmRecMemoize(arr, 1, n-1, mem);
    }

    // ####################-> OPTIMIZED MEMOIZATION (BEST APPROACH) <-################
    // # Time Complexity Improvement (O(n^3) ⮕ O(n^2))
    //     - The first approach makes redundant recursive calls, leading to unnecessary computations.
    //     - The optimized approach checks if a subproblem is already solved before making a recursive call, reducing redundant calculations.
    //     - This cuts down unnecessary function calls, making the solution closer to O(n^2) instead of O(n^3).

    // # Space Complexity Improvement (O(n^2) stack ⮕ O(n^2) table only)
    //     - Both approaches use O(n^2) memoization table.
    //     - However, the first approach stores extra recursive stack frames, leading to O(n) additional stack space in the worst case.
    //     - The optimized approach reduces recursion depth, leading to a shallower call stack and reducing overall auxiliary space usage.
    public static int optimizedMemRecursion(int[] arr, int i, int j, int[][] mem) {
        if(i >= j) 
            return 0;
        if(mem[i][j] != -1) 
            return mem[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int left, right;
            if(mem[i][k] != -1)
                left = mem[i][k];
            else 
                left = optimizedMemRecursion(arr, i, k, mem);
            if(mem[k+1][j] != -1) 
                right = mem[k+1][j];
            else 
                right = optimizedMemRecursion(arr, k+1, j, mem);
            int temp = left + right + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min, temp);
        }
        return mem[i][j] = min;
    }
    public static int optimizedMemoized(int[] arr, int n) {
        int[][] mem = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(mem[i], -1);
        return optimizedMemRecursion(arr, 1, n-1, mem);
    } 
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};  // MATRIX i = arr[i-1] * arr[i];
        // System.out.println(mcmRecursive(arr, 1, arr.length-1));  // i = 0 is INVALID as arr[-1]*arr[0] is invalid j = n -1 is valid 
                                                                   // as arr[n-2] * arr[n-1] is valid;
        // System.out.println(mcmBottomUpMemoization(arr, arr.length));
        System.out.println(optimizedMemoized(arr, arr.length));
    }
}
