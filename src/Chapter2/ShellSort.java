package Chapter2;

public class ShellSort extends Sort {
    // Shell排序
    // 分割成h个有序序列, 用插入排序对每个子序列排序
    static public void Sort(Comparable[] a) {
        if (null == a || a.length == 0) return;
        int N = a.length;
        int h = 1;

        while (h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }

            h = h / 3;
        }
    }

    static public void MySort(Comparable[] a) {
        int low = 0;
        int high = a.length - 1;

        MyShellSort(a, low, high);
    }

    static private void MyShellSort(Comparable[] a, int low, int high) {
        if (null == a || low >= high) return;

        int mid = (low + high) / 2;

        MyShellSort(a, low, mid);
        MyShellSort(a, mid + 1, high);

        ShellMerge(a, low, mid, high);
    }

    static private void ShellMerge(Comparable[] a, int low, int mid, int high) {
        for (int i = mid + 1; i <= high; i++) {
            for (int j = mid; j >= low && less(a[i], a[j]); j--) {
                exch(a, i, j);
            }
        }

    }
}
