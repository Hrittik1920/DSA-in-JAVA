public class MultiStageGraph {
    // work for directed graph only
    // Time complexity - O(n^2)
    public static void main(String[] args) {
        int stages = 4, n = 8, min;
        int[] cost = new int[n+1];
        int[] d = new int[n+1]; // destination of each node to next node
        int[] path = new int[stages+1];
        int[][] c = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 2, 1, 3, 0, 0, 0, 0}, 
                     {0, 0, 0, 0, 0, 2, 3, 0, 0}, 
                     {0, 0, 0, 0, 0, 6, 7, 0, 0},
                     {0, 0, 0, 0, 0, 0, 8, 9, 0}, 
                     {0, 0, 0, 0, 0, 0, 0, 0, 6},
                     {0, 0, 0, 0, 0, 0, 0, 0, 4},
                     {0, 0, 0, 0, 0, 0, 0, 0, 5},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        cost[n] = 0;
        for(int i=n-1;i>=1;i--) {
            min = Integer.MAX_VALUE;
            for(int k=i+1;k<=n;k++) {
                if(c[i][k] != 0 && c[i][k] + cost[k] < min) {
                    min = c[i][k] + cost[k];
                    d[i] = k;
                }
            }
            cost[i] = min;
        }
        path[1] = 1;
        path[stages] = n;
        for(int i=2;i<stages;i++) {
            path[i] = d[path[i-1]];
        }
        System.out.println("MultiStage Path is : ");
        for(int i=1;i<=stages;i++) {
            System.out.print(path[i]);
            if(i != stages) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
