package HashTable;

import java.util.LinkedList;

public class HashTable {
    LinkedList<HashNode>[] nodes;

    public HashTable(int size) {
        nodes = new LinkedList[size];
    }

    int hash(int x) { return (x*x*x + 3*x*x + 1) % nodes.length; }

    public void put(int key, int value) {
        int index = hash(key);
        HashNode node = new HashNode(key,value);
        if(nodes[index] == null)
            nodes[index] = new LinkedList<>();
        nodes[index].add(node);
    }

    public int get(int key) {
        LinkedList<HashNode> list = nodes[hash(key)];
        if(list != null)
            for(int i=0; i<list.size(); i++)
                if(list.get(i).key == key)
                    return list.get(i).value;
        return Integer.MAX_VALUE;
    }

    public boolean contains(int key) {
        LinkedList<HashNode> list = nodes[hash(key)];
        if ( list != null )
            for (int i=0; i<list.size(); i++)
                if (list.get(i).key == key)
                    return true;
        return false;
    }

    public void remove(int key) {
        LinkedList<HashNode> list = nodes[hash(key)];
        if( list != null)
            for(int i=0; i<list.size(); i++)
                if(list.get(i).key == key)
                    list.remove(i);
    }

    public void print() {
        for(int i = 0; i < nodes.length; i++)
            if(nodes[i] != null)
                for(int j=0; j< nodes[i].size(); j++)
                System.out.println("["+nodes[i].get(j).key+","+nodes[i].get(j).value+"] @ " + hash(nodes[i].get(j).key));
    }
}
