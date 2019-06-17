package Chapter3;

public class RedBlackBST<Key extends Comparable, Value> {
    private class Node{
        public Key key;
        public Value value;

        public Node left;
        public Node right;

        public int N;

        public boolean isRed;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;

            N = 1;
            isRed = true;

            left = null;
            right = null;
        }
    }

    private Node root;

    public static void main(String[] args) {
        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<>();

        redBlackBST.put("S", 0);
        redBlackBST.put("E", 1);
        redBlackBST.put("A", 2);
        redBlackBST.put("R", 3);
        redBlackBST.put("C", 4);
        redBlackBST.put("H", 5);
        redBlackBST.put("E", 6);
        redBlackBST.put("X", 7);
        redBlackBST.put("A", 8);
        redBlackBST.put("M", 9);
        redBlackBST.put("P", 10);
        redBlackBST.put("L", 11);
        redBlackBST.put("E", 12);

        redBlackBST.printInOrder(redBlackBST.getRoot());
        System.out.println();
        System.out.println("##############################");

        while(null != redBlackBST.getRoot()) {
            redBlackBST.deleteMin();
//            redBlackBST.printInOrder(redBlackBST.getRoot());
//            System.out.println();
//            System.out.println("------------------------------");
        }
    }

    public Node getRoot() {
        return root;
    }

    public int size(Node node) {
        if (null == node) return 0;
        return node.N;
    }

    public void put(Key key, Value value) {
        if (null == root) {
            root = new Node(key, value);
            blackRoot();
            return;
        }

        root = put(root, key, value);
        blackRoot();
    }

    private Node put(Node node, Key key, Value value) {
        int cmp = node.key.compareTo(key);

        if (cmp == 0) {
            node.value = value;
            return node;
        }

        if (cmp > 0) {
            if (null == node.left) {
                node.left = new Node(key, value);
            } else {
                node.left = put(node.left, key, value);
            }
        } else if (cmp < 0){
            if (null == node.right) {
                node.right = new Node(key, value);
            } else {
                node.right = put(node.right, key, value);
            }
        }

        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);

        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);

        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

//        System.out.println("Current node key is " + node.key);
//
//        printInOrder(root);
//        System.out.println();

        return node;
    }

    private Node moveRedLeft(Node node) {
        System.out.println("moveRedLeft PreNode is " + node.key);

        flipColors(node);

        if (null == node.right)
            System.out.println("For Break");

        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }

        System.out.println("moveRedLeft PreNode is " + node.key);
        return node;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right))
            root.isRed = true;

        root = deleteMin(root);
        blackRoot();
    }

    private Node deleteMin(Node node) {
        if (null == node.left)
            return null;

        Node t = node;
        boolean state = false;
        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = moveRedLeft(node);
            state = true;
        }

        if (state) {
            System.out.println("PreNode is " + t.key);
            System.out.println("CurrentNode is " + node.key);
            printInOrder(node);
            System.out.println();
            System.out.println("------------------------------");
        }

        node.left = deleteMin(node.left);
        return balance(node);
    }

    private Node balance(Node h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }


    private Node rotateRight(Node node) {
        Node child = node.left;

        node.left = child.right;
        child.right = node;

        child.isRed = node.isRed;
        node.isRed = true;

        node.N = size(node.left) + size(node.right) + 1;
        child.N = size(child.left) + size(child.right) + 1;

        return child;
    }

    private Node rotateLeft(Node node) {
        Node child = node.right;

        node.right = child.left;
        child.left = node;

        child.isRed = node.isRed;
        node.isRed = true;

        node.N = size(node.left) + size(node.right) + 1;
        child.N = size(child.left) + size(child.right) + 1;

        return child;
    }

    private void flipColors(Node node) {
        if (null == node)
            return;

        node.isRed = true;

        if (null != node.left)
            node.left.isRed = false;

        if (null != node.right)
            node.right.isRed = false;
    }

    private boolean isRed(Node node) {
        if (null == node) return false;

        return node.isRed;
    }

    private void blackRoot() {
        if (null != root) {
            root.isRed = false;
        }
    }

    public void printInOrder(Node node) {
        if (null == node) {
            System.out.print("null ");
            return;
        }

        String isRed = node.isRed ? "#" : "";
        System.out.print(isRed + node.key + " ");
        printInOrder(node.left);
        printInOrder(node.right);
    }
}
