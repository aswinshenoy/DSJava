import DisjointSet.DisjointSet;

public class DisjointSetDriver {
    public static void main(String[] args) {
        DisjointSet d = new DisjointSet(10);
        for (int i=0; i<10; i++)
            d.makeSet(i);
        d.print();
        d.union(0,1);
        d.union(1,2);
        d.union(6,3);
        d.print();
    }
}
