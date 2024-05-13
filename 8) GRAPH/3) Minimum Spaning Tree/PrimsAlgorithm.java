import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        public Edge(int s,int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int cost;
        int par;

        public Pair(int n,int c,int p) {
            this.node = n;
            this.cost = c;
            this.par = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    // Time Complexity - O(ElogE)
    public static void pirmsAlgo(ArrayList<Edge> graph[],int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // Non - MST set #*  In worst Case queue will store E edges
                                                                    // So sortiog time will go to ElogE in PriorityQueue 
        boolean visited[] = new boolean[V]; // MST set
        pq.add(new Pair(0,0,-1));

        ArrayList<Edge> path = new ArrayList<>();
        int mstCost = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!visited[curr.node]) {
                visited[curr.node] = true;
                mstCost += curr.cost;
                if(curr.node != 0) {
                    path.add(new Edge(curr.par,curr.node));
                }

                for(int i=0;i<graph[curr.node].size();i++) {
                    Edge e = graph[curr.node].get(i);
                    if(!visited[e.dest]) {
                        pq.add(new Pair(e.dest,e.wt,curr.node));
                    }
                }
            }
        }

        for(int i=0;i<path.size();i++) {
            Edge e = path.get(i);
            System.out.println("Edge " + (i+1) + ": " + e.src + ", " + e.dest );
        }

        System.out.println("Minimum Cost : " + mstCost);
    }

    public static void main(String[] args) {
        int v = 4;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        pirmsAlgo(graph, v);
    }
}
