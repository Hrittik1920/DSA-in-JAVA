import java.util.ArrayList;

public class Practice {
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
 
    public static void dfs(ArrayList<Edge> graph[],boolean ap[],int dt[],int low[],boolean vis[],int time,int curr,int par) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(curr == par) {
                continue;
            } else if(vis[e.dest]) {
                low[curr] = Math.min(low[curr],dt[e.dest]);
            } else {
                dfs(graph, ap, dt, low, vis, time, e.dest, curr);
                low[curr] = Math.min(low[curr],low[e.dest]);

                if(dt[curr] <= low[e.dest]  && par != -1) {
                    ap[curr] = true;
                }
            }
            children++;
        }

        if(par == -1  &&  children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[],int v) {
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean vis[] = new boolean[v];
        boolean ap[] = new boolean[v];
        int time=0;
        for(int i=0;i<v;i++) {
            if(!vis[i]) {
                dfs(graph,ap, dt, low, vis, time, i,-1);
            }
        }
        
        for(int i=0,j=1;i<v;i++) {
            if(ap[i]) {
                System.out.println("AP " + j + " : " + i);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;

        ArrayList<Edge> graph[] =new ArrayList[v];
        createGraph(graph);

        getAP(graph, v);
    }
}
