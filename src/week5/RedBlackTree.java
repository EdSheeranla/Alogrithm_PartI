package week5;

/**
 * Created by sheeran on 2017/3/31.
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node parent;
        Node left, right;
        boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.value;
    }


    private boolean isRed(Node node) {
        //when the node is null,set it black link
        return node != null && node.color == RED;
    }

    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.color = node.color;
        node.color = RED;
        x.left = node;
        return x;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.color = node.color;
        node.color = RED;
        x.right = node;
        return x;
    }

    private void flip(Node node) {
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }

    //暴露接口
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {

        if (node == null) return new Node(key, value, RED);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return put(node.left, key, value);
        else if (cmp > 0) return put(node.right, key, value);
        else node.value = value;

        if (isRed(node.left) && isRed(node.right)) flip(node);
        if (isRed(node.left) && isRed(node.left.left)) rightRotate(node);
        if (!isRed(node.left) && isRed(node.right)) leftRotate(node);
        return node;
    }
}
