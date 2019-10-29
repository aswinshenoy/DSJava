package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class GraphNode {
    int label;
    boolean visited;
    ArrayList<GraphNode> adjList;
    int preorder;


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

    public int dfs(int visitCount) {
        System.out.print(label + " ");
        visited = true;

        preorder = visitCount;

        for (int j=0; j<adjList.size(); j++)
            if ( !adjList.get(j).visited )
               visitCount = adjList.get(j).dfs(++visitCount);

        return visitCount;
    }

}
