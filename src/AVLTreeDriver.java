import AVLTree.AVLTree;

import java.util.Random;

public class AVLTreeDriver {
    public static void main(String[] args)
    {
        AVLTree avl = new AVLTree();
        int[] arr = new int[10];
        Random r = new Random();

        System.out.print("Insertion sequence: ");
        for (int i=0; i<10; i++) {
            arr[i] = r.nextInt(100);
            System.out.print(arr[i] + " ");
            avl.insert( arr[i] );
        }
        System.out.println();
        System.out.print("preorder: "); avl.preorder();
        System.out.print("inorder: "); avl.inorder();
        System.out.print("postorder: "); avl.postorder();

        System.out.println("height: " + avl.root.height());
    }
}
