package AVLTree;

public class AVLTree {

    public AVLNode root;

    public void insert(int key) {
        if (root == null)
            root = new AVLNode(key);
        else
            root = root.insert(key);
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
}
