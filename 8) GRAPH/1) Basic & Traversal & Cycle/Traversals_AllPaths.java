import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Traversals_AllPaths {
    static class Edge {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void bfs(ArrayList<Edge> graph[],boolean visited[],int node) { // O(V + E)
        Queue<Integer> q = new LinkedList<>();

        q.add(node);

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(visited[curr] == false) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i=0;i<graph[curr].size();i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[],boolean visited[],int curr) { // O(V + E)
        if(visited[curr] == false) {
            System.out.print(curr + " ");
            visited[curr] = true;
            for(int i=0;i<graph[curr].size();i++) {
                Edge e = graph[curr].get(i);
                dfs(graph,visited,e.dest);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[],boolean visited[],int curr,String path,int tar) {
        if(curr == tar) {
            System.out.println(path);
            return;
        }

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {
                visited[curr] = true;
                printAllPath(graph, visited, e.dest, path +" -> "+e.dest, tar);
                visited[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        int v = 7;

        /*
                1 --- 3
               /      | \
              0       |  5 --- 6
               \      | /
                2 --- 4  
        */

        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        boolean[] visited = new boolean[v];
        for(int i=0;i<visited.length;i++) {
            bfs(graph,visited,i);
        }
        System.out.println();
        
        Arrays.fill(visited,Boolean.FALSE);

        for(int i=0;i<visited.length;i++) {
            dfs(graph,visited,i);
        }
        System.out.println();

        Arrays.fill(visited,Boolean.FALSE);

    
        printAllPath(graph, visited, 0,"0", 5);
            
    }
}
