package week4;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by sheeran on 2017/3/29.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        private int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (root == null) return null;
        Node k = root;
        while (k != null) {
            int cmp = key.compareTo(k.key);
            if (cmp > 0) k = root.right;
            if (cmp < 0) k = root.left;
            if (cmp == 0) return k.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null) return new Node(key, value);
        int cmp = key.compareTo(root.key);
        //小于
        if (cmp < 0) put(root.left, key, value);
        else if (cmp > 0) put(root.right, key, value);
        else root.value = value;
        return null;
    }

    public Node floor(Key key) {
        return floor(root, key);
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return floor(node.left, key);
        else if (cmp == 0) return node.left;
        else {
            Node t = floor(node.right, key);
            if (t != null) return null;
            else return node;
        }
    }

    public int size(Key key) {
        return size(root, key);
    }

    private int size(Node node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return size(node.left, key);
        else if (cmp > 0) return 1 + size(node.left, key) + size(node.right, key);
        else return node.count;
    }

    public Iterable<Key> iterable() {
        Queue<Key> keys = new Queue<Key>();
        inorder(root, keys);
        return keys;
    }

    private void inorder(Node node, Queue<Key> keys) {
        if (node == null) return;
        inorder(node.left, keys);
        keys.enqueue(node.key);
        inorder(node.right, keys);
    }

    public void delMin(Node node) {
        Node k = min(node);
        k = null;
    }

    public Node min(Node node) {
        if (node == null) return null;
        Node k = node;
        while (k.left != null) {
            k = node.left;
        }
        return k;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return delete(node.left, key);
        else if (cmp > 0) return delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node t = node;
            node.right = min(t.right);
            node.left = t.left;
        }
        node.count = 1 + node.left.count + node.right.count;
        return node;
    }

    public static void main(String[] args) {
        BST bst=new BST();
    }
}
