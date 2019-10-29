import Heap.MinHeap;

import java.util.Random;

public class MinHeapDriver {
    public static void main(String[] args){
        Random r = new Random();
        int size = r.nextInt(100)+1;
        int[] keys = new int[size];

        for(int i=0; i<size; i++)
            keys[i] = r.nextInt(100);

        MinHeap m = new MinHeap(keys);

        m.print();
        m.buildHeap();
        m.print();
        System.out.println(m.extractMin());
        System.out.println(m.extractMin());
        size-=2;
        m.print();

        for (int i=0; i<=(size-2)/2; i++)
            if ( m.getRightChild(i) != -1 )
                if ( m.get(i) > m.get(m.getLeftChild(i)) || m.get(i) > m.get(m.getRightChild(i)) ) {
                    System.out.println("Test failed");
                    return;
                }
            else
                if ( m.get(i) > m.get(m.getLeftChild(i)) ) {
                    System.out.println("Test failed");
                    return;
                }
        System.out.println("Test passed");

    }



}
