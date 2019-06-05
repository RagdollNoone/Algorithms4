package Chapter3;

public class BinarySearchST<Key extends Comparable, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key []) (new Comparable[capacity]);
        values = (Value [])(new Object[capacity]);

        N = capacity;
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

    public int rankR(Key key) {
        return rankR(key, 0, N - 1);
    }

    private int rankR(Key key, int low, int high) {
        if (low > high) return low;

        int mid, cmp;
        mid = (low + high) / 2;
        cmp = keys[mid].compareTo(key);

        if (cmp == 0) return mid;
        if (cmp > 0) return rankR(key, low, mid - 1);
        else return rankR(key, mid + 1, high);
    }

    public int rank(Key key) {
        int low = 0, high = N - 1;
        int mid, cmp;

        while(low <= high) {
            mid = (low + high) / 2;
            cmp = keys[mid].compareTo(key);

            if (cmp == 0) return mid;
            if (cmp > 0) high = mid - 1;
            if (cmp < 0) low = mid + 1;
        }

        return low;
    }

    public Value select(int k) {
        return null;
    }
}
