import java.util.ArrayList;

public class ArticulationPoint {
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

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        // graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        // graph[4].add(new Edge(4,5));

        // graph[5].add(new Edge(5,3));
        // graph[5].add(new Edge(5,4));
    }

    // BackEdge - if u feel v is the child,but v is already get visited and it is become it's ancestor then this is the condition for backedge
    /* 
     *  Condition for Articulation Point
     *  1) Node == Corner Node(means par = -1(node is the start of DFS))  && *disconected childrens(unvisited nodes) > 1
     *  2) if u is the node node to v and u form a cycle through v ( par != -1)
     */
    // Tarjan's Algorithm(dfs)  # Time Complexity - O(V + E)
    public static void dfs(ArrayList<Edge> graph[],int curr,int par,int dt[],int low[],boolean vis[],int time,boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh) {
                continue;
            } else if(vis[neigh]) {
                low[curr] = Math.min(low[curr],dt[neigh]);
            } else {
                dfs(graph, neigh, curr, dt, low, vis, time, ap);
                low[curr] = Math.min(low[curr],low[neigh]);
                
                if(dt[curr] <= low[neigh]  &&  par != -1) {
                    ap[curr] = true;
                }
                children++;
            }
        }

        if(par == -1  &&  children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[],int V) {
        int dt[] = new int[V]; // discovery time
        int low[] = new int[V]; // Lowest discovery time - amongs neighbours and current node
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                dfs(graph,i,-1,dt,low,vis,time,ap);
            }
        }

        for(int i=0;i<V;i++) {
            if(ap[i]) {
                System.out.println("AP : " + i);
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        getAP(graph, v);
    }
}
