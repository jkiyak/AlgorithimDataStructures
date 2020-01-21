public class RBTree extends BinaryTree {
    RBNode root;

    RBTree() {
        root = null;
    }

    public RBTree(BinaryTreeNode node) {
        super(node);
    }
     void RBInsert() {
     RBNode y = null;
     RBNode x = root;
     RBNode z = null;
     while (x != null){
     y = x;
        if (z.key < x.key){
            x = x.left;
        else {
         x = x.right;
        }
        }
         z.parent = y;
        if (y == null){
            RBNode root = z;
        }
        else if (z.key < y.key) {
            y.left = z;
        }
        else {
        y.right = z;
        }
        z.left = null;
        z.right = null;
        z.isRed = true;
     }
     }

     void insertfixup(RBNode z){
     RBNode x = null;
     RBNode y = null;

     while (z.parent.isRed = true) {
      if (z.parent == z.parent.parent.left){
          y = z.parent.parent.right;
      }
      if (y.isRed = true) {
          z.parent.isRed = false;
          y.isRed = false;
          z.parent.parent.isRed = true;
          z = z.parent.parent;
      }
      else if (z == z.parent.right){
          z = z.parent;
          z.leftrotate(z);
          z.parent.isRed = false;
          z.parent.parent.isRed = true;
          z.rightrotate(z.parent.parent);
      }
     else {
      z.isRed = true;
      }
     }
     }
}

