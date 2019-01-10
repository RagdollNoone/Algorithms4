package Chapter2;

import sun.plugin.com.event.COMEventHandler;

public class Sort {
    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 选择排序算法描述:
    // 找到最小的元素, 和第一个元素交换位置,
    // 在剩下的元素中找到最小的元素, 再和第二个元素交换位置
    // 特点:
    // 交换的次数总是N
    // 算法的时间效率取决于比较次数
    // 对数据的初始状态利用是最差的, 对随机序列和有序序列排序用时一样
    // 数据的移动是最少的
    static public void SelectionSort(Comparable[] a) {
        if (null == a || a.length == 0) return;

        for (int i = 0; i < a.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minIndex])) minIndex = j;
            }

            exch(a, i, minIndex);
        }
    }

    // 插入排序算法描述:
    // 把当前元素插入到已排序列当中的适当位置, 并把之后的元素后移
    // 特点:
    // 对于部分有序的序列排序表现优秀
    // 部分有序概念
    // 1. 序列中的每个元素都离最终位置不远
    // 2. 一个有序列的大数组接一个小数组
    // 3. 数组中只有几个元素的位置不一样
    static public void InsertionSort(Comparable[] a) {
        if (null == a || a.length == 0) return;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    // Shell排序
    // 分割成h个有序序列, 用插入排序对每个子序列排序
    // 可以理解为一个h x n的二维数组, 将数组的每一列处理成有序
    // 这样元素最多移动二维数组的列数减一
    // 特点:
    // 最坏的情况下 也没有到达平方级别
    static public void ShellSort(Comparable[] a) {
        if (null == a || a.length == 0) return;
        int N = a.length;
        int h = 1;

        while (h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -=h) {
                    exch(a, j, j - h);
                }
            }

            h = h / 3;
        }
    }

    // 归并排序
    static private Comparable[] arrayCopy;
    static public void MergeSort(Comparable[] a) {
        if (null == a || a.length == 0) return;

        arrayCopy = new Comparable[a.length];
        MergeSort(a, 0, a.length - 1);
        arrayCopy = null;
    }

    // 适合链表类型的数据结构 因为参与的节点总是从近及远
    // 很适合断开原有连接, 建立新的连接, 并且可以不需要额
    // 外的内存空间, 原地排序
    static public void MergeSortBU(Comparable[] a) {
        if (null == a || a.length == 0) return;

        arrayCopy = new Comparable[a.length];

        for (int sz = 1; sz < a.length; sz = 2 * sz) {
            for (int low = 0; low < a.length - sz; low = 2 * sz) {
                Merge(a, low, low + sz - 1, Math.min(low + 2 * sz - 1, a.length - 1));
            }
        }

        arrayCopy = null;
    }

    static private void MergeSort(Comparable[] a, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        MergeSort(a, low, mid);
        MergeSort(a, mid + 1, high);

        Merge(a, low, mid, high);
    }

    static private void Merge(Comparable[] a, int low, int mid, int high) {
        int i = low; int j = mid + 1;

        for (int k = low; k <= high; k++) {
            arrayCopy[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = arrayCopy[j++];
            if (j > high) a[k] = arrayCopy[i++];
            if (less(arrayCopy[i], arrayCopy[j])) a[k] = arrayCopy[i++];
            else a[k] = arrayCopy[j++];
        }
    }

    static public void QuickSort(Comparable[] a) {
        if (null == a || a.length == 0) return;

        QuickSort(a, 0, a.length - 1);
    }

    static private void QuickSort(Comparable[] a, int low, int high) {
        if (low >= high) return;

        int mid = Partition(a, low, high);
        QuickSort(a, low, mid - 1);
        QuickSort(a, mid + 1, high);
    }

    static private int Partition(Comparable[] a, int low, int high) {
        int mid = low;

        while (low < high) {
            while (less(a[mid], a[high])) high--;
            exch(a, mid, high);
            mid = high;


            while (less(a[low], a[mid])) low++;
            exch(a, mid, low);
            mid = low;
        }

        return mid;
    }
}
