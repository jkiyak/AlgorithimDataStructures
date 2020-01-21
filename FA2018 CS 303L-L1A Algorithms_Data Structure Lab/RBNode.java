public class RBNode extends BinaryTreeNode {
    long key;
    RBNode left, right, parent, x,y;
    String words;
    boolean isRed;


    public RBNode(long theKey, String data) {
        super(theKey, data);
        key = theKey;
        words = data;
        left = null;
        right = null;
        parent = null;
        isRed = false;
    }

    void leftrotate(RBNode x) {
    RBNode y = x.right;
    x.right = y.left;
    if (y.left != null) {
       y.left.parent = x;
    }
    y.parent = x.parent;
    if (x.parent == null) {
        RBNode root = y;
    }
    else if (x == x.parent.left){
        x.parent.left = y;
    }
    else x.parent.right = y;
    y.left = x;
    x.parent = y;
    }

    void rightrotate(RBNode x){
        x = y.right;
    y.right = x.left;
    if (x.left != null){
       x.left.parent = y;
    }
    x.parent = y.parent;
    if (y.parent == null){
    RBNode root = x;
    }
    else if (y == y.parent.left){
    y.parent.left = x;
    }
    else y.parent.right = x;
    x.left = y;
    y.parent = x;
    }

}