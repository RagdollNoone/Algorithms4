package Chapter3;

public class BST<Key extends Comparable, Value> {

    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();

        bst.put("S", 0);
        bst.put("E", 1);
        bst.put("A", 2);
        bst.put("R", 3);
        bst.put("C", 4);
        bst.put("H", 5);
        bst.put("E", 6);
        bst.put("X", 7);
        bst.put("A", 8);
        bst.put("M", 9);
        bst.put("P", 10);
        bst.put("L", 11);
        bst.put("E", 12);

        bst.printInOrder(bst.getRoot());
        System.out.println();

        Integer result = bst.get("R");
        System.out.println("Get R value is " + result);

        result = bst.get("Q");
        System.out.println("Get Q value is " + result);

        String keyResult = bst.floor("G");
        System.out.println("Floor G value is " + keyResult);

        keyResult = bst.floor("Q");
        System.out.println("Floor Q value is " + keyResult);

        keyResult = bst.min();
        System.out.println("Min value is " + keyResult);

        keyResult = bst.select(8);
        System.out.println("Select 8 value is " + keyResult);

        bst.delete("A");
        bst.delete("X");
        bst.delete("H");
        bst.delete("S");

        bst.printInOrder(bst.getRoot());
        System.out.println();
    }

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

    public Node getRoot() {
        return root;
    }

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

        if (node.key.compareTo(key) < 0) {
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

        if (cmp > 0) node.left = delete(node.left, key);
        else if (cmp < 0) node.right = delete(node.right, key);
        else {
            if (null == node.right) return node.left;
            if (null == node.left) return node.right;

            Node t = node;
            node = min(t.right);
            node.left = t.left;
            node.right = deleteMin(t.right);
        }

        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key max() {
        return null;
    }

    public Key min() {
        if (null == root) return null;

        return min(root).key;
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
        if (cmp > 0) {
            return floor(node.left, key);
        }
        else {
            if (null == node.right) return node;
            Node result = floor(node.right, key);

            if (null == result) return node;
            return result;
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

    public void printInOrder(Node node) {
        if (null == node) {
            System.out.print("null ");
            return;
        }

        System.out.print(node.key + " ");
        printInOrder(node.left);
        printInOrder(node.right);
    }
}
