import BST.BST;

import java.util.Random;

public class BSTDriver {
    public static void main(String[] args)
    {
        BST bst = new BST();
        int[] arr = new int[10];
        Random r = new Random();

        System.out.print("Insertion sequence: ");
        for (int i=0; i<10; i++) {
            arr[i] = r.nextInt(100);
            System.out.print(arr[i] + " ");
            bst.insert( arr[i] );
        }
        System.out.println();
        System.out.print("preorder: "); bst.preorder();
        System.out.print("inorder: "); bst.inorder();
        System.out.print("postorder: "); bst.postorder();
        System.out.print("levelorder: "); bst.levelorder();


    }
}
