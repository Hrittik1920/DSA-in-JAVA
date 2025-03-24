import java.util.Arrays;

public class _2_Palindrome_Partition {
    // MINIMIN NO. OF PARTITION TO MAKE THE EACH PARTITION OF STRING PALINDROM
    // ######################-> RECURSIVE APPROACH <-########################
    public static boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) 
                return false;
            i++;j--;
        }
        return true;
    }
    public static int recursive(String s, int i, int j) {
        if(i >= j)
            return 0;
        if(isPalindrome(s, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int temp = 1 + recursive(s, i, k) + recursive(s, k+1, j);
            min = Math.min(min, temp);
        }
        return min;
    }

    // ##############-> MEMOIZATION (BOTTOM-UP APPROACH) <-#############
    public static int memoizedRecursion(String s, int i, int j, int[][] mem) {
        if(i >= j)  
            return 0;
        if(isPalindrome(s, i, j)) 
            return 0;
        if(mem[i][j] != -1) {
            return mem[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int temp = 1 + memoizedRecursion(s, i, k, mem) + memoizedRecursion(s, k+1, j, mem);
            min = Math.min(min, temp);
        }
        return mem[i][j] = min;
    }
    public static int palindromePartitionMemoization(String s, int n) {
        int[][] mem = new int[n+1][n+1];
        for(int i=0;i<=n;i++) 
            Arrays.fill(mem[i], -1);
        return memoizedRecursion(s, 0, n-1, mem);
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
    public static int optimizedRecursionMemoization(String s, int i, int j, int[][] mem) {
        if(i >= j)
            return 0;
        if(isPalindrome(s, i, j)) 
            return 0;
        if(mem[i][j] != -1) 
            return mem[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int left, right;
            if(mem[i][k] != -1) {
                left = mem[i][k];
            } else {
                left = optimizedRecursionMemoization(s, i, k, mem);
            }
            if(mem[k+1][j] != -1) {
                right = mem[k+1][j];
            } else {
                right = optimizedRecursionMemoization(s, k+1, j, mem);
            }
            int temp = 1 + left + right;
            min = Math.min(min, temp);
        }
        return mem[i][j] = min;
    }
    public static int optimizedMemoization(String s, int n) {
        int[][] mem = new int[n+1][n+1];
        for(int i=0;i<=n;i++) 
            Arrays.fill(mem[i], -1);
        return optimizedRecursionMemoization(s, 0, n-1, mem);
    }
    public static void main(String[] args) {
        String s = "niitgk";
        // System.out.println(recursive(s, 0, s.length()-1));
        // System.out.println(palindromePartitionMemoization(s, s.length()));
        System.out.println(optimizedMemoization(s, s.length()));
    }
}
