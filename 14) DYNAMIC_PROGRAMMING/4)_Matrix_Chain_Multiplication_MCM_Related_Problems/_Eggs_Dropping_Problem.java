import java.util.Arrays;

public class _Eggs_Dropping_Problem {
    // WE HAVE TO FIND IN HOW MANY MINIMUM NUMBERS OF CHECKS WE CAN FIND THREASOLD FLOOR ABOVE WHICH EGG WILL BE GET BREAK IF ITS THROUGH FROM THAT FLOOR
    // **IN SIMPLE WORDS: MINIMUM NUMBER OF TIME WE DO SAME PROCESS TO GET THE THRESHOLD FLOOR
    // ####################-> RECURSIVE APPROACH <-#########################
    public static int minCheckToFindThresholdFloorRecursive(int eges, int floors) {
        if(floors == 0 || floors == 1 || eges == 1)
            return floors;
        int min = Integer.MAX_VALUE;
        for(int k=1;k<=floors;k++) {
            int temp = 1 + Math.max(minCheckToFindThresholdFloorRecursive(eges-1, k-1), minCheckToFindThresholdFloorRecursive(eges, floors-k));
            min = Math.min(min, temp);
        }
        return min;
    }

    // ##################-> MEMOIZATION (BOTTOM-UP APPROACH) <-#####################
    public static int memoizedRecursion(int eges, int floors, int[][] mem) {
        if(floors == 0 || floors == 1 || eges == 1)
            return floors;
        if(mem[eges][floors] != -1)
            return mem[eges][floors];
        int min = Integer.MAX_VALUE;
        for(int k=1;k<=floors;k++) {
            int temp = 1 + Math.max(memoizedRecursion(eges-1, k-1, mem), memoizedRecursion(eges, floors-k, mem));
            min = Math.min(min, temp);
        }
        return mem[eges][floors] = min;
    } 
    public static int memoization(int eges, int floors) {
        int[][] mem = new int[eges+1][floors+1];
        for(int i=0;i<=eges;i++) 
            Arrays.fill(mem[i], -1);
        return memoizedRecursion(eges, floors, mem);
    }

    // ####################-> OPTIMIZED MEMOIZATION (BEST APPROACH) USING MAP <-################
    // # Time Complexity Improvement (O(n^3) ⮕ O(n^2))
    //     - The first approach makes redundant recursive calls, leading to unnecessary computations.
    //     - The optimized approach checks if a subproblem is already solved before making a recursive call, reducing redundant calculations.
    //     - This cuts down unnecessary function calls, making the solution closer to O(n^2) instead of O(n^3).

    // # Space Complexity Improvement (O(n^2) stack ⮕ O(n^2) table only)
    //     - Both approaches use O(n^2) memoization table.
    //     - However, the first approach stores extra recursive stack frames, leading to O(n) additional stack space in the worst case.
    //     - The optimized approach reduces recursion depth, leading to a shallower call stack and reducing overall auxiliary space usage.m
    public static int optimizedMemRecursion(int eges, int floors, int[][] mem) {
        if(floors == 0  ||  floors == 1  ||  eges == 1)
            return floors;
        if(mem[eges][floors] != -1)
            return mem[eges][floors];
        int min = Integer.MAX_VALUE;
        for(int k=1;k<=floors;k++) {
            int lowFloor, highFloor;
            if(mem[eges-1][k-1] != -1)
                lowFloor = mem[eges-1][k-1];
            else 
                lowFloor = optimizedMemRecursion(eges-1, k-1, mem);
            
            if(mem[eges][floors-k] != -1)
                highFloor = mem[eges][floors-k];
            else 
                highFloor = optimizedMemRecursion(eges, floors-k, mem);
            int temp = 1 + Math.max(lowFloor, highFloor);
            min = Math.min(min, temp);
        }
        return mem[eges][floors] = min;
    }
    public static int optimizedMemoization(int eges, int floors) {
        int[][] mem = new int[eges+1][floors+1];
        for(int i=0;i<=eges;i++) 
            Arrays.fill(mem[i], -1);
        return optimizedMemRecursion(eges, floors, mem);
    }
    public static void main(String[] args) {
        int eges = 3;
        int floors = 5;
        // OUTPUT : 3
        // System.out.println(minCheckToFindThresholdFloorRecursive(eges, floors));
        // System.out.println(memoization(eges, floors));
        System.out.println(optimizedMemoization(eges, floors));
    }
}
