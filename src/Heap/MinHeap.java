package Heap;

public class MinHeap {
    int[] arr;
    int size;

    public MinHeap(int[] a)
    {
        arr = a;
        size = a.length;
    }

    public int get(int index) { return arr[index]; }

    public boolean isLeaf(int index) {
        if(index >= (size/2) && index < size)
            return true;
        return false;
    }

    public int getParent(int index) {
        //if(index==0) return 0;
        return (index-1)/2;
    }

    public int getLeftChild(int index) {
        if ( (2*index)+1 < size )
            return (2*index)+1;
        return -1;
    }

    public int getRightChild(int index) {
        if ( (2*index)+2 < size )
            return (2*index)+2;
        return -1;
    }


    public void swap(int p1, int p2)
    {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

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

    public void buildHeap()
    {
        for(int i=(size-2)/2; i>=0; i--)
            fixHeap(i);
    }

    public int extractMin() {
        int val = arr[0];
        arr[0] = arr[size-1];
        size--;
        fixHeap(0);
        return val;
    }

    public void print() {
        System.out.print(arr[0]);
        for (int i=1; i<size; i++)
            System.out.print(" " + arr[i]);
        System.out.println();
    }
}
