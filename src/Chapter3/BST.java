package Chapter3;

public class BST<Key extends Comparable, Value> {
    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        int N;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            N = 1;
        }
    }

    private Node root;

    public int size() {
        if (null == root) return 0;

        return size();
    }

    private int size(Node node) {
        node.N = node.left.N + node.right.N + 1;
        return node.N;
    }

    public Node get(Key key) {
        if (null == root) return null;

        return get(root, key);
    }

    private Node get(Node node, Key key) {
        if (null == node) return null;

        if (node.key.compareTo(key) == 0) {
            return node;
        }

        if (node.key.compareTo(key) > 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        if (null == root) {
            root = new Node(key, value);
            return;
        }

        put(root, key, value);
    }

    private void put(Node node, Key key, Value value) {
        if (node.key.compareTo(key) == 0) {
            node.value = value;
            return;
        }

        if (node.key.compareTo(key) > 0) {
            if (null == node.left) {
                node.left = new Node(key, value);
            } else {
                put(node.left, key, value);
            }
        }

        if (node.key.compareTo(key) > 0) {
            if (null == node.right) {
                node.right = new Node(key, value);
            } else {
                put(node.right, key, value);
            }
        }

        size(node);
    }

    public void delete(Key key) {
        if (null == root) return;


    }

    public Value max() {
        return null;
    }

    public Value min() {
        return null;
    }

    public Node floor(Key key) {
        if (null == root) return null;

        return floor(root, key);
    }

    private Node floor(Node node, Key key) {
        if (null == node) return null;

        Node parent = get(node, key);
        return parent.left;
    }

    public Value ceiling(Key key) {
        return null;
    }


    public int rank(Key key) {
        return 0;
    }

    public Value select(int k) {
        return null;
    }
}
