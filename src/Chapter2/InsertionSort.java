package Chapter2;

public class InsertionSort extends SelectionSort {
    // 插入排序算法描述:
    // 把当前元素插入到已排序列当中的适当位置, 并把之后的元素后移
    // 特点:
    // 对于部分有序的序列排序表现优秀
    // 部分有序概念
    // 1. 序列中的每个元素都离最终位置不远
    // 2. 一个有序列的大数组接一个小数组
    // 3. 数组中只有几个元素的位置不一样
    static public void Sort(Comparable[] a) {
        if (null == a || a.length == 0) return;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
