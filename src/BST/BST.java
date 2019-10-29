package BST;

import java.util.ArrayDeque;

public class BST {
    BSTNode root;

    public void insert(int key) {
        if (root == null)
            root = new BSTNode(key);
        else
            root.insert(key);
    }

    public boolean search(int key) {
        if (root == null)
            return false;
        else
            return root.search(key);
    }

    public void inorder() {
        if (root == null)
            return;
        else
            root.inorder();
        System.out.println();
    }

    public void preorder() {
        if (root == null)
            return;
        else
            root.preorder();
        System.out.println();
    }

    public void postorder() {
        if (root == null)
            return;
        else
            root.postorder();
        System.out.println();
    }

    public void levelorder() {
        ArrayDeque<BSTNode> deq = new ArrayDeque<BSTNode>();
        deq.addLast(root);

        while ( !deq.isEmpty() ) { // until queue is not empty
            BSTNode n = deq.removeFirst();
            System.out.print(n.data + " ");
            if (n.left != null)
                deq.addLast(n.left);
            if (n.right != null)
                deq.addLast(n.right);
        }
        System.out.println();
    }
}
