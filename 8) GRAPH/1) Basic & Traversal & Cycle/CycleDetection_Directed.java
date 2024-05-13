import java.util.ArrayList;

public class CycleDetection_Directed {
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

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        // graph[3].add(new Edge(3,0));
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[],boolean visited[],int curr,boolean rec[]) {
        visited[curr] = true;
        rec[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(rec[e.dest]) {
                return true;
            }
            else if(!visited[e.dest]  && isCycleDirected(graph, visited, e.dest, rec)) {
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        boolean visited[] = new boolean[v];
        boolean rec[] = new boolean[v];
        for(int i=0;i<visited.length;i++) {
            if(!visited[i]) {
                System.out.println(isCycleDirected(graph, visited, i, rec));
            }
            if(isCycleDirected(graph, visited, i, rec)) {
                break;
            }
        }
    }
}
