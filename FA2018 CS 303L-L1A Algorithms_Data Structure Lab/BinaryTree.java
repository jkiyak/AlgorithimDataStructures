// Uzma Nur
// CS 303 TA
// Fall 2018
// Lab 7

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class BinaryTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> root; // the root of the tree
    private BinaryTreeNode<T> cursor; // the current node

    /**
     * Constructor for initializing a tree with node
     * being set as the root of the tree.
     * @param node
     */
    public BinaryTree(BinaryTreeNode<T> node) { root = node; }

    public BinaryTree() { this(null); }

    /**
     * Moves the cursor to the root.
     */
    public void toRoot() { cursor = root; }

    /**
     * Returns the cursor node.
     * @return cursor
     */
    public BinaryTreeNode<T> getCursor() { return cursor; }

    /**
     * Sets the root to the provided node.
     * ONLY USE IN THE DELETE METHOD
     * @param node
     */
    public void setRoot(BinaryTreeNode<T> node) { root = node; }

    /**
     * Checks if the tree node has a left child node
     * @return true if left child exists else false
     */
    public boolean hasLeftChild() { return cursor.getLeft() != null; }

    /**
     * Checks if the tree node has a right child node
     * @return true if right child exists else false
     */
    public boolean hasRightChild() { return cursor.getRight() != null; }

    /**
     * Move the cursor to the left child
     */
    public void toLeftChild() { cursor = cursor.getLeft(); }

    /**
     * Move the cursor to the right child
     */
    public void toRightChild() { cursor = cursor.getRight(); }

    /**
     * @return height of the tree
     */
    public int height() {
        if (root != null) { return root.height(); }
        else { return 0; }
    }

    /** (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        if (root != null) { return root.toStringPreOrder("."); }
        else { return ""; }
    }

    public void insert(BinaryTreeNode<T> z) {
        BinaryTreeNode<T> y = null;
        BinaryTreeNode<T> x = root;
        while (x != null) {
            y = x;
            if (z.getKey() instanceof String && Long.parseLong((String) z.getKey()) < Long.parseLong((String) x.getKey())) { x = x.getLeft(); }
            else if (z.getKey().compareTo(x.getKey()) < 0) { x = x.getLeft(); }
            else { x = x.getRight(); }
        }
        z.setParent(y); // this line not required for Lab 7
        if (y == null) { root = z; } // tree was empty
        else if (z.getKey() instanceof String && Long.parseLong((String) z.getKey()) < Long.parseLong((String) y.getKey())) { y.setLeft(z); }
        else if (z.getKey().compareTo(y.getKey()) < 0) { y.setLeft(z); }
        else { y.setRight(z); }
    }

    public void inorderTreeWalk(BinaryTreeNode<T> x) {
        if (x != null) {
            inorderTreeWalk(x.getLeft());
            if (x.getData() != null) { System.out.println(x.getKey() + ": " + x.getData()); }
            else {System.out.println(x.getKey()); }
            inorderTreeWalk(x.getRight());
        }
    }

    // iterative tree search
    public BinaryTreeNode<T> search(T key) { // root should be input for parameter x
        BinaryTreeNode<T> x = root;
        while (x != null && key != x.getKey()) {
            if (key instanceof String && Long.parseLong((String) key) < Long.parseLong((String) x.getKey())) { x = x.getLeft(); }
            else if (key.compareTo(x.getKey()) < 0) { x = x.getLeft(); }
            else { x = x.getRight(); }
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(0);
        BinaryTree<Integer> tree1 = new BinaryTree<Integer>(root);
        tree1.insert(new BinaryTreeNode<Integer>(50));
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int n = rand.nextInt(100);
            BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(n);
            tree1.insert(node);
        }
        tree1.inorderTreeWalk(tree1.root);
        System.out.println(tree1.search(50).getKey());

        Scanner sc = new Scanner(Paths.get("/Users/Uzma/Desktop/workspace/CS 303/UPC.csv"));
        BinaryTree<String> tree2 = new BinaryTree<String>(null);

        for (int i = 0; i < 177650; i++) {
            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                String key = line.substring(0,line.indexOf(','));
                String data = line.substring(line.indexOf(',') + 1, line.length());
                tree2.insert(new BinaryTreeNode<String>(key,data));
            }
        }

        sc.close();
        sc = new Scanner(Paths.get("/Users/Uzma/Desktop/workspace/CS 303/input.txt"));

        long execTime = System.nanoTime();
        BinaryTreeNode<String> node = null;

        for (int i = 0; i < 17; i++) {
            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                String key = line.substring(0,line.indexOf(','));
                node = tree2.search(key);
                if (node != null) {
                    System.out.println(node.getKey() + ": " + node.getData());
                }
            }
        }

        execTime = System.nanoTime() - execTime;
        sc.close();

        System.out.println("Search time: " + execTime);
    }
}