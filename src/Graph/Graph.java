package Graph;

import java.util.ArrayDeque;

public class Graph {
    GraphNode[] node;
    int size;

    public Graph(int n) {
        size = n;
        node = new GraphNode[size];
        for (int i=0; i<size; i++)
            node[i] = new GraphNode(i);
    }

    public void addEdge(int from, int to) {
        node[from].adjList.add(node[to]);
    }

    public void printAdjList() {
        for (int i=0; i<size; i++)
            node[i].printAdjList();
    }

    public void reset() {
        for (int i=0; i<size; i++)
            node[i].visited = false;
    }

    public void dfs() {
        for(int i=0; i<size; i++) {
            if (!node[i].visited )
                node[i].dfs();
        }
        System.out.println();
    }

    public void bfs() {
        ArrayDeque<GraphNode> q = new ArrayDeque<GraphNode>();
        for (int i=0; i<size; i++)
            if ( !node[i].visited ){
                q.add(node[i]);
                node[i].visited = true;
                node[i].bfs(q);
            }

    }
}
