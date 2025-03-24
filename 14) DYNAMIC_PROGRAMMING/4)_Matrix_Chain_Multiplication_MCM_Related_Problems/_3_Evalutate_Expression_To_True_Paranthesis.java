import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3_Evalutate_Expression_To_True_Paranthesis {
    // NO. OF WAYS TO MAKE EXPRESSION RETURN TRUE, BY DIVIDING IT WILL CORRECT PARANTHESIS
    // ####################-> RECURSIVE APPROACH <-#########################
    public static int recursive(String exp, int i, int j, boolean isTrue) {
        if(i > j) 
            return 0;
        if(i == j) {
            if(isTrue) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        int ans = 0;
        for(int k=i+1;k<j;k+=2) {
            int lt = recursive(exp, i, k-1, true);
            int lf = recursive(exp, i, k-1, false);
            int rt = recursive(exp, k+1, j, true);
            int rf = recursive(exp, k+1, j, false);
            char opt = exp.charAt(k);
            if(opt == '^') {
                if(isTrue) {
                    ans += (lt*rf + lf*rt);
                } else {
                    ans += (lt*rt + lf*rf);
                }
            }
            if(opt == '|') {
                if(isTrue) {
                    ans += (lt*rt + lt*rf + lf*rt);
                } else {
                    ans += lf*rf;
                }
            }
            if(opt == '&') {
                if(isTrue) {
                    ans += (lt*rt);
                } else {
                    ans += (lt*rf + lf*rt + lf*rf);
                }
            }
        }
        return ans;
    }

    // ##################-> MEMOIZATION (BOTTOM-UP APPROACH) <-#####################
    public static int memoizedRecursion(String exp, int i, int j, boolean isTrue, Map<String, Integer> map) {
        if(i > j)
            return 0;
        if(i == j) {
            if(isTrue) 
                return exp.charAt(i) == 'T' ? 1 : 0;
            else 
                return exp.charAt(i) == 'F' ? 1 : 0;
        }
        String s = i + " " + j + " " + (isTrue ? "T" : "F");
        if(map.containsKey(s)) {
            return map.get(s);
        } 
        int ans = 0;
        for(int k=i+1;k<j;k+=2) {
            int lt = memoizedRecursion(exp, i, k-1, true, map);
            int lf = memoizedRecursion(exp, i, k-1, false, map);
            int rt = memoizedRecursion(exp, k+1, j, true, map);
            int rf = memoizedRecursion(exp, k+1, j, false, map);
            char opt = exp.charAt(k);
            if(opt == '^') {
                if(isTrue) {
                    ans += (lt*rf + lf*rt);
                } else {
                    ans += (lt*rt + lf*rf);
                }
            }
            if(opt == '|') {
                if(isTrue) {
                    ans += (lt*rt + lt*rf + lf*rt);
                } else {
                    ans += lf*rf;
                }
            }
            if(opt == '&') {
                if(isTrue) {
                    ans += (lt*rt);
                } else {
                    ans += (lt*rf + lf*rt + lf*rf);
                }
            }
        }
        map.put(s, ans);
        return ans;
    }
    public static int memoization(String exp, int n) {
        // int[][][] mem = new int[n+1][n+1][2]; // n+1, n+1, 2 for i, j, isTrue;.
        Map<String, Integer> map = new HashMap<>();
        return memoizedRecursion(exp, 0, exp.length()-1, true, map);
    }

    // ####################-> OPTIMIZED MEMOIZATION (BEST APPROACH) USING MAP <-################
    // # Time Complexity Improvement (O(n^3) ⮕ O(n^2))
    //     - The first approach makes redundant recursive calls, leading to unnecessary computations.
    //     - The optimized approach checks if a subproblem is already solved before making a recursive call, reducing redundant calculations.
    //     - This cuts down unnecessary function calls, making the solution closer to O(n^2) instead of O(n^3).

    // # Space Complexity Improvement (O(n^2) stack ⮕ O(n^2) table only)
    //     - Both approaches use O(n^2) memoization table.
    //     - However, the first approach stores extra recursive stack frames, leading to O(n) additional stack space in the worst case.
    //     - The optimized approach reduces recursion depth, leading to a shallower call stack and reducing overall auxiliary space usage.
    public static int optimizedMemRecursion(String exp, int i, int j, boolean isTrue, Map<String, Integer> map) {
        if(i > j)   
            return 0;
        if(i == j) {
            if(isTrue) 
                return exp.charAt(i) == 'T' ? 1 : 0;
            else 
                return exp.charAt(i) == 'F' ? 1 : 0;
        } 
        String key = i + " " + j + " " + (isTrue ? "T" : "F");
        if(map.containsKey(key))
            return map.get(key);
        int ans = 0;
        for(int k=i+1;k<j;k+=2) {
            int lt, lf, rt, rf; // left expression true, left expression false, right expression true, right expression false
            String ltkey = i + " " + (k-1) + " T";
            String lfkey = i + " " + (k-1) + " F";
            String rtkey = (k+1) + " " + j + " T";
            String rfkey = (k+1) + " " + j + " F";
            if(map.containsKey(ltkey))
                lt = map.get(ltkey);
            else 
                lt = optimizedMemRecursion(exp, i, k-1, true, map);
            if(map.containsKey(lfkey))
                lf = map.get(lfkey);
            else 
                lf = optimizedMemRecursion(exp, i, k-1, false, map);
            if(map.containsKey(rtkey))
                rt = map.get(rtkey);
            else 
                rt = optimizedMemRecursion(exp, k+1, j, true, map);
            if(map.containsKey(rfkey))
                rf = map.get(rfkey);
            else 
                rf = optimizedMemRecursion(exp, k+1, j, false, map);
            char opt = exp.charAt(k);
            if(opt == '^') {
                if(isTrue)
                    ans += (lt*rf + lf*rt);
                else 
                    ans += (lt*rt + lf*rf);
            }
            if(opt == '&') {
                if(isTrue) 
                    ans += (lt*rt);
                else 
                    ans += (lt*rf + lf*rt + lf*rf);
            }
            if(opt == '|') {
                if(isTrue)
                    ans += (lt*rf + lt*rt + lf*rt);
                else 
                    ans += (lf*rf);
            }
        }
        map.put(key, ans);
        return ans;
    }
    public static int optimizedMemoizationMap(String exp, int n) {
        Map<String, Integer> map = new HashMap<>();
        return optimizedMemRecursion(exp, 0, n-1, true, map);
    }

    // ####################-> OPTIMIZED MEMOIZATION (BEST APPROACH) USING MULTIDIMENTION ARRAY(DP) <-################
    public static int optimizedMemRecursionDP(String exp, int i, int j, boolean isTrue, int[][][] mem) {
        if(i > j)
            return 0;
        if(i == j) {
            if(isTrue)
                return exp.charAt(i) == 'T' ? 1 : 0;
            else 
                return exp.charAt(i) == 'F' ? 1 : 0;
        }
        if(mem[i][j][isTrue ? 1 : 0] != -1)
            return mem[i][j][isTrue ? 1 : 0];
        int ans = 0;
        for(int k=i+1;k<j;k+=2) {
            int lt, lf, rt, rf;
            if(mem[i][k-1][1] != -1)
                lt = mem[i][k-1][1];
            else 
                lt = optimizedMemRecursionDP(exp, i, k-1, true, mem);
            if(mem[i][k-1][0] != -1)
                lf = mem[i][k-1][0];
            else 
                lf = optimizedMemRecursionDP(exp, i, k-1, false, mem);
            if(mem[k+1][j][1] != -1)
                rt = mem[k+1][j][1];
            else 
                rt = optimizedMemRecursionDP(exp, k+1, j, true, mem);
            if(mem[k+1][j][0] != -1)
                rf = mem[k+1][j][0];
            else 
                rf = optimizedMemRecursionDP(exp, k+1, j, false, mem);
            char opt = exp.charAt(k);
            if(opt == '^') {
                if(isTrue)
                    ans += (lt*rf + lf*rt);
                else 
                    ans += (lt*rt + lf*rf);
            }
            if(opt == '&') {
                if(isTrue) 
                    ans += (lt*rt);
                else 
                    ans += (lt*rf + lf*rt + lf*rf);
            }
            if(opt == '|') {
                if(isTrue)
                    ans += (lt*rf + lt*rt + lf*rt);
                else 
                    ans += (lf*rf);
            }
        }
        return mem[i][j][isTrue?1:0] = ans;
    }
    public static int optimizedMemoizedDPArray(String exp, int n) {
        int[][][] mem = new int[n+1][n+1][2]; // 3D-Array to store i, j, isTrue(as these three are variable parameters);
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        return optimizedMemRecursionDP(exp, 0, n-1, true, mem);
    }
    public static void main(String[] args) {
        String exp = "T^F&T";
        // OUTPUT : 2    **[((T^F)&T)  and  (T^(F&T)) these two are the answer of this above expressing which return true]
        // String exp = "T|F&T^F";
        // System.out.println(recursive(exp, 0, exp.length()-1, true));
        // System.out.println(memoization(exp, exp.length()));
        // System.out.println(optimizedMemoizationMap(exp, exp.length()));
        System.out.println(optimizedMemoizedDPArray(exp, exp.length()));
    }
}
