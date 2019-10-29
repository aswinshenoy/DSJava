package DisjointSet;

public class DSNode {
    int label;
    DSNode parent;

    public DSNode(int l) {
        label = l;
    }

    public DSNode getRoot() {
        if (parent == null)
            return this;
        else
            return parent.getRoot();
    }
}
