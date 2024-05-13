import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static class Edge {
        int scr;
        int dest;

        public Edge(int s,int d) {
            this.scr = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void topSortUtil(ArrayList<Edge> graph[],boolean visited[],int curr,Stack<Integer> s) {
        visited[curr] = true;
        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {
                topSortUtil(graph, visited, e.dest, s);
            }
        }
        s.push(curr);
    }

    public static void topSort(ArrayList<Edge> graph[],int v) {
        boolean visited[] = new boolean[v];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<visited.length;i++) {
            if(!visited[i]) {
                topSortUtil(graph, visited, i, s);
            }
        }

        System.out.println("Topologically Sorted Order of Graph: ");
        while(!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        topSort(graph, v);
    }
}
