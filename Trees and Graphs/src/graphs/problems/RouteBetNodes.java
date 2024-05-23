package graphs.problems;

import java.util.LinkedList;
import java.util.Queue;

//4.1
public class RouteBetNodes {

    public static void main(String []args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;

        u = 3;
        v = 1;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
    }
}

class Graph{
    int V;
    LinkedList<Integer> adj[];
    public Graph(int v){
        this.V = v;
        adj = new LinkedList[V];
        for(int i = 0 ; i < V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v){
        adj[u].add(v);
    }

    boolean isReachable(int s, int t){
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];
        queue.add(s);
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int v : adj[current]){
                if(v == t)
                    return true;
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return false;
    }
}