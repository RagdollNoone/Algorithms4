package Chapter2;

public class SelectionSort extends Sort {
    static public void Sort(Comparable[] a) {
        if (null == a || a.length == 0) return;

        for (int i = 0; i < a.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minIndex])) minIndex = j;
            }

            exch(a, i, minIndex);
        }
    }
}
