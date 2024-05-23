package graphs.dfs_bfs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {

    private int V;

    LinkedList<Integer> []adj;

    DFSGraph(int v){
        this.V = v;
        adj = new LinkedList[V];

        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int s, int t){
        adj[s].add(t);
    }

    void DFS(int i){
        boolean visited[] = new boolean[V];
        DFSUtils(i, visited);
    }

    private void DFSUtils(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> iterator = adj[v].listIterator();

        while(iterator.hasNext()){
            int nxt = iterator.next();
            if(!visited[nxt]){
                DFSUtils(nxt, visited);
            }
        }

    }

    public static void main(String []args){

        DFSGraph g = new DFSGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");
        g.DFS(2);

    }
}
