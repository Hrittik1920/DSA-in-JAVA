import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s,int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
    }

    public static void topSort(ArrayList<Edge> graph[],boolean visited[],int curr,Stack<Integer> s) {
        visited[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {
                topSort(graph, visited, e.dest, s);
            }
        }

        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[],boolean visited[],int curr) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {
                dfs(graph, visited, e.dest);
            }
        }
    }

    //Total Time Complexity - O(V + E)
    public static void kosarajuAlgo(ArrayList<Edge> graph[],int V) {
        //Step 1  -  O(V + E)
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                topSort(graph, visited, i, s);
            }
        }

        //Step 2  -  O(V + V)
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0;i<graph.length;i++) {
            visited[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<V;i++) {
            for(int j=0;j<graph[i].size();j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }

        //Step 3  -  O(V + E)
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!visited[curr]) {
                dfs(transpose, visited, curr);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        kosarajuAlgo(graph, v);
    }
}
