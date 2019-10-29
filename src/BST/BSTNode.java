package BST;

public class BSTNode {
    int data;
    BSTNode left, right;

    public BSTNode(int d) {
        data = d;
    }

    public void insert(int key) {
        if (key < data)
            if (left == null)
                left = new BSTNode(key);
            else
                left.insert(key);
        else
            if (right == null)
                right = new BSTNode(key);
            else
                right.insert(key);
    }

    public boolean search(int key) {
        if (key == data)
            return true;
        else if (key < data && left != null)
            return left.search(key);
        else if (key > data && right != null)
            return right.search(key);
        else
            return false;
    }

    public void inorder() {
        if (left != null) left.inorder();
        System.out.print(data + " ");
        if (right != null) right.inorder();
    }

    public void preorder() {
        System.out.print(data + " ");
        if (left != null) left.preorder();
        if (right != null) right.preorder();
    }

    public void postorder() {
        if (left != null) left.postorder();
        if (right != null) right.postorder();
        System.out.print(data + " ");
    }
}
