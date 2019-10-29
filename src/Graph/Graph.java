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
        int visitCount = 0;
        for(int i=0; i<size; i++) {
            if (!node[i].visited )
                visitCount = node[i].dfs(++visitCount);
        }
        System.out.println();
    }

    public void bfs() {
        ArrayDeque<GraphNode> q = new ArrayDeque<GraphNode>();

        //for each node of the graph, for unrelated graphs
        for (int i=0; i<size; i++)

            //check if node is visited earlier
            if ( !node[i].visited ){

                //add to queue if not visited, and mark it visited
                q.add(node[i]);
                node[i].visited = true;

                while ( !q.isEmpty() ) {
                    //dequeue a node
                    GraphNode curr = q.remove();

                    // print that node
                    System.out.print(curr.label + " ");

                    //queue unvisited nodes in adjList of that node, and mark them visited
                    for (int j=0; j<curr.adjList.size(); j++) {
                        GraphNode y = curr.adjList.get(j);
                        if ( !y.visited ) {
                            q.add(y);
                            y.visited = true;
                        }
                    }
                }

            }
    }

    public void printOrder() {
        for (int i=0; i<size; i++)
            System.out.println(node[i].label + " - " + node[i].preorder);
        System.out.println();
    }
}
