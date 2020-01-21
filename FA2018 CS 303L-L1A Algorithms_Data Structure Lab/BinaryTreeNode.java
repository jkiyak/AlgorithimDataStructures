// Uzma Nur
// CS 303 TA
// Fall 2018
// Lab 7



public class BinaryTreeNode<T extends Comparable<T>> {
    private T key; // the key of this node
    private BinaryTreeNode<T> left; // the left child
    private BinaryTreeNode<T> right; // the right child
    private T data = null; // the data in this node (if not represented by key)
    private BinaryTreeNode<T> parent;

    public BinaryTreeNode() { this(null, null, null, null); }

    public BinaryTreeNode(T theKey) { this(theKey, null, null, null); }

    public BinaryTreeNode(T theKey, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild, BinaryTreeNode<T> parentNode) {
        key = theKey;
        left = leftChild;
        right = rightChild;
        parent = parentNode;
    }

    public BinaryTreeNode(T theKey, T theData) {
        this(theKey);
        data = theData;
    }

    public T getKey() { return key; }
    public BinaryTreeNode<T> getLeft() { return left; }
    public BinaryTreeNode<T> getRight() { return right; }
    public BinaryTreeNode<T> getParent() { return parent; }
    public T getData() { return data; }

    public void setLeft(BinaryTreeNode<T> newLeft) { left = newLeft; }
    public void setRight(BinaryTreeNode<T> newRight) { right = newRight; }
    public void setParent(BinaryTreeNode<T> newParent) { parent = newParent; }

    public void preOrder() {
        if (data != null) { System.out.println(key + ": " + data); }
        else {System.out.println(key); }
        if (left != null) { left.preOrder(); }
        if (right != null) { right.preOrder(); }
    }

    public int height() {
        int leftHeight = 0; // Height of the left subtree
        int rightHeight = 0; // Height of the right subtree
        int height = 0; // The height of this subtree
        // If we have a left subtree, determine its height
        if (left != null) { leftHeight = left.height(); }
        // If we have a right subtree, determine its height
        if (right != null) { rightHeight = right.height(); }
        // The height of the tree rooted at this node is one more than the height of the 'taller' of its children.
        if (leftHeight > rightHeight) { height = 1 + leftHeight; }
        else { height = 1 + rightHeight; }
        // Return the answer
        return height;
    }

    /**
     * @param pathString
     * @return the tree nodes in pre-order traversal
     */
    public String toStringPreOrder(String pathString) {
        String treeString = pathString + " : " + key + "\n";
        if (left != null) { treeString += left.toStringPreOrder(pathString + "L"); }
        if (right != null) { treeString += right.toStringPreOrder(pathString + "R"); }
        return treeString;
    }
}