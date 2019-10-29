package DisjointSet;

public class DisjointSet {
    DSNode[] node;
    int size;

    public DisjointSet(int n) {
        size = n;
        node = new DSNode[size];
    }

    public void makeSet(int index) {
        node[index] = new DSNode(index);
    }

    public DSNode findParent(int key) {
        return node[key].getRoot();
    }

    public void union(int parent, int child) {
        DSNode p = findParent(parent);
        DSNode c = findParent(child);
        if ( p != c )
            c.parent = p;
    }

    public void print() {
        for(int i=0; i<size; i++)
            System.out.print("(" + i + "," + findParent(i).label + ") ");
        System.out.println();
    }

}
