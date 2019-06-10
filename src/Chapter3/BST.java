package Chapter3;

public class BST<Key extends Comparable, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        int N;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            N = 1;
        }
    }

    private Node root;

    public int size() {
        if (null == root) return 0;

        return size(root);
    }

    private int size(Node node) {
        if (null == node) return 0;
        return node.N;
    }

    public Value get(Key key) {
        if (null == root) return null;

        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (null == node) return null;

        if (node.key.compareTo(key) == 0) {
            return node.value;
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

        node.N = size(node.left) + size(node.right) + 1;
    }

    public void delete(Key key) {
        if (null == root) return;

        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (null == node) return null;

        int cmp = node.key.compareTo(key);

        if (cmp > 0) return delete(node.left, key);
        if (cmp < 0) return delete(node.right, key);
        else {
            Node t = node.left;
            Node tt = min(node.right);
            node.right = deleteMin(node.right);
            tt.left = t;
            tt.right = node.right;
            tt.N = size(tt.left) + size(tt.right) + 1;
            return tt;
        }
    }

    public Value max() {
        return null;
    }

    public Value min() {
        if (null == root) return null;

        return min(root).value;
    }

    private Node min(Node node) {
        if (null == node.left) return node;
        return min(node.left);
    }

    public void deleteMin() {
        if (null == root) return;

        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (null == node) return null;

        if (null == node.left) return node.right;
        else {
            node.left = deleteMin(node.left);
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }
    }

    public Key floor(Key key) {
        if (null == root) return null;
        Node t = floor(root, key);

        if (null == t) return null;
        return t.key;
    }

    private Node floor(Node node, Key key) {
        if (null == node) return null;

        int cmp = node.key.compareTo(key);
        if (cmp == 0) return node;
        if (cmp > 0) return floor(node.left, key);
        else {
            if (null == node.right) return node;
            else return floor(node.right, key);
        }
    }

    public Value ceiling(Key key) {
        return null;
    }


    public int rank(Key key) {
        if (null == root) return 0;
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        int cmp = node.key.compareTo(key);

        if (cmp == 0) return size(node);
        if (cmp > 0) return rank(node.left, key);
        else return size(node.left) + rank(node.right, key);
    }

    public Key select(int k) {
        if (null == root) return null;
        if (k <= 0) return null;

        return select(root, k);
    }

    private Key select(Node node, int k) {
        if (null == node) return null;
        if (k > size(node)) return null;

        int sizeLeft = size(node.left);
        if (k == sizeLeft + 1) return node.key;
        if (k <= sizeLeft) return select(node.left, k);
        else return select(node.right, k - 1 - sizeLeft);
    }
}
