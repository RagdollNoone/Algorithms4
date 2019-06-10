package Chapter2;

public class MergeSort extends Sort {
    static Comparable[] support;

    static public void SortBU(Comparable[] a) {
        support = new Comparable[a.length];

        for (int sz = 1; sz < a.length; sz = 2 * sz) {
            System.out.println("sz: " + sz);
            for (int low = 0; low < a.length - sz; low = low + 2 * sz) {
                Merge(a, low, low + sz - 1, Math.min(a.length - 1, low + 2 * sz - 1));
            }
            Sort.show(a);
        }
    }

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
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            support[k] = a[k];
        }

        // 错误的示范, 虽然同样的四个分支, 这样写会导致算法运行失败
        // 应为边界情况时不能应用less比较, 下标会益出
//        for (int k = low; k <= high; k++) {
//            if (less(a[i], a[j])) {
//                a[k] = support[i++];
//            } else if (less(a[j], a[i])) {
//                a[k] = support[j++];
//            } else if (i > mid) {
//                a[k] = support[j++];
//            } else if (j > high) {
//                a[k] = support[i++];
//            }
//        }

        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = support[j++];
            else if (j > high) a[k] = support[i++];
            else if (less(support[i], support[j])) a[k] = support[i++];
            else a[k] = support[j++];
        }

    }
}
