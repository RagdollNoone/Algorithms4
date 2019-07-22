package Chapter2;

public class InsertionSort extends Sort {
    static public void Sort(Comparable[] a) {
        if (null == a || a.length == 0) return;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
