package Chapter2;

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
}
