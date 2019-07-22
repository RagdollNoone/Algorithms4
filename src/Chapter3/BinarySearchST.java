package Chapter3;

import Chapter1.BinarySearch;

public class BinarySearchST<Key extends Comparable, Value> {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> binarySearchST = new BinarySearchST<>(100);

        binarySearchST.put("S", 0);
        binarySearchST.put("E", 1);
        binarySearchST.put("B", 2);
        binarySearchST.put("R", 3);
        binarySearchST.put("C", 4);
        binarySearchST.put("H", 5);
        binarySearchST.put("E", 6);
        binarySearchST.put("X", 7);
        binarySearchST.put("B", 8);
        binarySearchST.put("M", 9);
        binarySearchST.put("P", 10);
        binarySearchST.put("L", 11);
        binarySearchST.put("E", 12);

        binarySearchST.print();

        Integer result = binarySearchST.get("P");
        System.out.println("Get P value is " + result);

        result = binarySearchST.get("Q");
        System.out.println("Get Q value is " + result);

        String keyResult = binarySearchST.floor("A");
        System.out.println("Floor A value is " + keyResult);

        keyResult = binarySearchST.floor("Y");
        System.out.println("Floor Y value is " + keyResult);

        keyResult = binarySearchST.floor("P");
        System.out.println("Floor P value is " + keyResult);

        keyResult = binarySearchST.min();
        System.out.println("Min value is " + keyResult);

        keyResult = binarySearchST.max();
        System.out.println("Max value is " + keyResult);

        result = binarySearchST.select(5);
        System.out.println("Select 5 value is " + result);

        binarySearchST.delete("X");
        binarySearchST.delete("B");
        binarySearchST.delete("M");

        binarySearchST.print();
    }

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key []) (new Comparable[capacity]);
        values = (Value [])(new Object[capacity]);

        N = 0;
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
        for (int k = N - 1; k >= i; k--) {
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

    public Key max() {
        return keys[N - 1];
    }

    public Key min() {
        return keys[0];
    }

    public Key floor(Key key) {
        int i = rank(key);

        if (i < N && i >= 0 && keys[i].compareTo(key) == 0) return keys[i];

        if (i == N - 1) return keys[i];
        if ((i - 1) >= 0) return keys[i - 1];

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
        return values[k - 1];
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(keys[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < N; i++) {
            System.out.print(values[i] + " ");
        }

        System.out.println();
    }
}
