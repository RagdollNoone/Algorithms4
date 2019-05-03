package Chapter2;

public class MergeSort extends Sort {
    static Comparable[] support;

    static public void Sort(Comparable[] a) {
        support = new Comparable[a.length];
        Sort(a, 0, a.length - 1);
    }

    static public void Sort(Comparable[] a, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        Sort(a, low, mid);
        Sort(a, mid + 1, high);
        Merge(a, low, mid, high);
    }

    static private void Merge(Comparable[] a, int low, int mid, int high) {
        System.out.println("low = " + low + " mid = " + mid + " high = " + high);
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            support[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (less(a[i], a[j])) {
                a[k] = support[i++];
            } else if (less(a[j], a[i])) {
                a[k] = support[j++];
            } else if (i > mid) {
                a[k] = support[j++];
            } else if (j > high) {
                a[k] = support[i++];
            }

            System.out.println("k = " + k + " a[k] = " + a[k]);
        }

    }
}
