import java.util.ArrayList;

public class FloydWarshall {
    public static class Edge {
        int src, desc, wt;
        public Edge(int src, int desc, int wt) {
            this.src = src;
            this.desc = desc;
            this.wt = wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 3, 7));

        graph[1].add(new Edge(1, 0, 8));
        graph[1].add(new Edge(1, 2, 2));

        graph[2].add(new Edge(2, 0, 5));
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 0, 2));
    }
    public static int[][] createDistMatrix(ArrayList<Edge> graph[], int v) {
        int[][] distMatrix = new int[v][v];
        for(int i=0;i<v;i++) {
            for(int j=0;j<v;j++) {
                if(i != j) 
                    distMatrix[i][j] = 999999;
            }
        }
        for(int i=0;i<v;i++) {
            for(int j=0;j<graph[i].size();j++) {
                Edge e = graph[i].get(j);
                distMatrix[i][e.desc] = e.wt;
            }
        }
        return distMatrix;
    }
    // Time Complexity - O(n^3);
    public static void floydWarshallAlgorithm(int[][] distMatrix, int v) {
        for(int k=0;k<v;k++) {
            for(int i=0;i<v;i++) {
                if(i == k) continue;
                for(int j=0;j<v;j++) {
                    if(j == k || i == j) continue;
                    distMatrix[i][j] = Math.min(distMatrix[i][j], distMatrix[i][k] + distMatrix[k][j]);
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        int[][] distMatrix = createDistMatrix(graph, v);
        for(int i=0;i<v;i++) {
            for(int j=0;j<v;j++) {
                System.out.print(distMatrix[i][j] + " ");
            }
            System.out.println();
        }
        floydWarshallAlgorithm(distMatrix, v);
        for(int i=0;i<v;i++) {
            for(int j=0;j<v;j++) {
                System.out.print(distMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
