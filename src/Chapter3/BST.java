package Chapter3;

public class BST<Key extends Comparable, Value> {
    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        int N;
    }

    public int size() {
        return 0;
    }

    public Value get(Key key) {
        return null;
    }

    public void put(Key key, Value value) {

    }

    public void delete(Key key) {

    }


    public Value max() {
        return null;
    }

    public Value min() {
        return null;
    }

    public Value floor(Key key) {
        return null;
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
