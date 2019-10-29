package AVLTree;

public class AVLNode {
    int data;
    AVLNode left, right;

    int balanceFactor;

    public AVLNode(int d) {
        data = d;
        balanceFactor = 0;
    }

    public boolean isLeaf() {
        if (left == null && right == null)
            return true;
        return false;
    }

    public boolean hasOnlyLeft() {
        if (left != null && right == null)
            return true;
        return false;
    }

    public boolean hasOnlyRight() {
        if (left == null && right != null)
            return true;
        return false;
    }

    public int max(int a, int b) {
        if (a > b) return a;
        return b;
    }

    public int height() {
        if( isLeaf() )
            return 0;
        else if(hasOnlyLeft())
            return left.height() + 1;
        else if(hasOnlyRight())
            return right.height() + 1;
        return max(left.height(), right.height()) + 1;
    }

    public int computeBalance() {
        if (isLeaf()) return 0;
        else if (hasOnlyLeft()) return left.height()+1;
        else if (hasOnlyRight()) return -1 * (right.height()+1);
        return left.height() - right.height();
    }

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

    public AVLNode insert(int key) {
        if (key < data)
            if (left == null)
                left = new AVLNode(key);
            else
                left = left.insert(key);
        else
            if (right == null)
                right = new AVLNode(key);
            else
                right = right.insert(key);

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
