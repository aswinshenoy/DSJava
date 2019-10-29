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

    private int checkHeap(int i)
    {
        if(!isLeaf(i))

            if(getRightChild(i) != -1 && getLeftChild(i) != -1)
                if(arr[i] > arr[getLeftChild(i)] || arr[i] > arr[getRightChild(i)])
                {
                    if (arr[getLeftChild(i)] < arr[getRightChild(i)])
                        return getLeftChild(i);
                    else
                        return getRightChild(i);
                }

            else if(getRightChild(i) == -1 && arr[i] > arr[getLeftChild(i)])
                return getLeftChild(i);

        return i;
    }

    public void fixHeap(int index)
    {
        int j = checkHeap(index);
        if(j==index) return;
        else {
            swap(index,j);
            fixHeap(j);
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
