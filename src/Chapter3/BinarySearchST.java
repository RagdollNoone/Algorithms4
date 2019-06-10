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
        return N;
    }

    public Value get(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        // 只讨论没有满的情况
        for (int k = N - 2; k >= i; k --) {
            keys[k + 1] = keys[k];
            values[k + 1] = values[k];
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(Key key) {
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            for (int k = i; k < N - 1; k++) {
                keys[k] = keys[k + 1];
                values[k] = values[k + 1];
            }

            keys[N - 1] = null;
            values[N - 1] = null;
            N--;
        }
    }

    public Value max() {
        return values[N - 1];
    }

    public Value min() {
        return values[0];
    }

    public Value floor(Key key) {
        int i = rank(key);

        if (i == N - 1) return values[i];
        if ((i - 1) >= 0) return values[i - 1];

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
        return values[k];
    }
}
