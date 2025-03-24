import java.util.HashMap;
import java.util.Map;

public class _4_Scrambled_String {
    // CONSTRAINS : 1) Should for a binary tree (means recursize call should break in two);
    //              2) Child of binary tree should not contain empty string 
    // SO WE CAN SWAP THE CHILD NODE(gr, eat) -> (eat, gr) AND SUM UP TO PARENT NODE AS (eatgt)
    //                 great                      |                                rgeta
    //                  / \                       |                                 / \
    //                 /   \                      |                                /   \
    //                gr   eat                    |    concate(gr) -> rg          rg   eta      concate(eat) -> (eta) 
    //               / \   / \                    |                              / \   / \
    //              g   r e   at                  |    swap(g, r) -> (r, g)     r   g  e  ta      concate(at) -> (ta)
    //                        / \                 |                                      / \
    //                       a   t                |                                     t   a    swap(a, t) -> (t, a)
    // ####################-> RECURSIVE APPROACH <-#########################
    public static boolean recursive(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        if(s1.compareTo(s2) == 0)
            return true;
        if(s1.length() <= 1)
            return false;
        int n = s1.length();
        for(int i=1;i<n;i++) {
            // CONDITONS : swap condition recursion(great, eatgr)  || without swap recursion(great, great);
            if((recursive(s1.substring(0, i), s2.substring(n-i)) && (recursive(s1.substring(i), s2.substring(0, n-i))))
                || (recursive(s1.substring(0, i), s2.substring(0, i)) && recursive(s1.substring(i), s2.substring(i))))  {
                    return true;
                }
        }
        return false;
    }
    
    // ##################-> MEMOIZATION (BOTTOM-UP APPROACH) <-#####################
    public static boolean memoizedRecursive(String s1, String s2, Map<String, Boolean> map)  {
        if(s1.compareTo(s2) == 0) 
            return true;
        if(s1.length() <= 1) 
            return false;
        String key = s1 + " " + s2;
        int n = s1.length();
        if(map.containsKey(key)) 
            return map.get(key);
        for(int i=1;i<n;i++) {
            if((memoizedRecursive(s1.substring(0, 1), s2.substring(n-i), map) && memoizedRecursive(s1.substring(i), s2.substring(0, n-i), map))
                || (memoizedRecursive(s1.substring(0,i), s2.substring(0, i), map) && memoizedRecursive(s1.substring(i), s2.substring(i), map))) {
                    map.put(key, true);
                    return true;
                }
        }
        map.put(key, false);
        return false;
    }
    public static boolean memoization(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        Map<String, Boolean> map = new HashMap<>();
        return memoizedRecursive(s1, s2, map);
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
    public static boolean optimizedMemRecursion(String s1, String s2, Map<String, Boolean> map) {
        if(s1.compareTo(s2) == 0)
            return true;
        if(s1.length() <= 1)
            return false;
        String key = s1 + " " + s2;
        if(map.containsKey(key))
            return map.get(key);
        int n = s1.length();
        for(int i=1;i<n;i++) {
            boolean swapfirst, swapsec, first, second;
            String sfp1 = s1.substring(0, i);
            String sfp2 = s2.substring(n-i);
            if(map.containsKey(sfp1 + " " + sfp2)) {
                swapfirst = map.get(sfp1 + " " + sfp2);
            } else {
                swapfirst = optimizedMemRecursion(sfp1, sfp2, map);
            }
            String ssp1 = s1.substring(i);
            String ssp2 = s2.substring(0,n-i);
            if(map.containsKey(ssp1 + " " + ssp2)) {
                swapsec = map.get(ssp1 + " " + ssp2);
            } else {
                swapsec = optimizedMemRecursion(ssp1, ssp2, map);
            }
            String fp1 = s1.substring(0, i);
            String fp2 = s2.substring(0, i);
            if(map.containsKey(fp1 + " " + fp2)) {
                first = map.get(fp1 + " " + fp2);
            } else {
                first = optimizedMemRecursion(fp1, fp2, map);
            }
            String sp1 = s1.substring(i);
            String sp2 = s2.substring(i);
            if(map.containsKey(sp1 + " " + sp2)) {
                second = map.get(sp1 + " " + sp2);
            } else {
                second = optimizedMemRecursion(sp1, sp2, map);
            }
            if((swapfirst && swapsec) || (first && second)) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
    public static boolean optimizedMemoization(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        Map<String, Boolean> map = new HashMap<>();
        return optimizedMemRecursion(s1, s2, map);
    }
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgaet";
        // System.out.println(recursive(s1, s2));
        // System.out.println(memoization(s1, s2));
        System.out.println(optimizedMemoization(s1, s2));
    }
}
