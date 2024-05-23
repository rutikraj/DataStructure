package graphs.dfs_bfs;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {

    private int V;
    private LinkedList<Integer> adj[];

    BFSGraph(int v){
        this.V = v;
        adj = new LinkedList[V];
        for(int i =0; i < V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v){
        adj[u].add(v);
    }

    void BFS(int v){
        boolean visited[] = new boolean[V];
        BSFUtils(v, visited);
    }

    private void BSFUtils(int v, boolean[] visited) {
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()){
            int q = queue.poll();
            System.out.print(q + " ");
            Iterator<Integer> iterator = adj[q].listIterator();
            while (iterator.hasNext()){
                int value = iterator.next();
                if(!visited[value]){
                    visited[value] = true;
                    queue.add(value);
                }
            }
        }
    }
    public static void main(String []args){

        BFSGraph g = new BFSGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");
        g.BFS(2);

    }
}
