package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class GraphNode {
    int label;
    boolean visited;
    ArrayList<GraphNode> adjList;

    GraphNode(int l) {
        label = l;
        visited = false;
        adjList = new ArrayList<GraphNode>();
    }

    public void printAdjList() {
        System.out.print(label + " : ");
        for (int j=0; j<adjList.size(); j++)
            System.out.print(adjList.get(j).label + "->");
        System.out.println();
    }

    public void dfs() {
        System.out.print(label + " ");
        visited = true;

        for (int j=0; j<adjList.size(); j++) {
            if ( !adjList.get(j).visited )
                adjList.get(j).dfs();
        }
    }

    public void bfs(ArrayDeque<GraphNode> q) {
        while ( !q.isEmpty() ) {
            GraphNode x = q.remove();
            System.out.print(x.label + " ");
            for (int j=0; j<x.adjList.size(); j++) {
                GraphNode y = x.adjList.get(j);
                if ( !y.visited ) {
                    q.add(y);
                    y.visited = true;
                }
            }
        }
    }
}
