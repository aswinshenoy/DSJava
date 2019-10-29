
## AVL Tree
```java
public AVLNode rotateWithLeftChild() {
    AVLNode lc = left;
    left = lc.right;
    lc.right = this;
    return lc;
}

public AVLNode rotateWithRightChild() {
    AVLNode rc = right;
    right = rc.left;
    rc.left = this;
    return rc;
}
```

```java
public AVLNode insert(int key) {
    ....
    ....
    ....

    balanceFactor = computeBalance();
    switch(balanceFactor) {
        case 2: //left
            if (left.balanceFactor == -1)
            {
                left = left.rotateWithRightChild();
                return rotateWithLeftChild();
            }
            else return rotateWithLeftChild();

        case -2: //right
            if (right.balanceFactor == 1)
            {
                right = right.rotateWithLeftChild();
                return rotateWithRightChild();
            }
            else return rotateWithRightChild();

    }
    return this;
}

```

## Min Heap

- **Right Child** - (2*index)+2
- **Parent** - (index-1)/2)
- **Left Child** - (2*index)+1

- All nodes >= (n-1)/2 are leafs
- index (n-1)/2 may have left child only if n is even.

```java
private void fixHeap(int i)
{
    //if no child exists i.e. leaf, no need to fix
    if(!isLeaf(i))
        // if both children exists
        if(getRightChild(i) != -1 && getLeftChild(i) != -1)
            if(arr[i] > arr[getLeftChild(i)] || arr[i] > arr[getRightChild(i)])
            {
                if (arr[getLeftChild(i)] < arr[getRightChild(i)])
                {
                    swap(i,getLeftChild(i));
                    fixHeap(getLeftChild(i));
                }
                else
                {
                    swap(i,getRightChild(i));
                    fixHeap(getRightChild(i));
                }
            }
        //if right doesn't exist (there is no case where left doesnt exist, but right exists)
        else if(getRightChild(i) == -1 && arr[i] > arr[getLeftChild(i)])
        {
            swap(i,getLeftChild(i));
            fixHeap(getLeftChild(i));
        }
}
```

```java
public void buildHeap()
{
    for(int i=(size-2)/2; i>=0; i--)
        fixHeap(i);
}
```

## Graph

### DFS
```java
public int dfs(int visitCount) {
    System.out.print(label + " ");
    visited = true;

    for (int j=0; j<adjList.size(); j++)
        if ( !adjList.get(j).visited )
           adjList.get(j).dfs();

    return visitCount;
}
```

```java
public void dfs() {
    for(int i=0; i<size; i++) {
        if (!node[i].visited )
           node[i].dfs(++visitCount);
    }
    System.out.println();
}
```

### BFS
```java 
public void bfs() {
    ArrayDeque<GraphNode> q = new ArrayDeque<GraphNode>();
    for (int i=0; i<size; i++)
        if ( !node[i].visited ){
            q.add(node[i]);
            node[i].visited = true;

            while ( !q.isEmpty() ) {
                GraphNode curr = q.remove();
                System.out.print(curr.label + " ");

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
```

## Disjoint Set

```java
public DSNode getRoot() {
    if (parent == null)
        return this;
    else
        return parent.getRoot();
}
```

```java
public void union(int parent, int child) {
    DSNode p = findParent(parent);
    DSNode c = findParent(child);
    if ( p != c )
        c.parent = p;
}
```

## Hash Table

```java
int hash(int x) { return (x*x*x + 3*x*x + 1) % nodes.length; }
```

```java
public void put(int key, int value) {
    int index = hash(key);
    HashNode node = new HashNode(key,value);
    if(nodes[index] == null)
        nodes[index] = new LinkedList<>();
    nodes[index].add(node);
}
```

```java
public int get(int key) {
    LinkedList<HashNode> list = nodes[hash(key)];
    if(list != null)
        for(int i=0; i<list.size(); i++)
            if(list.get(i).key == key)
                return list.get(i).value;
    return Integer.MAX_VALUE;
}
```